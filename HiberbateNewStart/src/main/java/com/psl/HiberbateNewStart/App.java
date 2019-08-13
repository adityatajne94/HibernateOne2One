package com.psl.HiberbateNewStart;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		
		
		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		
		Session session = sessionFactory.openSession();
		
		org.hibernate.Transaction transaction = session.beginTransaction();
	
		Employee employee = new Employee();
		employee.setFirstName("Aditya");
		employee.setLastName("tajane");
		employee.setGmail("adityatajne94@gmail.com");
		
		Address address = new Address();
		address.setCity("Pune");
		address.setState("MH");
		address.setCountry("India");
		address.setPinCode(411);
		
		employee.setAddress(address);
		address.setEmployee(employee);
		
		session.save(employee);
		
		transaction.commit();
		
		session.close();
	}

    }

