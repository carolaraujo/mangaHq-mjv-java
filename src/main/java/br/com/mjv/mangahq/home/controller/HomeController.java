package br.com.mjv.mangahq.home.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mjv.mangahq.exceptions.UserNotFoundException;
import br.com.mjv.mangahq.mangahq.service.MangaHQService;
import br.com.mjv.mangahq.noticia.service.NoticiaService;
import br.com.mjv.mangahq.usuario.model.Usuario;
import br.com.mjv.mangahq.usuario.service.UsuarioService;

/**
 * Classe controller para rota home
 * @author kaique
 *
 */
@Controller
@RequestMapping("/mangahq/user/{id}/home")
public class HomeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private NoticiaService noticiaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private MangaHQService mangahqService;
	
	/**
	 * Controller para a rota /{id}/home
	 * Caso ocorra um erro, retorna uma página personalizada de erros.
	 * @return uma página inicial, exibida após um login bem sucedido.
	 * @routes
	 * GET /mangahq/user/{id}/home - Primeira página exibida ao logar
	 */
	@GetMapping
	public String home(@PathVariable(value="id") Integer id, RedirectAttributes attributes, Model model) {
		try {
			LOGGER.info("HomeController - Início do método home");
			Usuario usuario = usuarioService.buscarPorId(id);
			model.addAttribute("mangas", mangahqService.todosMangasHqsCadastrados());
			model.addAttribute("principaisNoticias", noticiaService.buscarNoticias(10, 20));
			model.addAttribute("carousel",noticiaService.buscarNoticias(3));
			model.addAttribute("usuario", usuario);
			return "home";
		}catch(UserNotFoundException e) {
			LOGGER.error(e.getMessage());
			model.addAttribute("errormsg", e.getMessage());
			return "redirect:/mangahq";		
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
			model.addAttribute("errormsg", "Ocorreu um erro, tente mais tarde.");
			return "error/error";
		}finally {
			LOGGER.info("HomeController - Fim do método home");			
		}
	}
}
