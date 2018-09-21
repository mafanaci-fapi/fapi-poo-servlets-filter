package br.edu.fapi.poo.servlets.usuario.service;

import br.edu.fapi.poo.servlets.usuario.Usuario;
import br.edu.fapi.poo.servlets.usuario.dao.UsuarioDAO;
import br.edu.fapi.poo.servlets.usuario.dao.impl.MockUsuarioDAOImpl;

public class LoginService {

	private UsuarioDAO usuarioDAO;

	public LoginService() {
		this.usuarioDAO = new MockUsuarioDAOImpl();
	}

	public LoginService(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public boolean login(Usuario usuario) {
		Usuario busca = usuarioDAO.buscarPorEmailSenha(usuario);
		if (busca != null) {
			return true;
		}
		return false;
	}

}
