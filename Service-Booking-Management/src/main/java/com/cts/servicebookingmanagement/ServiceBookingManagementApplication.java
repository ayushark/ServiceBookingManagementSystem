package com.cts.servicebookingmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableFeignClients
@SpringBootApplication
@EnableWebMvc
@Configuration
public class ServiceBookingManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceBookingManagementApplication.class, args);
	}

}
