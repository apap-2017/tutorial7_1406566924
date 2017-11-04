package com.tutorial7.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.tutorial7.model.CourseModel;
import com.tutorial7.model.StudentModel;

@Mapper
public interface CourseMapper {
	@Select("SELECT id_course, name, credits FROM course WHERE id_course = #{idCourse}") 
	@Results(value = {
	         @Result(property = "idCourse", column = "id_course"),
	         @Result(property = "name", column = "name"),
	         @Result(property = "credits", column = "credits"),
	         @Result(property = "students", column = "id_course", javaType = List.class, many = @Many(select = "selectStudents")) 
	         })
	CourseModel selectCourse(@Param("idCourse") String idCourse);
	
	@Select("SELECT student.npm, name, gpa FROM student join studentcourse on student.npm = studentcourse.npm WHERE studentcourse.id_course = #{id_course}")
	List<StudentModel> selectStudents(@Param("id_course") String idCourse);
}
