package com.tutorial7.mapper;

import java.util.List;

import com.tutorial7.model.CourseModel;

public interface CourseDAO {
	CourseModel selectCourse(String id);           
	List<CourseModel> selectAllCourses();
}
