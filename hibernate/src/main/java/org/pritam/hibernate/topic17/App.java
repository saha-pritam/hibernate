package org.pritam.hibernate.topic17;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaCriteriaUpdate;
import org.hibernate.query.criteria.JpaRoot;

import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;

public class App {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("org/pritam/hibernate/topic17/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
		JpaCriteriaUpdate<Student> criteriaUpdateQuery = builder.createCriteriaUpdate(Student.class);
		Root<Student> root = criteriaUpdateQuery.from(Student.class);
		criteriaUpdateQuery.set("name", "Pritam Saha");
		criteriaUpdateQuery.where(builder.equal(root.get("id"), 2));
		
		session.beginTransaction();
		session.createQuery(criteriaUpdateQuery).executeUpdate();
		session.getTransaction().commit();
		
		session.close();
		sessionFactory.close();
	}
}
