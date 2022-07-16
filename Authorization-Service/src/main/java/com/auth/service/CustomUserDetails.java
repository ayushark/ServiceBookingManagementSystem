package com.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.modal.User;
import com.auth.repository.UserRepository;


@Service
public class CustomUserDetails {
	
	
	
	@Autowired
	private UserRepository userRepository;
	
	public int getUserId(String name) {
		return this.userRepository.findByUsername(name).getId();
	}
	
	public User registerProfile(User user) {
		return userRepository.save(user);
	}

	public User getUserData(Integer id) {
		return userRepository.findById(id).get();
	}
	

public User updateProfile(User user) {
   
	return userRepository.save(user);
	
	}
}
