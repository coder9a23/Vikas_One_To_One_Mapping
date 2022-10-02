package com.hibernate.Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Teacher;
import com.hibernate.entity.TeacherDetails;

public class DeleteData {
		
	public static void main(String args[]) {
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(TeacherDetails.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Course course=session.get(Course.class,3);
			if(course!=null) {
				System.out.println("Deleting"+course);
				
				session.delete(course);
				
			}
			
				session.beginTransaction().commit();
			}finally {
				session.close();
				factory.close();
		}
	}
}
