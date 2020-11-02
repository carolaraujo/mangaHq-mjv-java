package br.com.mjv.mangahq.mangahq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjv.mangahq.mangahq.dao.MangaHQDao;
import br.com.mjv.mangahq.mangahq.model.MangaHQ;

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
	public List<MangaHQ> listarMeusMangasHqs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MangaHQ> mangasHqsNaoAdquiridos() {
		// TODO Auto-generated method stub
		return null;
	}

}
