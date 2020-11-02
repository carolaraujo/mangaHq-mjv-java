package br.com.mjv.mangahq.noticia.controller;

import java.util.HashMap;
import java.util.Map;

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

import br.com.mjv.mangahq.noticia.model.Noticia;
import br.com.mjv.mangahq.noticia.service.NoticiaService;

@Controller
@RequestMapping
public class NoticiaController {
	
	@Autowired
	private NoticiaService service;
	
	@GetMapping("mangahq/user/{id}/noticias/cadastro")
	public ModelAndView cadastroNoticias(@PathVariable(value="id") Integer id) {
		ModelAndView mv = new ModelAndView("noticias/cadastrarnoticia");
		mv.addObject("id", id);
		return mv;
	}
	
	@PostMapping("mangahq/user/{id}/noticias/cadastro")
	public String enviarCadastroNoticias(@PathVariable(value="id") Integer id, Noticia noticia, RedirectAttributes atributos, Model model) {
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
		
		try {
			if(!errorMsg.isEmpty()) {
				String msg = "Não Cadastrado!";
				atributos.addFlashAttribute("msg", msg);
				atributos.addFlashAttribute("errorMsg", errorMsg);
				return "redirect:/mangahq/user/" + id + "/noticias/cadastro";
			}
			String msg = "Cadastrado!";
			atributos.addFlashAttribute("msg", msg);
		
			Integer i = service.cadastrarNoticia(noticia);
			
			System.out.println(i);
			
			return "redirect:/mangahq/user/" + id + "/noticias/cadastro";
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		return "redirect:/mangahq/user/" + id + "/noticias/cadastro";
	}
}
