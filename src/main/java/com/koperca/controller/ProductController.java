package com.koperca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koperca.model.Product;
import com.koperca.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = { "/", "/listProduct" })
	public ResponseEntity<List<Product>> listProducts() {
		return new ResponseEntity<List<Product>>( productService.listProducts(), HttpStatus.OK);
	}

	@RequestMapping("/get/{idProduct}")
	public ResponseEntity<Product> getProduct(@PathVariable Long idProduct) {

		Product product = productService.getProduct(idProduct);
		
		return new ResponseEntity<Product>( product, HttpStatus.OK);
	}

	// save or update
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Void> saveProduct(@RequestBody Product product,
			BindingResult result) {
		if (product.getNameProduct() == null || product.getDescProduct() == null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);	
		}
		
		productService.saveProduct(product);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "{idProduct}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteProduct(@PathVariable("idProduct") Long id) {

		productService.deleteProduct(id);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
