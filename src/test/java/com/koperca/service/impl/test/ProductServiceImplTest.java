package com.koperca.service.impl.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.koperca.model.Product;
import com.koperca.service.ProductService;
import com.koperca.util.TestUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@TransactionConfiguration(transactionManager="transactionManager")
@ActiveProfiles("test")
public class ProductServiceImplTest {

	@Autowired
	 private SessionFactory sessionFactory;
    private Session session = null;
	
    @Autowired
    private ProductService productService; 
	
	@Test
	public void testSaveProduct() {

		Product product = new Product();
		
		   try {

			     for (int i = 0; i < 10; i++) { 
			    	 product.setNameProduct("Prueba Producto "+i);
			    	 product.setDescProduct("Prueba Descripcion Producto " +i);	
			    	 
			    	 productService.saveProduct(product);
			     }
			     
			     System.out.println(ClientServiceImplTest.class.getSimpleName()+"-"+ TestUtil.getNombreMetodo()  +": Success" );
			     

			} catch (Exception e) {
				e.printStackTrace();
			}

	}

	@Test
	public void testListProducts() {

		List<Product> products = new ArrayList<Product>() ;
		String productsJson;
		
		try {

			products = productService.listProducts();
			productsJson = TestUtil.convertObjectToJsonString(products);

			System.out.println(ClientServiceImplTest.class.getSimpleName()+"-"+ TestUtil.getNombreMetodo()  +": " +productsJson);
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}

	@Test
	public void testGetProduct() {

		Long idProduct = (long) 2;
		Product product = new Product();
		String productJson;
		
		try {

			product = productService.getProduct(idProduct);
			productJson = TestUtil.convertObjectToJsonString(product);
			
			System.out.println(ClientServiceImplTest.class.getSimpleName()+"-"+ TestUtil.getNombreMetodo()  +": " +productJson);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteProduct() {

		Long idProduct = (long) 1;
		
		try {

			productService.deleteProduct(idProduct);
			System.out.println(ClientServiceImplTest.class.getSimpleName()+"-"+ TestUtil.getNombreMetodo()  +": Success" );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
