package br.com.mjv.mangahq.login.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.mjv.mangahq.usuario.model.Usuario;
import br.com.mjv.mangahq.usuario.service.UsuarioService;

/**
 * Método controller das rotas relacionadas a login
 * @author kaique
 * @routes
 * GET /mangahq - Tela inicial, formulário de login
 * GET /mangahq/cadastrarusuario - Tela para cadastro de usuario
 * POST /mangahq/cadastrarusuario - Validação do cadastro de usuario
 * POST /mangahq/validarlogin - valida os campos e realiza login.
 */
@Controller
@RequestMapping("/mangahq")
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UsuarioService service;
	
	/**
	 * Primeira página exibida
	 * @return uma página para login
	 */
	@GetMapping
	public String login(Model model) {
		try {
			LOGGER.info("LoginController - Início do método @Get login");
			return "login/login";
		}catch (Exception e) {
			LOGGER.error("LoginController - " + e.getMessage());
			model.addAttribute("errormsg", "Ocorreu um erro, tente mais tarde");
			return "error/error";
		}finally {
			LOGGER.info("LoginController - Fim do método @Get login");			
		}
	}
	
	/**
	 * Página para cadastro de usuário.
	 * @return uma página com um formulario de cadastro.
	 */
	@GetMapping("/cadastrarusuario")
	public String cadastrarUsuario(Model model) {
		try {
			LOGGER.info("LoginController - Início do método @Get cadastrarUsuario");
			return "/login/cadastrarusuario";
		}catch(Exception e) {
			LOGGER.error("LoginController - " + e.getMessage());
			model.addAttribute("errormsg", "Ocorreu um erro, tente mais tarde");
			return "error/error";
		}finally {
			LOGGER.info("LoginController - Fim do método @Get cadastrarUsuario");
		}
	}
	
	/**
	 * Validação de cadastro de usuário
	 * Caso o login informado já tenha sido cadastrado, recarrega a página
	 * Caso ocorra algum erro, redireciona para página de erro
	 * @param usuario
	 * @param atributos
	 * @param model
	 * @return após um cadastro bem sucedido redireciona para página home.
	 */
	@PostMapping("/cadastrarusuario")
	public String validarCadastroUsuario(Usuario usuario, RedirectAttributes atributos, Model model) {
		try {
			LOGGER.info("LoginController - Início do método @Post ValidarCadastroUsuario");
			List<String> list = new ArrayList<>();
			
			if(StringUtils.isEmpty(usuario.getLogin())) {
				list.add("O campo Login não pode estar vazio");
			}
			
			if(StringUtils.isEmpty(usuario.getNome())) {
				list.add("O campo Nome não pode estar vazio");
			}
			
			if(!list.isEmpty()) {
				atributos.addFlashAttribute("errormsg", list);
				LOGGER.warn("Campos com valores incorretos");
				return "redirect:/mangahq/cadastrarusuario";
			}
			
			Boolean verificarExistente = service.verificarSeUsuarioExiste(usuario);
			
			if(verificarExistente == true) {
				LOGGER.warn("LoginController - Já existe um usuário com o login " + usuario.getLogin());
				list.add("Já existe um usuário com o login informado");
				atributos.addFlashAttribute("errormsg", list);
				return "redirect:/mangahq/cadastrarusuario";
			}
			
			Integer id = service.cadastrarUsuario(usuario);
			return "redirect:/mangahq/user/"+id+"/home";
		}catch(Exception e) {
			LOGGER.error("LoginController - " + e.getMessage());
			model.addAttribute("errormsg", "Ocorreu um erro, tente mais tarde");
			return "error/error";
		}finally {
			LOGGER.info("LoginController - Fim do método @Post ValidarCadastroUsuario");
		}
	}
	
	/**
	 * Método para validar login de uma contá já existente
	 * Caso ocorra algum erro inesperado, retorna uma página de erro.
	 * @param usuario
	 * @param atributos
	 * @return para a página home
	 */
	@PostMapping("/validarlogin")
	public String validarLogin(Usuario usuario, RedirectAttributes atributos, Model model) {
		try {
			LOGGER.info("LoginController - Início do método @Post validarLogin");
			String msg = null;
			
			if(StringUtils.isEmpty(usuario.getLogin())) {
				msg = "Os campos devem ser preenchidos";
				atributos.addFlashAttribute("errormsg", msg);
				LOGGER.warn("LoginController - O campo login não pode estar vazio");
				return "redirect:/mangahq";
			}
			
			Boolean usuarioExiste = service.verificarSeUsuarioExiste(usuario);
			if(usuarioExiste == false){
				msg = "Login ou senha inválidos";
				atributos.addFlashAttribute("errormsg", msg);
				LOGGER.warn("LoginController - Login ou senha inválidos");
				return "/mangahq";
			}
			Usuario usuarioValido = service.buscarPorLogin(usuario.getLogin());
			return "redirect:/mangahq/user/" + usuarioValido.getId_usuario() + "/home";
		}catch(Exception e) {
			LOGGER.error("LoginController - " + e.getMessage());
			model.addAttribute("errormsg", "Ocorreu um erro, tente mais tarde");
			return "error/error";
		}finally {
			LOGGER.info("LoginController - Fim do método @Post validarLogin");
		}
	}
	
	/**
	 * Método para logout
	 * @param atributos
	 * @return
	 */
	@GetMapping("/logout")
	public String logout(RedirectAttributes atributos) {
		LOGGER.info("LoginController - Início do método @Get logout");
		LOGGER.info("LoginController - Fim do método @Get logout");
		return "redirect:/mangahq";
	}
}
