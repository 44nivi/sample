package com.exterro.Maven_Related.Connectivity;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DBConnnectDemo {
 
private static Logger log = LogManager.getLogger(DBConnnectDemo.class);
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		try {
	        FileReader reader = new FileReader("D:\\NivekProjects\\Maven_Related\\src\\main\\resources\\config.properties");
			Properties prop = new Properties();
	        prop.load(reader);
	        String firstname=prop.getProperty("fname");
	        String LastName=prop.getProperty("lname");
	        int age=Integer.parseInt(prop.getProperty("age"));
	        System.out.println(firstname);
			log.info("Hello this is a debug message");
			log.log(Level.WARN,"This is warning message");
			System.out.println("hits!!!!");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("hits!!!!");
			Connection c1 = DriverManager.getConnection(
					"jdbc:sqlserver://LT-3MJSQF2;DatabaseName=nivi;encrypt=true;trustServerCertificate=true;", "sa",
					"exterro-123456");
			Statement stmt=c1.createStatement();  
			
			// String str = "insert into Employee
			// values('"+emp.getFName()+"','"+emp.getLName()+"',"+emp.getAge()+")";
			PreparedStatement pstmt =c1.prepareStatement( "insert into Persons (firstname,LastName,age) values(?,?,?)");
			pstmt.setString(1,firstname);
			pstmt.setString(2, LastName);
			pstmt.setInt(3,age);
			
			pstmt.executeUpdate();
			System.out.println("Done!!!!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		
		}

		// @formatter:on

	}

}
