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
public class AdminController {
	@Autowired
	public AdminRepository repository;
	@Autowired
	public CourseRepo repo;
	@GetMapping("admin")
	public Admin authenticate(@RequestParam String username, @RequestParam String password) {
		Admin obj = repository.findByUsernameAndPassword(username, password);
		if(obj==null) {
			return null;
		}
		return obj;
	}
	
	@PostMapping("addCourse")
	public Course addUser(@RequestBody Course newCourse) {
		Course obj = repo.findByNameAndAuthor(newCourse.getName(), newCourse.getAuthor());
		if(obj!=null) {
			return null;
		}
		return repo.save(newCourse);
	}
}
