package com.hibernate.Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Teacher;
import com.hibernate.entity.TeacherDetails;

public class InsertTeacherAndTeacherDetails {
	public static void main(String [] args) {
		
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
					// create the objects
					Teacher teacher=new Teacher("Vikas","Jaiswal","vikas@org.com");
					Teacher t2=new Teacher("Anushka","Jaiswal","Anusjka@org.com");
					Teacher t3=new Teacher("Anmol","Jaiswal","Anmol@.org.com");
					
					TeacherDetails teacherDetails=new TeacherDetails("Mumbai","Music");
					TeacherDetails td2=new TeacherDetails("Haryana","Dancing");
					TeacherDetails td3=new TeacherDetails("Dewas","Teaching");
					
					teacher.setTeacherDetails(teacherDetails);
					t2.setTeacherDetails(td2);
					t3.setTeacherDetails(td3);
					
					//start transection
					session.beginTransaction();
					
					//save the teacher
					System.out.println("Saving the teacher..."+teacher);
					session.save(teacher);
					session.save(t2);
					session.save(t3);
					
					//commit the transecion
					session.getTransaction().commit();
				
				}finally {
					session.close();
					factory.close();
					
				}
	}
}
