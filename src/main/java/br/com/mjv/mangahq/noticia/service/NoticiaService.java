package br.com.mjv.mangahq.noticia.service;

import java.util.List;

import br.com.mjv.mangahq.exceptions.ImpossibleInsertException;
import br.com.mjv.mangahq.noticia.model.Noticia;
import br.com.mjv.mangahq.usuario.model.Usuario;

/**
 * Interface com serviços usados pelo controller referente a noticias
 * @author kaique
 *
 */
public interface NoticiaService {
	
	/**
	 * Acessa o método {@link NoticiaDao.buscarTodasNoticias()}.
	 * @return Um objeto do tipo {@link List<Noticia>} devidamente populado.
	 */
	List<Noticia> buscarTodasNoticias();
	
	/**
	 * Método para retornar uma quantidade de noticias de acordo com o @param quantidadeNoticias
	 * @param quantidadeNoticias
	 * @return Um objeto do tipo {@link List<Noticia>} devidamente populado.
	 */
	List<Noticia> buscarNoticias(Integer quantidadeNoticias);
	
	/**
	 * Método para retornar uma quantidade de noticias de acordo com o @param quantidadeNoticias e
	 * uma quantidade limitada de palavras de acordo com o @param quantidadePalavras 
	 * @param quantidadeNoticias
	 * @param quantidadePalavras
	 * @return Um objeto do tipo {@link List<Noticia>} devidamente populado.
	 */
	List<Noticia> buscarNoticias(Integer quantidadeNoticias, Integer quantidadePalavras);
	
	/**
	 * Método para cadastrar uma nova notícia no banco de dados
	 * @param noticia
	 * @param usuario
	 * @return um numero correspondente ao id da notícia
	 * @throws ImpossibleInsertException 
	 */
	Integer cadastrarNoticia(Noticia noticia, Usuario usuario) throws ImpossibleInsertException;
	
}
