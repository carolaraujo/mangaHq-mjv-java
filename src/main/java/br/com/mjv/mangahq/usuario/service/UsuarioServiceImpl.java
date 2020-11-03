package br.com.mjv.mangahq.usuario.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjv.mangahq.mangahq.model.MangaHQ;
import br.com.mjv.mangahq.usuario.dao.UsuarioDao;
import br.com.mjv.mangahq.usuario.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private UsuarioDao dao;
	
	@Override
	public Usuario buscarPorLogin(String login) {
		Usuario usuario = dao.buscarPorLogin(login);
		return usuario;
	}
	
	@Override
	public Usuario buscarPorId(Integer id) {
		Usuario usuario = dao.buscarPorId(id);
		return usuario;
	}

	@Override
	public Integer cadastrarUsuario(Usuario usuario) {
		Integer id = dao.cadastrarUsuario(usuario);
		
		return id;
	}

	@Override
	public Integer cadastrarMangaHqParaUsuario(Usuario usuario, MangaHQ mangahq) {
		Integer id = dao.cadastrarMangaHqParaUsuario(usuario, mangahq);
		
		return id;
	}


}
