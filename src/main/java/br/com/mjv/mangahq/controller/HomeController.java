package br.com.mjv.mangahq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mjv.mangahq.noticia.service.NoticiaService;

/**
 * Classe controller para rotas relativas a home
 * @author kaique
 *
 */

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private NoticiaService service;
	
	@GetMapping
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("maisLidas", service.buscarNoticias(6));
		mv.addObject("principaisNoticias", service.buscarNoticias(3, 20));
		return mv;
	}
}
