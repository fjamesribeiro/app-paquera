package br.com.paqueradebar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/oauth")
	public String secured() {
		return "oauth";
	}
}
