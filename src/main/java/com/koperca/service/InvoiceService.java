package com.koperca.service;

import com.koperca.model.Invoice;


public interface InvoiceService {

	/*
	 * CREATE and UPDATE 
	 */
	public void saveInvoice(Invoice invoice);

	/*
	 * READ
	 */
	public Invoice getInvoice(Long idInvoice);

	/*
	 * DELETE
	 */
	public void deleteInvoice(Long idInvoice);

}
