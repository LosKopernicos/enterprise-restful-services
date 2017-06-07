package com.koperca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koperca.dao.ClientDao;
import com.koperca.model.Client;
import com.koperca.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDao clientDao;

	@Transactional
	public void saveClient(Client client) {
		clientDao.saveClient(client);
	}

	@Transactional(readOnly = true)
	public List<Client> listClients() {
		return clientDao.listClient();
	}

    @Transactional(readOnly = true)
	public Client getClient(Long idClient) {

		Client result = new Client();
		result = clientDao.getClient(idClient);
		
		return result;
	}

	@Transactional
	public void deleteClient(Long id) {
		clientDao.deleteClient(id);

	}

}
