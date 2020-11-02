package br.com.mjv.mangahq.noticia.controller;

import java.util.HashMap;
import java.util.Map;

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

import br.com.mjv.mangahq.home.controller.HomeController;
import br.com.mjv.mangahq.noticia.model.Noticia;
import br.com.mjv.mangahq.noticia.service.NoticiaService;
import br.com.mjv.mangahq.usuario.model.Usuario;
import br.com.mjv.mangahq.usuario.service.UsuarioService;

@Controller
@RequestMapping
public class NoticiaController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private NoticiaService noticiaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping("mangahq/user/{id}/noticias")
	public ModelAndView exibirNoticias(@PathVariable(value="id") Integer id) {
		LOGGER.info("Inicio do método Controller de acesso a página Home");
		Usuario usuario = usuarioService.buscarPorId(id);
				
		ModelAndView mv = new ModelAndView("noticias/noticias");
		mv.addObject("principaisNoticias", noticiaService.buscarNoticias(99));
		mv.addObject("usuario", usuario);
		
		LOGGER.info("Fim do método Controller de acesso a página Home");
		return mv;
	}
	
	@GetMapping("mangahq/user/{id}/noticias/cadastro")
	public ModelAndView cadastroNoticias(@PathVariable(value="id") Integer id) {
		ModelAndView mv = new ModelAndView("noticias/cadastrarnoticia");
		Usuario usuario = usuarioService.buscarPorId(id);
		mv.addObject("usuario", usuario);
		mv.addObject("id", id);
		return mv;
	}
	
	@PostMapping("mangahq/user/{id}/noticias/cadastro")
	public String enviarCadastroNoticias(@PathVariable(value="id") Integer id, Noticia noticia, RedirectAttributes atributos, Model model) {
		try {
			Map<String, String> errorMsg = new HashMap<>();
			
			if(StringUtils.isEmpty(noticia.getTitulo())) {
				errorMsg.put("titulo","O campo de título não pode estar vazio!");
			}
			
			if(StringUtils.isEmpty(noticia.getUrlImagem())) {
				errorMsg.put("urlImagem","O campo de URL da Imagem não pode estar vazio!");
			}
			
			if(StringUtils.isEmpty(noticia.getTextoConteudo())) {
				errorMsg.put("textoConteudo","O campo de texto da notícia não pode estar vazio!");
			}
		
			if(!errorMsg.isEmpty()) {
				String msg = "Não Cadastrado!";
				atributos.addFlashAttribute("msg", msg);
				atributos.addFlashAttribute("errorMsg", errorMsg);
				return "redirect:/mangahq/user/" + id + "/noticias/cadastro";
			}
			String msg = "Cadastrado!";
			atributos.addFlashAttribute("msg", msg);
		
			Integer i = noticiaService.cadastrarNoticia(noticia);
			
			System.out.println(i);
			
			return "redirect:/mangahq/user/" + id + "/noticias";
		}catch(Exception e) {
			e.printStackTrace();
			return "redirect:/mangahq/user/" + id + "/noticias/cadastro";			
		}
	}
}
