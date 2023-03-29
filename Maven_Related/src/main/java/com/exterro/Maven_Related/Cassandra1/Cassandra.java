package com.exterro.Maven_Related.Cassandra1;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Cassandra {
	 public static void main(String args[]){

	      //Query
	      String query = "CREATE KEYSPACE tp WITH replication "
	        + "= {'class':'SimpleStrategy', 'replication_factor':1};";
		 
		   //creating the table 
			/*
			 * String query = "CREATE TABLE worker(emp_id int PRIMARY KEY, " +
			 * "emp_name text, " + "emp_city text, " + "emp_sal varint, " +
			 * "emp_phone varint );";
			 */
		   String query1 = "INSERT INTO worker (emp_id, emp_name, emp_city, emp_phone,  emp_sal)"
					
	         + " VALUES(1,'ram', 'Hyderabad', 9848022338, 50000);" ;
	                             
	      String query2 = "INSERT INTO worker (emp_id, emp_name, emp_city, emp_phone, emp_sal)"
	      
	         + " VALUES(2,'robin', 'Hyderabad', 9848022339, 40000);" ;
	                             
	      String query3 = "INSERT INTO worker (emp_id, emp_name, emp_city, emp_phone, emp_sal)"
	       
	         + " VALUES(3,'rahman', 'Chennai', 9848022330, 45000);" ;
		  
	      String query4="select*from worker";
	      
	    
	      //creating Cluster object
	      Cluster  cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
	    
	      //Creating Session object
	      Session session = cluster.connect("tp");
	     
	      //Executing the query
	      session.execute(query1);
	      session.execute(query2);
	      session.execute(query3);
	     
	      com.datastax.driver.core.ResultSet result= session.execute(query4);
	      System.out.println(result.all());
	      String query5="delete from worker where emp_id=2";
	      
	      com.datastax.driver.core.ResultSet result1= session.execute(query4);
	      System.out.println(result1.all());
	      //using the KeySpace
	      session.execute("USE tp");
	      System.out.println("Table  created"); 
	      System.out.println("The values inserted");
	
}
}
