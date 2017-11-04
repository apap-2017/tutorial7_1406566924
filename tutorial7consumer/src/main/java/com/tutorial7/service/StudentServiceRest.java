package com.tutorial7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.tutorial7.mapper.StudentDAO;
import com.tutorial7.model.StudentModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Primary
public class StudentServiceRest implements StudentService {
	@Autowired
	private StudentDAO studentDAO;

	@Override
	public StudentModel selectStudent(String npm) {
		log.info("select student with npm {}", npm);
		return studentDAO.selectStudent(npm);
	}

	@Override
	public List<StudentModel> selectAllStudents() {
		log.info("select all students");
		return studentDAO.selectAllStudents();
	}

	@Override
	public void addStudent(StudentModel student) {
		
	}

	@Override
	public void deleteStudent(String npm) {
		
	}

	@Override
	public void updateStudent(StudentModel student) {
		
	}
}