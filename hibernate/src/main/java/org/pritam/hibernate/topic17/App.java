package org.pritam.hibernate.topic17;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;

import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Selection;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("org/pritam/hibernate/topic17/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		JpaCriteriaQuery<Double> criteriaQuery = criteriaBuilder.createQuery(Double.class);
		JpaRoot<Student> root = criteriaQuery.from(Student.class);
			
		criteriaQuery.select((Selection)criteriaBuilder.avg((Expression)root.get("mark")));
		Query<Double> query = session.createQuery(criteriaQuery);
		System.out.println("Avg of all marks :- "+query.uniqueResult());
			
		session.close();
		sessionFactory.close();
	}
}
