package br.com.paqueradebar.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/oauth")
	public String secured() {
		return "Vocẽ logou com o Google no APP de PAQUERA";
	}

}
