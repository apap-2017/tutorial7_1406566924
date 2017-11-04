package com.tutorial7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial7.mapper.CourseMapper;
import com.tutorial7.model.CourseModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CourseServiceDatabase implements CourseService {
	@Autowired
	private CourseMapper courseMapper;

	@Override
	public CourseModel selectCourse(String idCourse) {
		log.info("select course with id {}", idCourse);
		return courseMapper.selectCourse(idCourse);
	}

	
}