package br.edu.fapi.poo.servlets.usuario.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fapi.poo.servlets.usuario.utils.CookieUtils;

@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie = CookieUtils.getCookieUsuarioLogado(req);
		RequestDispatcher requestDispatcher = null;
		if (cookie == null) {
			System.out.println("Usuário não estava logado");
			requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/logout/logoutError.jsp");
		}else {
			System.out.println("Deslogando usuário");
			requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/logout/logout.jsp");
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
		}
		requestDispatcher.forward(req, resp);
	}

}
