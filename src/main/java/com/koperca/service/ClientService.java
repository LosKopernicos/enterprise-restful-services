package com.koperca.service;

import java.util.List;

import com.koperca.model.Client;


public interface ClientService {

	/*
	 * CREATE and UPDATE 
	 */
	public void saveClient(Client client);

	/*
	 * READ
	 */
	public List<Client> listClients();
	
	public Client getClient(Long idClient);

	/*
	 * DELETE
	 */
	public void deleteClient(Long id);

}
