package org.pritam.hibernate.topic17;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;


public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("org/pritam/hibernate/topic17/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		JpaCriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
		JpaRoot<Student> root = criteriaQuery.from(Student.class);
		
		session.close();
		sessionFactory.close();
	}
}
