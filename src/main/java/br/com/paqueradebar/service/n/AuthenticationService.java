package br.com.paqueradebar.service.n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.paqueradebar.config.security.n.JwtService;

@Service
public class AuthenticationService {

	@Autowired
	private JwtService jwtService;

	public String authenticate(Authentication authentication) {
		return jwtService.generateToken(authentication);
	}
}
