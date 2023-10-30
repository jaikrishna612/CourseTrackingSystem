package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CourseController {
	@Autowired
	private CourseRepo repository;
	
	@GetMapping("Course")
	public List<Course> course(){
		return repository.findByStatus("0");
	}
	
}
