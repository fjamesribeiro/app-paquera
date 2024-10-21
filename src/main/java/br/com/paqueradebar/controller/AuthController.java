package br.com.paqueradebar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.paqueradebar.dto.AuthResponseDto;
import br.com.paqueradebar.dto.LoginDto;
import br.com.paqueradebar.service.AuthService;

@RestController
public class AuthController {

	@Autowired
	private AuthService authService;

	@GetMapping("/login")
	public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto) {

		// 01 - Receive the token from AuthService
		String token = authService.login(loginDto);

		// 02 - Set the token as a response using JwtAuthResponse Dto class
		AuthResponseDto authResponseDto = new AuthResponseDto();
		authResponseDto.setAccessToken(token);

		// 03 - Return the response to the user
		return new ResponseEntity<>(authResponseDto, HttpStatus.OK);
	}

}
