package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import java.sql.*;
// 로그인처리 => COUNT 
// 회원가입
// 1차  	 	2차프로젝트
//JDBC -> DBCP(속도빠르고 다운이안됨(서버다운))-> ORM(MyBatis, Hibernate, JPA)
public class MemberDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private final String url="jdbc:oracle:thin:@localhost:1521:XE";
	private static MemberDAO dao;
	//드라이버생성
	public MemberDAO() 
	{
		try {
			//ojdbc8.jar
			// 런타임동적로딩
			//Class.forName("로드할 클래스 이름")
			//'어이 JVM, 실행하다가 이 코드만나면 OracleDriver로드하고 실행해'라는 의미
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static MemberDAO newInstance()
	{
		if(dao==null)
		{
			dao = new MemberDAO();
		}
		return dao;
	}
	
	public void getConnection()
	{
		try {
			
			conn=DriverManager.getConnection(url,"hr","happy");
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
	
	//기능처리
	//1. COUNT(*) -> 로그인
	public MemberVO isLogin(String id, String pwd)
	{
		MemberVO vo = new MemberVO();
		try {
			getConnection();
			String sql = "SELECT COUNT(*) FROM member WHERE id=?";
			//0 -> 아이디가 없는 경우 	1-> 아이디가 있는 경우
			ps=conn.prepareStatement(sql);
			//?에 값을 채운다
			ps.setString(1, id); //ex 'hong'
			//실행 후 결과값
			ResultSet rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			rs.close();
			
			if(count==0) //아이디없음
			{
				vo.setMsg("NOID");
			}
			else //id있음
			{
				sql="SELECT pwd, name, sex, address FROM member WHERE id=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				rs=ps.executeQuery();
				rs.next();
				String db_pwd=rs.getString(1);
				String name=rs.getString(2);
				String sex=rs.getString(3);
				String addreses=rs.getString(4);
				System.out.println("db_pwd"+db_pwd);
				if(db_pwd.equals(pwd)) //로그인
				{
					System.out.println("비밀번호 일치");
					vo.setMsg("OK");
					vo.setName(name);
					vo.setSex(sex);
					vo.setAddress(addreses);
				}	
				else //비밀번호 오류
				{
					System.out.println("비밀번호 불일치");
					vo.setMsg("NOPWD");
				}
				rs.close();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
		return vo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
