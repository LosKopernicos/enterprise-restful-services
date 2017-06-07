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

import com.koperca.model.Client;
import com.koperca.service.ClientService;
import com.koperca.util.TestUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@TransactionConfiguration(transactionManager="transactionManager")
@ActiveProfiles("test")
public class ClientServiceImplTest {

	@Autowired
	 private SessionFactory sessionFactory;
     private Session session = null;
 	
     @Autowired
     private ClientService clientService;
	

	@Test
	public void testSaveClient() {

		Client client = new Client();
	   try {

		     for (int i = 0; i < 5; i++) { 
		    	 
		    	 client.setNameClient("Cliente Prueba "+i);
			     client.setAdressClient("Direccion Cliente Prueba "+i);
			     client.setPhoneClient("123456");
			     clientService.saveClient(client);
			     
		     }
		     
		     System.out.println(ClientServiceImplTest.class.getSimpleName()+"-"+ TestUtil.getNombreMetodo()  +": Success" );
		     

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testListClients() {
		List<Client> clients = new ArrayList<Client>() ;
		String clientJson;
		
		try {

			clients = clientService.listClients();
			clientJson = TestUtil.convertObjectToJsonString(clients);

			System.out.println(ClientServiceImplTest.class.getSimpleName()+"-"+ TestUtil.getNombreMetodo()  +": " +clientJson);
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}

	@Test
	public void testGetClient() {
		Long idClient = (long) 2;
		Client client = new Client();
		String clientJson;
		
		try {

			client = clientService.getClient(idClient);
			clientJson = TestUtil.convertObjectToJsonString(client);
			
			System.out.println(ClientServiceImplTest.class.getSimpleName()+"-"+ TestUtil.getNombreMetodo()  +": " +clientJson);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testDeleteClient() {

		Long idClient = (long) 1;
		
		try {

			clientService.deleteClient(idClient);
			System.out.println(ClientServiceImplTest.class.getSimpleName()+"-"+ TestUtil.getNombreMetodo()  +": Success" );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
