package org.pritam.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        /*Use the below setup if configuration is available in default location and 
    	also the name of the configuration file is kept default.*/
    	SessionFactory sessionFactory1 = new Configuration().configure().buildSessionFactory();
        System.out.println("Connection1 Established");
        System.out.println("Session Factory 1 :- "+sessionFactory1);
        sessionFactory1.close();
        System.out.println("Connection1 Closed");
        
        /*Use the below setup if configuration is kept in a different location other than default
        and also the name of the configuration file is not as the default one.*/
    	SessionFactory sessionFactory2 = new Configuration().configure("org/pritam/hibernate/hibernate_configuration.xml").buildSessionFactory();
        System.out.println("Connection2 Established");
        System.out.println("Session Factory 2 :- "+sessionFactory2);
        sessionFactory2.close();
        System.out.println("Connection2 Closed");
    }
}
