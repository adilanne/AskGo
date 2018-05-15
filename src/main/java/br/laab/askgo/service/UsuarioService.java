package br.laab.askgo.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.laab.askgo.dao.Imp.UsuarioDAO;
import br.laab.askgo.entities.Usuario;

public class UsuarioService {
	static EntityManagerFactory fac = Persistence.createEntityManagerFactory("usuario");
	
	public Usuario efetuarLogin (String login, String senha) {
		EntityManager manager = fac.createEntityManager();
		UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
		
		try {
			return usuarioDAO.efetuarLogin(login, senha);
		} finally {
			manager.close();
		}
	}
	
	public void salvar(Usuario usuario) {
		EntityManager manager = fac.createEntityManager();
		UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
		
		try {
			manager.getTransaction().begin();
			usuarioDAO.save(usuario);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}
	
	public void excluir(Usuario usuario) {
		EntityManager manager = fac.createEntityManager();
		UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
		
		try {
			manager.getTransaction().begin();
			usuarioDAO.remove(usuario);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}
	
	public Usuario buscarUsuarioPorID (long id) {
		EntityManager manager = fac.createEntityManager();
		UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
		Usuario usuario = null;
		
		try {
			manager.getTransaction().begin();
			usuario = usuarioDAO.getById(null, id);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		
		return usuario;
	}
	
	public List<Usuario> listarUsuarios(){
		EntityManager manager = fac.createEntityManager();
		UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			manager.getTransaction().begin();
			usuarios = usuarioDAO.getAll();
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		
		return usuarios;
	}
	
	public void atualizar (Usuario usuario) {
		EntityManager manager = fac.createEntityManager();
		UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
		
		try {
			manager.getTransaction().begin();
			usuarioDAO.update(usuario);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}finally {
			manager.close();
		}
	}

}
