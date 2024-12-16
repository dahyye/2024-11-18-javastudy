package com.sist.dao;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Emp extends DataBase {

	@Override
	public void listPrint() {
		// TODO Auto-generated method stub
		driverConfig();
		Connection conn=getConnection();//연결
		try {
			//오라클 전송
			String sql="SELECT * FROM emp";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+""+rs.getString(3));
			}
		} catch (Exception ex) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void findPrint() {
		// TODO Auto-generated method stub
		
	}
	
	

}
