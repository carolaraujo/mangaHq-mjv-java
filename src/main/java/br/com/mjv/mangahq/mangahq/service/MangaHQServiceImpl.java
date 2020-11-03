package br.com.mjv.mangahq.mangahq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjv.mangahq.mangahq.dao.MangaHQDao;
import br.com.mjv.mangahq.mangahq.model.MangaHQ;
import br.com.mjv.mangahq.usuario.model.Usuario;

@Service
public class MangaHQServiceImpl implements MangaHQService {

	@Autowired
	private MangaHQDao dao;
	
	@Override
	public Integer cadastrarMangaHq(MangaHQ mangahq) {
		Integer id = dao.cadastrarMangaHq(mangahq);
		return id;
		
	}

	@Override
	public List<MangaHQ> listarMeusMangasHqs(Usuario usuario) {
		List<MangaHQ> list = dao.listarMeusMangasHqs(usuario);
		return list;
	}

	@Override
	public List<MangaHQ> mangasHqsNaoAdquiridos(Usuario usuario) {
		List<MangaHQ> minhaLista = listarMeusMangasHqs(usuario);
		List<MangaHQ> list = todosMangasHqs();
		
		list.removeAll(minhaLista);
		
		return list;
	}

	@Override
	public List<MangaHQ> todosMangasHqs() {
		List<MangaHQ> list = dao.todosMangasHqs();
		return list;
	}

	@Override
	public MangaHQ buscarPorId(Integer id) {
		MangaHQ mangahq = dao.buscarPorId(id);
		return mangahq;
	}

}
