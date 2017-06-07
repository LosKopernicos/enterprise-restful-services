package com.koperca.service;

import java.util.List;

import com.koperca.model.Product;


public interface ProductService {

	/*
	 * CREATE and UPDATE 
	 */
	public void saveProduct(Product product);

	/*
	 * READ
	 */
	public List<Product> listProducts();
	
	public Product getProduct(Long codeProduct);

	/*
	 * DELETE
	 */
	public void deleteProduct(Long id);

}
