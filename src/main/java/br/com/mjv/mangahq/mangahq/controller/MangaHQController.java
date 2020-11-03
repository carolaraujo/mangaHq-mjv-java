package br.com.mjv.mangahq.mangahq.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MangaHQController.class);
	
	@Autowired
	private NoticiaService noticiaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private MangaHQService mangahqService;
	
	/**
	 * Exibe uma lista de mangas e hqs, adquiridos e não adquiridos.
	 * @param id
	 * @return uma ModelAndView direcionando para a página adequada.
	 */
	@GetMapping("mangahq/user/{id}/mangashqs")
	public ModelAndView exibirMangasHqs(@PathVariable(value="id") Integer id) {
		ModelAndView mv = null;
		try {
			LOGGER.info("Início do método de acesso a página de lista de Mangas/HQs");
			mv = new ModelAndView("/mangashqs/mangashqs");
			Usuario usuario = usuarioService.buscarPorId(id);
			mv.addObject("usuario", usuario);
			
			List<MangaHQ> list = mangahqService.listarMeusMangasHqs(usuario);
			mv.addObject("listmangahq", list);
			
			List<MangaHQ> naoAdquiridos = mangahqService.mangasHqsNaoAdquiridos(usuario);
			mv.addObject("naoAdquiridos", naoAdquiridos);
			LOGGER.info("Início do método de acesso a página de lista de Mangas/HQs");
			return mv;
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
			mv = new ModelAndView("error/error");
			mv.addObject("errormsg", "Ocorreu um erro, tente mais tarde");
			return mv;
		}
	}
	
	/**
	 * Método ativado quando o usuario clica no botão de adquirir em algum manga/hq
	 * @param id
	 * @param id_mangahq
	 * @param attributes
	 * @return o manga clicado para a lista de mangas adquiridos
	 */
	@GetMapping("mangahq/user/{id}/mangashqs/adquirir")
	public String adquirirMangaHq(
			@PathVariable(value="id") Integer id,
			@RequestParam("id_manga_hq") String id_mangahq,
			RedirectAttributes attributes,
			Model model) {
		try {
			LOGGER.info("Início do método ativado ao clicar em adquirir um manga/hq.");
			MangaHQ mangahq = mangahqService.buscarPorId(Integer.parseInt(id_mangahq));
			Usuario usuario = usuarioService.buscarPorId(id);
			
			Integer id_cadastro = usuarioService.cadastrarMangaHqParaUsuario(usuario, mangahq);
						
			LOGGER.info("Fim do método ativado ao clicar em adquirir um manga/hq.");
			return "redirect:/mangahq/user/{id}/mangashqs";
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
			model.addAttribute("errormsg", "Ocorreu um erro, tente mais tarde");
			return "error/error";
		}
	}
	
	/**
	 * Método para acesso página de cadastro de manga/hq, disponivel apenas para admins.
	 * @param id
	 * @param attributes
	 * @return a página de cadastro de manga/hq.
	 */
	@GetMapping("mangahq/user/{id}/mangashqs/cadastro")
	public ModelAndView cadastrarMangasHqs(@PathVariable(value="id") Integer id, RedirectAttributes attributes) {
		ModelAndView mv = null;
		try {
			LOGGER.info("Início do método de acesso a página de cadastro de manga/hq.");
			mv = new ModelAndView("mangashqs/cadastrarmangahq");
			Usuario usuario = usuarioService.buscarPorId(id);
			mv.addObject("usuario", usuario);
			System.out.println(usuario.getTipoUsuario());
			LOGGER.info("Fim do método de acesso a página de cadastro de manga/hq.");
			return mv;
		}catch(Exception e) {
			LOGGER.error(e.getMessage());
			mv = new ModelAndView("error/error");
			mv.addObject("errormsg", "Ocorreu um erro, tente mais tarde");
			return mv;
		}
	}
	
	/**
	 * Método de validação de cadastro de algum manga/hq
	 * Retorna um erro para view quando um campo está incorreto.
	 * @param id
	 * @param mangahq
	 * @param attributes
	 * @return para página de mangas/hqs caso seja cadastrado com sucesso.
	 */
	@PostMapping("mangahq/user/{id}/mangashqs/cadastro")
	public String validarCadastroMangaHq(@PathVariable(value="id") Integer id, MangaHQ mangahq, RedirectAttributes attributes, Model model) {
		try {
			LOGGER.info("Início do método de validação de cadastro de manga/hq.");
			Usuario usuario = usuarioService.buscarPorId(id);
			attributes.addFlashAttribute("usuario", usuario);

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
			
			mangahqService.cadastrarMangaHq(mangahq);
			LOGGER.info("Fim do método de validação de cadastro de manga/hq.");
			return "redirect:/mangahq/user/" + id + "/mangashqs";
		}catch (Exception e) {
			LOGGER.error(e.getMessage());
			model.addAttribute("errormsg", "Ocorreu um erro, tente mais tarde");
			return "error/error";
		}
	}
}
