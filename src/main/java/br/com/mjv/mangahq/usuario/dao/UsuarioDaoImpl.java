package br.com.mjv.mangahq.usuario.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.mjv.mangahq.enums.TipoUsuario;
import br.com.mjv.mangahq.home.controller.HomeController;
import br.com.mjv.mangahq.mangahq.dao.MangaHQRowMapper;
import br.com.mjv.mangahq.mangahq.model.MangaHQ;
import br.com.mjv.mangahq.noticia.dao.NoticiaRowMapper;
import br.com.mjv.mangahq.noticia.model.Noticia;
import br.com.mjv.mangahq.usuario.model.Usuario;


@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	private DataSource ds;

	
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
		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(ds);
		insert.withTableName("TB_USUARIO").usingGeneratedKeyColumns("id_usuario");
		
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("nome", usuario.getNome());
		params.addValue("login", usuario.getLogin());
		params.addValue("tipoUsuario", TipoUsuario.NORMAL.name());
		params.addValue("dataCriacao", date.format(formatter));
		
		Integer id = (Integer) insert.executeAndReturnKey(params);
		
		return id;
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

	@Override
	public Integer cadastrarMangaHqParaUsuario(Usuario usuario, MangaHQ mangahq) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(ds);
		insert.withTableName("TB_USUARIO").usingGeneratedKeyColumns("id_usuario");
		
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("nome", usuario.getNome());
		params.addValue("login", usuario.getLogin());
		params.addValue("tipoUsuario", usuario.getTipoUsuario());
		params.addValue("dataCriacao", date.format(formatter));
		params.addValue("fk_id_mangahq", mangahq.getId_mangahq());
		
		Integer id = (Integer) insert.executeAndReturnKey(params);
		
		
		return id;
	}

	



}
