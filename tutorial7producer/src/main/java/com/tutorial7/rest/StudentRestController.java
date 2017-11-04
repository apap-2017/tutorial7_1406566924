package com.tutorial7.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial7.model.StudentModel;
import com.tutorial7.service.StudentService;

@RestController 
@RequestMapping("/rest")
public class StudentRestController {
	@Autowired
	StudentService studentDAO;
	
	@RequestMapping("/student/view/{npm}")
	public StudentModel view (@PathVariable(value = "npm" ) String npm)  {
		StudentModel student = studentDAO.selectStudent(npm);
		return student;
	}
}