package br.com.paqueradebar.controller.view;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

	@GetMapping("/home")
	public String home(Model model, @AuthenticationPrincipal OAuth2User auth2User) {
		model.addAttribute("name", auth2User.getAttribute("name"));
		return "home";
	}

}
