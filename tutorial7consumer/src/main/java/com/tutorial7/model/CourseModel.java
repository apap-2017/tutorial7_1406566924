package com.tutorial7.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseModel {
	private String idCourse;
	private String name;
	private int credits;
	private List<StudentModel> students;
}
