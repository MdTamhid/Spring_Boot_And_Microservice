package com.tm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tm.entity.Emplyee;

public interface IEmployeeMgmtService {
	
	public Page<Emplyee> showEmployeesByPagination(Pageable pag);
	public String registerEmployee(Emplyee emp);
	public Emplyee fetchEmployeeById(int id);
	public String modifyEmployee(Emplyee emp);
	public String deleteEmployeeById(int id);
}
