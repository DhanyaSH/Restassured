package com.read.csv.eample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaDatabaseConnectivity {

	public static void main(String[] args) throws SQLException {
		// connect to the database
		// Connection is an interface
		// DriverManager is a class
		Connection connection = DriverManager.getConnection("jdbc:mysql://139.59.91.96:3306/SR_DEV", "produser",
				"qweQWe123!");
		// Read data from tables
		// create a statement on the connection which is established and then fire the
		// query to the database

		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT* from mst_oem;");
		int total = 0;
		while (rs.next()) {
			total = total + 0;
			System.out.println(rs.getString("name") + "\t" + rs.getString("code"));

		}
		System.out.println("total entries" + total);

		// insert data on the table
		statement.execute("\r\n" + "  INSERT INTO SR_DEV.mst_oem\r\n"
				+ "  (id, name, code, is_active, created_at, modified_at)\r\n"
				+ "  VALUES(0, '', '', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)");
		//update

		statement.execute("UPDATE SR_DEV.mst_oem\r\n"
				+ "SET name='', code='', is_active=1, created_at=CURRENT_TIMESTAMP, modified_at=CURRENT_TIMESTAMP\r\n"
				+ "WHERE id=0");
		//delete

		statement.execute("DELETE FROM SR_DEV.mst_oem\r\n"
				+ "WHERE id=0;");

	}
}
