package br.com.mjv.mangahq.mangahq.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.mjv.mangahq.mangahq.model.MangaHQ;

@Repository
public class MangaHQDaoImpl implements MangaHQDao {
	
	@Autowired
	private DataSource ds;

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
	public List<MangaHQ> listarMeusMangasHqs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MangaHQ> mangasHqsNaoAdquiridos() {
		// TODO Auto-generated method stub
		return null;
	}

}
