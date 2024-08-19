package com.tm.serviec;

import java.util.List;

import com.tm.model.Student;

public interface IStudentServiceIMpl {
	
  // student save operations
	public String saveStudent(Student student);
	
	// find all operations
	public List<Student> getAllStudetnData();
	
	// find student by id
	public String getStudentById(Integer id);
	
	// delete student by id
	public String deleteStudentById(Integer id);
}
