package br.com.mjv.mangahq.usuario.service;

import br.com.mjv.mangahq.exceptions.ImpossibleInsertException;
import br.com.mjv.mangahq.exceptions.UserNotFoundException;
import br.com.mjv.mangahq.usuario.model.Usuario;

/**
 * Interface service referente a usuário
 * @author renan
 *
 */
public interface UsuarioService {
	
	/**
	 * Metodo para fazer busca por um parametro String login
	 * 
	 * @param login
	 * @return um objeto Usuario
	 * @throws UserNotFoundException 
	 */
	Usuario buscarPorLogin(String login) throws UserNotFoundException;
	
	
	/**
	 * Metodo para cadastrar usuário
	 * 
	 * @param usuario
	 * @return um inteiro correspondente ao id do usuario cadastrado
	 * @throws ImpossibleInsertException 
	 */
	Integer cadastrarUsuario(Usuario usuario) throws ImpossibleInsertException;
	

	/**
	 * Busca um usuario baseado no ID
	 * @param id
	 * @return um objeto do tipo Usuario
	 * @throws UserNotFoundException 
	 */
	Usuario buscarPorId(Integer id) throws UserNotFoundException;
	
	/**
	 * Método para verificar se um usuário já existe ao realizar um cadastro
	 * @param usuario
	 * @return
	 */
	Boolean verificarSeUsuarioExiste(Usuario usuario);
}
