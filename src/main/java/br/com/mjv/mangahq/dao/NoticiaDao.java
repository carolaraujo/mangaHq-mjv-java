package br.com.mjv.mangahq.dao;

import java.util.List;

import br.com.mjv.mangahq.model.Noticia;

public interface NoticiaDao {
	List<Noticia> buscarTodasNoticias();
}
