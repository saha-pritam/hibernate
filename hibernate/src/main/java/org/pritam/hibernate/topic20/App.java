package org.pritam.hibernate.topic20;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("org/pritam/hibernate/topic20/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Parent p1 = new Parent(1,"p1");
		Parent p2 = new Parent(2,"p2");
		Parent p3 = new Parent(3,"p3");
		Parent p4 = new Parent(4,"p4");
		
		Child c1 = new Child(1,"C1");
		Child c2 = new Child(2,"C2");
		Child c3 = new Child(3,"C3");
		Child c4 = new Child(4,"C4");
		
		p1.setChildren(new ArrayList<Child>());
		p2.setChildren(new ArrayList<Child>());
		p3.setChildren(new ArrayList<Child>());
		
		c1.setParent(new ArrayList<Parent>());
		c2.setParent(new ArrayList<Parent>());
		c3.setParent(new ArrayList<Parent>());
		
		p1.getChildren().add(c1); 
		p1.getChildren().add(c2);
		p2.getChildren().add(c2);
		p3.getChildren().add(c1);
		p3.getChildren().add(c2);
		p3.getChildren().add(c3);
		
		c1.getParent().add(p1);
		c1.getParent().add(p3);
		c2.getParent().add(p1);
		c2.getParent().add(p2);
		c2.getParent().add(p3);
		c3.getParent().add(p3);
		
		session.beginTransaction();
		session.persist(c4);//Saving via child with no parent
		session.getTransaction().commit();
		
		session.beginTransaction();
		session.persist(c1);//Saving via child with at least one parent
		session.getTransaction().commit();
		
		session.close();
		sessionFactory.close();
		
	}
}
