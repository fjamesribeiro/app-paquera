package br.com.paqueradebar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paqueradebar.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByNome(String nome);

}
