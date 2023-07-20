package org.pritam.hibernate.topic18;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("org/pritam/hibernate/topic18/hibernate.cfg.xml").buildSessionFactory();
		Session session1 = sessionFactory.openSession();
		Student s = session1.get(Student.class, 1);
		System.out.println("Student 1 details :- "+s);
		System.out.println("Again trying to fetch student 1 details");
		s = session1.get(Student.class, 1); //No query to DB will be passed
		System.out.println("Student 1 details :- "+s);
		session1.close();
		
		
		Session session2 = sessionFactory.openSession();
		System.out.println("Again trying to fetch student 1 details after closing previous session");
		s = session2.get(Student.class, 1);
		System.out.println("Student 1 details :- "+s);//No Query to DB will be passed
		session2.close();
		sessionFactory.close();
		
	}
}
