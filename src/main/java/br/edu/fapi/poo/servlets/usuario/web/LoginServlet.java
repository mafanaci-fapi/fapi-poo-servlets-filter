package br.edu.fapi.poo.servlets.usuario.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fapi.poo.servlets.usuario.Usuario;
import br.edu.fapi.poo.servlets.usuario.service.LoginService;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private LoginService loginService = new LoginService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");

		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);

		boolean logado = loginService.login(usuario);
		if (logado) {
			//Cookie cookieUsuarioLogado = new Cookie("usuario.logado", Base64.getEncoder().encodeToString(email.getBytes()));
			Cookie cookieUsuarioLogado = new Cookie("usuario.logado", email);
			//cookieUsuarioLogado.setMaxAge(30);
			resp.addCookie(cookieUsuarioLogado);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/main.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
			requestDispatcher.forward(req, resp);
		}
	}

}
