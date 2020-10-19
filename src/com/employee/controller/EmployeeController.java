package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	//inject Employee service
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employeelist")
	public String listEmployee(Model theModel) {
		
		//get the employees from employee Service 
		List<Employee> theEmployee = employeeService.getEmployees();
		
		//add the employees to the model
		theModel.addAttribute("employees", theEmployee);
		
		return "list-employee";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		Employee theEmployee = new Employee(); 
		
		//add the employees to the model
		theModel.addAttribute("employees", theEmployee);
		
		return "employee-form";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employees") Employee theEmployee) {
		
		//save the employee using our service
		employeeService.saveEmployee(theEmployee);
		
		return "redirect:/employee/employeelist";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int theId,Model theModel) {
		
		//get the employee from our service
		Employee theEmployee = employeeService.getEmployees(theId); 
		
		//set the employees as model attribute to prepopulate the form
		theModel.addAttribute("employees", theEmployee);
		
		//send over to our form
		
		return "employee-form";
	}
	
	@GetMapping("/showFormForDelete")
	public String showFormForDelete(@RequestParam("id") int theId) {
		
		//delete the employee 
		 employeeService.deleteEmployee(theId); 
		
		
		return "redirect:/employee/employeelist";
	}
	
}
