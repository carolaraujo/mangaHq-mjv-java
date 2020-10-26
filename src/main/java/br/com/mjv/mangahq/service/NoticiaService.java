package br.com.mjv.mangahq.service;

import java.util.List;

import br.com.mjv.mangahq.model.Noticia;

public interface NoticiaService {
	List<Noticia> buscarTodasNoticias();
	List<Noticia> buscarNoticias(Integer quantidade);
}
