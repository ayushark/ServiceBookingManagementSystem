package com.cts.servicebookingmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.servicebookingmanagement.model.AppServiceReq;
import com.cts.servicebookingmanagement.model.AppServiceReqReport;

@Repository
public interface BookingDaoReq extends JpaRepository<AppServiceReqReport, Integer> {
  
	Optional<List<AppServiceReqReport>> findAllByAdminId(Integer adminId);
}
