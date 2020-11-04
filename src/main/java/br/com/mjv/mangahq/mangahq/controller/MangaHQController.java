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
import br.com.mjv.mangahq.usuario.model.Usuario;
import br.com.mjv.mangahq.usuario.service.UsuarioService;

/**
 * Classe de mapeamento de rotas referentes a Mangas/HQs
 * @author kaique
 *GET /mangahq/user/{id}/mangashqs - Página para exibir e gerenciar mangás/hqs
 *GET /mangahq/user/{id}/mangashqs/cadastrar - Página para cadastro de mangas/hqs
 *POST /mangahq/user/{id}/mangashqs/cadastrar - Validação de cadastro de mangas/hqs e postagem
 *POST /mangahq/user/{id}/mangashqs/adquirir - Rota usada para um usuário adquirir um manga/hq
 */
@Controller
@RequestMapping("/mangahq/user/{id}/mangashqs")
public class MangaHQController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MangaHQController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private MangaHQService mangahqService;
	
	/**
	 * Exibe uma lista de mangas e hqs, adquiridos e não adquiridos.
	 * @param id
	 * @return uma ModelAndView direcionando para a página adequada.
	 */
	@GetMapping
	public ModelAndView exibirMangasHqs(@PathVariable(value="id") Integer id, RedirectAttributes atributos) {
		ModelAndView mv = null;
		try {
			LOGGER.info("Início do método de acesso a página de lista de Mangas/HQs");
			Usuario usuario = usuarioService.buscarPorId(id);
			
			if(usuario == null) {
				LOGGER.warn("Uma tentativa de acesso inapropriada foi verificada: um id inválido foi inserido na URL");
				mv = new ModelAndView("redirect:/mangahq");
				return mv;
			}
			mv = new ModelAndView("/mangashqs/mangashqs");
			mv.addObject("usuario", usuario);
			
			List<MangaHQ> list = mangahqService.listarMangasHqsUsuario(usuario);
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
	@GetMapping("/adquirir")
	public String adquirirMangaHq(
			@PathVariable(value="id") Integer id,
			@RequestParam("id_manga_hq") String id_mangahq,
			RedirectAttributes attributes,
			Model model) {
		try {
			LOGGER.info("Início do método ativado ao clicar em adquirir um manga/hq.");
			MangaHQ mangahq = mangahqService.buscarPorId(Integer.parseInt(id_mangahq));
			Usuario usuario = usuarioService.buscarPorId(id);
			
			if(usuario == null) {
				LOGGER.warn("Uma tentativa de acesso inapropriada foi verificada: um id inválido foi inserido na URL");
				return "redirect:/mangahq";
			}
			
			mangahqService.adquirirMangaHq(usuario, mangahq);
						
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
	@GetMapping("/cadastro")
	public ModelAndView cadastrarMangasHqs(@PathVariable(value="id") Integer id, RedirectAttributes attributes) {
		ModelAndView mv = null;
		try {
			LOGGER.info("Início do método de acesso a página de cadastro de manga/hq.");
			Usuario usuario = usuarioService.buscarPorId(id);
			
			if(usuario == null) {
				LOGGER.warn("Uma tentativa de acesso inapropriada foi verificada: um id inválido foi inserido na URL");
				mv = new ModelAndView("redirect:/mangahq");
				return mv;
			}
			
			mv = new ModelAndView("mangashqs/cadastrarmangahq");
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
	@PostMapping("/cadastro")
	public String validarCadastroMangaHq(@PathVariable(value="id") Integer id, MangaHQ mangahq, RedirectAttributes attributes, Model model) {
		try {
			LOGGER.info("Início do método de validação de cadastro de manga/hq.");
			Usuario usuario = usuarioService.buscarPorId(id);
			 
			if(usuario == null) {
				LOGGER.warn("Uma tentativa de acesso inapropriada foi verificada: um id inválido foi inserido na URL");
				return "redirect:/mangahq";
			}
			
			attributes.addFlashAttribute("usuario", usuario);

			List<String> errormsg = new ArrayList<>();

			if(StringUtils.isEmpty(mangahq.getTitulo())) {
				errormsg.add("O campo de Título não pode estar vazio!");
			}
			if(StringUtils.isEmpty(mangahq.getAutor())) {
				errormsg.add("O campo Autor não pode estar vazio!");
			}
			if(StringUtils.isEmpty(mangahq.getUrlCapa())) {
				errormsg.add("O campo Url da Imagem não pode estar vazio!");
			}
			if(StringUtils.isEmpty(mangahq.getVolumes())) {
				errormsg.add("O campo de Volumes não pode estar vazio!");
			}
			if(StringUtils.isEmpty(mangahq.getResumo())) {
				errormsg.add("O campo de Resumo não pode estar vazio!");
			}
			if(!errormsg.isEmpty()) {
				attributes.addFlashAttribute("errormsg", errormsg);
				return "redirect:/mangahq/user/" + id + "/mangashqs/cadastro";
			}
			
			mangahqService.cadastrarNovoMangaHq(mangahq);
			LOGGER.info("Fim do método de validação de cadastro de manga/hq.");
			return "redirect:/mangahq/user/" + id + "/mangashqs";
		}catch (Exception e) {
			LOGGER.error(e.getMessage());
			model.addAttribute("errormsg", "Ocorreu um erro, tente mais tarde");
			return "error/error";
		}
	}
}
