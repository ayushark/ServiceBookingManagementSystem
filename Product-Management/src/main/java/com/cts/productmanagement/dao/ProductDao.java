package com.cts.productmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.cts.productmanagement.model.AppProduct;

//public interface ProductDao extends CrudRepository<AppProduct, Integer> {
//
//}

public interface ProductDao extends JpaRepository<AppProduct, Integer> {

}