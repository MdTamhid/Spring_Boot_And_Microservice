package com.tm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tm.model.Student;
import com.tm.serviec.IStudentServiceIMpl;

import jakarta.validation.Valid;


@RestController
@RequestMapping("student-api")
public class StudentController {

	@Autowired
	private IStudentServiceIMpl stuService;

	// save operation
	@PostMapping("save")
	public ResponseEntity<Object> saveStudentData(@Valid @RequestBody Student stu) {

		try {
			// suing service
			String saveStudent = stuService.saveStudent(stu);
			return new ResponseEntity<Object>(saveStudent, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// find all operations
	@GetMapping("/all")
	public ResponseEntity<Object> findAllStudent() {

		try {
			// using service
			List<Student> list = stuService.getAllStudetnData();
			return new ResponseEntity<Object>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// find by id
	@GetMapping("/find/{id}")
	public ResponseEntity<Object> findStudentById(@PathVariable("id") Integer id) {

		try {
			// using service
			String byId = stuService.getStudentById(id);
			return new ResponseEntity<Object>(byId, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// delete student by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteStudentById(@PathVariable("id") Integer id) {

		try {
			// using service
			String delete = stuService.deleteStudentById(id);
			return new ResponseEntity<Object>(delete, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
