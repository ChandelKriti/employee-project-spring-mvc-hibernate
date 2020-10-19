package com.employee.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.employee.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getEmployees();

	public void saveEmployee(Employee theEmployee);

	public Employee getEmployees(int theId);

	public void deleteEmployee(int theId);

}
