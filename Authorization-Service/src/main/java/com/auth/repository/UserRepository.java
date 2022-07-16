package com.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.modal.User;

public interface UserRepository extends JpaRepository<User, Integer>  {
	
	public User findByUsername(String uname);
	

	

}
