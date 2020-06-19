package com.capgemini.empwebapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.empwebapp.dto.EmployeeBeans;

public class EmployeeJDBCImple implements EmployeeDAO {
	
		EmployeeBeans bean = new EmployeeBeans();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		@Override
		public EmployeeBeans getEmployeeDetailById(int id) {

			
			try { 
			
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false","root","root");
					
				stmt = conn.prepareStatement("select * from employee where id = ?");
				
				stmt.setInt(1, id);
				
				rs = stmt.executeQuery();

				if(rs.next()) {
				bean.setId(rs.getInt("eid"));
				bean.setName(rs.getString("name"));
				bean.setAge(rs.getInt("age"));
				bean.setSalary(rs.getInt("salary"));
				bean.setDesignation(rs.getString("designation"));
				bean.setPassword(rs.getString("password"));
				
				} else {
					System.out.println("Employee details not found");
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			//close connection
			finally {
				try {
					if(conn != null) {
					conn.close();
					} 
					if(stmt != null) {
					stmt.close();
					}
					if(rs != null) {
					rs.close();
					}
				} catch (SQLException e) {

					e.printStackTrace();
				}
			
			}
			return bean;
		}

		@Override
		public boolean deleteEmployeeInfo(int id) {

			try { 
				//load the driver
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				//get db connection via Driver
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false","root","root");
				
				//issue the sql query via connection
				stmt = conn.prepareStatement("delete from employee where deptid = ?");
				
				//set parameters
				stmt.setInt(1,id);
				
				//process the result "returned by sql queries"
				int rowsaffected= stmt.executeUpdate();
				if(rowsaffected != 0) {
					return true;
				} else {
					return false;
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			//close connection
			finally {
				try {
					if(conn != null) {
					conn.close();
					} 
					if(stmt != null) {
					stmt.close();
					}
					if(rs != null) {
					rs.close();
					}
				} catch (SQLException e) {

					e.printStackTrace();
				}
			
			}
			return false;
		}

		@Override
		public boolean updateEmployeeInfo(String name) {

			try { 
				//load the driver
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				//get db connection via Driver
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false","root","root");
				
				//issue the sql query via connection
				stmt = conn.prepareStatement("update employee set deptid = 30 where name = ?");
				
				//set parameters
				stmt.setString(1,bean.getName());
				
				//process the result "returned by sql queries"
				int rowsaffected = stmt.executeUpdate();
				if(rowsaffected != 0) {
					return true;
				} else {
					return false;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			//close connection
			finally {
				try {
					if(conn != null) {
					conn.close();
					} 
					if(stmt != null) {
					stmt.close();
					}
					if(rs != null) {
					rs.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			}
			return false;
		}

		@Override
		public boolean createEmployeeInfo(EmployeeBeans bean) {

			try { 
				//load the driver
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				//get db connection via Driver
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false","root","root");
				
				//issue the sql query via connection
				stmt = conn.prepareStatement("insert into employee(id,name,age,salary,designation,password) values (?,?,?,?,?,?)");
				
				//set parameters
				stmt.setInt(1,bean.getId());
				stmt.setString(2,bean.getName());
				stmt.setInt(3,bean.getAge());
				stmt.setInt(4,bean.getSalary());
				stmt.setString(5,bean.getDesignation());
				stmt.setString(6, bean.getPassword());
				
				//process the result "returned by sql queries"
				int rowsaffected= stmt.executeUpdate();
				if(rowsaffected != 0) {
					return true;
				} else {
					return false;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			//close connection
			finally {
				try {
					if(conn != null) {
					conn.close();
					} 
					if(stmt != null) {
					stmt.close();
					}
					if(rs != null) {
					rs.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			}
			return false;
		}

		@Override
		public List<EmployeeBeans> getAllEmployeeDetail() {

			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try { 
				//load the driver
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				
				//get db connection via Driver
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false","root","root");
				
				//issue the sql query via connection
				stmt = conn.createStatement();
				
				//process the result "returned by sql queries"
				rs = stmt.executeQuery("select * from employee");
				List<EmployeeBeans> list = new ArrayList<EmployeeBeans>();
				while(rs.next()) {
					EmployeeBeans beans = new EmployeeBeans();
					beans.setId(rs.getInt("id"));
					beans.setName(rs.getString("name"));
					beans.setAge(rs.getInt("age"));
					beans.setSalary(rs.getInt("salary"));
					beans.setDesignation(rs.getString("designation"));
					beans.setPassword(rs.getString("password"));
					list.add(beans);
				}
				return list;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			//close connection
			finally {
				try {
					if(conn != null) {
					conn.close();
					} 
					if(stmt != null) {
					stmt.close();
					}
					if(rs != null) {
					rs.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			}
			return null;
		}	

}  
