package br.com.paqueradebar.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class Home {

	@GetMapping("/")
	public String home(HttpSession request) {
		return "login";
	}

	@GetMapping("/fail")
	public String fail() {
		return "fail";
	}

}
