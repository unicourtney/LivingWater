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
	private Integer userID;

	@Column(name = "name")
	private String name;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "role")
	private Role role;


	public User(String name, String username, String password, Role role) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public User(Integer userID, String name, String username, String password, Role role) {
		this.userID = userID;
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Integer getUserID() {
		return this.userID;
	}

	public User() {
		super();
	}

	public void setUserID(Integer userid) {
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