//package com.example.demo.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.example.demo.model.Employee;
//import com.example.demo.repository.WebapiRepository;
//
//@RestController
//public class WebapiController {
//	
//	@Autowired
//	WebapiRepository repo;
//	
//	@RequestMapping("/")
//	@ResponseBody
//	public ModelAndView indexpage(Model model)
//	
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
//}
