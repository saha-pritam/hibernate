package org.pritam.hibernate.topic12;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("org/pritam/hibernate/topic12/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Student s1 = new Student("Agniva");
		Student s2 = new Student("Nilesh");
		Student s3 = new Student("Shitij");
		Student s4 = new Student("Agradip");
		
		Teacher t1 = new Teacher("Pritam Saha");
		Teacher t2 = new Teacher("Amalesh Pradhan");
		Teacher t3 = new Teacher("Hawk");
		
		t1.getStudents().add(s1);
		t1.getStudents().add(s2);
		t1.getStudents().add(s3);
		t1.getStudents().add(s4);
		
		t2.getStudents().add(s1);
		t2.getStudents().add(s2);
		t2.getStudents().add(s3);
		
		t3.getStudents().add(s2);
		t3.getStudents().add(s3);
				
		//Saving Data
		session.beginTransaction();
		session.persist(s1);
		session.persist(s2);
		session.persist(s3);
		session.persist(s4);
		session.persist(t1);
		session.persist(t2);
		session.persist(t3);
		session.getTransaction().commit();
	
		//Clearing First Level Cache
		session.clear();
		
		//Fetching
		System.out.println(session.get(Teacher.class, 1));
		System.out.println(session.get(Teacher.class, 2));
		System.out.println(session.get(Teacher.class, 3));
		
		session.close();
		sessionFactory.close();
	}
}
