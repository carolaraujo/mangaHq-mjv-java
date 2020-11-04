package br.com.mjv.mangahq.mangahq.dao;

import java.util.List;

import br.com.mjv.mangahq.mangahq.model.MangaHQ;
import br.com.mjv.mangahq.usuario.model.Usuario;

public interface MangaHQDao {
	Integer cadastrarNovoMangaHq(MangaHQ mangahq);
	List<MangaHQ> listarMangasHqsUsuario(Usuario usuario);
	List<MangaHQ> todosMangasHqsCadastrados();
	MangaHQ buscarPorId(Integer id);
	void adquirirMangaHq(Usuario usuario, MangaHQ mangahq);
}
