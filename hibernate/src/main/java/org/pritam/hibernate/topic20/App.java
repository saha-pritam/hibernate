package org.pritam.hibernate.topic20;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("org/pritam/hibernate/topic20/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Parent p1 = new Parent(1,"P1");
		
		Child c1 = new Child(1,"C1");
		Child c2 = new Child(2,"C2");
		Child c3 = new Child(3,"C3");
		
		p1.setChildren(new ArrayList<Child>());
		p1.getChildren().add(c1);
		p1.getChildren().add(c2);
		c1.setParent(p1);
		c2.setParent(p1);
		
		//Saving via child having no parent
		session.beginTransaction();
		session.persist(c3);
		session.getTransaction().commit();
		
		//Saving via child having parent
		session.beginTransaction();
		session.persist(c1);
		session.persist(c2);
		session.getTransaction().commit();
		
		
		session.close();
		sessionFactory.close();
		
	}
}
