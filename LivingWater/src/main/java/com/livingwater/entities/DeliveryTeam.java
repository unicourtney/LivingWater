package com.livingwater.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class DeliveryTeam {
	@Id
	@Column(name = "deliveryID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String deliveryID;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "user")
	private User user;
}
