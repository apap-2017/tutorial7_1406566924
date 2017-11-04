package com.tutorial7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.tutorial7.mapper.CourseDAO;
import com.tutorial7.model.CourseModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Primary
public class CourseServiceRest implements CourseService {
	@Autowired
	private CourseDAO courseDAO;

	@Override
	public CourseModel selectCourse(String id) {
		log.info("select course with npm {}", id);
		return courseDAO.selectCourse(id);
	}

	@Override
	public List<CourseModel> selectAllCourses() {
		log.info("select all students");
		return courseDAO.selectAllCourses();
	}

}