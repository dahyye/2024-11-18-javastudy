package com.sist.dao;
/*
 	//컬랙션 활용
 	1. 목록 => 페이지 나누기 => ArrayList 
 							단순 목록
 							수정/삭제가 느리다
 	2. 상세보기 => MusicVO => 버튼클릭 => 동영상 실행
 	3. 검색 => ArrayList
 	4. 게시판 => LinkedList
 				수정과 삭제가 빠르다
 	5. 구매 => 누가 어떤 상품 2개의 값 => Map 이용
 	6. 찜하기 => 한 사람이 한 번만 => Set
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import com.sist.vo.*;
public class MusicDAO {
	//연결객체
	private Connection conn;
	//오라클 연결객체 필요
	private PreparedStatement ps;
	//SQL 문장 전송 객체 필요
	private final String URL="jdbc:oracle:thin:@211.238.142.124:1521:XE";
	//url 등록
	private static MusicDAO dao;
	
	//ArrayList이용
	//1. 드라이버 등록
	public MusicDAO()
	{
		try {
			//ojdbc파일안에 들어가있다 -> 오라클사에서 지원하는 라이브러리
			//mvnrepospitory.com에서 다운받을 수 있다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		}
	}
	//2. 오라클 연결
	public void getConnection()
	{
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
			// 오라클 conn hr/happy
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//3. 오라클 닫기
	public void disConnection()
	{
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close(); 
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/*
	 	디자인 패턴
	 	 싱글톤 -> static
	 	 팩토리패턴 -> Map
	 	 MV패턴 => JSP(java+HTML)
	 	 				|   |
	 	 			Model	view
	 	 MVC패턴
	 	 Observer
	 	 prototype	 
	 
	 
	 */
	
	public static MusicDAO newInstance()
	{
		if(dao==null)
			dao=new MusicDAO();
		return dao;
	}
	//DAO는 사용자당 1개만 사용이 가능하게 만든다 -> 싱글턴이용이 기본
	//디도스 -> 커넥션을 계속 넣어 => 서버다운
	//4. 뮤직 목록 출력
	//5. 뮤직 상세보기
	//6. 뮤직 검색
	
	
	//DAO는 공용
	public List<MusicVO> musicFindData(String fd)
	{
		List<MusicVO> list = new ArrayList<MusicVO>();
		try {
			//1. 오라클 연결
			getConnection();
			//2. 오라큰 전송문장   														like -> contains()
			//String sql="SELECT mno,title,singer,album,poster "+"FROM genie_music"+"WHERE title LIKE '%'||?||'%'";
			String sql="SELECT mno,title,singer,album,poster "
					  +"FROM genie_music "
					  +"WHERE title LIKE '%'||?||'%'";
			//3.sql전송
			ps=conn.prepareStatement(sql);
			//4. ?의 값을 채운다 (검색할내용)
			ps.setString(1, fd);
			//5. 실행 후 값 가져오기
			ResultSet rs = ps.executeQuery();
			//6. list에 값을 채우기
			while(rs.next()) //처음부터 마지막까지 값을 한줄 씩 읽어온다
			{
				MusicVO vo = new MusicVO();
				vo.setMno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setSinger(rs.getString(3));
				vo.setAlbum(rs.getString(4));
				vo.setPoster(rs.getString(5));
				list.add(vo);
			}
			rs.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally
		{
			disConnection();
		}
		return list;
	}
	
	public String getKey(int mno)
	{
		String key = "";
		try {
			getConnection();//	 DISTINCT중복제거
			String sql = "SELECT DISTINCT key FROM genie_music"
					+"WHERE mno="+mno;
			ps=conn.prepareStatement(sql);
			ps.setInt(1, mno);
			ResultSet rs=ps.executeQuery();
			rs.next();
			key=rs.getString(1);
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
		return key;
	}
	
}
