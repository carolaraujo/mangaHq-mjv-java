package br.com.mjv.mangahq.noticia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import br.com.mjv.mangahq.noticia.service.NoticiaService;

/**
 * Classe controller para rota home
 * @author kaique
 *
 */
@Controller
@RequestMapping()
public class HomeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private NoticiaService service;
	
	/**
	 * Controller para a rota /{id}/home
	 * Retorna as notícias para a página requisitada
	 * {@link TODO} Retornar a lista dos ultimos mangás/hqs cadastrados
	 * {@link TODO} Acesso ao usuario pelo id
	 * @return
	 */
	@GetMapping("mangahq/user/{id}/home")
	public ModelAndView home(@PathVariable(value="id") Integer id) {
		LOGGER.info("Inicio do método Controller de acesso a página Home");
		
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("maisLidas", service.buscarNoticias(6));
		mv.addObject("principaisNoticias", service.buscarNoticias(6, 20));
		
		LOGGER.info("Fim do método Controller de acesso a página Home");
		return mv;
	}
}
