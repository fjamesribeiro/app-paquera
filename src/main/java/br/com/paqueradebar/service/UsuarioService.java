package br.com.paqueradebar.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.paqueradebar.config.exception.ResourceNotFoundException;
import br.com.paqueradebar.config.mapper.UsuarioMapper;
import br.com.paqueradebar.config.util.Util;
import br.com.paqueradebar.dto.UserAdditionalInfoDTO;
import br.com.paqueradebar.dto.UserDTO;
import br.com.paqueradebar.dto.UserRegistrationDTO;
import br.com.paqueradebar.model.RoleName;
import br.com.paqueradebar.model.Usuario;
import br.com.paqueradebar.repository.RoleRepository;
import br.com.paqueradebar.repository.UsuarioRepository;
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

	public UserDTO findById(Long id) {
		log.info("Buscando usuario");
		return mapper.toUserDTO(repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id)));
	}

	public UserDTO update(UserDTO t) {
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
		repository.save(user);
		return mapper.toUserDTO(user);
	}

	public UserDTO completeCadUser(UserAdditionalInfoDTO t) {
		log.info("Completando Cad User");

		// checa se o usuário existe
		Usuario usuario = repository.findByEmail(t.getEmail())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this email: " + t.getEmail()));

		// checa se o usuário que está logado é o mesmo enviado
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String emailLogado = ((UserDetails) principal).getUsername();

		if (!emailLogado.equalsIgnoreCase(t.getEmail())) {
			throw new RuntimeException("O email é diferente do usuário logado");
		}

		Util.copyProperties(t, usuario);
		repository.save(usuario);

		return mapper.toUserDTO(usuario);
	}

	public UserDTO createLoginUser(UserRegistrationDTO t) {
		log.info("Criando createUserRegistration");

		Usuario usuario = mapper.toEntity(t);

		var role = roleRepository.findByNome(RoleName.ROLE_USER.toString());
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
