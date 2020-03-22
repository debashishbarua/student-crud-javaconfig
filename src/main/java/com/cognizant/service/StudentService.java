package com.cognizant.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.config.AppConfig;
import com.cognizant.dao.StudentDao;
import com.cognizant.dao.StudentDaoImpl;
import com.cognizant.model.Student;

public class StudentService {	
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		StudentDao studentDao = ctx.getBean(StudentDaoImpl.class, "studentDao");
		String result = studentDao.create(new Student(15L, "Ajay", "Abc@gmail.com", "9677222265"));
		System.out.println(result);		
		studentDao.findAll().forEach(System.out::println);
	}
}
