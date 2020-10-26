package br.com.mjv.mangahq.service;

import java.util.List;

import br.com.mjv.mangahq.model.Noticia;

/**
 * Interface com serviços usados pelo controller referente a noticias
 * @author kaique
 *
 */

public interface NoticiaService {
	List<Noticia> buscarTodasNoticias();
	List<Noticia> buscarNoticias(Integer quantidadeNoticias);
	List<Noticia> buscarNoticias(Integer quantidadeNoticias, Integer quantidadePalavras);
}
