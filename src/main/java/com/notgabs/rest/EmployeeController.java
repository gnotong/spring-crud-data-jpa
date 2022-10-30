package com.notgabs.rest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.notgabs.entity.Employee;
import com.notgabs.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> all() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{id}")
	public Optional<Employee> one(@PathVariable int id) {
		return employeeService.findById(id);
	}
	
	@PostMapping("/employees")
	public Employee create(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}
	
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}
	
	@DeleteMapping("/employees/{id}")
	public void delete(@PathVariable int id) {
		Optional<Employee> employee = employeeService.findById(id);
		if (employee.isEmpty()) {
			throw new NoSuchElementException("Employee not found id " + id);
		}
		employeeService.delete(employee.get());
	}
}
