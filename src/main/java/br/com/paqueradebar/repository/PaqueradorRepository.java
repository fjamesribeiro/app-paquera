package br.com.paqueradebar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.paqueradebar.model.Paquerador;

public interface PaqueradorRepository extends JpaRepository<Paquerador, Long> {
	Optional<Paquerador> findByEmail(String email);
}
