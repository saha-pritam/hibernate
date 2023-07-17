package org.pritam.hibernate.topic15;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("org/pritam/hibernate/topic15/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//Transient State
		Student s1 = new Student("Agniva");
		System.out.println(session.contains(s1));
		
		//Persistent State
		session.beginTransaction();
		session.persist(s1);
		s1.setName("Pritam");
		session.getTransaction().commit();
		System.out.println(session.contains(s1));
		
		//Detached State
		session.close();
		try {
		System.out.println(session.contains(s1));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		session = sessionFactory.openSession();
		
		//Removed State
		Student student = session.get(Student.class, 1);
		session.beginTransaction();
		session.remove(student);
		session.getTransaction().commit();
		System.out.println(session.contains(s1));
		
		session.close();
		sessionFactory.close();
	}
}
