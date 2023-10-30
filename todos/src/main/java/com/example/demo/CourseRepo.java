package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long>{

//	public List<Course> findByStatus(String status);
//
//	public Course getReferenceByname(String name);

	public List<Course> findByStatus(String string);


	public Course findByName(String name);


	public Course findByNameAndAuthor(String name, String author);


//	public Course findByNameAndAuthor(String name, String author);
	
}
