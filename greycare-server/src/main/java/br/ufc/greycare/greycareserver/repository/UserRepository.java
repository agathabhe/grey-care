package br.ufc.greycare.greycareserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufc.greycare.greycareserver.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("from User where nome = ?1")
	User findByNome(String nome);
	@Query("from User where username = ?1")
	User findByUsername(String username);

}