package br.com.mjv.mangahq.usuario.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.mjv.mangahq.usuario.model.Usuario;


@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Override
	public Usuario buscarPorLogin(String login) {
		LOGGER.info("incio do método DAO de buscar login");
		String sql = "SELECT ( id_usuario, nome, login, tipoUsuario, dataCriacao ) FROM TB_USUARIO WHERE login = ?";
		
		Usuario usuario = jdbcTemplate.queryForObject(sql, new UsuarioRowMapper(), login);
		
		return usuario;
		
		
		
//		
//		MapSqlParameterSource params = new MapSqlParameterSource();
//		params.addValue("login", login);
//		
//		try {
//			Usuario usuario = template.queryForObject(sql, params, new UsuarioRowMapper());
//			LOGGER.info("fim do método DAO de buscar login");
//			return usuario;
//		}catch(EmptyResultDataAccessException e) {
//			LOGGER.error("erro ao buscar usuario" + e);
//			return null;
//		}
	}

	@Override
	public Integer cadastrarUsuario(Usuario usuario) {
		
		
		return null;
	}

}
