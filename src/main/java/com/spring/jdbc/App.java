package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dao.StudentConfig;
import com.dao.StudentDao;
import com.model.Student;

public class App {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);

		StudentDao bean = context.getBean("dao", StudentDao.class);
		
		
//		Student student = new Student("Marii", "mariigurav@gmail.com",23, "Civil Engg");
//		int ans = bean.saveStudent(student);
//		
//		System.out.println(ans+" student added.");
		
//		Student student=new Student();
//		student.setId(5);
//		student.setName("Maruti Gurav");
//		student.setAge(20);
//		student.setEmail("marutigurav88@gmail.com");
//		student.setDept("Mechanical engg");
//		
//		int update = bean.updateStudent(student);
//		System.out.println(update+" student updated.");
		
//		Student student = bean.getStudent(3);
//		System.out.println(student.getId());
//		System.out.println(student.getName());
//		System.out.println(student.getEmail());
//		System.out.println(student.getAge());
//		System.out.println(student.getDept());
		
		List<Student> allStudent = bean.getAllStudent();
		
		for (Student student : allStudent) {
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getEmail());
			System.out.println(student.getAge());
			System.out.println(student.getDept());
			
			System.out.println("=====================");
			
		}
	}
}
