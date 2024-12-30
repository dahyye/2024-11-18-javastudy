package com.sist.main;

import java.util.*;
import java.io.*;
import java.sql.*;

public class EmpDAO {
	private Connection conn;
	private PreparedStatement ps;
	private String driver, url, username, password;
	
	public EmpDAO()
	{
		//propertoes 파일 읽기
		try 
		{
			Properties_1 prop = new Properties_1();
			prop.load(new FileInputStream("C:\\Users\\sist.110\\git\\java-study\\Chapter11_IO라이브러리_5\\src\\com\\sist\\main\\Properties.java"));
			driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			username=prop.getProperty("username");
			password=prop.getProperty("password");
			//보안용 => 데이터베이스, 네트워크 서버
			//드라이버 설치
			Class.forName(driver);
			
			
			
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
	
	}
	
	//연결 
	public void getConnection()
	{
		try {
			conn = DriverManager.getConnection(url, username, password);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void disConnection()
	{
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<Emp> empListData()
	{
		List<Emp> list = new ArrayList<Emp>();
		try {
			getConnection();
			String sql = "SELECT empno,ename,job FROM emp";
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getNString(2));
				emp.setJob(rs.getString(3));
				list.add(emp);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
		return list;
	}
	
}
