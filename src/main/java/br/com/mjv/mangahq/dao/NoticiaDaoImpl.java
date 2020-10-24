package br.com.mjv.mangahq.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.mjv.mangahq.model.Noticia;

@Repository
public class NoticiaDaoImpl implements NoticiaDao {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Override
	public List<Noticia> buscarTodasNoticias() {
		try {
			final String SQL = "SELECT * FROM TB_NOTICIAS ORDER BY acessos DESC;";
			List<Noticia> noticias = template.query(SQL, new NoticiaRowMapper());
			return noticias;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

}
