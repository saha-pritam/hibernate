package org.pritam.hibernate.topic17;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaDelete;
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
		
		HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		JpaCriteriaDelete<Student> createCriteriaDelete = criteriaBuilder.createCriteriaDelete(Student.class);
		Root<Student> root = createCriteriaDelete.from(Student.class);
		
		createCriteriaDelete.where(criteriaBuilder.equal(root.get("id"), 2));
		session.beginTransaction();
		session.createQuery(createCriteriaDelete).executeUpdate();
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
