package com.demo.shoppinginjava;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Column(name = "product_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;

	private String name;

	private int price;

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
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
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	public Product() {
	}

	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Product(int productId, String name, int price) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "product id: " + productId + " product name: " + name + " product price: " + price;
	}

}
