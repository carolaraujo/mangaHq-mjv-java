package br.com.mjv.mangahq.usuario.dao;

import br.com.mjv.mangahq.usuario.model.Usuario;

public interface UsuarioDao {

	Usuario buscarPorLogin(String login);
	Usuario buscarPorId(Integer id);
	Integer cadastrarUsuario(Usuario usuario);	
}
