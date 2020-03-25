package com.demo.shoppinginjava;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateOperations {

	static Configuration con = new Configuration().addAnnotatedClass(User.class).addAnnotatedClass(Product.class)
			.addAnnotatedClass(Cart.class).configure();

	static ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties())
			.buildServiceRegistry();

	static SessionFactory factory = con.buildSessionFactory(registry);

	public static boolean validateUser(User user) {

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		// ALTERNATE METHOS IS THIS
//		Query query = session
//				.createQuery("select email,password from User where email = :email and password = :password");
//		query.setParameter("email", user.getEmail());
//		query.setParameter("password", user.getPassword());
//
//		Object[] userdb = (Object[]) query.uniqueResult();
//		if(userdb!=null && userdb.length>1) {
//			return true;
//		}

		Query query = session.createQuery("from User where email = :email and password = :password");
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());

		User userdb = (User) query.uniqueResult();

		if (userdb != null) {

			transaction.commit();
			return true;
		}

		transaction.commit();
		return false;
	}

	public static List<Product> getAllProducts() {

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		List<Product> productList = new ArrayList<Product>();
		Query query = session.createQuery("from Product");
		productList = query.list();

		transaction.commit();

		return productList;
	}

	public static User getUserFromEmailAndPassword(String email, String password) {

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from User where email = :email and password = :password");
		query.setParameter("email", email);
		query.setParameter("password", password);

		User userdb = (User) query.uniqueResult();

		transaction.commit();

		return userdb;
	}

	public static Product getProductFromProductId(int temp) {
		// TODO Auto-generated method stub

		Product productdb = new Product();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		productdb = (Product) session.get(Product.class, temp);

		transaction.commit();

		return productdb;
	}

	public static void saveCartToDB(Cart cart) {

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(cart);

		transaction.commit();

	}

	public static int calculateCartTotalFromProductList(List<Product> productListForCart) {
		// TODO Auto-generated method stub
		int sum = 0;

		for (Product p : productListForCart) {
			sum = sum + p.getPrice();
		}

		return sum;
	}

}
