package br.com.mjv.mangahq.usuario.dao;

import java.util.List;

import br.com.mjv.mangahq.mangahq.model.MangaHQ;
import br.com.mjv.mangahq.usuario.model.Usuario;

public interface UsuarioDao {

	Usuario buscarPorLogin(String login);
	Usuario buscarPorId(Integer id);
	Integer cadastrarUsuario(Usuario usuario);
	Integer cadastrarMangaHqParaUsuario(Usuario usuario, MangaHQ mangahq);
	
}
