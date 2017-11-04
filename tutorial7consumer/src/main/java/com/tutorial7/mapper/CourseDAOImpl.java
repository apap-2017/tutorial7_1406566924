package com.tutorial7.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tutorial7.model.CourseModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Primary
public class CourseDAOImpl implements CourseDAO {
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public CourseModel selectCourse(String id) {
		log.info("REST - select course with id {}", id);
		CourseModel course = restTemplate.getForObject("http://localhost:8080/rest/course/view/"+id, CourseModel.class);
		return course;
	}

	@Override
	public List<CourseModel> selectAllCourses() {
		log.info("REST - select all courses");
		List<CourseModel> courses = restTemplate.getForObject("http://localhost:8080/rest/course/viewall", List.class);
		return courses;
	}

}
