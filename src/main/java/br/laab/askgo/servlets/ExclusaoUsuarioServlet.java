package br.laab.askgo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.laab.askgo.entities.Usuario;
import br.laab.askgo.service.UsuarioService;

@WebServlet("/exclusao_usuario")
public class ExclusaoUsuarioServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		UsuarioService service = new UsuarioService();
		service.excluir(new Usuario(new Long(id)));
		response.sendRedirect("/AskGo/usuario");
		
	}

}
