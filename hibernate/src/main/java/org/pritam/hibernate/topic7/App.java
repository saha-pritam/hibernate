package org.pritam.hibernate.topic7;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("org/pritam/hibernate/topic7/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
				
		//Saving a data
		Address address = new Address("West Bengal","India");
		Person person = new Person("Ashish Saha",new Date(),address);
		session.beginTransaction();
		session.persist(person);
		session.getTransaction().commit();
		
		//Fetching 
		Person p = session.get(Person.class, 1);
		System.out.println("Fetching Complete");
		System.out.println(p);
		
		session.close();
		sessionFactory.close();
	}
}
