package com.sist.dao;
import java.sql.*;
public abstract class DataBase {
	//기능설정
	
	public void driverConfig()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {}
	}
	
	public Connection getConnection()
	{
		Connection conn=null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			
			conn=DriverManager.getConnection(url,"hr","happy");
		} catch (Exception ex) {}
		return conn;
	}// 공통으로 사용하는 것들은 구현
	
	public abstract void listPrint();
	public abstract void findPrint();
}
