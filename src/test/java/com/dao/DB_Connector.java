package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Connector {

int x;
public static Connection connection;
Statement statement;
public static final String DB_URL = "jdbc:mysql://139.59.91.96:3306/SR_DEV";
private static final String USERNAME = "produser";
private static final String PASSWORD = "qweQWe123!";

public static  DB_Connector data; //made static so that only one object get created(but giving 3 memory location so write a condition inside method)

private DB_Connector() { //creating constr private// private  other classes cannot create object of the class so create object in same class
	try {
		connection = DriverManager.getConnection("DB_URL ", "USERNAME", "PASSWORD");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		statement = connection.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}	
	
	public static Connection getconnection() {
	  if(data == null ) {
	 data = new DB_Connector () ;
		  }
	
	return connection;
		
	
	
	
	
	
	
	
}


}
