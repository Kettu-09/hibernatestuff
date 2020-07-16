package com.annotation.enity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientApp {

	public static void main(String[] args) {

		Student student = new Student();
		student.setId(01);
		student.setFirstName("Ketan");
		student.setLastName("Ingale");
		student.setAddress("Akola");

		Student student1 = new Student();
		student1.setId(02);
		student1.setFirstName("Rahul");
		student1.setLastName("Sharma");
		student1.setAddress("Pune");

		Library library = new Library();
		library.setDoj(new Date());
		library.setStudent(student);
		student.setLibrary(library);

		Library library1 = new Library();
		library1.setDoj(new Date());
		library1.setStudent(student1);
		student1.setLibrary(library1);

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		session.save(student);
		session.save(student1);
		transaction.commit();

		System.out.println("student save successfully");
		session.close();
	}

}
