package com.dao;


import java.util.List;

import com.model.Student;

public interface StudentDao {

	int saveStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(int id);
	Student getStudent(int id);
	List<Student> getAllStudent();
}
