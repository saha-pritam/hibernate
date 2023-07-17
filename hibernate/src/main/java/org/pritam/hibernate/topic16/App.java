package org.pritam.hibernate.topic16;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("org/pritam/hibernate/topic16/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Student s1 = new Student("Agniva");
		Student s2 = new Student("Agradip");
		Student s3 = new Student("Nilesh");
		Student s4 = new Student("Shitij");
		Student s5 = new Student("Sudipta");
		Student s6 = new Student("Sushmita");
		Student s7 = new Student("Ankan");
		Student s8 = new Student("Anirban");
		Student s9 = new Student("Rajdip");
		Student s10 = new Student("Roshni");
		Student s11 = new Student("Pratyush");
		Student s12 = new Student("Arpan");
		System.out.println(session.contains(s1));
		
		//Saving some data in db
		session.beginTransaction();
		session.persist(s1);
		session.persist(s2);
		session.persist(s3);
		session.persist(s4);
		session.persist(s5);
		session.persist(s6);
		session.persist(s7);
		session.persist(s8);
		session.persist(s9);
		session.persist(s10);
		session.persist(s11);
		session.persist(s12);
		session.getTransaction().commit();
		
		String query = "from Student where sid=2";
		Query q = session.createQuery(query,Student.class);
		Student student = (Student) q.uniqueResult();
		System.out.println("Student :- "+student);
		
		query = "from Student where sid=200";
		q = session.createQuery(query,Student.class);
		student = (Student) q.uniqueResult();
		System.out.println("Student :- "+student);
		
		session.close();
		sessionFactory.close();
	}
}
