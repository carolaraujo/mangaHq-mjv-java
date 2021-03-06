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
		LOGGER.info("UsuarioServiceImpl - Inicio do método buscarPorLogin");
		Usuario usuario = dao.buscarPorLogin(login);
		if(usuario == null) {
			LOGGER.error("Não foi possível encontrar o usuário com o login indicado");
			throw new UserNotFoundException("Não foi possível encontrar o usuário com o login indicado");
		}
		LOGGER.info("UsuarioServiceImpl - F do método buscarPorLogin");
		return usuario;
	}
	
	@Override
	public Usuario buscarPorId(Integer id) throws UserNotFoundException {
		LOGGER.info("UsuarioServiceImpl - Inicio do método buscarPorId");
		Usuario usuario = dao.buscarPorId(id);
		if(usuario == null) {
			LOGGER.error("Não foi possível encontrar o usuário com o id indicado");
			throw new UserNotFoundException("Não foi possível encontrar o usuário com o id indicado");
		}
		LOGGER.info("UsuarioServiceImpl - Fim do método buscarPorId");
		return usuario;
	}

	@Override
	public Integer cadastrarUsuario(Usuario usuario) throws ImpossibleInsertException {
		LOGGER.info("UsuarioServiceImpl - Inicio do método cadastrarUsuario");
		Integer id = dao.cadastrarUsuario(usuario);
		if(id == 0) {
			LOGGER.error("Não foi possível cadastrar o usuario, tente mais tarde");
			throw new ImpossibleInsertException("Não foi possível encontrar o usuário com o id indicado");
		}
		LOGGER.info("UsuarioServiceImpl - Fim do método cadastrarUsuario");
		return id;
	}

	@Override
	public Boolean verificarSeUsuarioExiste(Usuario usuario) {
		try {
			LOGGER.info("UsuarioServiceImpl - Inicio do método verificarSeUsuarioExiste");
			buscarPorLogin(usuario.getLogin());
			return true;
		} catch (UserNotFoundException e) {
			LOGGER.info("UsuarioServiceImpl - Usuário não encontrado, realizando cadastro...");
			return false;
		}finally {
			LOGGER.info("UsuarioServiceImpl - Fim do método verificarSeUsuarioExiste");
		}
	}
}
