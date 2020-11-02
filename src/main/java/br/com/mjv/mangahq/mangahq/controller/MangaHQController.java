package br.com.mjv.mangahq.mangahq.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mjv.mangahq.mangahq.model.MangaHQ;
import br.com.mjv.mangahq.mangahq.service.MangaHQService;
import br.com.mjv.mangahq.noticia.service.NoticiaService;
import br.com.mjv.mangahq.usuario.model.Usuario;
import br.com.mjv.mangahq.usuario.service.UsuarioService;

@Controller
@RequestMapping
public class MangaHQController {
	
	@Autowired
	private NoticiaService noticiaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private MangaHQService mangahqService;
	
	@GetMapping("mangahq/user/{id}/mangashqs")
	public ModelAndView exibirMangasHqs(@PathVariable(value="id") Integer id) {
		Usuario usuario = usuarioService.buscarPorId(id);
		ModelAndView mv = new ModelAndView("/mangashqs/mangashqs");
		mv.addObject("maisLidas", noticiaService.buscarNoticias(6));
		mv.addObject("principaisNoticias", noticiaService.buscarNoticias(6, 20));
		mv.addObject("usuario", usuario);
		
		return mv;
	}
	
	@GetMapping("mangahq/user/{id}/mangashqs/cadastro")
	public ModelAndView cadastrarMangasHqs(@PathVariable(value="id") Integer id) {
		Usuario usuario = usuarioService.buscarPorId(id);
		ModelAndView mv = new ModelAndView("/mangashqs/cadastrarmangahq");
		mv.addObject("maisLidas", noticiaService.buscarNoticias(6));
		mv.addObject("principaisNoticias", noticiaService.buscarNoticias(6, 20));
		mv.addObject("usuario", usuario);
		
		return mv;
	}
	
	@PostMapping("mangahq/user/{id}/mangashqs/cadastro")
	public String validarCadastroMangaHq(@PathVariable(value="id") Integer id, MangaHQ mangahq, RedirectAttributes attributes) {
		try {
			Usuario user = usuarioService.buscarPorId(id);
			attributes.addFlashAttribute("usuario", user);
			List<String> errorMsg = new ArrayList<>();
			
			
			if(StringUtils.isEmpty(mangahq.getTitulo())) {
				errorMsg.add("O campo de Título não pode estar vazio!");
			}
			if(StringUtils.isEmpty(mangahq.getAutor())) {
				errorMsg.add("O campo Autor não pode estar vazio!");
			}
			if(StringUtils.isEmpty(mangahq.getUrlCapa())) {
				errorMsg.add("O campo Url da Imagem não pode estar vazio!");
			}
			if(StringUtils.isEmpty(mangahq.getVolumes())) {
				errorMsg.add("O campo de Volumes não pode estar vazio!");
			}
			if(StringUtils.isEmpty(mangahq.getResumo())) {
				errorMsg.add("O campo de Resumo não pode estar vazio!");
			}
			if(!errorMsg.isEmpty()) {
				String msg = "Não foi possível cadastrar:";
				attributes.addFlashAttribute("msg", msg);
				attributes.addFlashAttribute("errorMsg",errorMsg);
				return "redirect:/mangahq/user/" + id + "/noticias/cadastro";
			}
			
			Integer idMangahq = mangahqService.cadastrarMangaHq(mangahq);
			
			System.out.println(idMangahq);
			
			return "redirect:/mangahq/user/" + id + "/mangashqs";
		}catch (Exception e) {
			e.printStackTrace();
			return "redirect:/mangahq/user/" + id + "/mangashqs/cadastro";
		}
	}
}
