package org.pritam.hibernate.topic5;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("org/pritam/hibernate/topic5/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//Saving via save method
		Person person1 = new Person("Pritam Saha",new Date());
		session.beginTransaction();
		session.save(person1);
		session.getTransaction().commit();
		
		//Saving via persists method
		Person person2 = new Person("Ashish Saha",new Date());
		session.beginTransaction();
		session.persist(person2);
		session.getTransaction().commit();
	
		session.close();
		sessionFactory.close();
	}
}
