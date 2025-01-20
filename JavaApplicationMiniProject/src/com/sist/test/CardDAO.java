package com.sist.test;

import java.sql.*;

public class CardDAO {
	private Connection conn;
	//송수신-> SQL문장 전송, 결과값 받기
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static CardDAO dao;
	
	//드라이버 등록
	public CardDAO()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//리플랙션 -> 클래스이름으로 메모리할당 / 메소드 제어..
			//new 역할 -> 메소드명을 모르는 경우에도 호출 가능
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static CardDAO newInstance()
	{
		if(dao==null)
			dao=new CardDAO();
		return dao;
	}
	//연결
	public void getConnection()
	{
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//해제
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
	
	public void cardInser(String id, int price)
	{
		try {
			getConnection();
			conn.setAutoCommit(false);//커밋해제
			String sql="INSERT INTO myCard VALUES(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, price);
			ps.executeUpdate();
			
			sql="INSERT INTO myPoint VALUES(SELECT NVL(MAX(no)+1,1) FROM myPoint),?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, price);
			ps.executeUpdate();
			
			//insert가 2번 실행되는데 마지막에 commit을 날릴예정이야
			//둘 중 하나에서 오류가 나면 catch로 넘어가기 때문에 commit이 안됨 -> 실제 오라클에는 저장이 안된다
			conn.commit();
						
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
	}
	
	
	public static void main(String[] args) {
		CardDAO dao= CardDAO.newInstance();
		dao.cardInser("hong", 30000);
	}
	
	
}
