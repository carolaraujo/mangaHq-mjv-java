package br.com.mjv.mangahq.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjv.mangahq.dao.NoticiaDao;
import br.com.mjv.mangahq.model.Noticia;

/**
 * Implementação da interface de serviço referente a notícias
 * @author kaique
 *
 */

@Service
public class NoticiaServiceImpl implements NoticiaService{

	@Autowired
	private NoticiaDao dao;
	
	@Override
	public List<Noticia> buscarTodasNoticias() {
		return dao.buscarTodasNoticias();
	}

	@Override
	public List<Noticia> buscarNoticias(Integer quantidadeNoticias) {
		List<Noticia> noticias = buscarTodasNoticias();
		Noticia noticiasMaisLidas[] = new Noticia[quantidadeNoticias];
		
		for(int i = 0; i < quantidadeNoticias; i++) {
			noticiasMaisLidas[i] = noticias.get(i);
		}
		noticias = Arrays.asList(noticiasMaisLidas);
		return noticias;
	}

	@Override
	public List<Noticia> buscarNoticias(Integer quantidadeNoticias, Integer quantidadePalavras) {
		List<Noticia> noticias = buscarTodasNoticias();
		Noticia noticiasMaisLidas[] = new Noticia[quantidadeNoticias];
		
		for(int i = 0; i < quantidadeNoticias; i++) {
			noticiasMaisLidas[i] = noticias.get(i);
		}
		noticias = Arrays.asList(noticiasMaisLidas);
		
		for(Noticia n : noticias) {
			String texto[] = n.getTextoConteudo().split(" ");
			String textoResumido = "";
			for(int i = 0; i < quantidadePalavras; i++) {
				textoResumido += texto[i] + " ";
			}
			n.setTextoConteudo(textoResumido + "...");
		}
		return noticias;
	}
}
