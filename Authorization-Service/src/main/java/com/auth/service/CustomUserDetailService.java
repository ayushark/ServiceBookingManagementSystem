package com.auth.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth.exception.UserNotFoundException;
import com.auth.modal.CustomUserDetails;
import com.auth.modal.User;
import com.auth.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = this.userRepository.findByUsername(username);
		System.out.println("user"+user);
		if(user==null) {
			throw new UsernameNotFoundException(username);
		}
		else {
			return new CustomUserDetails(user);
		}
		
		
	}
	
	
	
	

}
