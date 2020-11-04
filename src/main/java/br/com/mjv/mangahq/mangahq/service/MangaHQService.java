package br.com.mjv.mangahq.mangahq.service;

import java.util.List;

import br.com.mjv.mangahq.mangahq.model.MangaHQ;
import br.com.mjv.mangahq.usuario.model.Usuario;

public interface MangaHQService {
	Integer cadastrarNovoMangaHq(MangaHQ mangahq);
	List<MangaHQ> listarMangasHqsUsuario(Usuario usuario);
	List<MangaHQ> todosMangasHqsCadastrados();
	List<MangaHQ> mangasHqsNaoAdquiridos(Usuario usuario);
	MangaHQ buscarPorId(Integer id);
	void adquirirMangaHq(Usuario usuario, MangaHQ mangahq);
}
