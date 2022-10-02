package com.hibernate.Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Teacher;
import com.hibernate.entity.TeacherDetails;

public class RetriveData {
	
	public static void main(String[]args) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(TeacherDetails.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			session.beginTransaction();
			
			Teacher teacher=session.get(Teacher.class,2);
			System.out.println("Teacher "+teacher);
			
			//get course of Teacher(teacher)
			System.out.println("Courses "+teacher.getCourses());
			
			System.out.println("Complete succssfully...");
			session.beginTransaction().commit();
		}
		finally{
			session.close();
			factory.close();
		}
	}
}
