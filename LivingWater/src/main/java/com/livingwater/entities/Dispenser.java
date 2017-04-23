package com.livingwater.entities;

import javax.persistence.*;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "dispenser")
public class Dispenser {

	@Id
	@Column(name = "serialNumber")
	private String serialNumber;

	@Column(name = "status")
	private String status;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "customerID")
	private Customer customer;

	public Dispenser() {
		super();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}