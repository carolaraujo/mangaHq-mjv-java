package br.com.mjv.mangahq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Classe de inicialização
 * Acesso a página home direto acessando localhost:8080/
 * Padrão usado: MVC
 * @author kaique
 *
 */

@SpringBootApplication
public class MangahqApplication {

	public static void main(String[] args) {
		SpringApplication.run(MangahqApplication.class, args);
	}

}
