package com.psl.Hibernatemany2Many;

import java.util.ArrayList;
import java.util.List;

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
		
		
		UserDetails userDetails = new UserDetails();
		userDetails.setAddress("Pune");
		
		UserDetails userDetails2 = new UserDetails();
		userDetails2.setAddress("Mumbai");
		
		
		List<UserDetails> uList = new ArrayList<UserDetails>();
		uList.add(userDetails);
		uList.add(userDetails2);
		
		CarRental carRental = new CarRental();
		carRental.setCarNumber("MH 34 BJ 5532");
		
		CarRental carRental2 = new CarRental();
		carRental2.setCarNumber("Mh 34 BC 6754");
		
		List<CarRental> caList = new ArrayList<CarRental>();
		caList.add(carRental);
		caList.add(carRental2);
		
		userDetails.setCarRentals(caList);
		userDetails2.setCarRentals(caList);
		
		carRental.setUserDetails(uList);
		carRental2.setUserDetails(uList);
		
		session.save(userDetails);
		session.save(userDetails2);
		session.save(carRental);
		session.save(carRental2);
		transaction.commit();
		session.close();
		
    }
}
