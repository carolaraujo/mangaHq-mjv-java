package br.com.mjv.mangahq.login.controller;

import java.util.ArrayList;
import java.util.List;

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
		return "login/login";
	}
	
	@GetMapping("/cadastrarusuario")
	public String cadastrarUsuario() {
		return "/login/cadastrarusuario";
	}
	
	@PostMapping("/cadastrarusuario")
	public String validarCadastroUsuario(Usuario usuario, RedirectAttributes atributos) {
		List<String> list = new ArrayList<>();
		
		if(StringUtils.isEmpty(usuario.getLogin())) {
			list.add("O campo Login não pode estar vazio");
		}
		
		if(StringUtils.isEmpty(usuario.getNome())) {
			list.add("O campo Nome não pode estar vazio");
		}
		
		Integer id = service.cadastrarUsuario(usuario);
		
		System.out.println(id);
		
		return "redirect:/mangahq";
	}
	
	@PostMapping("/validarlogin")
	public String validarLogin(Usuario usuario, RedirectAttributes atributos) {
		LOGGER.info("incio do método Controller de validação de login");
		String msg = null;
		
		if(StringUtils.isEmpty(usuario.getLogin())) {
			msg = "Login ou senha inválidos";
			atributos.addFlashAttribute("mensagem", msg);
			return "redirect:/mangahq";
		}
		Usuario usuarioValido = service.buscarPorLogin(usuario.getLogin());
		
		if(usuarioValido == null){
			msg = "Login ou senha inválidos";
			atributos.addFlashAttribute("mensagem", msg);
			return "redirect:/mangahq";
		}
		
		LOGGER.info("fim do método Controller de validação de login");
		return "redirect:/mangahq/user/" + usuarioValido.getId_usuario() + "/home";
	}
}
