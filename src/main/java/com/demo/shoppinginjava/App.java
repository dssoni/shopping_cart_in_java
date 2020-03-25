package com.demo.shoppinginjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {

		String email, password;
		Cart cart = new Cart();
		List<Product> productListForCart = new ArrayList<Product>();

		// to register user for the first time
//		 Initializer.registerUser(new User("dhruv", "dhruvsoni@gmail.com", "soni"));

		System.out.println("WELCOME TO AMAZON SHOPPING in JAVA by DHRUV");

		System.out.println("enter email: ");
		email = scanner.next();
		System.out.println("enter password: ");
		password = scanner.next();

		if (HibernateOperations.validateUser(new User(email, password))) {
			System.out.println("SELECT OPTIONS FROM BELOW: ");
			System.out.println("1: list all products");

			int option = scanner.nextInt();

			switch (option) {
			case 1:

				// to register all productos for the first time
//				Initializer.registerProduct(new Product("macbook", 1500));
//				Initializer.registerProduct(new Product("lenovo", 900));
//				Initializer.registerProduct(new Product("hp", 750));
//				Initializer.registerProduct(new Product("dell", 1200));

				List<Product> products = HibernateOperations.getAllProducts();

				for (Product p : products) {
					System.out.println(p);
				}

				System.out.println("WANT TO ADD PRODUCTS TO CART? : YES/NO");

				switch (scanner.next()) {

				case "YES":

					System.out.println("ENTER PRODUCT ID FROM THE LIST ABOVE TO ADD IT TO CART");
					System.out.println("enter DONE when you are done adding products to carts!");
					cart.setUser(HibernateOperations.getUserFromEmailAndPassword(email, password));
					while (scanner.hasNext()) {
						String temp = scanner.next();
						if (temp.equals("DONE")) {
							break;
						} else {
							productListForCart.add(HibernateOperations.getProductFromProductId(Integer.parseInt(temp)));
							System.out.println("Successfully added product: " + Integer.parseInt(temp));
						}
					}

					cart.setProducts(productListForCart);
					cart.setCartTotal(HibernateOperations.calculateCartTotalFromProductList(productListForCart));
					HibernateOperations.saveCartToDB(cart);
					System.out.println("MOVING TO CART NOW.....");

					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(cart);

					System.out.println("TO CHECKOUT TRANSACTION -- ENTER 'PAY' or to CANCEL TRANSACTION 'CANCEL'. ");

					switch (scanner.next()) {

					case "PAY":

						System.out.println("THANKS FOR PAYMENT! "
								+ HibernateOperations.getUserFromEmailAndPassword(email, password).getName());
						break;

					case "CANCEL":
						System.out.println("YOUR TRANSACTION IS CANCELLED! "
								+ HibernateOperations.getUserFromEmailAndPassword(email, password).getName());
						break;

					}

					break;

				case "NO":

					break;

				default:

					break;
				}

				break;

			default:
				break;
			}

		} else {
			System.out.println("uhh ohh! ... wrong credentials...run app again");
		}

	}

}
