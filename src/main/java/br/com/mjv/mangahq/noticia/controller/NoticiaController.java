package br.com.mjv.mangahq.noticia.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mjv.mangahq.exceptions.ImpossibleInsertException;
import br.com.mjv.mangahq.exceptions.UserNotFoundException;
import br.com.mjv.mangahq.noticia.model.Noticia;
import br.com.mjv.mangahq.noticia.service.NoticiaService;
import br.com.mjv.mangahq.usuario.model.Usuario;
import br.com.mjv.mangahq.usuario.service.UsuarioService;

/**
 * Classe de mapeamento para rotas referentes a Notícias
 * @author kaique
 *GET /mangahq/user/{id}/noticias - Página com todas as notícias
 *GET /mangahq/user/{id}/noticias/cadastro - Página de cadastro de notícias
 *POST /mangahq/user/{id}/noticias/cadastro - Validação de cadastro de notícia e postagem
 */
@Controller
@RequestMapping("mangahq/user/{id}/noticias")
public class NoticiaController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NoticiaController.class);
	
	@Autowired
	private NoticiaService noticiaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	/**
	 * Método para página de notícias
	 * @param id
	 * @return uma ModelAndView para página de notícias
	 */
	@GetMapping
	public ModelAndView exibirNoticias(@PathVariable(value="id") Integer id) {
		ModelAndView mv = null;
		try {
			LOGGER.info("NoticiaController - Início do método @Get exibirNoticias");
			Usuario usuario = usuarioService.buscarPorId(id);
			mv = new ModelAndView("noticias/noticias");
			mv.addObject("principaisNoticias", noticiaService.buscarNoticias(99));
			mv.addObject("usuario", usuario);
			return mv;
		}catch(UserNotFoundException e) {
			LOGGER.error("NoticiaController - " + e.getMessage());
			mv = new ModelAndView("redirect:/mangahq");
			mv.addObject("errormsg", e.getMessage());
			return mv;
		}catch(Exception e) {
			LOGGER.error("NoticiaController - " + e.getMessage());
			mv = new ModelAndView("error/error");
			mv.addObject("errormsg", "Ocorreu um erro, tente mais tarde.");
			return mv;
		}finally {
			LOGGER.info("NoticiaController - Fim do método @Get exibirNoticias");
		}
	}
	
	/**
	 * Método para exibir página de cadastro de notícia
	 * @param id
	 * @return uma página de cadastro de notícia
	 */
	@GetMapping("/cadastro")
	public ModelAndView cadastroNoticias(@PathVariable(value="id") Integer id) {
		ModelAndView mv = null;
		try {
			LOGGER.info("NoticiaController - Início do método @Get cadastroNoticias");
			Usuario usuario = usuarioService.buscarPorId(id);			
			mv = new ModelAndView("noticias/cadastrarnoticia");
			mv.addObject("usuario", usuario);
			mv.addObject("id", id);
			return mv;
		}catch(UserNotFoundException e) {
			LOGGER.error("NoticiaController - " + e.getMessage());
			mv = new ModelAndView("redirect:/mangahq");
			mv.addObject("errormsg", e.getMessage());
			return mv;
		}catch(Exception e) {
			LOGGER.error("NoticiaController - " + e.getMessage());
			mv = new ModelAndView("error/error");
			mv.addObject("errormsg", "Ocorreu um erro, tente mais tarde.");
			return mv;
		}finally {
			LOGGER.info("NoticiaController - Fim do método @Get cadastroNoticias");
		}
	}
	
	/**
	 * Método para validar o cadastro de uma notícia
	 * @param id
	 * @param noticia
	 * @param atributos
	 * @param model
	 * @return para a página de notícias caso o cadastro seja bem sucedido.
	 */
	@PostMapping("/cadastro")
	public String validarCadastroNoticias(@PathVariable(value="id") Integer id, Noticia noticia, RedirectAttributes atributos, Model model) {
		try {
			LOGGER.info("NoticiaController - Inicio do método @Post validarCadastroNoticias");
			Usuario usuario = usuarioService.buscarPorId(id);
			
			if(usuario == null) {
				LOGGER.warn("NoticiaController - Uma tentativa de acesso inapropriada foi verificada: um id inválido foi inserido na URL");
				return "redirect:/mangahq";
			}
			
			List<String> errormsg = new ArrayList<>();
			
			if(StringUtils.isEmpty(noticia.getTitulo())) {
				errormsg.add("O campo de título não pode estar vazio!");
			}
			
			if(StringUtils.isEmpty(noticia.getUrlImagem())) {
				errormsg.add("O campo de URL da Imagem não pode estar vazio!");
			}
			
			if(StringUtils.isEmpty(noticia.getTextoConteudo())) {
				errormsg.add("O campo de texto da notícia não pode estar vazio!");
			}
		
			if(!errormsg.isEmpty()) {
				atributos.addFlashAttribute("errormsg", errormsg);
				return "redirect:/mangahq/user/" + id + "/noticias/cadastro";
			}
			String msg = "Cadastrado!";
			atributos.addFlashAttribute("msg", msg);
			atributos.addFlashAttribute("usuario", usuario);
			
			noticiaService.cadastrarNoticia(noticia, usuario);
			
			return "redirect:/mangahq/user/" + id + "/noticias";
		}catch(ImpossibleInsertException e) {
			LOGGER.error("NoticiaController - " + e.getMessage());
			model.addAttribute("errormsg", e.getMessage());
			return "error/error";
		}catch(Exception e) {
			LOGGER.error("NoticiaController - " + e.getMessage());
			model.addAttribute("errormsg", "Ocorreu um erro, tente mais tarde");
			return "error/error";		
		}finally {
			LOGGER.info("NoticiaController - Fim do método @Post validarCadastroNoticias");
		}
	}
}
