package com.example.demo.service;

import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Employee;

public interface EmployeeService {

	public ModelAndView getEmployee();

	public ModelAndView addEmployee(Employee employee);

	public ModelAndView editEmployeeById(int id);

	public void delete(int id);
	
	public void updateEmployee(Employee employee);



	

	
}
