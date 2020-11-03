package br.com.mjv.mangahq.mangahq.dao;

import java.util.List;

import br.com.mjv.mangahq.mangahq.model.MangaHQ;
import br.com.mjv.mangahq.usuario.model.Usuario;

public interface MangaHQDao {
	Integer cadastrarMangaHq(MangaHQ mangahq);
	List<MangaHQ> listarMeusMangasHqs(Usuario usuario);
	List<MangaHQ> todosMangasHqs();
	MangaHQ buscarPorId(Integer id);
}
