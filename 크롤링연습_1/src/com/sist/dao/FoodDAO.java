package com.sist.dao;
// 오라클에 저장 
import java.util.*;
import java.sql.*;
public class FoodDAO {
	  private Connection conn;
	  private PreparedStatement ps;
	  private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	  private static FoodDAO dao;
	  // genie/melon
	  public FoodDAO()
	  {
		  try
		  {
			  Class.forName("oracle.jdbc.driver.OracleDriver");
		  }catch(Exception ex) {}
	  }
	  public static FoodDAO newInstance()
	  {
		  if(dao==null)
			  dao=new FoodDAO();
		  return dao;
	  }
	  public void getConnection()
	  {
		  try
		  {
			  conn=DriverManager.getConnection(URL,"hr","happy");
		  }catch(Exception ex) {}
	  }
	  public void disConnection()
	  {
		  try
		  {
			  if(ps!=null) ps.close();
			  if(conn!=null) conn.close();
		  }catch(Exception ex) {}
	  }
	  /*
 FNO  NOT NULL NUMBER
 NAME                                      NOT NULL VARCHAR2(500)
 TYPE                                      NOT NULL VARCHAR2(100)
 PHONE                                     NOT NULL VARCHAR2(20)
 ADDRESS                                   NOT NULL VARCHAR2(700)
 SCORE                                              NUMBER(2,1)
 THEME                                     NOT NULL CLOB
 POSTER                                    NOT NULL VARCHAR2(300)
 IMAGES                                             VARCHAR2(4000)
 TIME                                      NOT NULL VARCHAR2(100)
 PARKING                                            VARCHAR2(200)
 CONTENT                                   NOT NULL CLOB
 HIT 
 PRICE                                               NUMBER
	   */
	  // 기능 설정 
	  public void foodInsert(FoodVO vo)
	  {
		  try
		  {
			  getConnection();
			  String sql="INSERT INTO food_menupan "
					   +"VALUES(fm_fno_seq.nextval,"
					   +"?,?,?,?,?,?,?,?,?,?,?,0,?)";
			  // fno(처리) name type phone address score 
			  // theme poster images time parking content
			  // hit price
			  ps=conn.prepareStatement(sql);
			  // ? 에 값을 채운다 
			  ps.setString(1, vo.getName());
			  ps.setString(2, vo.getType());
			  ps.setString(3, vo.getPhone());
			  ps.setString(4, vo.getAddress());
			  ps.setDouble(5, vo.getScore());
			  ps.setString(6, vo.getTheme());
			  ps.setString(7, vo.getPoster());
			  ps.setString(8, vo.getImages());
			  ps.setString(9, vo.getTime());
			  ps.setString(10, vo.getParking());
			  ps.setString(11, vo.getContent());
			  ps.setString(12, vo.getPrice());
			  ps.executeUpdate();
			  
		  }catch(Exception ex)
		  {
			  ex.printStackTrace();
		  }
		  finally
		  {
			  disConnection();
		  }
	  }
}