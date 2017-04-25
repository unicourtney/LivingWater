package com.livingwater.entities;

import java.sql.Timestamp;
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
	private int batchID;

	@Column(name="date")
	private Timestamp date;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "bottleID")
	private Bottle bottle;

	public BatchBottles(int batchID, Bottle bottle) {
		this.batchID = batchID;
		this.bottle = bottle;
	}


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

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
}