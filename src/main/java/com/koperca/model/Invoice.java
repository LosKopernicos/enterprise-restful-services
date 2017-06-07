package com.koperca.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "invoice")

public  class Invoice implements Serializable   {

	private static final long serialVersionUID = 1L;
	private Long idInvoice;
	private Long idClient;
	private Date dateInvoice;


	public Invoice() {
	
	}

	public Invoice(Long idInvoice, Long idClient, Date dateInvoice,
			List<InvoiceDetail> invoiceDetails) {
		super();
		this.idInvoice = idInvoice;
		this.idClient = idClient;
		this.dateInvoice = dateInvoice;
		this.invoiceDetails = invoiceDetails;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getIdInvoice() {
		return idInvoice;
	}


    @Column(nullable = false)
	public Long getIdClient() {
		return idClient;
	}


   @Column(nullable = false)
	public Date getDateInvoice() {
		return dateInvoice;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public void setDateInvoice(Date dateInvoice) {
		this.dateInvoice = dateInvoice;
	}

	public void setIdInvoice(Long idInvoice) {
		this.idInvoice = idInvoice;
	}

	 
	private List<InvoiceDetail> invoiceDetails;
	
	@JsonManagedReference
	 @OneToMany(mappedBy="invoices",cascade= CascadeType.ALL,fetch=FetchType.EAGER)
	 public List<InvoiceDetail> getInvoiceDetails() {
		return invoiceDetails;
	}

	public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}
	
	 
	 
	  
	  
}
	