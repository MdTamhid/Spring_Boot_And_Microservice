package com.tm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.entity.UserEntity;
import com.tm.repository.UserRepositry;

@Service
public class UserServiceImpl implements IUserMgmtService {

	@Autowired
	private UserRepositry userRepo;
	
	
	@Override
	public Iterable<UserEntity> showAllUser() {
		
		return userRepo.findAll();
	}

	@Override
	public String registerUser(UserEntity emp) {
	
		Integer id = userRepo.save(emp).getId();
		return "User record insreted with user id : "+id;
	}

}
