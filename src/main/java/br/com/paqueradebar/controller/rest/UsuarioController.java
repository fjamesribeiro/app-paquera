package br.com.paqueradebar.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paqueradebar.model.Usuario;
import br.com.paqueradebar.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/usuario")
@Slf4j
public class UsuarioController {
	@Autowired
	private UsuarioService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping
	public ResponseEntity<Usuario> createUsuario(@Valid @RequestBody Usuario usuario) {
		log.info(usuario.toString());
		return new ResponseEntity<>(service.create(usuario), HttpStatus.CREATED);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Usuario update(@Valid @RequestBody Usuario dto) {
		return service.update(dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
