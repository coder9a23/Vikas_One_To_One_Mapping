package com.hibernate.Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Teacher;
import com.hibernate.entity.TeacherDetails;

public class InsertDataIntoCourse {
	
	public static void main(String args[] ) {
		//create sessioin factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(TeacherDetails.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
//create session
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Teacher teacher=session.get(Teacher.class, 2);
			
			Course course1=new Course("HTML");
			Course course2=new Course("Python");
			
			//add course to Teacher(teacher)
			teacher.add(course1);
			teacher.add(course2);
			
			//save the courses
			session.save(course1);
			session.save(course2);
			
			session.beginTransaction().commit();
			
			System.out.println("Complited successfully...");
			
		}finally {
			//add the clean up code
			session.close();
			factory.close();
		}
	}
}
