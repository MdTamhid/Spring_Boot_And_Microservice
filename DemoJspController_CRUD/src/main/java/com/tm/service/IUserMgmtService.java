package com.tm.service;

import com.tm.entity.UserEntity;

public interface IUserMgmtService {
	
	
	public Iterable<UserEntity> showAllUser();
	public String registerUser(UserEntity emp);
	
	/*public Emplyee fetchEmployeeById(int id);
	public String modifyEmployee(Emplyee emp);
	public String deleteEmployeeById(int id);*/

}
