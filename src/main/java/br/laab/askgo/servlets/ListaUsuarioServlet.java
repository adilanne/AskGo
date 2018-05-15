package br.laab.askgo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.laab.askgo.entities.Usuario;
import br.laab.askgo.service.UsuarioService;

@WebServlet("/usuario")
public class ListaUsuarioServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsuarioService usuarioService = new UsuarioService();
		List<Usuario> usuarios = usuarioService.listarUsuarios();
		req.setAttribute("usuarios", usuarios);
		RequestDispatcher dispatcher = req.getRequestDispatcher("listaUsuario.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
