package br.com.mjv.mangahq.noticia.dao;

import java.util.List;

import br.com.mjv.mangahq.noticia.model.Noticia;
import br.com.mjv.mangahq.usuario.model.Usuario;

/**
 * Interface com métodos padrão para acesso a dados
 * @author kaique
 */
public interface NoticiaDao {
	
	/**
	 * Busca todas as notícias no banco de dados.
	 * @return um objeto do tipo {@link List<Noticia>} devidamente populado.
	 */
	List<Noticia> buscarTodasNoticias();
	
	/**
	 * Cadastra uma notícia no banco de dados.
	 * @param noticia
	 * @return o id da notícia cadastrada.
	 */
	Integer cadastrarNoticia(Noticia noticia, Usuario usuario);
}
