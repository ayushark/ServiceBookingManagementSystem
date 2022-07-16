package com.cts.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.usermanagement.dto.ValidatingDTO;
import com.cts.usermanagement.feign.AuthClient;
import com.cts.usermanagement.model.AppUser;
import com.cts.usermanagement.model.JwtResponse;
import com.cts.usermanagement.service.UserService;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthClient authClient;
	
	
	@GetMapping("/awsBooking")
	public String welcome() {
    	return "UserManagement Service Deployed to Cloud";
	}
	
	/*
	 * Add User
	 */
	
    @PostMapping("/user")	
	public AppUser registerUser(@RequestHeader(name="Authorization",required = true)String token ,@RequestBody AppUser appUser) {
    	
    	ValidatingDTO validatingDTO  = authClient.checkToken(token);
    	return userService.registerUser(appUser);
	}
	
    
    /*
     *	 GET All Users
     */
	@GetMapping("/user/alluser")
	public List<AppUser> getAllUsers(@RequestHeader(name="Authorization",required = true)String token){
	 ValidatingDTO validatingDTO = authClient.checkToken(token);
		return userService.getAllUsers();		
	}
	
	/*
	 * GET My Users Based on Admin ID
	 */
	@GetMapping("/user/myusers/{adminId}")
	public List<AppUser> getMyUsers(@RequestHeader(name="Authorization",required = true)String token,@PathVariable("adminId") Integer adminId){
		ValidatingDTO validatingDTO = authClient.checkToken(token);
		return userService.getMyUser(adminId);		
		
	}
	
	/*
	 * Delete Users Based on Admin ID
	 */
	
	@DeleteMapping("/deleteUsers/{id}")
	public void deleteUser(@RequestHeader(name="Authorization",required = true)String token,@PathVariable Integer id) {
		ValidatingDTO validatingDTO = authClient.checkToken(token);
		userService.deleteUser(id);
	}
	
	/*
	 * Update Users
	 */
	
	@PutMapping("/user")
	public AppUser updateUser(@RequestHeader(name="Authorization",required = true)String token,@RequestBody AppUser appUser) {
		ValidatingDTO validatingDTO = authClient.checkToken(token);
		return  userService.updateUser(appUser);
	}
	
	/*
	 * Get user Details based on ID
	 */
	
	
	@GetMapping("/user/{id}")
	public AppUser getUserById(@RequestHeader(name="Authorization",required = true)String token, @PathVariable("id") Integer id) {
		ValidatingDTO validatingDTO  = authClient.checkToken(token);
		return userService.getUserById(id);
	}
	
/*	
     1.POST : /user/ - Create User ->complete
     2.GET: /user/alluser - GET All Users ->complete
     3.GET : /user/myusers/{adminId} - Get My users ->complete
     4.DELETE: /deleteUsers/{id} - Delete Users Based on ID --> Complete
     5.PUT :/user - Update Users  ->Complete
     6. GET: /user/{id} - Get USER Details By ID --> Complete
    
	
	Login with JWT Authorisation*/

}
