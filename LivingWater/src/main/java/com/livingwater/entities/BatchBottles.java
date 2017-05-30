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


	@Id
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "bottleID")
	private Bottle bottle;

	public BatchBottles() {
	}

	public BatchBottles(Calendar date, Batch batch, Bottle bottle) {

		this.batch = batch;
		this.date = date;
		this.bottle = bottle;
	}

	public BatchBottles(Batch batch, Bottle bottle) {
		this.batch = batch;
		this.bottle = bottle;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Bottle getBottle() {
		return bottle;
	}

	public void setBottle(Bottle bottle) {
		this.bottle = bottle;
	}
}