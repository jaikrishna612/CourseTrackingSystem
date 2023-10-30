package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long>{
	public Login findByUsername(String username);
	public Login findByUsernameAndPassword(String username, String password);

}
