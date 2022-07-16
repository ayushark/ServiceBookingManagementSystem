package com.cts.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cts.usermanagement.dao.UserDao;
import com.cts.usermanagement.model.AppUser;

@Service
public class UserService  {

	@Autowired
	private UserDao userDao;
	
	public UserService(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	
	public AppUser registerUser(AppUser appUser) {
		return userDao.save(appUser);
	}
	
	public List<AppUser> getAllUsers(){
		return  userDao.findAll();		 
	}
	
	public List<AppUser> getMyUser(Integer status){
		return  userDao.findAllByAdminId(status);		 
	}
	
	
	public void deleteUser(Integer id) {
		userDao.deleteById(id);
	}
	
	public AppUser updateUser(AppUser appUser) {
		
		
		Integer id = appUser.getId();
		AppUser us = userDao.findById(id).orElse(appUser);
		us.setMailId(appUser.getMailId());
		us.setMobile(appUser.getMobile());
		us.setName(appUser.getName());
		us.setPassword(appUser.getPassword());
		us.setRedgDate(appUser.getRedgDate());
		
		return userDao.save(us);
	}
	
	public AppUser getUserById(Integer id) {
		return userDao.findById(id).orElse(null);
	}
	
}
