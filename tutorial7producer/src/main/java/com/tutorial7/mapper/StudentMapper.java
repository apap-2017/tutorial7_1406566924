package com.tutorial7.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tutorial7.model.CourseModel;
import com.tutorial7.model.StudentModel;

@Mapper
public interface StudentMapper {
	@Select("SELECT npm, name, gpa FROM student WHERE npm = #{npm}") 
	@Results(value = {
	         @Result(property = "npm", column = "npm"),
	         @Result(property = "name", column = "name"),
	         @Result(property = "gpa", column = "gpa"),
	         @Result(property = "courses", column = "npm", javaType = List.class, many = @Many(select = "selectCourses")) 
	         })
	StudentModel selectStudent(@Param("npm") String npm);

/*	@Select("SELECT npm, name, gpa FROM student WHERE npm = #{npm}")
	StudentModel selectStudent(@Param("npm") String npm); */
	
	@Select("SELECT npm, name, gpa FROM student") 
	@Results(value = {
	         @Result(property = "npm", column = "npm"),
	         @Result(property = "name", column = "name"),
	         @Result(property = "gpa", column = "gpa"),
	         @Result(property = "courses", column = "npm", javaType = List.class, many = @Many(select = "selectCourses")) 
	         })
	List<StudentModel> selectAllStudents();
	
/*	@Select("SELECT npm, name, gpa FROM student")
	List<StudentModel> selectAllStudents(); */

	@Insert("INSERT INTO student (npm, name, gpa) VALUES (#{npm}, #{name}, #{gpa})")
	void addStudent(StudentModel student);

	@Delete("DELETE FROM student WHERE npm = #{npm}")
	void deleteStudent(@Param("npm") String npm);

	@Update("UPDATE student SET npm=#{npm}, name=#{name}, gpa=#{gpa} WHERE npm=#{npm}")
	void updateStudent(StudentModel student);

	@Select("SELECT course.id_course as idCourse, name, credits FROM studentcourse join course on studentcourse.id_course=course.id_course WHERE studentcourse.npm=#{npm}")
	@Results(value = {
			@Result(property = "idCourse", column = "idCourse"),
			@Result(property = "name", column = "name"),
			@Result(property = "credits", column = "credits")
	})
	List<CourseModel> selectCourses(@Param("npm") String npm);
}
