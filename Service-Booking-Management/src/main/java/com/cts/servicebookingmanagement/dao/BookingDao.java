package com.cts.servicebookingmanagement.dao;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.servicebookingmanagement.model.AppServiceReq;

@Repository
public interface BookingDao extends JpaRepository<AppServiceReq, Integer>{

	
	//Individual Booking 	
	
	//	List<AppServiceReq> findAllByIdAndStatus(Integer id, String status);
	
	Optional<AppServiceReq> findByIdAndStatus(Integer id, String status);
	
	//List OF Pending & Resolved Bookings
	Optional<List<AppServiceReq>> findAllByAdminIdAndStatus(Integer adminId, String status);
	
	

}

