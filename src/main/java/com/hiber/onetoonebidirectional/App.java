package com.hiber.onetoonebidirectional;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Question q1 = new Question();
		q1.setQid(101);
		q1.setQuestion("What is Java?");
		Answer answer1 = new Answer();
		answer1.setQuestion(q1);
		answer1.setAnsId(234);
		answer1.setAnswer("Java is a programming language");
		q1.setAnswer(answer1);

		Question q2 = new Question();
		q2.setQid(102);
		q2.setQuestion("What is Hibernate?");
		Answer answer2 = new Answer();
		answer2.setAnsId(235);
		answer2.setQuestion(q2);
		answer2.setAnswer("Hibernate is a ORM tool");
		q2.setAnswer(answer2);

		Question q3 = new Question();
		q3.setQid(103);
		q3.setQuestion("What s SQL?");
		Answer answer3 = new Answer();
		answer3.setAnsId(236);
		answer3.setAnswer("SQL is a programming Database language");
		q3.setAnswer(answer3);
		answer3.setQuestion(q3);

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(q1);
		session.save(q2);
		session.save(q3);
		session.save(answer1);
		session.save(answer2);
		session.save(answer3);
		transaction.commit();
		session.close();
	}
}
