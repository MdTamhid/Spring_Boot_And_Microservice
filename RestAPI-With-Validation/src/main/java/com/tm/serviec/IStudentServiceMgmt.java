package com.tm.serviec;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.model.Student;
import com.tm.reposotiory.IStudetn;

@Service
public class IStudentServiceMgmt implements IStudentServiceIMpl {

	@Autowired
	private IStudetn stuRepo;
	
	@Override
	public String saveStudent(Student student) {
		Integer stuId = stuRepo.save(student).getStuId();
		return "Student data saved into DB with this Id : "+stuId;
	}

	@Override
	public List<Student> getAllStudetnData() {
		List<Student> all = stuRepo.findAll();
		return all;
	}

	@Override
	public String getStudentById(Integer id) {
		
		Optional<Student> byId = stuRepo.findById(id);
		if(byId.isPresent()) {
			 Student student = byId.get();
			 return "Student data found by thid Id : "+student;
		}
		return "Invalid Id !! ";
	}

	@Override
	public String deleteStudentById(Integer id) {
		
		Optional<Student> byId = stuRepo.findById(id);
		if(byId.isPresent()) {
			Student student = byId.get();
			stuRepo.delete(student);
			return "Student deleted sucessfullt!!";
		}
		return "Student id not found for deleaion !! ";
	}

	
	
}
