package com.notgabs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notgabs.dao.EmployeeDao;
import com.notgabs.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public Optional<Employee> findById(int id) {
		Optional<Employee> emOptional = employeeDao.findById(id);
		
		if (emOptional.isPresent()) {
			return Optional.of(emOptional.get());
		}
		
		return Optional.empty();
	}

	@Override
	public Employee save(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	public void delete(Employee employee) {
		employeeDao.delete(employee);
	}

}
