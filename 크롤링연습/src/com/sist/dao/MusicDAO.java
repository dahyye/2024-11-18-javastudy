package com.sist.dao;
import java.util.*;
import java.sql.*;
/*

MNO            NOT NULL NUMBER
CNO            NUMBER
TITLE          NOT NULL VARCHAR2(1000)
SINGER         NOT NULL VARCHAR2(500)
ALBUM          NOT NULL VARCHAR2(500)
POSTER         VARCHAR2(260)
IDCREMENT      NUMBER //상승하강 몇개씩인지 표시하기위현 변수
STATE          VARCHAR2(30)
KEY            VARCHAR2(200)
HIT            NUMBER

*/
public class MusicDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static MusicDAO dao;
	
	public MusicDAO()
	{
		try {
			//Class.forName(URL)
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static MusicDAO newInstance()
	{
		if(dao==null)
			dao=new MusicDAO();
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
	
	//크롤링데이터 추가
	public void genieMusicInsert(MusicVO vo)
	{
		try {
			getConnection();
			String sql="INSERT INTO genie_music VALUES((SELECT NVL(MAX(mno)+1,1) FROM genie_music),"
					+ "?,?,?,?,?,?,?,?,0)";
			ps=conn.prepareStatement(sql);
			//?에 값 채우기
			ps.setInt(1, vo.getCno());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getSinger());
			ps.setString(4, vo.getAlbum());
			ps.setString(5, vo.getPoster());
			ps.setInt(6, vo.getIdcrement());
			ps.setString(7, vo.getState());
			ps.setString(8, vo.getKey());
			//youtube => 2번 실수하면 막혀
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			disConnection();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

