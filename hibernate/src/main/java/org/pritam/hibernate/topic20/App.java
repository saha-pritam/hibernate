package org.pritam.hibernate.topic20;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("org/pritam/hibernate/topic20/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Parent p1 = new Parent(1,"P1");
		Child c1 = new Child(1,"C1");
		p1.setChild(c1);
		c1.setParent(p1);
		
		session.beginTransaction();
		session.persist(p1);
		session.getTransaction().commit();
		
		
		session.close();
		sessionFactory.close();
		
	}
}
