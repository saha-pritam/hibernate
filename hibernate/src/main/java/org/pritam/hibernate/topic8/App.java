package org.pritam.hibernate.topic8;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("org/pritam/hibernate/topic8/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
						
		Aadhar a1 = new Aadhar("999941057058","Shivshankar Choudhury");
		Aadhar a2 = new Aadhar("999971658847","Kumar Agarwal");
		Aadhar a3 = new Aadhar("999933119405","Fatima Bedi");
		Aadhar a4 = new Aadhar("999955183433","Rohit Pandey");
		
		Pan p1 = new Pan("BAJPC4350M","Shivshankar Choudhury",a1);
		Pan p2 = new Pan("DAJPC4150P","Kumar Agarwal",a2);
		Pan p3 = new Pan("XGZFE7225A","Fatima Bedi",a3);
		Pan p4 = new Pan("CTUGE1616I","Rohit Pandey",a4);
		
		//Saving Data
		session.beginTransaction();
		session.persist(a1);
		session.persist(a2);
		session.persist(a3);
		session.persist(a4);
		session.persist(p1);
		session.persist(p2);
		session.persist(p3);
		session.persist(p4);
		session.getTransaction().commit();
		
		//Clearing First Level Cache
		session.clear();
		
		//Fetching
		Pan pan = session.get(Pan.class, "BAJPC4350M");
		System.out.println(pan);
		
		session.close();
		sessionFactory.close();
	}
}
