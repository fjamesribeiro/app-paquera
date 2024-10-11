package br.com.paqueradebar.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.paqueradebar.exception.ResourceNotFoundException;
import br.com.paqueradebar.model.Admin;
import br.com.paqueradebar.model.RoleName;
import br.com.paqueradebar.repository.AdminRepository;
import br.com.paqueradebar.repository.RoleRepository;
import br.com.paqueradebar.util.Util;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminService implements iCRUDService<Admin> {

	@Autowired
	private AdminRepository repository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public List<Admin> findAll() {
		log.info("Buscando todos admins");
		return repository.findAll();
	}

	@Override
	public Admin findById(Long id) {
		log.info("Buscando admin");
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));
	}

	@Override
	public Admin update(Admin t) {
		log.info("Atualizando admin");

		// Encontre o usuário existente no banco de dados
		Admin user = repository.findById(t.getId())
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
	public Admin create(Admin t) {
		log.info("Criando admin");
		var role = roleRepository.findByNome(RoleName.ADMIN);
		t.setRoles(Set.of(role));

		t.setSenha(encoder.encode(t.getSenha()));
		return repository.save(t);
	}

	@Override
	public void delete(Long id) {
		log.info("Deletando admin");
		var user = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID: " + id));

		repository.delete(user);
	}

}
