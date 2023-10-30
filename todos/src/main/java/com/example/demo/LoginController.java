package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class LoginController {
	@Autowired
	private LoginRepository repository;
	
	@PostMapping("insertUser")
	public Login addUser(@RequestBody Login newUser) {
		Login obj = repository.findByUsername(newUser.getUsername());
		if(obj!=null) {
			return null;
		}
		return repository.save(newUser);
	}
	
	@GetMapping("authenticate")
	public Login authenticate(@RequestParam String username, @RequestParam String password) {
		Login obj = repository.findByUsernameAndPassword(username, password);
		if(obj==null) {
			return null;
		}
		return obj;
	}
}
