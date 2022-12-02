package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ServiceImplementaion.StudentServiceImplementation;
import com.example.demo.model.Student;

@RestController
public class MyController {
	
	@Autowired
	StudentServiceImplementation studentserviceimp;
	
	@RequestMapping("register")
	public String register(@RequestBody Student student)
	{
		try
		{
			Student st=this.studentserviceimp.registerStudent(student);
			return "Student Saved\n"+st;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "Something Went Wrong";
		}
		
	}
	
	@RequestMapping("delete{id}")
	public String delete(@PathVariable int id)
	{
		try
		{
			this.studentserviceimp.deleteStudent(id);
			return "Student Deleted Successfully";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "Something Went Wrong";
		}
	}
	
	@RequestMapping("update")
	public Student Update(@RequestBody Student student)
	{
		try
		{
			Student updatedStudent = this.studentserviceimp.updateStudent(student);
			return updatedStudent;
		}
		catch (Exception e)
		{
		e.printStackTrace();
		return null;
		}
	}
	
	@RequestMapping("Allstudent")
	public List<Student> ViewAllStudent()
	{
		try
		{
			List<Student> list = this.studentserviceimp.getAllStudent();
			return list;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
