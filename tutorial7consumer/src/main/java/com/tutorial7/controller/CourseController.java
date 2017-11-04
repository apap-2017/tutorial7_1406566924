package com.tutorial7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tutorial7.model.CourseModel;
import com.tutorial7.service.CourseService;

@Controller
public class CourseController {
	@Autowired
	CourseService courseDAO;
	
	@RequestMapping("/course/view")
	public String view(@RequestParam(value = "idCourse", required = false) String idCourse, Model model) {
		CourseModel course = courseDAO.selectCourse(idCourse);

		if (course != null) {
			model.addAttribute("course", course);
			return "view-course";
		} else {
			model.addAttribute("idCourse", idCourse);
			return "not-found-course";
		}
	}
	
	@RequestMapping("/course/view/{id}")
	public String viewPath(@PathVariable(value="id") String idCourse, Model model) {
		CourseModel course = courseDAO.selectCourse(idCourse);

		if (course != null) {
			model.addAttribute("course", course);
			return "view-course";
		} else {
			model.addAttribute("idCourse", idCourse);
			return "not-found-course";
		}
	}

}
