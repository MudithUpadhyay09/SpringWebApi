package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class WebApiController1 {
	
	@Autowired
	public EmployeeService employeeService;
	@ResponseBody
	
	@RequestMapping("/")
	public ModelAndView indexpage(Model model){
		return employeeService.getEmployee();
	}

	@RequestMapping("/new")
	public ModelAndView newformemployee(Model model) {
		Employee employee = new Employee();
		return employeeService.addEmployee(employee);
		
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView editById(@PathVariable("id")int id) {
		return employeeService.editEmployeeById(id);
		
	}
	
	@RequestMapping(value="add")
	public String Employee( Employee employee) {
		employeeService.updateEmployee(employee); 
		return "The Details You Provided is Updated";
		
	}

	@RequestMapping("/delete/{id}")
	public String deleteemp(@PathVariable("id")int id) {
		employeeService.delete(id);
		return "The Id Which You Provided Is Deleted";
	}
}
