package br.com.mjv.mangahq.mangahq.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.mjv.mangahq.mangahq.model.MangaHQ;

public class MangaHQRowMapper implements RowMapper<MangaHQ> {

	@Override
	public MangaHQ mapRow(ResultSet rs, int rowNum) throws SQLException {
		MangaHQ mangahq = new MangaHQ();
		mangahq.setId_mangahq(rs.getInt("id_mangahq"));
		mangahq.setTitulo(rs.getString("titulo"));
		mangahq.setAutor(rs.getString("autor"));
		mangahq.setUrlCapa(rs.getString("urlCapa"));
		mangahq.setDataAdicao(rs.getDate("dataAdicao"));
		mangahq.setCategoria(rs.getString("categoria"));
		mangahq.setVolumes(rs.getInt("volumes"));
		mangahq.setResumo(rs.getString("resumo"));
		return mangahq;
	}

}
