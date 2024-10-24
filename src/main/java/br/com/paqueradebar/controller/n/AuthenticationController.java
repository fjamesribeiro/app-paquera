package br.com.paqueradebar.controller.n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paqueradebar.config.validation.Create;
import br.com.paqueradebar.dto.AuthResponseDto;
import br.com.paqueradebar.dto.UserDTO;
import br.com.paqueradebar.dto.UserRegistrationDTO;
import br.com.paqueradebar.service.UsuarioService;
import br.com.paqueradebar.service.n.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/createuser")
	public ResponseEntity<UserDTO> create(@Validated(Create.class) @RequestBody UserRegistrationDTO dto) {
		return new ResponseEntity<UserDTO>(usuarioService.createLoginUser(dto), HttpStatus.CREATED);
	}

	@PostMapping("login")
	public ResponseEntity<AuthResponseDto> authenticate(Authentication authentication) {

		// 01 - Receive the token from AuthService
		String token = authenticationService.authenticate(authentication);

		// 02 - Set the token as a response using JwtAuthResponse Dto class
		AuthResponseDto authResponseDto = new AuthResponseDto();
		authResponseDto.setAccessToken(token);

		// 03 - Return the response to the user
		return new ResponseEntity<>(authResponseDto, HttpStatus.OK);
	}
}
