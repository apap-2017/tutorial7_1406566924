package com.tutorial7.service;

import java.util.List;

import com.tutorial7.model.CourseModel;

public interface CourseService {
	CourseModel selectCourse(String idCourse);
	List<CourseModel> selectAllCourses();
}
