package br.laab.askgo.test;

import java.util.List;

import br.laab.askgo.dao.IUsuarioDAO;
import br.laab.askgo.dao.Imp.UsuarioDAO;
import br.laab.askgo.entities.Enquete;
import br.laab.askgo.entities.Usuario;
import br.laab.askgo.controller.EnqueteController;

public class TesteMain {

	public static void main(String[] args) {

		Usuario user = new Usuario();
		user.setNome("Adilanne");
		user.setEmail("brasil@brasil.br");
		user.setCelular("9999");;
		
		IUsuarioDAO userDao = new UsuarioDAO(null);
		
		userDao.save(user);

		List<Usuario> listaUsers = userDao.getAll();

		for (Usuario u : listaUsers) {
			System.out.println(u.getNome());
		}
		
		// Enquete		
		Enquete enq = new Enquete();
		enq.setDescricao("Melhor dia para a reunião?");
		
		EnqueteController enquet = new EnqueteController();
		enquet.cadastrarEnquete(enq, user);
		
		String newDescricao = "Edit melhor dia para reuniao?";
		enquet.editarEnquete(enq, "titulo",newDescricao);
		
		System.out.println(enquet.gerarLink(enq.getId()));		
	}

}