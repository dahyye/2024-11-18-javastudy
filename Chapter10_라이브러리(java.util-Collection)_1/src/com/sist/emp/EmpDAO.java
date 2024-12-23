package com.sist.emp;
import java.sql.*;
import java.util.*;

public class EmpDAO {
	private Connection conn;//연결
	private PreparedStatement ps;//전송
	//=> 오라클 => 데이터 => 오라클에서 실행이 가능한 문장을 전송 
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	//"jdbc:업체명:드라이버명:@IP:PORT:데이터베이스명"
	//자바에서 지원하는게 아니라 해당 데이터베이스 업체에서 지원
	
	//1. 싱글턴 => 객체를 한 번만 생성
	private static EmpDAO dao;
	
	//2. 드라이버 등록 => 1번만 등록 => 생성자
	public EmpDAO()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//클래스 정보를 읽어서 메모리 할당 -> 리플렉션
			//클래스가 가지고 있는 변수 / 메소드 / 생성자 제어
			//-------------------------- 스프링
			//스프링 : 객체의 생명주기를 담당(컨테이너)
			//-> JSP ( MVC => 구조 : 스프링 형식 )
			// 2차 => 1차 프로젝트가 어렵다
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static EmpDAO newInstance()
	{
		if(dao==null)
			dao = new EmpDAO();
		return dao;
	}
	
	//반복 제거 연결, 닫기
	
	public void getConnection()
	{
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");  // conn hr/happy
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
	
	//검색
	public TreeSet<String> empGetNames()
	{
		TreeSet<String> set = new TreeSet<String>();
		try {
			getConnection();
			String sql = "SELECT ename FROM emp";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				set.add(rs.getString(1));
				//set.add(rs.getString("ename"); 둘 다 가능
				//자바는 배열이나 문자열이 다 0부터 시작이지만
				//오라클은 1번부터 시작이야
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			disConnection();
		}
		return set;
	}
	
	//중복 제거
	public HashSet<String> empGetJobs()
	{
		HashSet<String> set = new HashSet<String>();
		try {
			//1. 연결
			getConnection();
			//2. 오라클 => SQL문장
			String sql = "SELECT job FROM emp"; // 이 명령어가 오라클로 넘어가
			//3.오라클 전송
			ps=conn.prepareStatement(sql);
			//4. 실행 후 데이터를 읽기
			ResultSet rs = ps.executeQuery();
			while(rs.next()) //위에서부터 데이터를 하나씩 가져와
			{
				set.add(rs.getString(1));  //중복된 데이터는 제거해서 가져와
			}
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally
		{
			disConnection();
		}
		return set;
	}
	
	//사원의 모든 정보 출력 => 목록 => ArrayList 
	
	
}
