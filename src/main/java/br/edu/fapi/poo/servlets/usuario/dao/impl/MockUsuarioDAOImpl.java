package br.edu.fapi.poo.servlets.usuario.dao.impl;

import java.util.ArrayList;
import java.util.List;

import br.edu.fapi.poo.servlets.usuario.Usuario;
import br.edu.fapi.poo.servlets.usuario.dao.UsuarioDAO;

public class MockUsuarioDAOImpl implements UsuarioDAO{

	private List<Usuario> usuarios = new ArrayList<>();

	public MockUsuarioDAOImpl() {
		Usuario usuario = new Usuario();
		usuario.setEmail("admin@fapi.edu.br");
		usuario.setSenha("admin");
		usuarios.add(usuario);
	}
	
	public int cadastrar(Usuario aluno) {
		usuarios.add(aluno);
		return 1;
	}

	public Usuario buscar(Usuario aluno) {
		for (Usuario alunoLista : usuarios) {
			if (alunoLista.equals(aluno)) {
				return alunoLista;
			}
		}
		return null;
	}

	public Usuario buscarPorEmailSenha(Usuario usuario) {
		for (Usuario usuarioLista : usuarios) {
			if (usuarioLista.equals(usuario)) {
				return usuarioLista;
			}
		}
		return null;
	}
	
	public int excluir(Usuario aluno) {
		return usuarios.remove(aluno) ? 1 : 0;
	}

	public int atualizar(Usuario aluno) {
		Usuario alunoEncontrado = null;
		for (Usuario alunoLista : usuarios) {
			if (alunoLista.equals(aluno)) {
				alunoEncontrado = alunoLista;
				break;
			}
		}
		if (alunoEncontrado != null) {
			alunoEncontrado = aluno;
			return 1;
		} else {
			return 0;
		}

	}

	public List<Usuario> listarTodos() {
		return usuarios;
	}

}
