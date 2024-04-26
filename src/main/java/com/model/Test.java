package com.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class Test {

	public static void main(String[] args) {
//		addProd();
//		getAll();
//		update();
//		delete();
		
		hqlTest();
	}

	// add product
	static void addProd() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		Product p = new Product();
		p.setName("Laptop");
		p.setCompany("Asus");
		p.setPrice(78000);

		session.save(p);
		session.getTransaction().commit();
		session.close();

	}

	static void getAll() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		Criteria crt = session.createCriteria(Product.class);
//		crt.add(Restrictions.eq("company", "cg"));
//		crt.add(Restrictions.gt("price", 9000)); // greatet than
		crt.add(Restrictions.eq("price", 8000)); // equals to

		List<Product> list = crt.list();
		System.out.println(list);

	}

	static void update() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		Product p = (Product) session.get(Product.class, 1);
		p.setPrice(p.getPrice() + 5000);

		session.save(p);
		session.getTransaction().commit();
		session.close();
	}

	static void delete() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		Product p = (Product) session.get(Product.class, 4);
		session.delete(p);

		session.getTransaction().commit();
		session.close();

	}

	static void hqlTest() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		
		Query hql=session.createQuery("From Product");
		List<Product> list=hql.list();
		System.out.println(list);
		
	}
	
}





















