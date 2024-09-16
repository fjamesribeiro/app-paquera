package br.com.paqueradebar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "TE AMO minha morango do nordeste, esse nosso app vai bombar!!";
	}

	@GetMapping("/oauth")
	public String secured() {
		return "Vocẽ logou com o Google no APP de PAQUERA";
	}

}
