package org.pritam.hibernate.topic6;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("org/pritam/hibernate/topic6/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
				
		//Saving a data
		Person person = new Person("Ashish Saha",new Date());
		session.beginTransaction();
		session.persist(person);
		session.getTransaction().commit();
		
		//Fetching via get - eager loading
		Person p = session.get(Person.class, 1);
		System.out.println("Fetching Complete");
		System.out.println(p);
		
		//When Id doesn't exists get will return null
		p = session.get(Person.class, 100);
		System.out.println("Fetching Complete");
		System.out.println(p);
		
		//Clearing cache
		session.clear(); 
		
		//Fetching via load - lazy loading
		System.out.println("==============================================");
		p = session.load(Person.class, 1);
		System.out.println("Fetching Not Yet Started");
		System.out.println(p);
		
		//When Id doesn't exists load will throw exception only when the query is executed
		p = session.load(Person.class, 100);
		System.out.println("Fetching Not Yet Started");
		try {
			System.out.println(p);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Clearing cache
		session.clear(); 
		
		//Fetching via getReference - lazy loading
		System.out.println("==============================================");
		p = session.getReference(Person.class, 1);
		System.out.println("Fetching Not Yet Started");
		System.out.println(p);
				
		//When Id doesn't exists load will throw exception only when the query is executed
		p = session.getReference(Person.class, 100);
		System.out.println("Fetching Not Yet Started");
		try {
				System.out.println(p);
		}
		catch(Exception e) {
				System.out.println(e.getMessage());
		}
		
		session.close();
		sessionFactory.close();
	}
}
