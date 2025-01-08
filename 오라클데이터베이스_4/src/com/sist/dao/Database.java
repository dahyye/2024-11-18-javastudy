package com.sist.dao;
import java.util.*;
import java.sql.*;

public class Database {
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	public Database()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		Connection conn =  null;
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return conn;
	}
	
	public void disConnection(Connection conn,PreparedStatement ps)
	{
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
