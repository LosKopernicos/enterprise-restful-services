package com.koperca.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koperca.dao.ClientDao;
import com.koperca.model.Client;

@Repository
public class ClientDaoImpl implements ClientDao {

	@Autowired
	private SessionFactory sessionFactory;


	public ClientDaoImpl() {
		super();
	
	}



	public void saveClient(Client client) {
		getSession().merge(client);

	}

	@SuppressWarnings("unchecked")
	public List<Client> listClient() {

		return getSession().createCriteria(Client.class).list();
	}


   public Client getClient(Long idClient) {
		return (Client) getSession().get(Client.class, idClient);
	}

	public void deleteClient(Long idClient) {

		Client client = getClient(idClient);

		if (null != client) {
			getSession().delete(client);
		}

	}

	private Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
