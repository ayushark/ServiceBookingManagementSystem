package com.cts.productmanagement.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;


import com.cts.productmanagement.dto.ValidatingDTO;

//@FeignClient(name="authorization-service",url="http://localhost:8084")
//	public interface AuthClient {
//
//		@GetMapping("/api/auth/validate")
//		public JwtResponse verifyToken(@RequestHeader(name="Authorization",required = true)String token) ;
//					
//
//	
//}

@FeignClient(url = "http://localhost:8085/authorization", name = "authorization-service")
public interface AuthClient {
	
	@GetMapping("/validate")
	public ValidatingDTO checkToken(@RequestHeader("Authorization") String token);
		

}
