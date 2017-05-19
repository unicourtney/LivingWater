package com.livingwater.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "deliveryTeam")
public class DeliveryTeam implements Serializable{


	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "plateNumber")
	private Vehicle vehicle;


	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "deliveryID")
	private Delivery delivery;


	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "user")
	private User user;

	@Column(name = "designation")
	private String designation;

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public DeliveryTeam() {
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DeliveryTeam(Vehicle vehicle, Delivery delivery, User user) {
		this.vehicle = vehicle;
		this.delivery = delivery;
		this.user = user;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
