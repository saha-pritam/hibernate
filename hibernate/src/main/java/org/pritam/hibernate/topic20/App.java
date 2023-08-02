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
		Parent p2 = new Parent(2,"P2");
		
		Child c1 = new Child(1,"C1");
		Child c2 = new Child(2,"C2");
		Child c3 = new Child(3,"C3");
		
		p1.setChildren(new ArrayList<Child>());
		p1.getChildren().add(c1);
		p1.getChildren().add(c2);
		c1.setParent(p1);
		c2.setParent(p1);
		
		//Saving dummy data
		session.beginTransaction();
		session.persist(p1); //Saving parent having child
		session.persist(p2); //Saving parent having no child
		session.persist(c3); //Saving child having no parent
		session.getTransaction().commit();
		
		session.clear();
		
		c1=session.get(Child.class,1);
		c3=session.get(Child.class,3);
		
		session.beginTransaction();
		session.remove(c1);//Deleting via child having parent
		session.remove(c3);//Deleting via child having no parent
		session.getTransaction().commit();
				
		session.close();
		sessionFactory.close();
		
	}
}
