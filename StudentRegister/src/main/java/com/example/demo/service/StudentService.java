package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService  {
	
	
	public Student registerStudent(Student student);
	
	public Student updateStudent(Student student);

	public String deleteStudent(int id);

	public List<Student> getAllStudent();
	
	


}
