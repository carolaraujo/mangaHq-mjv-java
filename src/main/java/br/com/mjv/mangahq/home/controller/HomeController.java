package br.com.mjv.mangahq.home.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mjv.mangahq.noticia.service.NoticiaService;
import br.com.mjv.mangahq.usuario.model.Usuario;
import br.com.mjv.mangahq.usuario.service.UsuarioService;

/**
 * Classe controller para rota home
 * @author kaique
 *
 */
@Controller
@RequestMapping
public class HomeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private NoticiaService noticiaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
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
		Usuario usuario = usuarioService.buscarPorId(id);
				
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("maisLidas", noticiaService.buscarNoticias(6));
		mv.addObject("principaisNoticias", noticiaService.buscarNoticias(6, 20));
		mv.addObject("usuario", usuario);
		
		LOGGER.info("Fim do método Controller de acesso a página Home");
		return mv;
	}
}
