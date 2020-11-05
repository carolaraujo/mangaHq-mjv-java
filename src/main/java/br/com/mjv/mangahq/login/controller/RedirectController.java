package br.com.mjv.mangahq.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {

	@GetMapping("/")
	public String redirectToLogin(RedirectAttributes atributos) {
		return "redirect:/mangahq";
	}

}