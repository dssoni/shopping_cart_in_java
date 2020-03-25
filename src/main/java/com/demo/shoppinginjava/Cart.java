package com.demo.shoppinginjava;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart {

	@Column(name = "cart_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;

	@Column(name = "cart_total")
	private int cartTotal;

	@OneToOne
	private User user;

	@ManyToMany
	@Column(name = "product_id")
	private List<Product> products;

	/**
	 * @return the cartId
	 */
	public int getCartId() {
		return cartId;
	}

	/**
	 * @param cartId the cartId to set
	 */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return the cartTotal
	 */
	public int getCartTotal() {
		return cartTotal;
	}

	/**
	 * @param cartTotal the cartTotal to set
	 */
	public void setCartTotal(int cartTotal) {
		this.cartTotal = cartTotal;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	public Cart(List<Product> products) {
		super();
		this.products = products;
	}

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Cart() {
		super();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "cart id: " + cartId + " cart total: " + cartTotal + " products: " + products + "user: " + user;
	}

}
