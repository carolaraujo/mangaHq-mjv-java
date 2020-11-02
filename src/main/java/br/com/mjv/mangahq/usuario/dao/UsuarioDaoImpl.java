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
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import br.com.mjv.mangahq.home.controller.HomeController;
import br.com.mjv.mangahq.noticia.dao.NoticiaRowMapper;
import br.com.mjv.mangahq.noticia.model.Noticia;
import br.com.mjv.mangahq.usuario.model.Usuario;


@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Override
	public Usuario buscarPorLogin(String login) {
		String sql = "SELECT * FROM TB_USUARIO WHERE login = :login FETCH FIRST 1 ROWS ONLY";
		try {
			LOGGER.info("Inicio do método buscarPorLogin em UsuarioDaoImpl.");
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("login", login);
			
			Usuario usuario = template.queryForObject(sql, params, new UsuarioRowMapper());
			return usuario;
		} catch (EmptyResultDataAccessException e) {
			LOGGER.info("Não foi encontrado nenhum registro na tabela com o nome " + login);
			return null;
		} finally {
			LOGGER.info("Fim do método buscarPorLogin em UsuarioDaoImpl.");
		}
	}

	@Override
	public Integer cadastrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscarPorId(Integer id) {
		String sql = "SELECT * FROM TB_USUARIO WHERE id_usuario = :id FETCH FIRST 1 ROWS ONLY";
		try {
			LOGGER.info("Inicio do método buscarPorId em UsuarioDaoImpl.");
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("id", id);
			
			Usuario usuario = template.queryForObject(sql, params, new UsuarioRowMapper());
			return usuario;
		} catch (EmptyResultDataAccessException e) {
			LOGGER.info("Não foi encontrado nenhum registro na tabela com o id " + id);
			return null;
		} finally {
			LOGGER.info("Fim do método buscarPorId em UsuarioDaoImpl.");
		}
	}



}
