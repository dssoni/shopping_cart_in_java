package com.demo.shoppinginjava;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Initializer {

	static Configuration con = new Configuration().addAnnotatedClass(User.class).addAnnotatedClass(Product.class)
			.addAnnotatedClass(Cart.class).configure();

	static ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(con.getProperties())
			.buildServiceRegistry();

	static SessionFactory factory = con.buildSessionFactory(registry);

	public static void registerUser(User user) {

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(user);

		transaction.commit();

	}

	public static void registerProduct(Product product) {
		// TODO Auto-generated method stub

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(product);

		transaction.commit();

	}

}
