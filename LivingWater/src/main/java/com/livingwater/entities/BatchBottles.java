package com.livingwater.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "batchBottles")
public class BatchBottles implements Serializable{

	@Id
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "batchID")
	private Batch batch;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date")
	private Calendar date;

	private int batchID;

	@Id
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "bottleID")
	private Bottle bottle;

	public BatchBottles(int batchID, Bottle bottle) {
		this.batchID = batchID;
		this.bottle = bottle;
	}

	public BatchBottles(Calendar date,Batch batch, Bottle bottle) {
		this.date = date;
		this.bottle = bottle;
		this.batch = batch;
	}

	public BatchBottles() {
		super();
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Bottle getBottle() {
		return bottle;
	}

	public void setBottle(Bottle bottle) {
		this.bottle = bottle;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}
}