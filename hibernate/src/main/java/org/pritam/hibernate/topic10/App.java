package org.pritam.hibernate.topic10;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("org/pritam/hibernate/topic10/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
						
		Person person1 = new Person("Pritam Saha");
		Person person2 = new Person("Aditya Ghosh");
		Person person3 = new Person("Soumi Saha");
		
		Mobile mob1 = new Mobile("+191422613847");
		mob1.setPerson(person1);
		Mobile mob2 = new Mobile("+447909621886");
		mob2.setPerson(person1);
		Mobile mob3 = new Mobile("+995571013376");
		mob3.setPerson(person1);
		Mobile mob4 = new Mobile("+447769759897");
		mob4.setPerson(person2);
		Mobile mob5 = new Mobile("+151622554869");
		mob5.setPerson(person2);
		Mobile mob6 = new Mobile("+380974265121");
		mob6.setPerson(person3);
		

		
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
		Mobile mobile = session.get(Mobile.class, "+447909621886");
		System.out.println("mobile = "+mobile);
		
		session.close();
		sessionFactory.close();
	}
}
