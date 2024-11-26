package com.generic.databaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

/**
 * Contains methods to interact with MySQL Database
 * @author Rajani
 * 
 * 
 */
public class DatabaseUtility {

	Connection conn;

	/**
	 * Establish MySQL Database connection
	 */
	public void getDBConnection() {
		try {
			Driver DBDriver = new Driver();
			DriverManager.registerDriver(DBDriver);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		} catch (Exception e) {

		}
	}
	
	/**
	 * Executes select query
	 * @param query - select statement
	 * @return ResultSet
	 */
	public ResultSet executeSelectQuery(String query) {
		ResultSet result=null;
		try {
			Statement s=conn.createStatement();
			result=s.executeQuery(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	/**
	 * Executes non-select query
	 * @param query - insert/update/delete statements
	 * @return RowCount - Successful,
	 * 0 - Unsuccessful.
	 * 
	 */
	public int executeNonSelectQuery(String query) {
		int result=0;
		try {
			Statement s=conn.createStatement();
			result=s.executeUpdate(query);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	/**
	 * Close MySQL Database connection
	 * @throws Throwable
	 */
	public void closeDBConnection() throws Throwable {
		try {
			conn.close();
		} catch(Exception e) {
		}
	}
}
