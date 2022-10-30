package com.notgabs.service;

import java.util.List;
import java.util.Optional;

import com.notgabs.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Optional<Employee> findById(int id);
	public Employee save(Employee employee);
	public void delete(Employee employee);
}
