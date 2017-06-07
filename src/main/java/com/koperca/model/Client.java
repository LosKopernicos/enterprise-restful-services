package com.koperca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "client")
public class Client {

	private Long idClient;
	private String nameClient;
	private String adressClient;
	private String phoneClient;
   
	

	public Client() {
		super();
	}


	public Client(Long idClient, String nameClient, String adressClient,
			String phoneClient) {
		super();
		this.idClient = idClient;
		this.nameClient = nameClient;
		this.adressClient = adressClient;
		this.phoneClient = phoneClient;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getIdClient() {
		return idClient;
	}
	

	@Column(nullable = false)
	public String getNameClient() {
		return nameClient;
	}
	
	@Column
	public String getAdressClient() {
		return adressClient;
	}
	
	@Column
	public String getPhoneClient() {
		return phoneClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	
	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public void setAdressClient(String adressClient) {
		this.adressClient = adressClient;
	}
	
	public void setPhoneClient(String phoneClient) {
		this.phoneClient = phoneClient;
	}
	
	
}
