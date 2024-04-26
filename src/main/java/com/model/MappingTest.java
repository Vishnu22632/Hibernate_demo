package com.model;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class MappingTest {

	public static void main(String[] args) {
//		oneToOne();
//		manyToOne();
		manyToMany();

	}
	
	static void oneToOne() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		
		
		Address a=new Address();
		a.setCountry("Nepal");
		a.setCity("Janakpur");
		a.setState("Madesh Pradesh");
		
		session.save(a);
		
		Employee e=new Employee();
		e.setFname("Vishnu");
		e.setLname("Thakur");
		e.setAge(27);
		e.setSalary(25000);
		e.setAddress(a);
		
		session.save(e);
		
		session.getTransaction().commit();
		session.close();
		
	}

	
	static void manyToOne() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		
		
		Address a=new Address();
		a.setCountry("Nepal");
		a.setCity("Janakpur");
		a.setState("Madesh Pradesh");
		
		session.save(a);
		
		Employee e=new Employee();
		e.setFname("Vishnu");
		e.setLname("Thakur");
		e.setAge(27);
		e.setSalary(25000);
		e.setAddress(a);
		
		Phone p1=new Phone();
		p1.setNumber("9809692255");
		p1.setType("NCELL");
		p1.setEmployee(e);
		session.save(p1);
		
		Phone p2=new Phone();
		p2.setNumber("9706488965");
		p2.setType("NTC");
		p2.setEmployee(e);
		session.save(p2);
		
		e.setPhoneList(Arrays.asList(p1,p2));
		
		session.save(e);
		
		session.getTransaction().commit();
		session.close();
	}
	
	static void manyToMany() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		
		
		Address a=new Address();
		a.setCountry("Nepal");
		a.setCity("Janakpur");
		a.setState("Madesh Pradesh");
		
		session.save(a);
		
		Employee e=new Employee();
		e.setFname("Vishnu");
		e.setLname("Thakur");
		e.setAge(27);
		e.setSalary(25000);
		e.setAddress(a);
		
		Phone p1=new Phone();
		p1.setNumber("9809692255");
		p1.setType("NCELL");
		p1.setEmployee(e);
		session.save(p1);
		
		Phone p2=new Phone();
		p2.setNumber("9706488965");
		p2.setType("NTC");
		p2.setEmployee(e);
		session.save(p2);
		
		Department dept1=new Department();
		dept1.setDeptName("IT");
		dept1.setDeptHead("Vishnu");
		session.save(dept1);
		
		Department dept2=new Department();
		dept2.setDeptName("HR");
		dept2.setDeptHead("Roshan");
		session.save(dept2);
		
		e.setPhoneList(Arrays.asList(p1,p2));
		e.setDeptList(Arrays.asList(dept1,dept2));
		
		session.save(e);
		
		session.getTransaction().commit();
		session.close();
	}
}
