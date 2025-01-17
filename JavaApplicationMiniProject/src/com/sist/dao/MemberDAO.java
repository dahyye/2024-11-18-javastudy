package com.sist.dao;
import java.sql.*;
import com.sist.vo.*;

//로그인 / 회원가입 / 회원탈퇴 / 회원수정 => 오라클연결
public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static MemberDAO dao;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	//											  ---------------> 나중에 내컴퓨터 연결할 때 211.238....
		
	public MemberDAO()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static MemberDAO newInstance()
	{
		if(dao==null)
		{
			dao=new MemberDAO();
		}
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
	
	
	//기능
	//1.로그인
	public MemberVO isLogin(String id,String pwd)
	{
		MemberVO vo = new MemberVO();
		try {
			getConnection();
			String sql="SELECT COUNT(*) FROM member WHERE id=?"; //아이디존재여부확인
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs=ps.executeQuery();
			rs.next();
			int count=rs.getInt(1);
			rs.close();
			
			
			if(count==0)
			{
				//아이디없음
				vo.setMsg("NOID");
			}
			else
			{
				//아이디있음
				sql="SELECT id,pwd,name,sex FROM member WHERE id=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				
				rs=ps.executeQuery();
				rs.next();
				vo.setId(rs.getString(1));
				vo.setName(rs.getString(3));
				vo.setSex(rs.getString(4));
				String db_pwd=rs.getString(2); // 비밀번호 비교하기 위해서 따로 저장
				
				//비밀번호 검사
				if(db_pwd.equals(pwd))
				{
					//비밀번호 일치
					vo.setMsg("OK");
				}
				else
				{
					//비밀번호 불일치
					vo.setMsg("NOPWD");
					
				}
				
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
	//회원정보
	public MemberVO memberInfo(String id)
	{
		MemberVO vo=new MemberVO();
		try {
			getConnection();
			String sql="SELECT name,sex,email,address,regdate, birthday FROM member WHERE id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs= ps.executeQuery();
			rs.next();
			
			vo.setName(rs.getString(1));
			vo.setSex(rs.getString(2));
			vo.setEmail(rs.getString(3));
			vo.setAddress(rs.getString(4));
			vo.setRegdate(rs.getDate(5));
			vo.setBirthday(rs.getDate(6));
			
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
		return vo;
	}
	//2.회원가입
	//3.회원수정
	//4.회원탈퇴
	
	
}
