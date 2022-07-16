package com.cts.servicebookingmanagement.service;



import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;


import com.cts.servicebookingmanagement.dao.BookingDao;



@SpringBootTest
public class TestService {
	
	@Mock
	BookingDao bookingDao;
	
	
	
	
	BookingService productService;
	

	@BeforeEach
	void setUp() {
		this.productService =new BookingService(this.bookingDao);
	}
	
	@Test
	void getAllBookings() {

		
		productService.getBooking();
		verify(bookingDao).findAll();
			
	}
	


}