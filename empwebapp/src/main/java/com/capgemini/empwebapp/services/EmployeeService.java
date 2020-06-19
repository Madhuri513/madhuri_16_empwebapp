package com.capgemini.empwebapp.services;

import java.util.List;

import com.capgemini.empwebapp.dto.EmployeeBeans;

public interface EmployeeService {
	
	public EmployeeBeans authenticate(int empId, String password);
	
	public EmployeeBeans getEmployeeDetailById(int id);
	public boolean deleteEmployeeInfo(int id);
	public boolean updateEmployeeInfo(String name);
	public boolean createEmployeeInfo(EmployeeBeans bean);
	public List<EmployeeBeans> getAllEmployeeDetail();


}
