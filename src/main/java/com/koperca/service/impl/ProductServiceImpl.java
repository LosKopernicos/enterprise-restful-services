package com.koperca.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koperca.dao.ProductDao;
import com.koperca.model.Product;
import com.koperca.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Transactional
	public void saveProduct(Product product) {
		productDao.saveProduct(product);
	}

	@Transactional(readOnly = true)
	public List<Product> listProducts() {
		return productDao.listProduct();
	}

	@Transactional(readOnly = true)
	public Product getProduct(Long codeProduct) {
		return productDao.getProduct(codeProduct);
	}

	@Transactional
	public void deleteProduct(Long id) {
		productDao.deleteProduct(id);

	}

}
