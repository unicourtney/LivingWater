package com.livingwater.entities;

import javax.persistence.*;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="customer")
public class Customer {

	@Id
	@Column(name="customerID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerID;

	@Column(name="name")
	private String name;

	public Customer() {
		super();
	}

	@Column(name="address")
	private String address;
	
	@Column(name="contact_number")
	private Long contactNumber;

	@Column(name="pricing")	
	private Double pricing;
	
	@Column(name="typeOfCustomer")
	private String typeOfCustomer;


	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Double getPricing() {
		return pricing;
	}

	public void setPricing(Double pricing) {
		this.pricing = pricing;
	}

	public String getTypeOfCustomer() {
		return typeOfCustomer;
	}

	public void setTypeOfCustomer(String typeOfCustomer) {
		this.typeOfCustomer = typeOfCustomer;
	}


}