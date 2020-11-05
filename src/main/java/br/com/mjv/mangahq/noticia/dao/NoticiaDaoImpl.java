package br.com.mjv.mangahq.noticia.dao;

import java.util.List;

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

import br.com.mjv.mangahq.home.controller.HomeController;
import br.com.mjv.mangahq.noticia.model.Noticia;
import br.com.mjv.mangahq.usuario.model.Usuario;

/**
 * Implementação da interface DAO usando H2
 * 
 * @author kaique
 *
 */
@Repository
@PropertySource("classpath:sql/tb_noticias.xml")
public class NoticiaDaoImpl implements NoticiaDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(NoticiaDaoImpl.class);

	@Autowired
	private DataSource ds;

	@Value("${sql.findAll}")
	private String SQL_FIND_ALL;

	@Autowired
	private NamedParameterJdbcTemplate template;

	@Override
	public List<Noticia> buscarTodasNoticias() {
		try {
			LOGGER.info("NoticiaDaoImpl - Inicio do método buscarTodasNoticias");
			List<Noticia> noticias = template.query(SQL_FIND_ALL, new NoticiaRowMapper());
			return noticias;
		} catch (EmptyResultDataAccessException e) {
			LOGGER.info("Não foi encontrado nenhum registro na tabela.");
			return null;
		} finally {
			LOGGER.info("NoticiaDaoImpl - Fim do método buscarTodasNoticias");
		}
	}

	@Override
	public Integer cadastrarNoticia(Noticia noticia, Usuario usuario) {
		LOGGER.info("NoticiaDaoImpl - Inicio do método cadastrarNoticia");
		SimpleJdbcInsert insert = new SimpleJdbcInsert(ds);
		insert.withTableName("TB_NOTICIAS").usingGeneratedKeyColumns("id_noticia");
		insert.usingColumns("titulo","textoConteudo","urlImagem","autor","categoria");
		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("titulo", noticia.getTitulo());
		params.addValue("textoConteudo", noticia.getTextoConteudo());
		params.addValue("urlImagem", noticia.getUrlImagem());
		params.addValue("autor", usuario.getNome() + " - " + usuario.getLogin());
		params.addValue("categoria", noticia.getCategoria());

		Integer result = (Integer) insert.executeAndReturnKey(params);
		LOGGER.info("NoticiaDaoImpl - Fim do método cadastrarNoticia");
		return result;
	}
}
