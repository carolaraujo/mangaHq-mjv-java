package br.com.mjv.mangahq.noticia.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private NoticiaDao dao;
	
	
	@Override
	public List<Noticia> buscarTodasNoticias() {
		LOGGER.info("Inicio do método buscarTodasNoticias em NoticiaServiceImpl");
		LOGGER.info("Fim do método buscarTodasNoticias em NoticiaServiceImpl");
		return dao.buscarTodasNoticias();
	}

	
	@Override
	public List<Noticia> buscarNoticias(Integer quantidadeNoticias) {
		try {
			LOGGER.info("Inicio do método buscarTodasNoticias por quantidadeNoticias em NoticiaServiceImpl");
			List<Noticia> noticias = buscarTodasNoticias();
			Noticia noticiasMaisLidas[] = new Noticia[quantidadeNoticias];
			
			for(int i = 0; i < quantidadeNoticias; i++) {
				noticiasMaisLidas[i] = noticias.get(i);
			}
			noticias = Arrays.asList(noticiasMaisLidas);
			return noticias;
		}catch(IndexOutOfBoundsException e) {
			LOGGER.warn("ATENÇÃO: Algum numero indicado para busca nos parâmetros é maior do que a quantidade de noticias no banco de dados. Retornando todas as notícias...");
			return buscarTodasNoticias();
		}finally {
			LOGGER.info("Fim do método buscarTodasNoticias por quantidadeNoticias em NoticiaServiceImpl");
		}
		
	}

	@Override
	public List<Noticia> buscarNoticias(Integer quantidadeNoticias, Integer quantidadePalavras) {
		try {
			LOGGER.info("Inicio do método buscarTodasNoticias por quantidadeNoticias e quantidadePalavras em NoticiaServiceImpl");
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
			LOGGER.warn("ATENÇÃO: Algum numero indicado para busca nos parâmetros é maior do que a quantidade de noticias no banco de dados, ou maior que a quantidade de palavras cadastradas como descrição. Retornando todas as notícias com o texto completo...");
			return buscarTodasNoticias();
		}finally {
			LOGGER.info("Fim do método buscarTodasNoticias por quantidadeNoticias e quantidadePalavras em NoticiaServiceImpl");
		}
	}


	@Override
	public Integer cadastrarNoticia(Noticia noticia, Usuario usuario) {
		Integer id = dao.cadastrarNoticia(noticia, usuario);
		return id;
	}
}
