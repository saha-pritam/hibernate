package org.pritam.hibernate.topic7;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("org/pritam/hibernate/topic7/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
				
		//Saving a data
		Point point1 = new Point(-3,5);
		Point point2 = new Point(4,5);
		Point point3 = new Point(4,2);
		Point point4 = new Point(-3,2);
		Rectangle rectangle = new Rectangle(point1,point2,point3,point4);
		rectangle.calcArea();
		rectangle.calcPerimeter();
		session.beginTransaction();
		session.persist(rectangle);
		session.getTransaction().commit();
		
		//Fetching 
		Rectangle r = session.get(Rectangle.class, 1);
		System.out.println(r);
		
		session.close();
		sessionFactory.close();
	}
}
