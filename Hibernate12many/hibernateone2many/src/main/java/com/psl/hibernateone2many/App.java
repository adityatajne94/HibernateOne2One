package com.psl.hibernateone2many;

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
		
		Answers answers = new Answers();
		answers.setAnswername("java is programming language");
		answers.setPostedBy("Aditya");
		
		Answers answers2 =  new Answers();
		answers2.setAnswername("Java is robust");
		answers2.setPostedBy("Devyani");
		
		
		Question question = new Question();
		question.setQuestion("What is Java");
		
		List<Answers> list = new ArrayList<Answers>();
		list.add(answers);
		list.add(answers2);
		
		question.setAnswerlist(list);
		
		session.persist(question);
		
		transaction.commit();
		
		session.close();
    }
}
