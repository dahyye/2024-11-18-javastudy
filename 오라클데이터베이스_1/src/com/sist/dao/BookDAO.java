package com.sist.dao;
import com.sist.vo.*;
import java.sql.*;
import java.util.*;
public class BookDAO {

	private Connection conn;
	private PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static BookDAO dao;//싱글톤
	
	
	

	
	
	
	
	
	private BookDAO()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
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
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static BookDAO newInstance()
	{
		if(dao==null)
			//BookDAO dao = new BookDAO();
			dao = new BookDAO();
		return dao;
	}
	
	//기능
	public List<BookVO> bookFind(String publisher)
	{
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			getConnection();
			String sql = "SELECT bookid,bookname,publisher,price FROM book WHERE publisher LIKE '%'||?||'%'";
			// '%'||?||'%'
			// '%?%'
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, publisher);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				BookVO vo = new BookVO();
				vo.setBookid(rs.getInt(1));
				vo.setBookname(rs.getString(2));
				vo.setPublisher(rs.getString(3));
				vo.setPrice(rs.getInt(4));
				list.add(vo);
				System.out.println("list에 데이터넣기");
			}
			rs.close();
			
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
		return list;
	}
	
	public int bookFindCount(String publisher)
	{
		System.out.println("카운터메소드");
		int count=0;
		try {
			getConnection();
			System.out.println("오라클연결");
			String sql = "SELECT COUNT(*) FROM book WHERE publisher LIKE '%'||?||'%' ";
			System.out.println("sql입력");
			ps=conn.prepareStatement(sql);
			System.out.println("sql입력=> 엔터");
			ps.setString(1, publisher);
			System.out.println("첫번째가 퍼블리셔");
			ResultSet rs = ps.executeQuery();
			rs.next();
			count=rs.getInt(1);
			rs.close();
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
		
		return count;
	}
	
}
