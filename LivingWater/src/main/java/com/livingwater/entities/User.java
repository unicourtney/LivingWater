package com.livingwater.entities;

import javax.persistence.*;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "userID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String userID;

	@Column(name = "name")
	private String name;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "role")
	private Role role;


	public String getUserID() {
		return this.userID;
	}

	public User() {
		super();
	}

	public void setUserID(String userid) {
		this.userID = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}