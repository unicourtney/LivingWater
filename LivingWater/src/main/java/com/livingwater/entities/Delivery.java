package com.livingwater.entities;

import javax.persistence.*;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "delivery")
public class Delivery {

	@Id
	@Column(name = "deliveryID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String deliveryID;

	@Column(name = "status")
	private String status;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "batchID")
	private Batch batch;

	public Delivery() {
		super();
	}

	public String getDeliveryID() {
		return deliveryID;
	}

	public void setDeliveryID(String deliveryID) {
		this.deliveryID = deliveryID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

}