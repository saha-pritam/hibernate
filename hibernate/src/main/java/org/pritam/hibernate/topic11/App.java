package org.pritam.hibernate.topic11;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("org/pritam/hibernate/topic11/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
						
		Person person1 = new Person("Pritam Saha");
		Person person2 = new Person("Aditya Ghosh");
		Person person3 = new Person("Soumi Saha");
		
		Mobile mob1 = new Mobile("+191422613847");
		Mobile mob2 = new Mobile("+447909621886");
		Mobile mob3 = new Mobile("+995571013376");
		Mobile mob4 = new Mobile("+447769759897");
		Mobile mob5 = new Mobile("+151622554869");
		Mobile mob6 = new Mobile("+380974265121");
		
		mob1.setPerson(person1);
		mob2.setPerson(person1);
		mob3.setPerson(person1);
		mob4.setPerson(person2);
		mob5.setPerson(person2);
		mob6.setPerson(person3);
		
		person1.getNumbers().add(mob1);
		person1.getNumbers().add(mob2);
		person1.getNumbers().add(mob3);
		person2.getNumbers().add(mob4);
		person2.getNumbers().add(mob5);
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
		Mobile mobile = session.get(Mobile.class, "+447909621886");
		System.out.println("mobile = "+mobile);
		Person person = session.get(Person.class, 2);
		System.out.println("person = "+person);
		
		session.close();
		sessionFactory.close();
	}
}
