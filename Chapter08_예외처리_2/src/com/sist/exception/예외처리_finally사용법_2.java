package com.sist.exception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class 예외처리_finally사용법_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		1. 오라클 연결이 가능하게 드라이버 설정
			class.forName("드라이버")
			=>ClassNotFoundException : CheckException
		2. 오라클 연동
			Connection : SQLException : CheckException
		3. 오라클로 명령어(SQL) 전송
			PreparedStatment : SQLException
		4. 결과값을 받는다
			ResultSet => 결과값을 메모리에 저장
		----------------------------------
		5. ResultSet 닫기
			PreparedStatment 닫기
			Connection 닫기
			
		try안에서 선언이 되면 try 안에서만 사용가능

*/	
		Connection conn = null;
		//오라클뿐만 아니라 MySQL이나 다른프로그램 연결시에도 사용 -> 인터페이스로 되어 있어
		PreparedStatement ps = null;
		//오라클의 송수신을 담당
		ResultSet rs = null;
		//결과값을 저장
		try {
			
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			//연결 드라이버설정
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			//연결
			conn=DriverManager.getConnection(url,"hr","happy");
			//오라클요청
			String sql="SELECT empno,ename,job FROM emp";
			ps = conn.prepareStatement(sql);
			//실행 후 결과값을 가지고 온다(메모리에 저장)
			rs= ps.executeQuery();
			//결과출력
			while(rs.next()) //커서를 처음이나 마지막에 두고 차례대로 가져온다(처음-> rs.next , 아래 rs.previous()
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			//오라클 연결 해제
			try {
				if(rs!=null)
					rs.close();
				if(ps!=null)
					ps.close();
				if(conn!=null)
					conn.close();
				
			} catch (SQLException ex) {
				// TODO: handle exception
				
			}
		}
		
	}

}
