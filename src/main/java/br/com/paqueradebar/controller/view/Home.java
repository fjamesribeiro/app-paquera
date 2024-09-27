package br.com.paqueradebar.controller.view;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Home {

	@GetMapping("/home")
	public String home(Model model, @AuthenticationPrincipal OAuth2User auth2User) {
		model.addAttribute("given_name", auth2User.getAttribute("given_name"));
		model.addAttribute("family_name", auth2User.getAttribute("family_name"));
		model.addAttribute("email", auth2User.getAttribute("email"));
		model.addAttribute("picture", auth2User.getAttribute("picture"));
		return "/home";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/fail")
	public String fail() {
		return "fail";
	}

	@GetMapping("/logout")
	public String logoutPage() {
		return "logout"; // Nome do template Thymeleaf (logout.html)
	}

	@PostMapping("/perform-logout")
	public String performLogout(HttpServletRequest request) {
		return "redirect:/login"; // Redireciona para a página inicial ou qualquer outra página
	}

}
