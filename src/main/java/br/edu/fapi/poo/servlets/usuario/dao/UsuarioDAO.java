package br.edu.fapi.poo.servlets.usuario.dao;

import java.util.List;

import br.edu.fapi.poo.servlets.usuario.Usuario;

public interface UsuarioDAO {

	int cadastrar(Usuario aluno);

	Usuario buscar(Usuario aluno);

	Usuario buscarPorEmailSenha(Usuario usuario);

	int excluir(Usuario aluno);

	int atualizar(Usuario aluno);

	List<Usuario> listarTodos();
	
}
