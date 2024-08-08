package com.tm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tm.entity.UserEntity;
import com.tm.service.IUserMgmtService;

@Controller
public class UserController {
	
	@Autowired
	private IUserMgmtService userService;
	
	
	@GetMapping("/register") // for form launching
	public String showRigesterHomePage(@ModelAttribute("user")UserEntity user)
	{
		
		return "user_register_page";
	}
	
	
	@PostMapping("/save") // for form submition
	public String registerEmployee(@ModelAttribute("user")UserEntity user,
			                       Map<String, Object>map) {
		// use service
		String msg = userService.registerUser(user);
	 Iterable<UserEntity> list = userService.showAllUser();
		map.put("userList", list);
		map.put("resultMsg", msg);
		// return LVN
		return "show_report";
	}
	
	@GetMapping("/report")
	public String fetchAllEmployees(Map<String, Object>map)
	{ 
		// use service
		Iterable<UserEntity>it=userService.showAllUser();
		// keep the result in model attributes
		map.put("userList", it);
		// return LVN
		return "show_report";
	}
}
