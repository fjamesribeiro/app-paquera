package br.com.paqueradebar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.paqueradebar.dto.UserAdditionalInfoDTO;
import br.com.paqueradebar.dto.UserDTO;
import br.com.paqueradebar.dto.UserRegistrationDTO;
import br.com.paqueradebar.service.UsuarioService;
import br.com.paqueradebar.validation.Create;

@RestController("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/createuser")
	public ResponseEntity<UserDTO> create(@Validated(Create.class) @RequestBody UserRegistrationDTO dto) {
		return new ResponseEntity<UserDTO>(usuarioService.createLoginUser(dto), HttpStatus.CREATED);
	}

	@PostMapping("/completecaduser")
	public ResponseEntity<UserDTO> completeCadUser(@Validated(Create.class) @RequestBody UserAdditionalInfoDTO dto) {
		return new ResponseEntity<UserDTO>(usuarioService.completeCadUser(dto), HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<List<UserDTO>> findAll() {
		return new ResponseEntity<List<UserDTO>>(usuarioService.findAll(), HttpStatus.OK);
	}

}
