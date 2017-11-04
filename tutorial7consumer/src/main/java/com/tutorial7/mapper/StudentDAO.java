package com.tutorial7.mapper;

import java.util.List;

import com.tutorial7.model.StudentModel;

public interface StudentDAO {
	StudentModel selectStudent(String npm);           
	List<StudentModel> selectAllStudents();
}
