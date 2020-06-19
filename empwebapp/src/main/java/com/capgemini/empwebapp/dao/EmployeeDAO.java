package com.capgemini.empwebapp.dao;

import java.util.List;

import com.capgemini.empwebapp.dto.EmployeeBeans;


public interface EmployeeDAO {

	public EmployeeBeans getEmployeeDetailById(int id);
	public boolean deleteEmployeeInfo(int id);
	public boolean updateEmployeeInfo(String name);
	public boolean createEmployeeInfo(EmployeeBeans bean);
	public List<EmployeeBeans> getAllEmployeeDetail();

}
