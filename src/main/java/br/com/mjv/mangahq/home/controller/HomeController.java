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
	 * Caso ocorra um erro, retorna uma página personalizada de erros.
	 * @return uma página inicial, exibida após um login bem sucedido.
	 */
	@GetMapping("mangahq/user/{id}/home")
	public ModelAndView home(@PathVariable(value="id") Integer id) {
		ModelAndView mv = null;
		try {
			mv = new ModelAndView("home");
			LOGGER.info("Inicio do método Controller de acesso a página Home");
			Usuario usuario = usuarioService.buscarPorId(id);
			mv.addObject("maisLidas", noticiaService.buscarNoticias(6));
			mv.addObject("principaisNoticias", noticiaService.buscarNoticias(6, 20));
			mv.addObject("usuario", usuario);
			
			LOGGER.info("Fim do método Controller de acesso a página Home");
			return mv;
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
			mv = new ModelAndView("error/error");
			mv.addObject("errormsg", "Ocorreu um erro, tente mais tarde.");
			return mv;
		}
	}
}
