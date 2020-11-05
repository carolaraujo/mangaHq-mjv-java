package br.com.mjv.mangahq.usuario.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjv.mangahq.exceptions.ImpossibleInsertException;
import br.com.mjv.mangahq.exceptions.UserNotFoundException;
import br.com.mjv.mangahq.usuario.dao.UsuarioDao;
import br.com.mjv.mangahq.usuario.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private UsuarioDao dao;
	
	@Override
	public Usuario buscarPorLogin(String login) throws UserNotFoundException {
		LOGGER.info("Inicio do método Service de busca por login");
		Usuario usuario = dao.buscarPorLogin(login);
		if(usuario == null) {
			LOGGER.error("Não foi possível encontrar o usuário com o login indicado");
			throw new UserNotFoundException("Não foi possível encontrar o usuário com o login indicado");
		}
		LOGGER.info("Fim método Service de busca por login");
		return usuario;
	}
	
	@Override
	public Usuario buscarPorId(Integer id) throws UserNotFoundException {
		LOGGER.info("Inicio do método Service de busca por id");
		Usuario usuario = dao.buscarPorId(id);
		if(usuario == null) {
			LOGGER.error("Não foi possível encontrar o usuário com o login indicado");
			throw new UserNotFoundException("Não foi possível encontrar o usuário com o id indicado");
		}
		LOGGER.info("Fim método Service de busca por id");
		return usuario;
	}

	@Override
	public Integer cadastrarUsuario(Usuario usuario) throws ImpossibleInsertException {
		LOGGER.info("Inicio do método Service de cadastro de usuario");
		Integer id = dao.cadastrarUsuario(usuario);
		if(id == 0) {
			LOGGER.error("Não foi possível cadastrar o usuario, tente mais tarde");
			throw new ImpossibleInsertException("Não foi possível encontrar o usuário com o id indicado");
		}
		return id;
	}
}
