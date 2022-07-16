package com.cts.productmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.productmanagement.dao.ProductDao;
import com.cts.productmanagement.model.AppProduct;

@Service
public class ProductService {

	
	@Autowired
	private ProductDao productDao;
	
	
	
	public ProductService(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	public AppProduct addProduct(AppProduct appProduct) {
		return productDao.save(appProduct);
	}
	
	public List<AppProduct> getProduct(){
		return  productDao.findAll();		 
	}
	
	public void deleteProduct(Integer id) {
		productDao.deleteById(id);  
	}
	
	public AppProduct updateProduct(AppProduct appProduct) {
		
		Integer id = appProduct.getId();
		AppProduct prod = productDao.findById(id).orElse(appProduct);
		prod.setName(appProduct.getName());
		prod.setModel(appProduct.getModel());
		prod.setCreatedDate(appProduct.getCreatedDate());
		prod.setCost(appProduct.getCost());
		prod.setMake(appProduct.getMake());
		
		return productDao.save(prod);
		
	}
	
	public AppProduct getProductById(Integer id) {
		return productDao.findById(id).orElse(null);
	}
	
}
