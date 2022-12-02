package com.example.demo.ServiceImplementaion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Repo.StudentRepo;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImplementation implements StudentService{
	
	@Autowired
	StudentRepo studentrepo;

	@Override
	public Student registerStudent(Student student) {
		
		try
		{
			Student st=new Student();
			  st.setEmail(student.getEmail());
			  st.setName(student.getName());
			  st.setPhone_no(student.getPhone_no());
			  Student savedstud=studentrepo.save(st);
			  return savedstud;
			  
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Student updateStudent( Student student) {
		
		try
		{
			Student presentStudent=this.studentrepo.findById(student.getId()).orElseGet(null);
			presentStudent.setId(student.getId());
			presentStudent.setEmail(student.getEmail());
			presentStudent.setName(student.getName());
			presentStudent.setPhone_no(student.getPhone_no());
			
			Student Updated=this.studentrepo.save(presentStudent);
			return Updated;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String deleteStudent(int id) {
		
		try
		{
			Student st=this.studentrepo.findById(id).orElseThrow(null);
			this.studentrepo.delete(st);
			return "Student Deleted Successfully";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "Something Went Wrong";
		}
	}

	@Override
	public List<Student> getAllStudent() {
		
		try
		{
			List<Student> list=this.studentrepo.findAll();
			return list;
		}
		catch (Exception w)
		{
			w.printStackTrace();
			return  null;
		}
	}

}
