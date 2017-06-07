package com.koperca.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koperca.dao.InvoiceDao;
import com.koperca.model.Invoice;
import com.koperca.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceDao invoiceDao;

	@Transactional
	public void saveInvoice(Invoice invoice) {
		invoiceDao.saveInvoice(invoice);
	}

	@Transactional(readOnly = true)
	public Invoice getInvoice(Long idInvoice) {
		return invoiceDao.getInvoice(idInvoice);
	}

	@Transactional
	public void deleteInvoice(Long idInvoice) {
		invoiceDao.deleteInvoice(idInvoice);

	}

}
