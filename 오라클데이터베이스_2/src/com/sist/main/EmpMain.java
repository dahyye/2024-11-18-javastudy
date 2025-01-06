package com.sist.main;
import java.util.*;
import java.io.BufferedReader;
import java.sql.*;

public class EmpMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력: ");
		String ename = scan.next();
		
		//오라클 연결 후 데이터 읽기 -> 출력
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			Connection conn = DriverManager.getConnection(url,"hr","happy");
			
			//문자열은 반드시 ' ' 안에 있어야한다 그렇지 않으면 데이터를 정수로 인식한다
			//String sql = "SELECT ename, job, sal, hiredate FROM emp WHERE ename=UPPER('"+ename+"')";
			//String sql = "SELECT ename, job, sal, hiredate FROM emp WHERE LOWER(ename)='"+ename+"'";
			String sql = "SELECT ename, job, sal, hiredate FROM emp WHERE ename='"+ename.toUpperCase()+"'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			System.out.println("이름 : "+rs.getString(1));
			System.out.println("직위 : "+rs.getString(2));
			System.out.println("급여 :"+rs.getString(3));
			System.out.println("입사일 :"+rs.getDate(4));
			
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
