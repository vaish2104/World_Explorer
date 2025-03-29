package com.stackroute.userauthentication.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {


	/*
	 * Defining the columns in the table
	 * Marking username of type string as Primary Key
	 */
	@Id
	private String username;
	private String password;
	
	/*
	 * Creating Getters and Setters
	*/
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
	
	/*
	 * overriding the toString Method
	*/
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	
		
}


