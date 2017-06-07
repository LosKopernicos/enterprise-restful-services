package com.koperca.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koperca.dao.ProductDao;
import com.koperca.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveProduct(Product product) {
		
		getSession().merge(product);

	}

	@SuppressWarnings("unchecked")
	public List<Product> listProduct() {

		return getSession().createCriteria(Product.class).list();
	}

	public Product getProduct(Long codeProduct) {
		return (Product) getSession().get(Product.class, codeProduct);
	}

	public void deleteProduct(Long codeProduct) {

		Product product = getProduct(codeProduct);

		if (null != product) {
			getSession().delete(product);
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
