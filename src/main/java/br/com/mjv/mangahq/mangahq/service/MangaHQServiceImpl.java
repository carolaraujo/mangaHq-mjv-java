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
	public Integer cadastrarNovoMangaHq(MangaHQ mangahq) {
		Integer id = dao.cadastrarNovoMangaHq(mangahq);
		return id;
		
	}

	@Override
	public List<MangaHQ> listarMangasHqsUsuario(Usuario usuario) {
		List<MangaHQ> list = dao.listarMangasHqsUsuario(usuario);
		return list;
	}

	@Override
	public List<MangaHQ> mangasHqsNaoAdquiridos(Usuario usuario) {
		List<MangaHQ> minhaLista = listarMangasHqsUsuario(usuario);
		List<MangaHQ> list = todosMangasHqsCadastrados();
		
		list.removeAll(minhaLista);
		
		return list;
	}

	@Override
	public List<MangaHQ> todosMangasHqsCadastrados() {
		List<MangaHQ> list = dao.todosMangasHqsCadastrados();
		return list;
	}

	@Override
	public MangaHQ buscarPorId(Integer id) {
		MangaHQ mangahq = dao.buscarPorId(id);
		return mangahq;
	}

	@Override
	public void adquirirMangaHq(Usuario usuario, MangaHQ mangahq) {
		dao.adquirirMangaHq(usuario, mangahq);
	}

}
