package br.com.mjv.mangahq.mangahq.service;

import java.util.List;

import br.com.mjv.mangahq.mangahq.model.MangaHQ;
import br.com.mjv.mangahq.usuario.model.Usuario;

public interface MangaHQService {
	Integer cadastrarMangaHq(MangaHQ mangahq);
	List<MangaHQ> listarMeusMangasHqs(Usuario usuario);
	List<MangaHQ> todosMangasHqs();
	List<MangaHQ> mangasHqsNaoAdquiridos(Usuario usuario);
	MangaHQ buscarPorId(Integer id);
}
