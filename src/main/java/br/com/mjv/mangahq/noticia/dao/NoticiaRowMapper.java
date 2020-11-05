package br.com.mjv.mangahq.noticia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.mjv.mangahq.enums.Categoria;
import br.com.mjv.mangahq.noticia.model.Noticia;

/**
 * Classe rowMapper representando a tabela TB_NOTICIA
 * @author kaique
 *
 */
public class NoticiaRowMapper implements RowMapper<Noticia>{

	@Override
	public Noticia mapRow(ResultSet rs, int rowNum) throws SQLException {
		Noticia noticia = new Noticia();
		noticia.setId_noticia(rs.getLong("id_noticia"));
		noticia.setTitulo(rs.getString("titulo"));
		noticia.setTextoConteudo(rs.getString("textoConteudo"));
		noticia.setUrlImagem(rs.getString("urlImagem"));
		noticia.setDataPublicacao(rs.getDate("dataPublicacao"));
		noticia.setAutor(rs.getString("autor"));
		noticia.setCategoria(Categoria.valueOf(rs.getString("categoria")));
		return noticia;
	}

}
