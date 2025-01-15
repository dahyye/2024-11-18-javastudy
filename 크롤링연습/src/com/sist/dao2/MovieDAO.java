package com.sist.dao2;

import java.util.*;
import java.sql.*;

import com.sist.dao.MusicDAO;
import com.sist.dao.MusicVO;

public class MovieDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static MovieDAO dao;
	
	public MovieDAO()
	{
		try {
			//Class.forName(URL)
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static MovieDAO newInstance()
	{
		if(dao==null)
			dao=new MovieDAO();
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
	//데이터추가
	/*
	M_NO        NOT NULL NUMBER        
	M_TITLE     NOT NULL VARCHAR2(100) 
	M_ENG_TITLE NOT NULL VARCHAR2(100) 
	M_POST      NOT NULL VARCHAR2(100) 
	NATION      NOT NULL VARCHAR2(40)  
	GENRE       NOT NULL VARCHAR2(20)  
	RUNTIME     NOT NULL VARCHAR2(20)  
	REG_DATE             DATE          
	TOTAL_AUDI           NUMBER        
	DIR         NOT NULL VARCHAR2(20)  
	ACT                  VARCHAR2(100) 
	RATING               NUMBER(2,1)   
	STORY       NOT NULL CLOB  
	 */
	public void MovieInsert(MovieVO vo)
	{
		try {
			getConnection();
			String sql="INSERT INTO movie_test VALUES((SELECT NVL(MAX(mno)+1,1) FROM movie_test),"
					+ "?,?,?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			//?에 값 채우기
			ps.setInt(1, vo.getM_no());
			ps.setString(2, vo.getM_title());
			ps.setString(3, vo.getM_eng_title());
			ps.setString(4, vo.getM_post());
			ps.setString(5, vo.getNation());
			ps.setString(6, vo.getGenre());
			ps.setString(7, vo.getRuntime());
			ps.setString(8, vo.getReg_date());
			ps.setInt(9, vo.getTotal_audi());
			ps.setString(10, vo.getDir());
			ps.setString(11, vo.getAcr());
			ps.setInt(12, vo.getRating());
			ps.setString(13, vo.getStory());
			
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			disConnection();
		}
	}

	

}
