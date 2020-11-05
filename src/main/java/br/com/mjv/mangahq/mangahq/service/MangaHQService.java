package br.com.mjv.mangahq.mangahq.service;

import java.util.List;

import br.com.mjv.mangahq.mangahq.model.MangaHQ;
import br.com.mjv.mangahq.usuario.model.Usuario;

/**
 * Classe de services referentes a MangasHQs
 * @author kaique
 *
 */
public interface MangaHQService {
	/**
	 * Cadastra um novo manga/hq na lista de mangás do site
	 * @param mangahq
	 * @return o id do mangá
	 */
	Integer cadastrarNovoMangaHq(MangaHQ mangahq);
	
	/**
	 * Lista todos os mangás/hqs que o usuário possui
	 * @param usuario
	 * @return uma lista com todos os mangas/hqs que o usuário possui
	 */
	List<MangaHQ> listarMangasHqsUsuario(Usuario usuario);
	
	/**
	 * Lista todos os mangas/hqs cadastrados no sistema
	 * @return uma lista com todos os mangas/hqs cadastrados no sistema
	 */
	List<MangaHQ> todosMangasHqsCadastrados();
	
	/**
	 * Lista de mangas não adquiridos pelo usuario
	 * @param usuario
	 * @return uma lista com todos os mangas/hqs não adquiridos pelo usuario
	 */
	List<MangaHQ> mangasHqsNaoAdquiridos(Usuario usuario);
	
	/**
	 * Busca um manga/hq pelo id
	 * @param id
	 * @return uma manga/hq
	 */
	MangaHQ buscarPorId(Integer id);
	
	/**
	 * Método ativado ao clicar no botão adquirir na view. Inclui um manga/hq não adquirido
	 * a lista de mangas adquiridos
	 * @param usuario
	 * @param mangahq
	 */
	void adquirirMangaHq(Usuario usuario, MangaHQ mangahq);
}
