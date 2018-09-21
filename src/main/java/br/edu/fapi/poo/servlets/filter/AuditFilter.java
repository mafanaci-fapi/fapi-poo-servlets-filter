package br.edu.fapi.poo.servlets.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import br.edu.fapi.poo.servlets.usuario.utils.CookieUtils;

@WebFilter(urlPatterns = "/*")
public class AuditFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();

		System.out.println("Usuário " + checkUser(req) + " está acessando a URI: " + uri);
		if(req.getParameterMap() != null) {
			req.getParameterMap().forEach((key, value) -> System.out.println("Parâmetro:" + key + " Valor: " + Arrays.toString(value)));	
		}
		
		chain.doFilter(request, response);
	}

	private String checkUser(HttpServletRequest req) {
		Cookie cookie = CookieUtils.getCookieUsuarioLogado(req);
		if (cookie == null) {
			return "<deslogado>";
		}
		return cookie.getValue();
	}

}
