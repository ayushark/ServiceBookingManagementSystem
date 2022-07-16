package com.cts.servicebookingmanagement.controller;

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
import org.springframework.web.bind.annotation.RestController;
import com.cts.servicebookingmanagement.feign.AuthClient;
import com.cts.servicebookingmanagement.model.AppServiceReq;
import com.cts.servicebookingmanagement.model.AppServiceReqReport;
import com.cts.servicebookingmanagement.service.BookingService;

import com.cts.servicebookingmanagement.dto.ValidatingDTO;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private AuthClient authClient;
	
	@GetMapping("/awsBooking")
	public String welcome() {
    	return "Booking Service Deployed to Cloud";
	}
	
	
    /*
     * Get All Bookings
     */
	@GetMapping("/servicereq")
	public List<AppServiceReq> getBooking(@RequestHeader(name="Authorization",required = true)String token){
		ValidatingDTO validatingDTO  = authClient.checkToken(token);
		return bookingService.getBooking();		
		 
	}
	
	
	/*
	 * Add Bookings
	 */

    @PostMapping("/servicereq")
	public AppServiceReq createBooking(@RequestHeader(name="Authorization",required = true)String token,@RequestBody AppServiceReq appServiceReq) {
		ValidatingDTO validatingDTO  = authClient.checkToken(token);
		return bookingService.createBooking(appServiceReq);
	}
	
	
    /*
     * Updating Booking
     */
    
	@PutMapping("/servicereq")
	public AppServiceReq updateBooking(@RequestHeader(name="Authorization", required = true)String token, @RequestBody AppServiceReq appServiceReq) {
		ValidatingDTO validatingDTO = authClient.checkToken(token); 
		return  bookingService.updateBooking(appServiceReq);
	}
	
	
	/*
	 * Delete Booking By ID
	 */
	
	@DeleteMapping("/servicereq/delete/{id}")
	public void deleteUser(@RequestHeader(name="Authorization", required = true)String token, @PathVariable("id") Integer id) {
		bookingService.deleteBooking(id);
	}
	
	
	/*
	 * Get Bookings for  My User (Pending Page/Resolved Page)
	 */
	
	@GetMapping("/servicereq/request/{adminId}/{status}")
	public List<AppServiceReq> getUserById(@PathVariable("adminId") Integer adminId, @PathVariable("status") String status) {
		
		return bookingService.getMyBookings(adminId, status);
	}
	
	/*
	 * Get Booking Details Based on ID
	 */
	
	@GetMapping("/booking/{id}")
	public AppServiceReq getBookingById(@RequestHeader(name="Authorization",required = true)String token, @PathVariable("id") Integer id) {
		ValidatingDTO validatingDTO  = authClient.checkToken(token);
		return bookingService.getBookingById(id);
	}
	

	
	/*
	 *  Get My Bookings Details Based on Status {Pending/Resolved}
	 */
	
	@GetMapping("/servicereq/details/{id}/{status}")
	public void getDetailsById(@PathVariable("id") Integer id, @PathVariable("status") String status) {
		bookingService.getBookingByIdAndStatus(id, status);
	}
	
	
	
	//-- Rest APIs for Service Request Report Pages
	
	
	
	/*
	 * Generate Reports
	 */
	
	@PostMapping("/servicereq/report")
	public AppServiceReqReport addReport(@RequestHeader(name="Authorization",required = true)String token,@RequestBody AppServiceReqReport appServiceReqReport) {
		ValidatingDTO validatingDTO = authClient.checkToken(token);
		return bookingService.addReport(appServiceReqReport);
	}
	
	
   
	/*
	 * Delete My Reports By ID 
	 */
	
	@DeleteMapping("/servicereq/{reportId}")
	public void deleteReport(@RequestHeader(name="Authorization",required = true)String token, @PathVariable Integer reportId) {
		ValidatingDTO validatingDTO = authClient.checkToken(token);
		bookingService.deleteReport(reportId);
	}
	
	
	
	/*
	 * Get All Booking Reports
	 */
	
	@GetMapping("/servicereq/report")
	public List<AppServiceReqReport> getAllBookingReport(@RequestHeader(name="Authorization",required = true)String token){
		ValidatingDTO validatingDTO = authClient.checkToken(token);
		return bookingService.getAllBookingReport();		
	}
	
	/*
	 * Get My Reports By Admin Id
	 */
	
	@GetMapping("/servicereq/report/{adminId}")
	public List<AppServiceReqReport> getReportById(@RequestHeader(name="Authorization",required = true)String token , @PathVariable("adminId") Integer adminId) {
		ValidatingDTO validatingDTO = authClient.checkToken(token);
		return bookingService.getMyReports(adminId);
	}
	
	
	/*
	 * Get Report Details Based on Report ID
	 */
	
	@GetMapping("/servicereq/reportData/{reportId}")
	public AppServiceReqReport getReportByreportId( @RequestHeader(name="Authorization",required = true)String token, @PathVariable("reportId") Integer reportId) {
		ValidatingDTO validatingDTO = authClient.checkToken(token);
		return bookingService.getReportByreportId(reportId);
	}
	
	
/*	
    // Service Booking Request
     
     1.GET: /servicereq/ - Get All Bookings  -> Completed
     2.POST: /servicereq/ - Add Service bookings -> Completed
     3.PUT: /servicereq/ - Update Service Bookings  -> Completed
     4.DELETE:/servicereq/delete/{id} - Deletes particular service booking  ->Completed
     5.GET: /servicereq/request/{adminId}/{status} -> Get Booking for my User -> Completed
     6.GET: /booking/{id} - Get Booking Details By ID -> Completed
     7.GET: /servicereq/details/{id}/{status} - Get My Bookings Based on Status {Pending/Resolved} -> Completed
    
    // Service Booking Report 
     
     8. POST: /servicereq/report - Generate Reports --> Completed
     9. DELETE: /servicereq/{reportId} - Delete My Reports Based on Report ID --> Completed
     10.GET:/servicereq/report - Get All Booking Reports 
     11.GET: /servicereq/report/{adminId} - Get My Reports Admin ID
     12.GET: /servicereq/reportData/{reportId} - Get Report Details Based on Report ID 
	
	
	Login with JWT Authorisation*- Completed
*/ 

}
