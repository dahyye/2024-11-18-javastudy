package com.sist.oracle;
import java.sql.*;
public class 오라클연동 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//오라클 드라이버 설정
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//ojdbc8.jar
		//오라클연결
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		Connection conn=DriverManager.getConnection(url, "hr", "happy");
		//conn hr/happy
		String sql="SELECT * FROM emp"; // -> 나중에 인터페이스로 넘어와
		//오라클 => SQL문장 전송
		//"SELECT * FROM emp" => SQL  
		PreparedStatement ps=conn.prepareStatement(sql);
		//실행 결과
		ResultSet rs=ps.executeQuery();
		//rs에 실행된 데이터가 들어가 있다
		while(rs.next()) //데이터 시작부터 끝까지 읽어온다
		{
			System.out.println(
				rs.getInt(1)+" "
				+rs.getString(2)+""
				+rs.getString(3)
			);
			
		}
		
	}

}
