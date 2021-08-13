package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Employee;
import com.example.demo.repository.WebapiRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired WebapiRepository repo;

	@Override
	public ModelAndView getEmployee() {

		ModelAndView abc = new ModelAndView("index");
		List<Employee> emp=(List<Employee>) repo.findAll();
		abc.addObject("emplist", emp);
		return abc;
	}
	
	@Override
	public ModelAndView addEmployee(Employee employee) {
		ModelAndView abc= new ModelAndView("new_emp");
		abc.addObject("employee",employee);
		return abc;
	}
	
	
	@Override
	public ModelAndView editEmployeeById(int id) {
		ModelAndView abc=new ModelAndView("edit_emp");
		Employee emp= repo.findById(id).orElse(null);
		abc.addObject("employee", emp);
		return abc;
	}
	
	@Override
	public void updateEmployee(Employee employee) {
	 repo.save(employee);
	}
	
	
	@Override
	public void delete(int id) {
		repo.deleteById(id);
		
	}
}
	

	


	
	
	
	
	
	
//	{
//		
//		ModelAndView abc = new ModelAndView("index");
//		List<Employee> emp=(List<Employee>) repo.findAll();
//		abc.addObject("emplist", emp);
//		return abc;
//		  
//	}
//
//	
//	@RequestMapping("/new")
//	public ModelAndView newformemployee(Model model)
//	{
//		ModelAndView ab = new ModelAndView("new_emp");
//		Employee emp=new Employee();
//		repo.save(emp);
//		ab.addObject("employee",emp);
//		return  ab;
//	
//	}
//	
//	@RequestMapping(value="add")
//	public String addemployee(Employee emp)
//	{
//		repo.save(emp);
//		return "Data Updated For Employee";
//	}
//	
//	@RequestMapping("/edit/{id}")
//	public ModelAndView EditById(@PathVariable("id")int id)
//	{
//		ModelAndView abc=new ModelAndView("edit_emp");
//		Employee emp= repo.findById(id).orElse(null);
//		abc.addObject("employee", emp);
//		return abc;
//	}
//	
//	@RequestMapping("/delete/{id}")
//	public String deleteemp(@PathVariable("id")int id)
//	{
//		repo.deleteById(id);
//		return "The Id Which You Provided Is Deleted";
//	}
//

