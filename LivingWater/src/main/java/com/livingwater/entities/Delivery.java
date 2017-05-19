package com.livingwater.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * The persistent class for the users database table.
 */
@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @Column(name = "deliveryID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer deliveryID;

    @ManyToOne
    @JoinColumn(name = "plateNumber")
    private Vehicle vehicle;

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Column(name = "status")

	private String status;

    @Column(name = "deliveryDate")
    private Timestamp date;


    public Delivery() {
        super();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Integer getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(Integer deliveryID) {
        this.deliveryID = deliveryID;
    }

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}