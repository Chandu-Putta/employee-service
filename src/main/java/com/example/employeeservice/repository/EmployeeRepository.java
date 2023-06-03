package com.example.employeeservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.employeeservice.model.Employee;


@Repository
public class EmployeeRepository {
	
    private List<Employee> employees = new ArrayList<>();
	
	public Employee add(Employee e) {
		employees.add(e);
		return e;
	}
	
	public Employee findById(Long id) {
		return employees.stream().filter(emp -> emp.id().equals(id))
				.findFirst().orElseThrow();
	}
	
	public List<Employee> findAll() {
		return employees;
	}
	
	public List<Employee> findByDept(Long deptId) {
		return employees.stream().filter(e -> e.deptId().equals(deptId))
				.toList();
	}

}
