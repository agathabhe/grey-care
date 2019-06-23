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

import br.ufc.greycare.greycareserver.model.User;
import br.ufc.greycare.greycareserver.repository.UserRepository;

@RestController
@RequestMapping(path = "/api/users")
@CrossOrigin
public class UserService {

	@Autowired
	private UserRepository users;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUser() {
		return new ResponseEntity<List<User>>(users.findAll(), HttpStatus.OK);
		// return new ResponseEntity<List<User>>(users.findAll(new
		// Sort(Sort.Direction.ASC, "id")), HttpStatus.OK);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
		Optional<User> user = users.findById(id);

		if (user.isPresent()) {
			return new ResponseEntity<User>(user.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@RequestParam("nome") String nome) { 
		System.out.println(nome);
		User user = users.findByNome(nome);

		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> addUser(String tipo, String username, String senha, String nome, String crm,
			String telefone, String especialidade, String email, String nascimento, String cpf) {
		if (tipo == null || username == null || senha == null || nome == null || crm == null || telefone == null
				|| especialidade == null || email == null || nascimento == null || cpf == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<User>(users.save(new User(tipo, username, senha, nome, crm, telefone, especialidade, email, nascimento, cpf)), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> atualizarUser(@PathVariable("id") int id, String tipo, String username, String senha,
			String nome, String crm, String telefone, String especialidade, String email, String nascimento,
			String cpf) {
		if (tipo == null || username == null || senha == null || nome == null || crm == null || telefone == null
				|| especialidade == null || email == null || nascimento == null || cpf == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<User> user = users.findById(id);

		if (user.isPresent()) {
			user.get().setTipo(tipo);
			user.get().setUsername(username);
			user.get().setSenha(senha);
			user.get().setNome(nome);
			user.get().setCrm(crm);
			user.get().setTelefone(telefone);
			user.get().setEspecialidade(especialidade);
			user.get().setEmail(email);
			user.get().setNascimento(nascimento);
			user.get().setCpf(cpf);
			
			return new ResponseEntity<User>(user.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deletarUser(@PathVariable("id") int id) {
		if (users.existsById(id)) {
			users.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}