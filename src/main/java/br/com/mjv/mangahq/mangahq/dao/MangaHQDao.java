package br.com.mjv.mangahq.mangahq.dao;

import java.util.List;

import br.com.mjv.mangahq.mangahq.model.MangaHQ;

public interface MangaHQDao {
	Integer cadastrarMangaHq(MangaHQ mangahq);
	List<MangaHQ> listarMeusMangasHqs();
	List<MangaHQ> mangasHqsNaoAdquiridos();
}
