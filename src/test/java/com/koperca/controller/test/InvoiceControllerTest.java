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

import com.koperca.controller.InvoiceController;
import com.koperca.model.Invoice;
import com.koperca.service.InvoiceService;
import com.koperca.util.TestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@TransactionConfiguration(transactionManager="transactionManager")
@ActiveProfiles("test")
public class InvoiceControllerTest {

	@Mock 
	private InvoiceService invoiceService;
	
	private MockMvc mockMvc;


    @InjectMocks
    private InvoiceController invoiceController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(invoiceController)
                .build();
    }
    
	@Test
	public void testGetInvoicet() {

		try {
			this.mockMvc.perform(get("/invoice/get/2"))
						.andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testSaveInvoice() {

	     Invoice invoice = new Invoice();
	     invoice.setIdClient((long) 1);
             
	     
		 try {
		
			 this.mockMvc.perform((post("/invoice/save")
			            .contentType(TestUtil.APPLICATION_JSON_UTF8)
			            .content(TestUtil.convertObjectToJsonString(invoice)))
			    ).andExpect(MockMvcResultMatchers.status().isOk());
			 
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}

	@Test
	public void testDeleteInvoice() {

		 try {
			this.mockMvc.perform(delete("/invoice/1"))
			.andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}

}
