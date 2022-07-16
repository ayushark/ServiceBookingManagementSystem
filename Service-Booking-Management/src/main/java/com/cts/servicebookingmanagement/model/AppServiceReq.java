package com.cts.servicebookingmanagement.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppServiceReq {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "auto_gen")
	@SequenceGenerator(name = "auto_gen", sequenceName = "A")
	private Integer id;
	private Integer productId;
	private Integer userId;
	private Integer adminId;
	private Date reqDate; 
	private String problem; 
	private String description; 
	private String status  ; //pending,resolved 
	
/*
    "id":1,
	"productId":1,
	"userId":1,
	"reqDate": "2022-02-02",
	"problem":"NA" ,
	"description":"NA" ,
	"status": "pending"
	 "adminId":"101"
*/
	

		
	
}
