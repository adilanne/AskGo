package br.laab.askgo.dao.Imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.laab.askgo.dao.IUsuarioDAO;
import br.laab.askgo.entities.Usuario;

public class UsuarioDAO extends DAO<Usuario, Long> implements IUsuarioDAO {
	 
	public UsuarioDAO(EntityManager manager) {
		super(manager);
	}
	
	public Usuario efetuarLogin(String login, String senha) {
		String str= "select c from Usuario u where u.login = :login and u.senha = :senha";
		Query query = manager.createQuery(str);
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios  = query.getResultList();
		if(usuarios.isEmpty()) {
			return null;
		}
		return usuarios.get(0);
	 }

	public void update(Usuario usuario) {
		manager.merge(usuario);
	}

	@Override
	public Class<Usuario> getEntityClass() {
		return Usuario.class;
	}
	
}