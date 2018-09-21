package br.edu.fapi.poo.servlets.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/controller")
public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("rota");

		if ("pagina1".equalsIgnoreCase(acao)) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/pagina1.jsp");
			requestDispatcher.forward(req, resp);
		} else if ("pagina2".equalsIgnoreCase(acao)) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/pagina2.jsp");
			requestDispatcher.forward(req, resp);
		} else if ("pagina3".equalsIgnoreCase(acao)) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/pagina3.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/main.jsp");
			requestDispatcher.forward(req, resp);
		}
	}

}
