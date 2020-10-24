package br.com.mjv.mangahq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjv.mangahq.dao.NoticiaDao;
import br.com.mjv.mangahq.model.Noticia;

@Service
public class NoticiaServiceImpl implements NoticiaService{

	@Autowired
	private NoticiaDao dao;
	
	@Override
	public List<Noticia> buscarTodasNoticias() {
		return dao.buscarTodasNoticias();
	}

}
