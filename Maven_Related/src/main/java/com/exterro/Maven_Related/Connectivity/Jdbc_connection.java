package com.exterro.Maven_Related.Connectivity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class Jdbc_connection {
	public static void main(String[] args) throws SQLException  {
		// TODO Auto-generated method stub
	
		Scanner ss = new Scanner(System.in);

        String Fname = ss.next();
        String Lname = ss.next();
        int age = ss.nextInt();
        Connection connnection = null;
        
        try {

            // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            SQLServerDataSource ds = new SQLServerDataSource();
            ds.setIntegratedSecurity(true);
            ds.setEncrypt(true);         
            ds.setTrustServerCertificate(true);
            ds.setServerName("localhost");
            ds.setPortNumber(1433);
            ds.setDatabaseName("nivi");
            connnection = ds.getConnection();
            String ss1 = "insert into Persons values('"+Fname+"','"+Lname+"',"+age+")";
            Statement smt = connnection.createStatement();
            smt.executeUpdate(ss1);
            System.out.println("complete");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
            

        }
        finally {
            System.out.println("Connection closed!!!");
            //con.close();
        }
	}


}
