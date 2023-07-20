package org.pritam.hibernate.topic19;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("org/pritam/hibernate/topic19/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		Student student = new Student("John Deo", "Four", 75, "female");
		session.persist(student);
		session.getTransaction().commit();
		
		//Clearing first level cache
		session.clear();
		
		//Fetching
		Student s = session.get(Student.class, 1);
		System.out.println(s);
		
		session.close();
		sessionFactory.close();
		
	}
}
