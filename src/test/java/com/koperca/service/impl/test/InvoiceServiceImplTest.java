package com.koperca.service.impl.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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

import com.koperca.model.Invoice;
import com.koperca.model.InvoiceDetail;
import com.koperca.service.InvoiceService;
import com.koperca.util.TestUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@TransactionConfiguration(transactionManager="transactionManager")
@ActiveProfiles("test")
public class InvoiceServiceImplTest {

	@Autowired
	private SessionFactory sessionFactory;
    private Session session = null;
	
    @Autowired
    private InvoiceService invoiceService;
    
	@Test
	public void testSaveInvoice() {
		
		  for (int i = 0; i < 2; i++) { 
			  
			  Date date = new Date();
				Invoice invoice = new Invoice();
				List <InvoiceDetail> invoiceDetails = new ArrayList<InvoiceDetail>();
				invoice.setIdClient((long) i+2);
				invoice.setDateInvoice(date);

				invoiceDetails.add(new InvoiceDetail(Long.valueOf("1"), String.valueOf(i+2), 3, 10, invoice));
				invoiceDetails.add(new InvoiceDetail(Long.valueOf("2"),  String.valueOf(i+3), 5, 30, invoice));
				
				invoice.setInvoiceDetails(invoiceDetails); 
				
				invoiceService.saveInvoice(invoice);
		  }
		  
		  System.out.println(ClientServiceImplTest.class.getSimpleName()+"-"+ TestUtil.getNombreMetodo()  +": Success" );
		
	}

	@Test
	public void testGetInvoice() {
		
		Long idInvoice = (long) 2;
		Invoice invoice = new Invoice();
		String invoiceJson;
		
		try {

			invoice = invoiceService.getInvoice(idInvoice);
			invoiceJson = TestUtil.convertObjectToJsonString(invoice);
			
			System.out.println(ClientServiceImplTest.class.getSimpleName()+"-"+ TestUtil.getNombreMetodo()  +": " +invoiceJson);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testDeleteInvoice() {

		Long idInvoice = (long) 1;
		
		try {

			invoiceService.deleteInvoice(idInvoice);
			System.out.println(ClientServiceImplTest.class.getSimpleName()+"-"+ TestUtil.getNombreMetodo()  +": Success" );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
