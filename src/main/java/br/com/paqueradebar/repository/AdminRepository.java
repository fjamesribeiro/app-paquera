package br.com.paqueradebar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paqueradebar.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {


}
