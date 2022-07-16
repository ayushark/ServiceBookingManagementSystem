package com.cts.usermanagement.service;



import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import com.cts.usermanagement.dao.UserDao;



@SpringBootTest
public class TestService {
	
	@Mock
    UserDao userDao;
	
	
	
	
	UserService userService;
	

	@BeforeEach
	void setUp() {
		this.userService =new UserService(this.userDao);
	}
	
	@Test
	void getUsers() {

		
		userService.getAllUsers();
		verify(userDao).findAll();
			
	}
	


}