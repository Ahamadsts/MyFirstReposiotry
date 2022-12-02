package com.example.demo.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	StudentRepo sr;
	
	@RequestMapping("save")
	public Student save(@RequestBody Student student)
	{
		try
		{
			sr.save(student);
			return student;
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("delete{id}")
	public String delete(@PathVariable int id)
	{
		try
		{
			sr.deleteById(id);
			return "Student Deleted Successfully";
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return "Something Went Wrong";
		}
	}
	
	@RequestMapping("viewAllUser")
	public List<Student> findAll()
	{
		try
		{
		List<Student> list = sr.findAll();
		return list;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping("findbyid{id}")
	public Student findbyid(@PathVariable int id)
	{
		try
		{
			Student student = sr.findById(id).get();
			return student;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
