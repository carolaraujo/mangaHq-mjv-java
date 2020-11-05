package br.com.mjv.mangahq.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * Método para redirecionar rota / para página inicial
	 * @param atributos
	 * @return
	 */
	@GetMapping("/")
	public String redirectToLogin(RedirectAttributes atributos) {
		LOGGER.info("RedirectController - Início do método @Get redirectToLogin");
		LOGGER.info("RedirectController - Fim do método @Get redirectToLogin");
		return "redirect:/mangahq";
	}

}
