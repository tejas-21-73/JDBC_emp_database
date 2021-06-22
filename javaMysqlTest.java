package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class javaMysqlTest {
	

	public static void main(String[] args) {
		 
		
		    //insert1("sachin","patel","789123456","sachin@gmail.com","R&D",31000);
		    //insert1("Rakesh","Naik","9992123456","rakesh@gmail.com","HR",25000);
//		    insert1("amith","bhatcharya","7896744456","ab@gmail.com","R&D",31000);
//		    insert1("manish","patel","5789123456","manish@gmail.com","HR",26000);
		    select1();
		
		
		}
		
	
	public static void select1(){
		
		String dbURL = "jdbc:mysql://172.17.10.152:3306/employee123";
		String username = "root";
		String password = "password";
		
		try {
			 
			   Connection conn = DriverManager.getConnection(dbURL, username, password);
			    if (conn != null) {
			        System.out.println("Connected");
			    }
		
		String sql = "SELECT * FROM emp";
		 
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		 
		int count = 0;
		 
		while (result.next()){
		    String fname = result.getString(2);
		    String lname = result.getString(3);
		    String phnum = result.getString("phnum");
		    String email = result.getString("email");
		    
		 
		    String output = "User #%d: %s - %s - %s - %s";
		    System.out.println(String.format(output, ++count, fname, lname, phnum, email));
		}
		
		
	}
		catch (SQLException ex) {
		    ex.printStackTrace();
		}
		
		
	}
	
	
	public static void  insert1(String fname,String lname,String phnum,String email,String dept,int salary){
		
		String dbURL = "jdbc:mysql://172.17.10.152:3306/employee123";
		String username = "root";
		String password = "password";
		 
		try {
		 
		   Connection conn = DriverManager.getConnection(dbURL, username, password);
		    if (conn != null) {
		        System.out.println("Connected");
		    }
		
		  String sql = "INSERT INTO emp(empfname, emplname, phnum, email,dept,salary) VALUES (?, ?, ?, ?,?,?)";
		    
		    PreparedStatement statement = conn.prepareStatement(sql);
		    statement.setString(1,fname);
		    statement.setString(2, lname);
		    statement.setString(3, phnum);
		    statement.setString(4, email);
		    statement.setString(5,dept);
		    statement.setInt(6,salary);
		     
		    int rowsInserted = statement.executeUpdate();
		    if (rowsInserted > 0) {
		        System.out.println("A new user was inserted successfully!");
		    }
		
		} 
		catch (SQLException ex) {
		    ex.printStackTrace();
		}
		
	}

}
