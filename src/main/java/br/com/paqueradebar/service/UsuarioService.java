package br.com.paqueradebar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.paqueradebar.model.Usuario;
import br.com.paqueradebar.repository.UsuarioRepository;
import br.com.paqueradebar.util.Util;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuarioService implements iCRUDService<Usuario> {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public List<Usuario> findAll() {
		log.info("Buscando todos usuarios");
		return repository.findAll();
	}

	@Override
	public Usuario findById(Long id) {
		log.info("Buscando usuario");
		return repository.findById(id).orElseThrow(() -> new RuntimeException("No records found for this ID: " + id));
	}

	@Override
	public Usuario update(Usuario t) {
		log.info("Atualizando usuario");

		// Encontre o usuário existente no banco de dados
		Usuario user = repository.findById(t.getId())
				.orElseThrow(() -> new RuntimeException("No record found for this ID: " + t.getId()));

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
	public Usuario create(Usuario t) {
		log.info("Criando usuario");
		return repository.save(t);
	}

	@Override
	public void delete(Long id) {
		log.info("Deletando usuario");
		var user = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("No record found for this ID: " + id));

		repository.delete(user);
	}

}
