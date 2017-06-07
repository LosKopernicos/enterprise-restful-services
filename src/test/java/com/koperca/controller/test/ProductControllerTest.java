package com.koperca.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.koperca.controller.ProductController;
import com.koperca.model.Product;
import com.koperca.service.ProductService;
import com.koperca.util.TestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@TransactionConfiguration(transactionManager="transactionManager")
@ActiveProfiles("test")
public class ProductControllerTest {

	@Mock 
	private ProductService productService;
	
	private MockMvc mockMvc;


    @InjectMocks
    private ProductController productController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(productController)
                .build();
    }

    
	@Test
	public void testListProducts() {

		try {
			this.mockMvc.perform(get("/product/listProduct"))
						.andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testGetProduct() {

		try {
			this.mockMvc.perform(get("/product/get/2"))
						.andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testSaveProduct() {

	     Product product = new Product();
	     product.setNameProduct("Product 1");
	     product.setDescProduct("Prueba Product 1");
              
	     
		 try {
		
			 this.mockMvc.perform((post("/product/save")
			            .contentType(TestUtil.APPLICATION_JSON_UTF8)
			            .content(TestUtil.convertObjectToJsonString(product)))
			    ).andExpect(MockMvcResultMatchers.status().isOk());
			 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}

	@Test
	public void testDeleteProduct() {

		 try {
			this.mockMvc.perform(delete("/product/1"))
			.andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}

}
