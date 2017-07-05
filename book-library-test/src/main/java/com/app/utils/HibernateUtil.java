package com.app.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.app.model.Book;

public class HibernateUtil {

	// Annotation based configuration
	private static SessionFactory sessionAnnotationFactory;

	private static SessionFactory buildSessionFactory(){
	   	try {
        	Configuration configuration = new Configuration();
        	configuration.configure("hibernate.cfg.xml");
        	
        	configuration.addAnnotatedClass(Book.class);
        	
        	System.out.println("Hibernate Annotation Configuration loaded");
        	
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
        			.applySettings(configuration.getProperties())
        			.build();
        	System.out.println("Hibernate Annotation serviceRegistry created");
        	
        	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	
            return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
	   	
	   	
	}
	public static SessionFactory getSessionFactory() {
		if(sessionAnnotationFactory == null)
			sessionAnnotationFactory = buildSessionFactory();
        return sessionAnnotationFactory;
    }
	
	public static void closeSessionFactory (){
		if(!sessionAnnotationFactory.isClosed())
			sessionAnnotationFactory.close();
	}
	
	
	
}
