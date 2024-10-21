package br.com.paqueradebar.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.paqueradebar.dto.UserAdditionalInfoDTO;
import br.com.paqueradebar.dto.UserDTO;
import br.com.paqueradebar.dto.UserRegistrationDTO;
import br.com.paqueradebar.dto.mapper.UsuarioMapper;
import br.com.paqueradebar.exception.ResourceNotFoundException;
import br.com.paqueradebar.model.RoleName;
import br.com.paqueradebar.model.Usuario;
import br.com.paqueradebar.repository.RoleRepository;
import br.com.paqueradebar.repository.UsuarioRepository;
import br.com.paqueradebar.util.Util;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UsuarioMapper mapper;

	public List<UserDTO> findAll() {
		log.info("Buscando todos usuarios");
		return mapper.toListUserDTO(repository.findAll());
	}

	public Usuario findById(Long id) {
		log.info("Buscando usuario");
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));
	}

	public Usuario update(Usuario t) {
		log.info("Atualizando usuario");

		// Encontre o usuário existente no banco de dados
		Usuario user = repository.findById(t.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + t.getId()));

		// Atualize as propriedades da entidade existente com os valores do DTO
		try {
			Util.copyProperties(t, user); // Evite copiar o ID para não sobrescrever
		} catch (Exception e) {
			throw new RuntimeException("Erro ao copiar propriedades", e);
		}

		// Salve a entidade atualizada
		return repository.save(user);
	}

	public UserDTO completeCadUser(UserAdditionalInfoDTO t) {
		log.info("Completando Cad User");

		Usuario usuario = repository.findByEmail(t.getEmail())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this email: " + t.getEmail()));

		Util.copyProperties(t, usuario);
		repository.save(usuario);

		return mapper.toUserDTO(usuario);
	}

	public UserDTO createLoginUser(UserRegistrationDTO t) {
		log.info("Criando createUserRegistration");

		Usuario usuario = mapper.toEntity(t);

		var role = roleRepository.findByNome(RoleName.USER.toString());
		t.setRoles(Set.of(role));

		usuario.setSenha(encoder.encode(t.getSenha()));
		repository.save(usuario);

		return mapper.toUserDTO(usuario);
	}

	public void delete(Long id) {
		log.info("Deletando usuario");
		var user = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + id));

		repository.delete(user);
	}

}
