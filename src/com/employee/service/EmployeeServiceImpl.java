package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.dao.EmployeeDAO;
import com.employee.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	//inject customer DAO
	@Autowired
	private EmployeeDAO employeeDao;
	
	@Override
	@Transactional
	public List<Employee> getEmployees() {
		
		return employeeDao.getEmployees();
	}


	@Override
	@Transactional
	public void saveEmployee(Employee theEmployee) {
		
		employeeDao.saveEmployee(theEmployee);
	}

	@Override
	@Transactional
	public Employee getEmployees(int theId) {
		
		return employeeDao.getEmployees(theId);
	}

	@Override
	@Transactional
	public void deleteEmployee(int theId) {
		employeeDao.deleteEmployee(theId);
	}


}
