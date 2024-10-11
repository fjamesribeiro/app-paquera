package br.com.paqueradebar.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.paqueradebar.exception.ResourceNotFoundException;
import br.com.paqueradebar.model.Paquerador;
import br.com.paqueradebar.model.RoleName;
import br.com.paqueradebar.repository.PaqueradorRepository;
import br.com.paqueradebar.repository.RoleRepository;
import br.com.paqueradebar.util.Util;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaqueradorService implements iCRUDService<Paquerador> {

	@Autowired
	private PaqueradorRepository repository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public List<Paquerador> findAll() {
		log.info("Buscando todos usuarios");
		return repository.findAll();
	}

	@Override
	public Paquerador findById(Long id) {
		log.info("Buscando usuario");
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));
	}

	@Override
	public Paquerador update(Paquerador t) {
		log.info("Atualizando usuario");

		// Encontre o usuário existente no banco de dados
		Paquerador user = repository.findById(t.getId())
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

	@Override
	public Paquerador create(Paquerador t) {
		log.info("Criando usuario");

		var role = roleRepository.findByNome(RoleName.USER);
		t.setRoles(Set.of(role));

		t.setSenha(encoder.encode(t.getSenha()));

		return repository.save(t);
	}

	@Override
	public void delete(Long id) {
		log.info("Deletando usuario");
		var user = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + id));

		repository.delete(user);
	}

}
