package com.tm.service;

import java.util.Optional;

import com.tm.entity.Emplyee;

public interface IEmployeeMgmtService {
	
	public Iterable<Emplyee> showAllEmployees();
	public String registerEmployee(Emplyee emp);
	public Emplyee fetchEmployeeById(int id);
	public String modifyEmployee(Emplyee emp);
	public String deleteEmployeeById(int id);
}
