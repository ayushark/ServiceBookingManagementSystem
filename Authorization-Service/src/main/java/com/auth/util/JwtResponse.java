package com.auth.util;

import lombok.Data;

@Data
public class JwtResponse {
	
	String jwtToken;
	
	public JwtResponse(String token) {
		this.jwtToken=token;
	}

}
