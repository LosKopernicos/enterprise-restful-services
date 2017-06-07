package com.koperca.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "detailInvoice")

public class InvoiceDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long idDetailInvoice; 
	private String codeProduct;
	private int quantityProduct;
	private double amountProduct;
	 private Invoice invoices;
	

	public InvoiceDetail() {
		// TODO Auto-generated constructor stub
	}



	public InvoiceDetail(Long idDetailInvoice, String codeProduct,
			int quantityProduct, double amountProduct, Invoice invoices) {
		super();
		this.idDetailInvoice = idDetailInvoice;
		this.codeProduct = codeProduct;
		this.quantityProduct = quantityProduct;
		this.amountProduct = amountProduct;
		this.invoices = invoices;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	  public Long getIdDetailInvoice() {
		return idDetailInvoice;
	}
	
	@Column(nullable = false)
	public String getCodeProduct() {
		return codeProduct;
	}
	
	 @Column(nullable = false)
	public int getQuantityProduct() {
		return quantityProduct;
	}
	
	 @Column(nullable = false)
	public double getAmountProduct() {
		return amountProduct;
	}
	

	public void setQuantityProduct(int quantityProduct) {
		this.quantityProduct = quantityProduct;
	}
	
	public void setAmountProduct(double amountProduct) {
		this.amountProduct = amountProduct;
	}
	
	public void setCodeProduct(String codeProduct) {
		this.codeProduct = codeProduct;
	}

	
	 public void setIdDetailInvoice(Long idDetailInvoice) {
		this.idDetailInvoice = idDetailInvoice;
	}
	 
	 @JsonBackReference
	 @ManyToOne(cascade= CascadeType.ALL,fetch=FetchType.LAZY)
	 @JoinColumn(name="idInvoice")
	public Invoice getInvoices() {
		return invoices;
	}

	public void setInvoices(Invoice invoices) {
		this.invoices = invoices;
	}
	 
	 
}
