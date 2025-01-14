package com.sist.dao;
import java.util.*;
import java.sql.*;

public class EmpDeptDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static EmpDeptDAO dao;
	
	public EmpDeptDAO()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static EmpDeptDAO newInstance()
	{
		if(dao==null)
			dao=new EmpDeptDAO();
		return dao;
	}
	public void getConnection()
	{
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void disConnection()
	{
		try {
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//일반 sql문장 사용
	public void sqlExecute()
	{
		try {
			getConnection();
			String sql="SELECT empno,ename,job,hiredate,sal,rank,dname,loc,grade "
					+ "FROM (SELECT empno,ename,job,hiredate,sal,RANK() OVER(ORDER BY sal DESC) rank,dname,loc,grade "
					+ "FROM emp,dept,salgrade "
					+ "WHERE emp.deptno=dept.deptno AND sal BETWEEN losal AND hisal)";
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "
			+rs.getString(3)+" "+rs.getDate(4)+" "+rs.getInt(5)+" "+rs.getInt(6)+" "
						+rs.getString(7)+" "+rs.getString(8)+" "+rs.getInt(9));
				
				
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
	}
	
	//view를 사용
	public void viewExecute()
	{
		try {
			getConnection();
			String sql="SELECT * FROM empAllData";
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "
			+rs.getString(3)+" "+rs.getDate(4)+" "+rs.getInt(5)+" "+rs.getInt(6)+" "
						+rs.getString(7)+" "+rs.getString(8)+" "+rs.getInt(9));
				
				
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
		
	}
	
	
}

























