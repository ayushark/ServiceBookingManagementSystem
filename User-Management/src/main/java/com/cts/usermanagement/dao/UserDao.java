package com.cts.usermanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.usermanagement.model.AppUser;

@Repository
public interface UserDao extends JpaRepository<AppUser, Integer> {

	List<AppUser> findAllByAdminId(Integer adminId);
	
}
