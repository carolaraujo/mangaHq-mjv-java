package br.com.mjv.mangahq.mangahq.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.mjv.mangahq.mangahq.model.MangaHQ;
import br.com.mjv.mangahq.usuario.model.Usuario;

@Repository
public class MangaHQDaoImpl implements MangaHQDao {
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private NamedParameterJdbcTemplate template;

	@Override
	public Integer cadastrarMangaHq(MangaHQ mangahq) {
		SimpleJdbcInsert insertMangahq = new SimpleJdbcInsert(ds).usingGeneratedKeyColumns("id_mangahq");
		insertMangahq.withTableName("TB_MANGAS_HQS");
		
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		Map<String, Object> params = new HashMap<>();
		
		params.put("titulo", mangahq.getTitulo());
		params.put("autor", mangahq.getAutor());
		params.put("urlCapa", mangahq.getUrlCapa());
		params.put("dataAdicao", date.format(formatter));
		params.put("categoria", mangahq.getCategoria());
		params.put("volumes", mangahq.getVolumes());
		params.put("resumo", mangahq.getResumo());
		
		Integer result = (Integer) insertMangahq.executeAndReturnKey(params);
		return result;
	}

	@Override
	public List<MangaHQ> listarMeusMangasHqs(Usuario usuario) {
		try {
			String sql = "SELECT u.login, m.* FROM TB_USUARIO u, TB_MANGAS_HQS m  WHERE login = :login AND fk_id_mangahq = id_mangahq";
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("login", usuario.getLogin());
			
			List<MangaHQ> list = template.query(sql, params, new MangaHQRowMapper());
			return list;
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<MangaHQ> todosMangasHqs() {
		try {
			String sql = "SELECT * FROM TB_MANGAS_HQS";	
			List<MangaHQ> list = template.query(sql, new MangaHQRowMapper());
			return list;
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public MangaHQ buscarPorId(Integer id) {
		try {
			String sql = "SELECT * FROM TB_MANGAS_HQS WHERE id_mangahq = :id_mangahq";
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("id_mangahq", id);
			MangaHQ mangahq = template.queryForObject(sql, params, new MangaHQRowMapper());
			return mangahq;
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	

}
