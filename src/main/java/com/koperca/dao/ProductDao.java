package com.koperca.dao;

import java.util.List;

import com.koperca.model.Product;

public interface ProductDao {

	public void saveProduct(Product product); 

	public List<Product> listProduct();
	
	public Product getProduct(Long codeProduct);

	public void deleteProduct(Long id);
}
