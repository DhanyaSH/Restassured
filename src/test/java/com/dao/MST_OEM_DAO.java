package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.pojo.MST_OEM_POJO;

public class MST_OEM_DAO {
	Connection connection;
	Statement statement;
	MST_OEM_POJO data;
	// GOING TO HAVE 4 METHODS AND ONE CONSTRUCTOR

	public MST_OEM_DAO()  { // construcor
		connection = DB_Connector.getconnection();
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertOEM(int id) throws Throwable {

	}

	public MST_OEM_POJO getOENInoBy(int id ,String name) throws Throwable {

		ResultSet rs = statement.executeQuery("SELECT id, name, code, is_active, created_at, modified_at\r\n"
				+ "FROM SR_DEV.mst_oem\r\n" + "WHERE id=" + id + "+ name=\""+name+"\"");
		int total = 0;
		while (rs.next()) {
			total = total + 1;
			data = new MST_OEM_POJO(id,rs.getString("name"), rs.getString("code"));
		}
		return data;
	}
	public MST_OEM_POJO getOENInoBy(int id) throws Throwable {

		ResultSet rs = statement.executeQuery("SELECT id, name, code, is_active, created_at, modified_at\r\n"
				+ "FROM SR_DEV.mst_oem\r\n" + "WHERE id=" + id + "");
		int total = 0;
		while (rs.next()) {
			total = total + 1;
			data = new MST_OEM_POJO(id, rs.getString("name"), rs.getString("code"));
			
		}
	   return data;
	
	
	}
	

	public void UpdateOEMInfoWith(String id) throws Throwable {

	}

	public void deleteOEMInfoWith(String id) throws Throwable {

	}
}
