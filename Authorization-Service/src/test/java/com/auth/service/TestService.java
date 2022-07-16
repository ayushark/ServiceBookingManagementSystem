package com.auth.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.auth.repository.UserRepository;

@SpringBootTest
public class TestService {
	
	@Autowired
	private UserRepository userRepository;

	
	@Test
	void getUserId() {
		
		int id=userRepository.findByUsername("ayush@gmail.com").getId();
		
		assertEquals(id, 101);
		
		
		
	}
	
	

}