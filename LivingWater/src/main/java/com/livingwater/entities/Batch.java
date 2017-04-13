package com.livingwater.entities;

import javax.persistence.*;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="batch")
public class Batch{

	@Id
	@Column(name="batchID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String batchID;
	
	@Column(name="status")
	private String status;

	public Batch() {
		super();
	}

	public String getBatchID() {
		return batchID;
	}

	public void setBatchID(String batchID) {
		this.batchID = batchID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	
	
}