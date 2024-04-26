package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		addProd();
	}
	
	//add product
	static void addProd() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
		Session session=sf.openSession();
		session.beginTransaction();
		
		Product p=new Product();
		p.setName("Laptop");
		p.setCompany("Asus");
		p.setPrice(78000);
		
		session.save(p);
		session.getTransaction().commit();
		session.close();
		
	}
	

}






