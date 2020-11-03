package br.com.mjv.mangahq.usuario.service;

import br.com.mjv.mangahq.mangahq.model.MangaHQ;
import br.com.mjv.mangahq.usuario.model.Usuario;

/**
 * Interface com serviços usados pelo controller referente a usuário
 * @author renan
 *
 */
public interface UsuarioService {
	
	/**
	 * Metodo para fazer busca por um parametro String login
	 * 
	 * @param login
	 * @return um objeto Usuario
	 */
	Usuario buscarPorLogin(String login);
	
	
	/**
	 * Metodo para cadastrar usuário
	 * 
	 * @param usuario
	 * @return um inteiro correspondente ao id do usuario cadastrado
	 */
	Integer cadastrarUsuario(Usuario usuario);
	

	/**
	 * Busca um usuario baseado no ID
	 * @param id
	 * @return um objeto do tipo Usuario
	 */
	Usuario buscarPorId(Integer id);
	
	Integer cadastrarMangaHqParaUsuario(Usuario usuario, MangaHQ mangahq);
}
