package com.livingwater.entities;

import javax.persistence.*;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "Dispenser")
public class Dispenser {

	@Id
	@Column(name = "serialNumber")
	private String serialNumber;

	@Column(name = "status")
	private String status;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "user")
	private User user;

	public Dispenser() {
		super();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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