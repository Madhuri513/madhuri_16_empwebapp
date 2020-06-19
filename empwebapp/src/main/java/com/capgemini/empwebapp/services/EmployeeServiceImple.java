package com.capgemini.empwebapp.services;

import java.util.List;

import com.capgemini.empwebapp.dao.EmployeeDAO;
import com.capgemini.empwebapp.dao.EmployeeJDBCImple;
import com.capgemini.empwebapp.dto.EmployeeBeans;

public class EmployeeServiceImple implements EmployeeService {
	
	EmployeeDAO dao = new EmployeeJDBCImple();

	@Override
	public EmployeeBeans getEmployeeDetailById(int id) {
		if(id!= 0) {
			return dao.getEmployeeDetailById(id);
		}
		return null;
	}

	@Override
	public boolean deleteEmployeeInfo(int id) {
		if(id!=0) {
			return dao.deleteEmployeeInfo(id);
		}
		return false;
	}

	@Override
	public boolean updateEmployeeInfo(String name) {
		if(name!=null) {
			return dao.updateEmployeeInfo(name);
		}
		return false;
		
	}

	@Override
	public boolean createEmployeeInfo(EmployeeBeans bean) {
		if(bean!=null) {
			return dao.createEmployeeInfo(bean);
		}
		return false;
	}

	@Override
	public List<EmployeeBeans> getAllEmployeeDetail() {
		return dao.getAllEmployeeDetail();
	}

	@Override
	public EmployeeBeans authenticate(int empId, String password) {
		if(empId < 0 || password == null || password.trim().isEmpty()) {
			return null;
		}
		return dao.authenticate(empId,password);
	}

}
