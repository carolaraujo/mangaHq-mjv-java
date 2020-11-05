package br.com.mjv.mangahq.mangahq.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import br.com.mjv.mangahq.mangahq.controller.MangaHQController;
import br.com.mjv.mangahq.mangahq.model.MangaHQ;
import br.com.mjv.mangahq.usuario.model.Usuario;

@Repository
@PropertySource("classpath:sql/tb_mangas_hqs.xml")
public class MangaHQDaoImpl implements MangaHQDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MangaHQDaoImpl.class);
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Value("${sql.findAll.mangashqs.userHave.by.id}")
	private String SQL_FINDALL_MANGASHQS_USERHAVE_BY_ID;
	
	@Value("${sql.findAll.mangashqs}")
	private String SQL_FINDALL_MANGASHQS;
	
	@Value("${sql.find.mangashqs.by.id}")
	private String SQL_FIND_MANGASHQS_BY_ID;

	@Override
	public Integer cadastrarNovoMangaHq(MangaHQ mangahq) {
		LOGGER.info("MangaHQDaoImpl - Início do método cadastrarNovoManga");
		SimpleJdbcInsert insertMangahq = new SimpleJdbcInsert(ds).usingGeneratedKeyColumns("id_mangahq");
		insertMangahq.withTableName("TB_MANGAS_HQS");
		insertMangahq.usingColumns("titulo","autor","urlCapa","categoria","volumes","resumo");
		Map<String, Object> params = new HashMap<>();
		
		params.put("titulo", mangahq.getTitulo());
		params.put("autor", mangahq.getAutor());
		params.put("urlCapa", mangahq.getUrlCapa());
		params.put("categoria", mangahq.getCategoria());
		params.put("volumes", mangahq.getVolumes());
		params.put("resumo", mangahq.getResumo());
		
		Integer result = (Integer) insertMangahq.executeAndReturnKey(params);
		LOGGER.info("MangaHQDaoImpl - Fim do método cadastrarNovoManga");
		return result;
	}

	@Override
	public List<MangaHQ> listarMangasHqsUsuario(Usuario usuario) {
		try {
			LOGGER.info("MangaHQDaoImpl - Início do método listarMangasHqsUsuario");
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("id_usuario", usuario.getId_usuario());
			
			List<MangaHQ> list = template.query(SQL_FINDALL_MANGASHQS_USERHAVE_BY_ID, params, new MangaHQRowMapper());
			return list;
		}catch(EmptyResultDataAccessException e) {
			LOGGER.error("MangaHQDaoImpl - " + e.getMessage());
			return null;
		}finally {
			LOGGER.info("MangaHQDaoImpl - Fim do método listarMangasHqsUsuario");
		}
	}

	@Override
	public List<MangaHQ> todosMangasHqsCadastrados() {
		try {
			LOGGER.info("MangaHQDaoImpl - Início do método todosMangasHqsCadastrados");
			List<MangaHQ> list = template.query(SQL_FINDALL_MANGASHQS, new MangaHQRowMapper());
			return list;
		}catch(EmptyResultDataAccessException e) {
			LOGGER.error("MangaHQDaoImpl - " + e.getMessage());
			return null;
		}finally {
			LOGGER.info("MangaHQDaoImpl - Fim do método todosMangasHqsCadastrados");
		}
	}

	@Override
	public MangaHQ buscarPorId(Integer id) {
		try {
			LOGGER.info("MangaHQDaoImpl - Início do método buscarPorId");
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("id_mangahq", id);
			MangaHQ mangahq = template.queryForObject(SQL_FIND_MANGASHQS_BY_ID, params, new MangaHQRowMapper());
			return mangahq;
		}catch(EmptyResultDataAccessException e) {
			LOGGER.error("MangaHQDaoImpl - " + e.getMessage());
			return null;
		}finally {
			LOGGER.info("MangaHQDaoImpl - Fim do método buscarPorId");
		}
	}

	@Override
	public void adquirirMangaHq(Usuario usuario, MangaHQ mangahq) {
		LOGGER.info("MangaHQDaoImpl - Início do método adquirirMangaHq");
		SimpleJdbcInsert insert = new SimpleJdbcInsert(ds);
		insert.withTableName("TB_USUARIO_MANGASHQS");
		insert.usingColumns("fk_id_usuario", "fk_id_mangahq");

		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("fk_id_usuario", usuario.getId_usuario());
		params.addValue("fk_id_mangahq", mangahq.getId_mangahq());

		insert.execute(params);
		LOGGER.info("MangaHQDaoImpl - Fim do método adquirirMangaHq");
	}
}
