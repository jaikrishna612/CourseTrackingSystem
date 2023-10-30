package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long>{
	public List<Todo> findByUsernameAndStatus(String username, String status);
	public Todo getReferenceByUsernameAndName(String username, String name);
	public Todo getReferenceByNameAndUsername(String name, String username);
	public Todo findByNameAndUsername(String name, String username);
}
