package com.koperca.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koperca.dao.InvoiceDao;
import com.koperca.model.Invoice;

@Repository
public class InvoiceDaoImpl implements InvoiceDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveInvoice(Invoice invoice) {
		
		getSession().merge(invoice);

	}

	public Invoice getInvoice(Long idInvoice) {
		return (Invoice) getSession().get(Invoice.class, idInvoice);
	}

	public void deleteInvoice(Long idInvoice) {

		Invoice invoice = getInvoice(idInvoice);

		if (null != invoice) {
			getSession().delete(invoice);
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
