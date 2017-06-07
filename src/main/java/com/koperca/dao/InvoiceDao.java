package com.koperca.dao;

import com.koperca.model.Invoice;

public interface InvoiceDao {

	public void saveInvoice(Invoice invoice); 

	public Invoice getInvoice(Long idInvoice);

	public void deleteInvoice(Long idInvoice);
}
