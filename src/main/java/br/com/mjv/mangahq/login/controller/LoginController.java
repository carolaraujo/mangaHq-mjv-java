package br.com.mjv.mangahq.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mjv.mangahq.usuario.model.Usuario;
import br.com.mjv.mangahq.usuario.service.UsuarioService;

@Controller
@RequestMapping("/mangahq")
public class LoginController {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping()
	public String login() {
		LOGGER.info("Método Controller de acesso a página Login");
		return "login";
	}
	
	@PostMapping("/login")
	public String validarLogin(Usuario usuario, RedirectAttributes atributos) {
		LOGGER.info("incio do método Controller de validação de login");
		String msg = null;
		
		
		if(StringUtils.isEmpty(usuario.getLogin())) {
			msg = "Login ou senha inválidos";
			atributos.addFlashAttribute("mensagem", msg);
			return "redirect:/mangahq";
		}
		
		Usuario usuarioService = service.buscarPorLogin(usuario.getLogin());
		
		if(usuarioService == null){
			msg = "Login ou senha inválidos";
			atributos.addFlashAttribute("mensagem", msg);
			return "redirect:/mangahq";
		}
		
		LOGGER.info("fim do método Controller de validação de login");
		return "/user/" + usuarioService.getId_usuario() + "/home";
	}
}
