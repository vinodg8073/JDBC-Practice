package com.practice.jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstJDBC {
	
	//Insert a hardcoded data into DB 
	private static void performAction() {
		Connection con = null;
		Statement stmt = null;
		String qry = "Insert into college_db.new_colleges values (01,'SSIT',1500,'Kyatsandra')";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded......");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&&password=admin");
			System.out.println("DB connection successfull..........");
			stmt =con.createStatement();
			stmt.execute(qry);
			System.out.println("Query executed.......");
		}
		
		catch(ClassNotFoundException | SQLException e) {
			System.err.println("Exception");
			e.printStackTrace();
		}
		
		finally {
			  
			  if (stmt!=null) { 
				  try { 
					  stmt.close(); 
				  }
				  catch (SQLException e) {
					  e.printStackTrace(); 
				  }
			  
			  if (con!=null) 
			  	{ 
				  	try { 
				  		con.close();
			  			System.out.println("Data Added Successfully" + "" + ""); 
			  		} 
				  	catch(SQLException e) { e.printStackTrace(); 
				  	}
				 }
			  } 
		}
	}
	
	
	public static void main(String[] args) {
		performAction();
	}
}
