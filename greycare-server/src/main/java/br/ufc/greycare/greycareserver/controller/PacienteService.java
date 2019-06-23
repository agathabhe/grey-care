package br.ufc.greycare.greycareserver.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.greycare.greycareserver.model.Paciente;
import br.ufc.greycare.greycareserver.repository.PacienteRepository;

@RestController
@RequestMapping(path = "/api/pacientes")
@CrossOrigin
public class PacienteService {

	@Autowired
	private PacienteRepository pacientes;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Paciente>> getPacientes() {
		return new ResponseEntity<List<Paciente>>(pacientes.findAll(), HttpStatus.OK);
//		 return new ResponseEntity<List<Paciente>>(pacientes.findAll(new
//		 Sort(Sort.Direction.ASC, "id")), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Paciente> addPaciente(String nome, String cpf, String nascimento, String telefone,
			String estadoCivil, String endereco, String cep, String email, String alergias, String tipoSanguineo,
			String doador) {
		if (nome == null || cpf == null || nascimento == null || telefone == null || estadoCivil == null || cep == null || alergias == null ) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Paciente>(pacientes.save(new Paciente(nome, cpf, nascimento, telefone,
					estadoCivil, endereco, cep, email, alergias, tipoSanguineo, doador)), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<Paciente> getUPaciente(@PathVariable("id") Integer id) {
		Optional<Paciente> paciente = pacientes.findById(id);

		if (paciente.isPresent()) {
			return new ResponseEntity<Paciente>(paciente.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<List<Paciente>> getPaciente(@RequestParam("nome") String nome) {
		System.out.println(nome);
		List<Paciente> pacientesList = pacientes.findByNome(nome);

		if (pacientesList != null) {
			return new ResponseEntity<List<Paciente>>(pacientesList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<Paciente> atualizarPaciente(@PathVariable("id") int id, String nome, String cpf,
			String nascimento, String telefone, String estadoCivil, String endereco, String cep, String email,
			String alergias, String tipoSanguineo, String doador) {
		System.out.println(id);
		if (nome == null || cpf == null || nascimento == null || telefone == null || 
				estadoCivil == null || cep == null || alergias == null || doador == null) {
		
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Paciente> pacienteBanco = pacientes.findById(id);
		Paciente paciente = new Paciente();
		if (pacienteBanco.isPresent()) {
			paciente.setId(id);
			paciente.setNome(nome);
			paciente.setCpf(cpf);
			paciente.setNascimento(nascimento);
			paciente.setTelefone(telefone);
			paciente.setEstadoCivil(estadoCivil);
			paciente.setEndereco(endereco);
			paciente.setCep(cep);
			paciente.setEmail(email);
			paciente.setAlergias(alergias);
			paciente.setTipoSanguineo(tipoSanguineo);
			paciente.setDoador(doador);

			return new ResponseEntity<Paciente>(pacientes.save(paciente), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public ResponseEntity<Paciente> deletePaciente(@PathVariable("id") int id) {
		if (pacientes.existsById(id)) {
			pacientes.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}