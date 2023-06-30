package org.pritam.hibernate.topic9;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("org/pritam/hibernate/topic9/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
						
		Mobile mob1 = new Mobile("+191422613847");
		Mobile mob2 = new Mobile("+447909621886");
		Mobile mob3 = new Mobile("+995571013376");
		Mobile mob4 = new Mobile("+447769759897");
		Mobile mob5 = new Mobile("+151622554869");
		Mobile mob6 = new Mobile("+380974265121");
		
		Person person1 = new Person("Pritam Saha");
		person1.getNumbers().add(mob1);
		person1.getNumbers().add(mob2);
		person1.getNumbers().add(mob3);
		
		Person person2 = new Person("Aditya Ghosh");
		person2.getNumbers().add(mob4);
		person2.getNumbers().add(mob5);
		
		Person person3 = new Person("Soumi Saha");
		person3.getNumbers().add(mob6);
		
		//Saving Data
		session.beginTransaction();
		session.persist(person1);
		session.persist(person2);
		session.persist(person3);
		session.persist(mob1);
		session.persist(mob2);
		session.persist(mob3);
		session.persist(mob4);
		session.persist(mob5);
		session.persist(mob6);
		session.getTransaction().commit();
		
		//Clearing First Level Cache
		session.clear();
		
		//Fetching
		Person p1 = session.get(Person.class, 1);
		System.out.println("p1 = "+p1);
		
		session.close();
		sessionFactory.close();
	}
}
