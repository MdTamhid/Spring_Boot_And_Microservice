package com.tm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tm.entity.UserEntity;
import com.tm.service.IUserMgmtService;
import com.tm.validation.UserValidetor;

@Controller
public class UserController {
	
	@Autowired
	private IUserMgmtService userService;
	
	@Autowired
	UserValidetor empValidator;

	
	@GetMapping("/register") // for form launching
	public String showRigesterHomePage(@ModelAttribute("emp")UserEntity emp)
	{
		
		return "user_register_page";
	}
	
	
	@PostMapping("/save") // for form submition
	public String registerEmployee(RedirectAttributes map,@ModelAttribute("emp")UserEntity emp,
			                       BindingResult errors) {
		
		if (empValidator.supports(emp.getClass()))
		{
			empValidator.validate(emp, errors);
			if (errors.hasErrors())
				return "show_report";
		}
		String resultMsg = userService.registerUser(emp);
		map.addFlashAttribute("resultMsg", resultMsg);
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
