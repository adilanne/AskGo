package br.laab.askgo.controller;

import org.springframework.stereotype.Controller;

import br.laab.askgo.dao.IEnqueteDAO;
import br.laab.askgo.dao.Imp.EnqueteDAO;
import br.laab.askgo.entities.Enquete;
import br.laab.askgo.entities.Usuario;

@Controller
public class EnqueteController {

	public boolean cadastrarEnquete(Enquete enq, Usuario user) {		
		IEnqueteDAO enqDao = new EnqueteDAO();			
		enqDao.save(enq);
		return true;
	}
	
	public boolean editarEnquete(Enquete enq, String newTitulo, String newDescricao) {
		enq.setTitulo(newTitulo);
		enq.setDescricao(newDescricao);
		IEnqueteDAO enqDao = new EnqueteDAO();
		enqDao.save(enq);
		return true;
	} 
	
	public String gerarLink(Long id) {
		return "www.linkGerado.com.br";
	}

}
