package com.koperca.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "product")
public class Product {
	
	private Long idProduct;
	private String nameProduct;
	private String descProduct;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getIdProduct() {
		return idProduct;
	}

	@Column(nullable = false)
	public String getNameProduct() {
		return nameProduct;
	}
	
	@Column(nullable = false)
	public String getDescProduct() {
		return descProduct;
	}
	
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public void setDescProduct(String descProduct) {
		this.descProduct = descProduct;
	}

}
