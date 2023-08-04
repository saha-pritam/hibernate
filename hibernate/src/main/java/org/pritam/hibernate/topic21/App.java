package org.pritam.hibernate.topic21;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("org/pritam/hibernate/topic21/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Person p1 = new Person("Pritam","Saha");
		Person p2 = new Person("Ashish","Saha");
		Person p3 = new Person("Aditya","Ghosh");
		Person p4 = new Person("Gunjan","Nath");
		
		session.beginTransaction();
		session.persist(p1);
		session.persist(p2);
		session.persist(p3);
		session.persist(p4);
		session.getTransaction().commit();
		
		session.clear();
		
		Query<Person> namedQuery = session.createNamedQuery("getById",Person.class);
		namedQuery.setParameter("param", 1);
		Person person1 = namedQuery.uniqueResult();
		System.out.println("Person 1 = "+person1);
		
		session.clear();
		
		namedQuery = session.createNamedQuery("getAll",Person.class);
		List<Person> list = namedQuery.list();
		for(Person person:list)
			System.out.println(person);
		
		session.close();
		sessionFactory.close();
	}
}
