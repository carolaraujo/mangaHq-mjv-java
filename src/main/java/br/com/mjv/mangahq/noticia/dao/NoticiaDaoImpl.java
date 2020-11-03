package br.com.mjv.mangahq.noticia.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

/**
 * Implementação da interface DAO usando H2
 * 
 * @author kaique
 *
 */
@Repository
@PropertySource("classpath:sql/tb_noticias.xml")
public class NoticiaDaoImpl implements NoticiaDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private DataSource ds;

	@Value("${sql.findAll.descBy.acessos}")
	private String SQL_FIND_ALL_DESC_BY_ACESSOS;

	@Autowired
	private NamedParameterJdbcTemplate template;

	@Override
	public List<Noticia> buscarTodasNoticias() {
		try {
			LOGGER.info("Inicio do método buscarTodasNoticias em NoticiaDaoImpl.");
			List<Noticia> noticias = template.query(SQL_FIND_ALL_DESC_BY_ACESSOS, new NoticiaRowMapper());
			return noticias;
		} catch (EmptyResultDataAccessException e) {
			LOGGER.info("Não foi encontrado nenhum registro na tabela.");
			return null;
		} finally {
			LOGGER.info("Fim do método buscarTodasNoticias em NoticiaDaoImpl.");
		}
	}

	@Override
	public Integer cadastrarNoticia(Noticia noticia) {

		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		SimpleJdbcInsert insert = new SimpleJdbcInsert(ds);
		insert.withTableName("TB_NOTICIAS").usingGeneratedKeyColumns("id_noticia");

		MapSqlParameterSource params = new MapSqlParameterSource();


		params.addValue("titulo", noticia.getTitulo());
		params.addValue("textoConteudo", noticia.getTextoConteudo());
		params.addValue("urlImagem", noticia.getUrlImagem());
		params.addValue("dataPublicacao", date.format(formatter));
		params.addValue("autor", "usuario");
		params.addValue("acessos", 0);
		params.addValue("categoria", noticia.getCategoria());

		Integer result = (Integer) insert.executeAndReturnKey(params);

		return result;
	}
}
