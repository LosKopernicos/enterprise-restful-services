package com.koperca.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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

import com.koperca.controller.ClientController;
import com.koperca.model.Client;
import com.koperca.service.ClientService;
import com.koperca.util.TestUtil;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@TransactionConfiguration(transactionManager="transactionManager")
@ActiveProfiles("test")
public class ClientControllerTest {
	
	@Mock 
	private ClientService clientService;
	
	private MockMvc mockMvc;


    @InjectMocks
    private ClientController clientController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(clientController)
                .build();
    }

	@Test
	public void testListClients() {

		try {
			this.mockMvc.perform(get("/client/listClient"))
						.andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testGetClient() {
		 
		try {
			this.mockMvc.perform(get("/client/get/2"))
						.andExpect(MockMvcResultMatchers.status().isNotFound());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testSaveClient() throws Exception {
		
	     Client client = new Client();
	     client.setNameClient("omar");
	     client.setAdressClient("prueba");
	     client.setPhoneClient("123456");
	              
	     
		 this.mockMvc.perform((post("/client/save")
	                .contentType(TestUtil.APPLICATION_JSON_UTF8)
	                .content(TestUtil.convertObjectToJsonString(client)))
	        ).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testDeleteClient() {

		 try {
			this.mockMvc.perform(delete("/client/1"))
			.andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

    
}
