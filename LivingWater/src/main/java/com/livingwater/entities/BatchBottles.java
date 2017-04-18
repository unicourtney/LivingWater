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
	private int batchID;

	public BatchBottles(int batchID, Bottle bottle) {
		this.batchID = batchID;
		this.bottle = bottle;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "bottleID")
	private Bottle bottle;

	public BatchBottles() {
		super();
	}

	public int getBatchID() {
		return batchID;
	}

	public void setBatchID(int batchID) {
		this.batchID = batchID;
	}

	public Bottle getBottle() {
		return bottle;
	}

	public void setBottle(Bottle bottle) {
		this.bottle = bottle;
	}

	
}