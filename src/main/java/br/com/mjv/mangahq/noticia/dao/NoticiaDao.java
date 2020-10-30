package br.com.mjv.mangahq.noticia.dao;

import java.util.List;

import br.com.mjv.mangahq.noticia.model.Noticia;

/**
 * Interface com métodos padrão para acesso a dados
 * @author kaique
 *
 */

public interface NoticiaDao {
	List<Noticia> buscarTodasNoticias();
	
	
}
