package br.org.serratec.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.ecommerce.entities.User;
import br.org.serratec.ecommerce.records.CredenciaisLoginRecord;
import br.org.serratec.ecommerce.records.JwtTokenRecord;
import br.org.serratec.ecommerce.records.UserRecord;
import br.org.serratec.ecommerce.services.UserService;


@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/signin")
	public ResponseEntity<JwtTokenRecord> login(@RequestBody CredenciaisLoginRecord credenciaisLoginRecord) {
		JwtTokenRecord jwtToken = userService.authenticateUser(credenciaisLoginRecord);
		return new ResponseEntity<>(jwtToken, HttpStatus.OK);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<User> cadastro(@RequestBody UserRecord userRecord) {
		return new ResponseEntity<>(userService.createUser(userRecord), HttpStatus.CREATED);
	}
}
