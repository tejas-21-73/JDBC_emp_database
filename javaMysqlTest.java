package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class javaMysqlTest {
	

	public static void main(String[] args) {
		 
		    insert1("sachin","patel","789123456","sachin@gmail.com","R&D",31000);
		    insert1("Rakesh","Naik","9992123456","rakesh@gmail.com","HR",25000);
		    insert1("amith","bhatcharya","7896744456","ab@gmail.com","R&D",31000);
		    insert1("manish","patel","5789123456","manish@gmail.com","HR",26000);
		    select1();
		    update1();
		    delete1();		
		 }
	
}
