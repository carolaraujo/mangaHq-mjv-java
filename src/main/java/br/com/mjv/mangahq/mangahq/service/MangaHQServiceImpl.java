package br.com.mjv.mangahq.mangahq.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjv.mangahq.mangahq.dao.MangaHQDao;
import br.com.mjv.mangahq.mangahq.dao.MangaHQDaoImpl;
import br.com.mjv.mangahq.mangahq.model.MangaHQ;
import br.com.mjv.mangahq.usuario.model.Usuario;

/**
 * Implementação da interface {@link MangaHQService}
 * @author kaique
 *
 */
@Service
public class MangaHQServiceImpl implements MangaHQService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MangaHQDaoImpl.class);
	
	@Autowired
	private MangaHQDao dao;
	
	@Override
	public Integer cadastrarNovoMangaHq(MangaHQ mangahq) {
		LOGGER.info("MangaHQServiceImpl - Início do método cadastrarNovoMangaHq");
		Integer id = dao.cadastrarNovoMangaHq(mangahq);
		LOGGER.info("MangaHQServiceImpl - Fim do método cadastrarNovoMangaHq");
		return id;
		
	}

	@Override
	public List<MangaHQ> listarMangasHqsUsuario(Usuario usuario) {
		LOGGER.info("MangaHQServiceImpl - Início do método listarMangasHqsUsuario");
		List<MangaHQ> list = dao.listarMangasHqsUsuario(usuario);
		LOGGER.info("MangaHQServiceImpl - Fim do método cadastrarNovoMangaHq");
		return list;
	}

	@Override
	public List<MangaHQ> mangasHqsNaoAdquiridos(Usuario usuario) {
		LOGGER.info("MangaHQServiceImpl - Início do método mangasHqsNaoAdquiridos");
		List<MangaHQ> minhaLista = listarMangasHqsUsuario(usuario);
		List<MangaHQ> list = todosMangasHqsCadastrados();
		
		list.removeAll(minhaLista);
		LOGGER.info("MangaHQServiceImpl - Fim do método mangasHqsNaoAdquiridos");
		return list;
	}

	@Override
	public List<MangaHQ> todosMangasHqsCadastrados() {
		LOGGER.info("MangaHQServiceImpl - Início do método todosMangasHqsCadastrados");
		List<MangaHQ> list = dao.todosMangasHqsCadastrados();
		LOGGER.info("MangaHQServiceImpl - Fim do método todosMangasHqsCadastrados");
		return list;
	}

	@Override
	public MangaHQ buscarPorId(Integer id) {
		LOGGER.info("MangaHQServiceImpl - Início do método buscarPorId");
		MangaHQ mangahq = dao.buscarPorId(id);
		LOGGER.info("MangaHQServiceImpl - Fim do método buscarPorId");
		return mangahq;
	}

	@Override
	public void adquirirMangaHq(Usuario usuario, MangaHQ mangahq) {
		LOGGER.info("MangaHQServiceImpl - Início do método adquirirMangaHq");
		dao.adquirirMangaHq(usuario, mangahq);
		LOGGER.info("MangaHQServiceImpl - Fim do método buscarPorId");
	}

}
