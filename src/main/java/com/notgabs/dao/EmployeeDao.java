package com.notgabs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notgabs.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
