package com.koperca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koperca.model.Invoice;
import com.koperca.service.InvoiceService;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	@RequestMapping("/get/{idInvoice}")
	public ResponseEntity<Invoice> getInvoicet(@PathVariable Long idInvoice) {

		if (idInvoice==0) {
			return new ResponseEntity<Invoice>(HttpStatus.NO_CONTENT);
		}
		Invoice invoice = invoiceService.getInvoice(idInvoice);
		
		return new ResponseEntity<Invoice>(invoice, HttpStatus.OK);
	}

	// save or update
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Void> saveInvoice(@RequestBody Invoice invoice,
			BindingResult result) {
		if (invoice.getIdClient() == null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);	
		}
		
		invoiceService.saveInvoice(invoice);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "{idInvoice}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteInvoice(@PathVariable("idInvoice") Long idInvoice) {
	
		if (idInvoice==0) {
		return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
		invoiceService.deleteInvoice(idInvoice);

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
