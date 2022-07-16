package com.cts.productmanagement.ProductManagement.service;



import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import com.cts.productmanagement.dao.ProductDao;
import com.cts.productmanagement.model.AppProduct;
import com.cts.productmanagement.service.ProductService;



@SpringBootTest
public class TestService {
	
	@Mock
	ProductDao productDao;
	
	
	
	
	ProductService productService;
	

	@BeforeEach
	void setUp() {
		this.productService =new ProductService(this.productDao);
	}
	
	@Test
	void getAllProducts() {
//		List<AppProduct> list=  (List<AppProduct>) productDao.findAll();
//		assertThat(list).size().isGreaterThan(0);
		
		productService.getProduct();
		verify(productDao).findAll();
			
	}
	


}