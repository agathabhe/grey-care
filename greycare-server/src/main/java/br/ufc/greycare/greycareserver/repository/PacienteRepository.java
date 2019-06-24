package br.ufc.greycare.greycareserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufc.greycare.greycareserver.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
	@Query("from Paciente where nome like %?1%")
	List<Paciente> findByNome(String nome);
}
