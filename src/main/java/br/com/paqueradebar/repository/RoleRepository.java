package br.com.paqueradebar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paqueradebar.model.Role;
import br.com.paqueradebar.model.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findByNome(RoleName nome);

}
