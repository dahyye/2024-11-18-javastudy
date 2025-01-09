package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;

public class FoodDAO {

	private Connection conn;
	private PreparedStatement ps;
	private Database db = new Database();
	private static FoodDAO dao;
	
	public static FoodDAO newInstance()
	{
		if(dao==null)
		{
			dao= new FoodDAO();
		}
		return dao;
	}
	
	//목록출력
	public List<FoodVO> foodListData(int page)
	{
		List<FoodVO> list = new ArrayList<FoodVO>();
		try {
			conn=db.getConnection();
			//페이지나누기
			int rowSize=20;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			//0~19 20~39 40~59 자바는 0부터 시작인데
			//오라클 rownum은 1부터 시작이라서 
			//1~20 21~40 41~60으로 맞춰줘야해
			String sql="SELECT fno,name, type,phone,num "
					 + "FROM (SELECT fno,name, type,phone, rownum as num "
					 + "FROM (SELECT fno, name,type,phone FROM food_house ORDER BY fno)) "
					 + "WHERE num BETWEEN "+start+" AND "+end;
			ps=conn.prepareStatement(sql);
			System.out.println("오라클전송");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				FoodVO vo = new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setType(rs.getString(3));
				vo.setPhone(rs.getString(4));
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			db.disConnection(conn, ps);
		}
		return list;
		
	}
	
	
}
