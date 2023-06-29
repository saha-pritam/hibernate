package org.pritam.hibernate.topic4;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("org/pritam/hibernate/topic4/hibernate.cfg.xml").buildSessionFactory();
		sessionFactory.close();
	}

}
