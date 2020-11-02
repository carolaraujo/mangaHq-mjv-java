package br.com.mjv.mangahq.mangahq.service;

import java.util.List;

import br.com.mjv.mangahq.mangahq.model.MangaHQ;

public interface MangaHQService {
	Integer cadastrarMangaHq(MangaHQ mangahq);
	List<MangaHQ> listarMeusMangasHqs();
	List<MangaHQ> mangasHqsNaoAdquiridos();
}
