package br.ufc.greycare.greycareserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.greycare.greycareserver.model.User;
import br.ufc.greycare.greycareserver.repository.UserRepository;

@RestController
@RequestMapping(path = "/api/login")
@CrossOrigin
public class LoginService {

	@Autowired
	private UserRepository users;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> realizarLogin(String username, String senha) {
		if (username == null || senha == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			User user = users.findByUsername(username);
			if (user != null && user.getSenha().equals(senha)) {
				return new ResponseEntity<>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}

		}
	}

}
