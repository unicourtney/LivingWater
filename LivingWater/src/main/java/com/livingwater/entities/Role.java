package com.livingwater.entities;

import javax.persistence.*;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "role")
public class Role {

	
	@Id
	@Column(name = "roleID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String roleID;

	@Column(name = "name")
	private String name;

	public Role() {
		super();
	}

	
	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}