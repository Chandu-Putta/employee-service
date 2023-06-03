package com.example.employeeservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeRepository repository;
	
	@PostMapping
    public Employee add(@RequestBody Employee e) {
		log.info("Adding Employee: " + e);
    	return repository.add(e);
    }
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable Long id) {
		log.info("Finding Employee by ID: " + id);
		return repository.findById(id);
	}
	
	@GetMapping("/findAllEmp")
	public List<Employee> findAllEmployees() {
		log.info("Finding All Employees: ");
		return repository.findAll();
	}
	
	@GetMapping("/department/{deptId}")
	public List<Employee> findEmpListByDeptId(@PathVariable Long deptId) {
		log.info("Finding Employee by Dept Id: " + deptId);
		return repository.findByDept(deptId);
	}

}
