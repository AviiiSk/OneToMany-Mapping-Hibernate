package com.mapping.example;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainMap {

	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		
		// creating question 
		
		Question q1 = new Question();
		q1.setQuestionId(101);
		q1.setQuestion("What is JAVA ?");
		
		// creating Answer
		
		Answer answer1 = new Answer();
		answer1.setAnswerId(344);
		answer1.setAnswer("JAVA is programming language");
        answer1.setQuestion(q1);
       
        Answer answer2 = new Answer();
		answer2.setAnswerId(343);
		answer2.setAnswer("With the help of we can create Software");
        answer2.setQuestion(q1);
       
        Answer answer3 = new Answer();
      	answer3.setAnswerId(342);
      	answer3.setAnswer("Java has different types of frameworks");
        answer3.setQuestion(q1);
             
		List<Answer> list = new ArrayList<Answer>();
        list.add(answer1);
        list.add(answer2);
        list.add(answer3);
        
        q1.setAnswer(list);
        
	
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		s.save(q1);
		s.save(answer1);
		s.save(answer2);
		s.save(answer3);
		
		
		tx.commit();
		s.close();
		factory.close();
		
		
		
	}

}
