package br.laab.askgo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.laab.askgo.entities.Usuario;
import br.laab.askgo.service.UsuarioService;

@WebServlet("/cadastro_usuario")
public class CadastroUsuarioServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id =  request.getParameter("id");
		
		if(id != null) {
			UsuarioService service = new UsuarioService();
			Usuario usuario = service.buscarUsuarioPorID(new Long(id));
			request.setAttribute("usaurio", usuario);
		}
		
		request.getRequestDispatcher("cadastro_usuario.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setEmail(email);
		
		UsuarioService service = new UsuarioService();
		
		if(!id.equals("")) {
			usuario.setId(new Long(id));
			service.atualizar(usuario);
		}
		else {
			service.salvar(usuario);
		}
		
		response.sendRedirect("/AskGo/usuario");
	}
	

}
