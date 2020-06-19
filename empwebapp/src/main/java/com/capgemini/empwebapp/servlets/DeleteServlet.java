package com.capgemini.empwebapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.empwebapp.dao.EmployeeDAO;
import com.capgemini.empwebapp.dao.EmployeeJDBCImple;

@WebServlet("/DeleteServlet")  
public class DeleteServlet extends HttpServlet{
		EmployeeDAO employee = new EmployeeJDBCImple();
	
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	             throws ServletException, IOException {  
	      
	    	String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	        employee.deleteEmployeeInfo(id);  
	        
	        	        	      
	        RequestDispatcher res = request.getRequestDispatcher("/form.html");
	        res.include(request, response);  
	    }  

}
