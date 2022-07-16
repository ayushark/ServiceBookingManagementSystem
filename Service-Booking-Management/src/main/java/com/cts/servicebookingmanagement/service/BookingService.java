package com.cts.servicebookingmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.servicebookingmanagement.dao.BookingDao;
import com.cts.servicebookingmanagement.dao.BookingDaoReq;
import com.cts.servicebookingmanagement.model.AppServiceReq;
import com.cts.servicebookingmanagement.model.AppServiceReqReport;
//import com.cts.usermanagement.model.AppUser;


@Service
public class BookingService {

	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private BookingDaoReq bookingDaoReq;
	
	public AppServiceReq createBooking(AppServiceReq appServiceReq) {
		return bookingDao.save(appServiceReq);
	}
	
	public AppServiceReq getBookingByIdAndStatus(Integer id, String status) {
		return bookingDao.findByIdAndStatus(id, status).orElse(null);
	}
	
	public List<AppServiceReq> getBooking(){
		return  bookingDao.findAll();		 
	}
	
	
	public AppServiceReq updateBooking(AppServiceReq appServiceReq) {
		Integer id = appServiceReq.getId();
		Integer adminId = appServiceReq.getAdminId();
		AppServiceReq book = bookingDao.findById(id).orElse(appServiceReq);
		book.setReqDate(appServiceReq.getReqDate());
		book.setProblem(appServiceReq.getProblem());
		book.setDescription(appServiceReq.getDescription());
		book.setStatus(appServiceReq.getStatus());
		book = bookingDao.findById(adminId).orElse(appServiceReq);
		return bookingDao.save(book);
	}
	
	public BookingService(BookingDao bookingDao) {
		super();
		this.bookingDao = bookingDao;

	}

	public void deleteBooking(Integer id) {
		bookingDao.deleteById(id);
	}
	
	public List<AppServiceReq> getMyBookings(Integer adminId, String status) {
		return bookingDao.findAllByAdminIdAndStatus(adminId, status).orElse(null);
	}

//	public List<AppServiceReq>  getServiceByStatus(String status) {
//		System.out.println("Service Worked");
//		return  bookingDao.findAllByStatus(status).orElse(null);
//	}

//	public List<AppServiceReq> getServiceByReport(String report) {
//		return  bookingDao.findAllByStatus(report).orElse(null);
//	}

	/*
	 * Get All Reports
	 */
	public List<AppServiceReqReport> getAllBookingReport() {
		return bookingDaoReq.findAll();	
	}
		
	/*
	 * Get My Reports
	 */
	public List<AppServiceReqReport> getMyReports(Integer adminId) {
		return bookingDaoReq.findAllByAdminId(adminId).orElse(null);
	}
	
	public List<AppServiceReq> getServiceByUserAndStatus(Integer adminId, String status) {
		return  bookingDao.findAllByAdminIdAndStatus(adminId, status).orElse(null);
	}
	
	
	/*
	 * Get Reports By ID
	 */

	public AppServiceReqReport getReportByreportId(Integer reportId) {
		return bookingDaoReq.findById(reportId).orElse(null);
	}

	/*
	 * Add My Reports {We need to pass our adminID along with it.
	 */
	public AppServiceReqReport addReport(AppServiceReqReport appServiceReqReport) {
		return bookingDaoReq.save(appServiceReqReport);
	}
	
	
	/*
	 * Delete Report
	 */
	public void deleteReport(Integer reportId) {
		bookingDaoReq.deleteById(reportId);
	}
	
	public AppServiceReq getBookingById(Integer id) {
		return bookingDao.findById(id).orElse(null);
	}
}

