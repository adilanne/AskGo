package br.laab.askgo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.laab.askgo.entities.Usuario;
import br.laab.askgo.service.UsuarioService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		if(login.equals("") || senha.equals("")) {
			request.setAttribute("mensagemErro", "Login ou senha vazio");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		UsuarioService service = new UsuarioService();
		Usuario usuario= service.efetuarLogin(login, senha);
		
		if(usuario == null) {
			request.setAttribute("mensagemErro", "Login ou senha inválidos");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		HttpSession sessao = request.getSession();
		sessao.setAttribute("usuarioLogado", usuario);
		response.sendRedirect("/AskGo/usuario");


	}
}