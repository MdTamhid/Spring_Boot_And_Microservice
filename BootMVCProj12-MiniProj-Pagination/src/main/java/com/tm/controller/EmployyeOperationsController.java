package com.tm.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tm.entity.Emplyee;
import com.tm.service.IEmployeeMgmtService;

import jakarta.persistence.PostUpdate;

@Controller
public class EmployyeOperationsController {
	
	@Autowired
	private IEmployeeMgmtService empService;
	
	// load home page
	@GetMapping("/")
	public String showHomePage()
	{
		// return LVN
		return "welcome";
	}

	@GetMapping("/report")
	public String fetchAllEmployees(@PageableDefault(page=0,size=3,sort="job")
	                                 Pageable pagess,
			                         Map<String, Object>map)
	{ 
		// use service
		Page<Emplyee> page = empService.showEmployeesByPagination(pagess);
		// keep the result in model attributes
		map.put("pageInfo", page);
		// return LVN
		return "show_report";
	}
	
	@GetMapping("/register") // for form launching
	public String showRigesterHomePage(@ModelAttribute("emp")Emplyee emp)
	{
		// return LVN (form page for employee register)
		return "employee_register_from";
	}
	
	/*@PostMapping("/register") // for form submition
	public String registerEmployee(@ModelAttribute("emp")Emplyee emp,
			                       Map<String, Object>map) {
		// use service
		String msg = empService.registerEmployee(emp);
		Iterable<Emplyee> list = empService.showAllEmployees();
		map.put("empList", list);
		// keep result in share memory
		map.put("resultMsg", msg);
		// return LVN
		return "show_report";
	}*/
	
	@PostMapping("/register") // for form submition with PRG pattern
	public String registerEmployee(@ModelAttribute("emp")Emplyee emp,
			                       Map<String, Object>map) {
		// use service
		String msg = empService.registerEmployee(emp);
		// keep result in share memory
		map.put("resultMsg", msg);
		// return LVN
		return "redirect:report";
	}
	
	/*@PostMapping("/register") // for form submission with PRG pattern wiht flash attributes	
	public String registerEmployee(@ModelAttribute("emp")Emplyee emp,
			                       RedirectAttributes map) {
		// use service
		String msg = empService.registerEmployee(emp);
		// keep result in share memory
		map.addFlashAttribute("resultMsg", msg);
		// return LVN
		return "redirect:report";
	}*/	
	
	@GetMapping("/edit")
	public String showRegiesterFormPage(@RequestParam("id") int id, @ModelAttribute("emp") Emplyee emp)
	{
		// get emplyee record by submitting id
		Emplyee emp1=empService.fetchEmployeeById(id);
		// copy emp1 data to emp
		BeanUtils.copyProperties(emp1, emp);
		// return LVN(edit form page)
        return "employee_edit_form";
	}
	
	@PostMapping("/edit")
	public String modifyEmployee(@ModelAttribute("emp")Emplyee emp,
			                     RedirectAttributes attrs) {
		
		// use service
		String msg = empService.modifyEmployee(emp);
		// keep the result in flash attributes
		attrs.addFlashAttribute("resultMsg",msg);
		// return LVN
		return "redirect:report";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") int id,
			                     RedirectAttributes attrs) {
		
		// use service
		String msg = empService.deleteEmployeeById(id);
		// keep the result in flash attributes
		attrs.addFlashAttribute("resultMsg",msg);
		// return LVN
		return "redirect:report";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
