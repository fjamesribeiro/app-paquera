package br.com.paqueradebar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.paqueradebar.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
