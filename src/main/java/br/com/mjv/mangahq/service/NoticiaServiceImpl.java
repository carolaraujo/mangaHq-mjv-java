package br.com.mjv.mangahq.service;

import java.util.Arrays;
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

	@Override
	public List<Noticia> buscarNoticias(Integer quantidade) {
		List<Noticia> noticias = buscarTodasNoticias();
		Noticia noticiasMaisLidas[] = new Noticia[quantidade];
		
		for(int i = 0; i < quantidade; i++) {
			noticiasMaisLidas[i] = noticias.get(i);
		}
		noticias = Arrays.asList(noticiasMaisLidas);
		return noticias;
	}

}
