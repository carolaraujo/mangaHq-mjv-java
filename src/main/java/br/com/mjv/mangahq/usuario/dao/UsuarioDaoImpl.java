package br.com.mjv.mangahq.usuario.dao;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.mjv.mangahq.enums.TipoUsuario;
import br.com.mjv.mangahq.usuario.model.Usuario;

/**
 * Classe de implementação da interface {@link UsuarioDao}
 * @author kaique
 *
 */
@Repository
@PropertySource("classpath:sql/tb_usuario.xml")
public class UsuarioDaoImpl implements UsuarioDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioDaoImpl.class);
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	private DataSource ds;
	
	@Value("${sql.findUsuario.by.login}")
	private String SQL_FINDUSUARIO_BY_LOGIN;
	
	@Value("${sql.findUsuario.by.id}")
	private String SQL_FINDUSUARIO_BY_ID;
	
	@Override
	public Usuario buscarPorLogin(String login) {
		try {
			LOGGER.info("UsuarioDaoImpl - Inicio do método buscarPorLogin");
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("login", login);
			
			Usuario usuario = template.queryForObject(SQL_FINDUSUARIO_BY_LOGIN, params, new UsuarioRowMapper());
			return usuario;
		} catch (EmptyResultDataAccessException e) {
			LOGGER.error("UsuarioDaoImpl - " + e.getMessage());
			return null;
		} finally {
			LOGGER.info("UsuarioDaoImpl - Inicio do método buscarPorLogin");
		}
	}

	@Override
	public Integer cadastrarUsuario(Usuario usuario) {
		LOGGER.info("UsuarioDaoImpl - Inicio do método cadastrarUsuario");
		SimpleJdbcInsert insert = new SimpleJdbcInsert(ds);
		insert.withTableName("TB_USUARIO").usingGeneratedKeyColumns("id_usuario");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("nome", usuario.getNome());
		params.addValue("login", usuario.getLogin());
		params.addValue("tipoUsuario", TipoUsuario.NORMAL.name());
		
		Integer id = (Integer) insert.executeAndReturnKey(params);
		LOGGER.info("UsuarioDaoImpl - Fim do método cadastrarUsuario");
		return id;
	}

	@Override
	public Usuario buscarPorId(Integer id) {
		try {
			LOGGER.info("UsuarioDaoImpl - Inicio do método buscarPorId");
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("id", id);
			
			Usuario usuario = template.queryForObject(SQL_FINDUSUARIO_BY_ID, params, new UsuarioRowMapper());
			return usuario;
		} catch (EmptyResultDataAccessException e) {
			LOGGER.error("UsuarioDaoImpl - " + e.getMessage());
			return null;
		} finally {
			LOGGER.info("UsuarioDaoImpl - Inicio do método buscarPorId");
		}
	}
}
