package com.dao;

import java.sql.Connection;

public class Runner_Single_Ton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection d1 = DB_Connector.getconnection();
		
        System.out.println(d1);	

        
		Connection d2 = DB_Connector.getconnection();
		System.out.println(d2);
		
		Connection d3 = DB_Connector.getconnection();
		System.out.println(d3);
	}

}
