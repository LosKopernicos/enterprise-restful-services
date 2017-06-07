package com.koperca.dao;

import java.util.List;

import com.koperca.model.Client;

public interface ClientDao {

	public void saveClient(Client client); 

	public List<Client> listClient();
	
	public Client getClient(Long idCliente);

	public void deleteClient(Long idCliente);
}
