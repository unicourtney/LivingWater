package com.livingwater.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "deliveryTeam")
public class DeliveryTeam implements Serializable{
	@Id
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "deliveryID")
	private Delivery delivery;

	@Id
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "user")
	private User user;

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

	public DeliveryTeam(Delivery delivery, User user) {

		this.delivery = delivery;
		this.user = user;
	}
}
