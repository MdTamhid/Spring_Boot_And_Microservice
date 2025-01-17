package com.tm.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tm.entity.*;
import com.tm.service.IEmployeeMgmtService;
import com.tm.validation.EmployeeValidator;



@Controller
public class EmployeeOperationsConteroller {

	@Autowired
    private IEmployeeMgmtService empService;
	
	@Autowired
	EmployeeValidator empValidator;

	@GetMapping("/")
	public String showHomePage() {

		return "welcome";
	}

	@GetMapping("/report")
	public String fetchAllEmployee(Map<String, Object> map) {
		System.out.println("EmployeeOperationsController.fetchAllEmployee()");
		Iterable<Employee> it = empService.showAllEmployee();
		map.put("empList", it);
		return "show_report";
	}

	@GetMapping("/register")
	public String showRegisterFormPage(@ModelAttribute("emp") Employee emp) {

		return "emp_registration_form";
	}

	// Double-POSTING Problem occurred here
	/*@PostMapping("/register")
	public String registerEmployee(Map<String, Object> map, @ModelAttribute("emp") Employee emp) {
		String resultMsg = empService.registerEmployee(emp);
		Iterable<Employee> it = empService.showAllEmployee();
		map.put("empList", it);
		map.put("resultMsg", resultMsg);
		return "show_report";
	}*/

	/*@PostMapping("/register")
	public String registerEmployee(Map<String, Object> map, @ModelAttribute("emp") Employee emp) {
		System.out.println("EmployeeOperationsController.registerEmployee()");
		String resultMsg = empService.registerEmployee(emp);
		map.put("resultMsg", resultMsg);
		return "redirect:report"; //PRG pattern support
	}*/

	// BEST SOLUTION
	// PRG pattern with Flash Attributes
	@PostMapping("/register")
	public String registerEmployee(RedirectAttributes map, @ModelAttribute("emp") Employee emp, BindingResult errors) {

		System.out.println("EmployeeOperationsController.registerEmployee()");

		//enable server side validation only if client side validation are not done
		/*if(emp.getCsvStatus().equalsIgnoreCase("disabled"))
		{*/
			// perform form validation
			if (empValidator.supports(emp.getClass()))
			{
				empValidator.validate(emp, errors);
				if (errors.hasErrors())
					return "emp_registration_form";
			}
		//}
		
		String resultMsg = empService.registerEmployee(emp);
		map.addFlashAttribute("resultMsg", resultMsg);
		return "redirect:report"; // PRG pattern support
	}

	/*//PRG pattern with Browser Scope/client scope using session attribute
		@PostMapping("/register")
		public String registerEmployee(HttpSession session, @ModelAttribute("emp") Employee emp) {
			System.out.println("EmployeeOperationsController.registerEmployee()");
			String resultMsg = empService.registerEmployee(emp);
			session.setAttribute("resultMsg", resultMsg);
			return "redirect:report"; //PRG pattern support
		}*/

	@GetMapping("/edit")
	public String showEditForm(@RequestParam("id") Integer id, @ModelAttribute("emp") Employee emp) {
		Employee employee = empService.fetchEmployeeById(id);
		// Copy employee obj data to emp.
		BeanUtils.copyProperties(employee, emp);
		return "employee_edit_form";
	}

	@PostMapping("/edit")
	public String editEmployee(@ModelAttribute("emp") Employee emp, RedirectAttributes redirect,
			BindingResult errors) {

		//enable server side validation only if client side validation are not done
		if(emp.getCsvStatus().equalsIgnoreCase("disabled"))
		{
			// perform form validation
			if (empValidator.supports(emp.getClass())) {
				empValidator.validate(emp, errors);
				if (errors.hasErrors())
					return "emp_registration_form";
			}
		}
		
		String resultMsg = empService.updateEmployee(emp);
		redirect.addFlashAttribute("resultMsg", resultMsg);
		return "redirect:report";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") Integer id, RedirectAttributes redirect) {

		String resultMsg = empService.deleteEmployeeById(id);
		redirect.addFlashAttribute("resultMsg", resultMsg);
		return "redirect:report";
	}
	
}

