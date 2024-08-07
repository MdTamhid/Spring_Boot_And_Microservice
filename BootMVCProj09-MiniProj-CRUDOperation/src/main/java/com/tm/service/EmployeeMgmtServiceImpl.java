package com.tm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.tm.entity.Emplyee;
import com.tm.repository.IEmployeeRepository;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	public Iterable<Emplyee> showAllEmployees() {
		
		return employeeRepository.findAll();
	}
	
	@Override
	public String registerEmployee(Emplyee emp) {
		
		int ival = employeeRepository.save(emp).getEmpno();
		
		return "Employee record insreted with employee id : "+ival;
	}

	@Override
	public Emplyee fetchEmployeeById(int id) {
		
		return  employeeRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid number"));
	}
	
	@Override
	public String modifyEmployee(Emplyee emp) {
		
		Optional<Emplyee> byId = employeeRepository.findById(emp.getEmpno());
		if(byId.isPresent())
		{
		   employeeRepository.save(emp);
		   return emp.getEmpno()+ " is updated!";
		}
		
		return emp.getEmpno()+"is not found for updatation!!";
	}

	@Override
	public String deleteEmployeeById(int id) {
		
		Optional<Emplyee> byId = employeeRepository.findById(id);
		if(byId.isPresent())
		{
		   employeeRepository.deleteById(id);
		   return id+ " is deleted!";
		}
		
		return id+"is not found for deleteation!!";
	}
	
}
