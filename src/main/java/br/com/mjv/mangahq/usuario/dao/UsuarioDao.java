package br.com.mjv.mangahq.usuario.dao;

import br.com.mjv.mangahq.usuario.model.Usuario;

public interface UsuarioDao {

	Usuario buscarPorLogin(String login);
	Integer cadastrarUsuario(Usuario usuario);
}
