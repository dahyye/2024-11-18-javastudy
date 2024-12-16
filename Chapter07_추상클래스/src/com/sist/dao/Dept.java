package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
//import javax.naming.spi.DirStateFactory.Result;

public class Dept extends DataBase {
	//driverConfig(), getConnection() 구현된 메소드 2개와
	//listPrint(), findPrint() 구현안된 메소드 2개를 상속
	//구현안된 메소드 2개는 구현해야함
	
	@Override
	public void listPrint() {
		// TODO Auto-generated method stub
		driverConfig();
		Connection conn=getConnection();//연결
		try {
			//오라클 전송
			String sql = "SELECT * FROM dept";
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
