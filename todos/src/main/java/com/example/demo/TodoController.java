package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin("*")
public class TodoController {
	@Autowired
	private TodoRepository repository;
	@Autowired
	private CourseRepo repo;
	
//	@PostMapping("insert")
//	public Todo addTodo(@RequestBody )
	
	@GetMapping("ongoingtodos")
	public List<Todo> ongoing(@RequestParam String username,@RequestParam String status) {
//		List<Todo>x;
		return repository.findByUsernameAndStatus(username,status);
//		System.out.println(x);
//		return x;
		
	}
	@PutMapping("update")
	public Todo Status(@RequestParam String username, @RequestParam String name) {
		Todo row = repository.getReferenceByUsernameAndName(username, name);
		row.setStatus("1");
		return repository.save(row);
	}
//	@GetMapping("Course")
//	public List<Course> course(@RequestParam String status){
//		return repository.findByStatus(status);
//		
//	}
	@PutMapping("drag")
	public Course setStatus(@RequestParam String name,@RequestParam String username) {
		Todo obj = repository.findByNameAndUsername(name,username);
		Course obj1 = repo.findByName(name);
		if(obj != null) {
			return null;
		}
		else {
			Todo newObj = new Todo(name, obj1.getAuthor(),username,"0");
			repository.save(newObj);
			return obj1;
		}
	}
	
}
