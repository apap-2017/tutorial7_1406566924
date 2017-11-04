package com.tutorial7.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial7.model.CourseModel;
import com.tutorial7.service.CourseService;

@RestController 
@RequestMapping("/rest")
public class CourseRestController {
	@Autowired
	CourseService courseDAO;
	
	@RequestMapping("/course/view/{id}")
	public CourseModel view(@PathVariable(value = "id") String id)  {
		CourseModel course = courseDAO.selectCourse(id);
		return course;
	}
	
	@RequestMapping("/course/viewall")
	public List<CourseModel> viewall()  {
		List<CourseModel> courses = courseDAO.selectAllCourses();
		return courses;
	}
}