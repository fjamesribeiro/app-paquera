package br.com.paqueradebar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.paqueradebar.config.security.JwtService;
import br.com.paqueradebar.dto.LoginDto;

@Service
public class AuthenticationService {

	@Autowired
	private JwtService jwtService;

	public String authenticate(LoginDto authentication) {
		return jwtService.generateToken(authentication);
	}
}
