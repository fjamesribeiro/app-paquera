package br.com.paqueradebar.controller.rest;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	@GetMapping("/login")
	public String getToken(Authentication authentication) {
		OAuth2AuthenticationToken authToken = (OAuth2AuthenticationToken) authentication;
		OAuth2User user = authToken.getPrincipal();

		String token = (String) user.getAttributes().get("id_token");

		return token; // Retorna o JWT token como resposta
	}
	
	@GetMapping("/token")
	public String getToken(Authentication authentication) {
		OAuth2AuthenticationToken authToken = (OAuth2AuthenticationToken) authentication;
		OAuth2User user = authToken.getPrincipal();

		String token = (String) user.getAttributes().get("id_token");

		return token; // Retorna o JWT token como resposta
	}
	
}
