package com.livingwater.entities;

import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "batchBottles")
public class BatchBottles {

	@Id
	@Column(name = "batchID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String batchID;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "bottleID")
	private List<Bottle> bottle;

	public BatchBottles() {
		super();
	}

	public String getBatchID() {
		return batchID;
	}

	public void setBatchID(String batchID) {
		this.batchID = batchID;
	}

	public List<Bottle> getBottle() {
		return bottle;
	}

	public void setBottle(List<Bottle> bottle) {
		this.bottle = bottle;
	}

	
}