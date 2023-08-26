package com.student.login.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student.login.entity.Student;
import com.student.login.repository.StudentRepo;

@Controller
@ResponseBody
@CrossOrigin("*")
public class DemoController {
    
	@Autowired
	private StudentRepo sturepo;
	
	@PostMapping("messege")
	public void setMessege(@RequestBody Student s)
	{
		System.out.println(s);
	     
		sturepo.save(s);
		
	}
	
	@GetMapping("get")
	public List<Student> getMessege()
	{
		
		List<Student> list = sturepo.findAll();
		
		return list;
	}
}
