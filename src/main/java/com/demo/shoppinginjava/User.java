package com.demo.shoppinginjava;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Column(name = "user_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	private String name;

	private String email;

	private String password;

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public User(int userId, String name, String email, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public User() {
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "user id: " + userId + " name: " + name + " email: " + email + " password: " + password;
	}
}
