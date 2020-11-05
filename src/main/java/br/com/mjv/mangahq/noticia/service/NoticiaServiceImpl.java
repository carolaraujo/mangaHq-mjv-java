package br.com.mjv.mangahq.noticia.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjv.mangahq.exceptions.ImpossibleInsertException;
import br.com.mjv.mangahq.home.controller.HomeController;
import br.com.mjv.mangahq.noticia.dao.NoticiaDao;
import br.com.mjv.mangahq.noticia.model.Noticia;
import br.com.mjv.mangahq.usuario.model.Usuario;

/**
 * Implementação da interface de serviço referente a notícias
 * @author kaique
 */
@Service
public class NoticiaServiceImpl implements NoticiaService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NoticiaServiceImpl.class);

	@Autowired
	private NoticiaDao dao;
	
	
	@Override
	public List<Noticia> buscarTodasNoticias() {
		LOGGER.info("NoticiaServiceImpl - Inicio do método buscarTodasNoticias");
		LOGGER.info("NoticiaServiceImpl - Fim do método buscarTodasNoticias");
		return dao.buscarTodasNoticias();
	}

	
	@Override
	public List<Noticia> buscarNoticias(Integer quantidadeNoticias) {
		try {
			LOGGER.info("NoticiaServiceImpl - Inicio do método buscarNoticias @params quantidadeNoticias");
			List<Noticia> noticias = buscarTodasNoticias();
			Noticia noticiasMaisLidas[] = new Noticia[quantidadeNoticias];
			
			for(int i = 0; i < quantidadeNoticias; i++) {
				noticiasMaisLidas[i] = noticias.get(i);
			}
			noticias = Arrays.asList(noticiasMaisLidas);
			return noticias;
		}catch(IndexOutOfBoundsException e) {
			LOGGER.error("NoticiaServiceImpl - " + e.getMessage());
			return buscarTodasNoticias();
		}finally {
			LOGGER.info("NoticiaServiceImpl - Fim do método buscarNoticias @params quantidadeNoticias");
		}
		
	}

	@Override
	public List<Noticia> buscarNoticias(Integer quantidadeNoticias, Integer quantidadePalavras) {
		try {
			LOGGER.info("NoticiaServiceImpl - Inicio do método buscarNoticias @params quantidadeNoticias, quantidadePalavras");
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
		}catch (IndexOutOfBoundsException e) {
			LOGGER.error("NoticiaServiceImpl - " + e.getMessage());
			return buscarNoticias(quantidadeNoticias);
		}finally {
			LOGGER.info("NoticiaServiceImpl - Fim do método buscarNoticias @params quantidadeNoticias, quantidadePalavras");
		}
	}


	@Override
	public Integer cadastrarNoticia(Noticia noticia, Usuario usuario) throws ImpossibleInsertException {
		LOGGER.info("NoticiaServiceImpl - Inicio do método cadastrarNoticia");
		Integer id = dao.cadastrarNoticia(noticia, usuario);
		if(id == 0) {
			throw new ImpossibleInsertException("Não foi possível inserir a notícia. Tente mais tarde.");
		}
		LOGGER.info("NoticiaServiceImpl - Fim do método cadastrarNoticia");
		return id;
	}
}
