package br.com.mjv.mangahq.usuario.dao;

import br.com.mjv.mangahq.usuario.model.Usuario;

/**
 * Classe DAO referente a Usuario
 * @author kaique
 *
 */
public interface UsuarioDao {

	/**
	 * Método para buscar um usuario por login
	 * @param login
	 * @return
	 */
	Usuario buscarPorLogin(String login);
	
	/**
	 * Método para buscar um usuario por id
	 * @param id
	 * @return
	 */
	Usuario buscarPorId(Integer id);
	
	/**
	 * Método para cadastrar um usuario
	 * @param usuario
	 * @return
	 */
	Integer cadastrarUsuario(Usuario usuario);
}
