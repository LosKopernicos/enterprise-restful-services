package com.koperca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koperca.model.Client;
import com.koperca.service.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@RequestMapping(value = { "/", "/listClient" })
	public ResponseEntity<List<Client>> listClients() {

		return new ResponseEntity<List<Client>>( clientService.listClients(), HttpStatus.OK);
		
	}

	@RequestMapping("/get/{idClient}")
	public ResponseEntity<Client> getClient(@PathVariable Long idClient) {

		if (idClient==0) {
			return new ResponseEntity<Client>(HttpStatus.NOT_ACCEPTABLE);
		}
		
		Client client = clientService.getClient(idClient);
		if (client==null) {
			return new ResponseEntity<Client>( client, HttpStatus.NOT_FOUND);
			
		}
		
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	// save or update
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Void> saveClient(@RequestBody Client client) {
		if (client.getNameClient() == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);	
		}
		
		clientService.saveClient(client);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "{idClient}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteClient(@PathVariable("idClient") Long id) {

		if (id==0) {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
		
		clientService.deleteClient(id);
	
		return new ResponseEntity<Void>(HttpStatus.OK);

	}
}
