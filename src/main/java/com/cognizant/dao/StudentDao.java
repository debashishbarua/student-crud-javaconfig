package com.cognizant.dao;

import java.util.List;

import com.cognizant.model.Student;

public interface StudentDao {
	
	public String create(Student customer);
	
	public List<Student> findAll();
	
	public List<Student> findByName(String name);
}
