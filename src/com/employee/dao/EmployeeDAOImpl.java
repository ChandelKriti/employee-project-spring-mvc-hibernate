package com.employee.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.employee.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	//inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Employee> getEmployees() {
		
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee",Employee.class);
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		//return the results
		return employees;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {

		//get the current session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save or update the employee
		currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	public Employee getEmployees(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//retrieve or read form db using primary key
		Employee theEmployee = currentSession.get(Employee.class,theId);
		
		return theEmployee;
	}

	@Override
	public void deleteEmployee(int theId) {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				//delete object primary key
				Query theQuery = currentSession.createQuery("delete from Employee where id=:id");
				
				theQuery.setParameter("id",theId);
				
				theQuery.executeUpdate();
				
	}


}
