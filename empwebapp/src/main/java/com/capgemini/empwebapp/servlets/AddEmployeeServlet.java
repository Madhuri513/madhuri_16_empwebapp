package com.capgemini.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.empwebapp.dao.EmployeeDAO;
import com.capgemini.empwebapp.dao.EmployeeJDBCImple;
import com.capgemini.empwebapp.dto.EmployeeBeans;

@WebServlet("/AddEmployee")
public class AddEmployeeServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmployeeBeans bean = new EmployeeBeans();
		EmployeeDAO employee = new EmployeeJDBCImple();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Add Employee</h1>");
		
		employee.createEmployeeInfo(bean);

		out.print("<form action='GetDetails' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='" + bean.getId() + "'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='" + bean.getName() + "'/></td></tr>");
		out.print("<tr><td>Age:</td><td><input type='number' name='id' value='" + bean.getAge() + "'/></td></tr>");
		out.print("<tr><td>Salary:</td><td><input type='number' name='salary' value='" + bean.getSalary()
				+ "'/></td></tr>");
		out.print("<tr><td>Designation:</td><td><input type='text' name='designation' value='" + bean.getDesignation()
				+ "'/></td></tr>");
		out.print("<tr><td>Password:</td><td><input type='password' name='password' value='" + bean.getPassword()
				+ "'/> </td></tr>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Add' /></td></tr>");
		out.print("</table>");
		out.print("</form>");

		RequestDispatcher res = request.getRequestDispatcher("/form.html");
        res.include(request, response);  
		
		out.close();
	}

	
	

}
