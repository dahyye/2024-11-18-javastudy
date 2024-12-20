package com.sist.math;
import java.sql.*;

/*

 	데이터형
 	=> 기본형
 	=> 참조형
 	   ---- 클래스 / 배열
 	   		----
 	   		|라이브러리
 	   		|사용자 정의
 	 멤버변수 => 기본형 / 클래스 / 배열
 	 
 	

	오라클 실행 명령어
	-------------- SQL
	
	DQL : 데이터 검색 => 데이터읽기
			=> SELECT
			
			SELECT COUNT(*) FROM goods_all;
		SELECT CEIL(COUNT(*)/20.0) FROM goods_all;
	
	
	DML : 데이터 조작
			=> INSERT -> 데이터를 오라클에 추가
			=> UPDATE -> 데이터 수정
			=> DELETE -> 데이터 삭제
	
	DCL : 데이터 제어
			=> GRANT : 권한 부여
			=> REVOKE  : 권한 해제
	
	DDL : 저장장소, 함수...
			=> CREATE, ALTER, DROP, RENAME
			=> TRANCATE
	TCL : 트랜젝션 제어
			=> COMMIT : 정상 저장
			=> ROLLBACK : 모든 명령 취소
			
	JOIN / Subquery -> 많이 사용 할 예정
			
	
	
	
*/


public class GoodsDAO {
	//클래스 전체영역에서 사용하는 변수/클래스/배열 설정 => 멤버변수
	private Connection conn; //오라클연결
	private PreparedStatement ps; //오라클 명령문
	//변경이 되면 안되는 값 : 상수 => 오라클 주소
	// 
	private final String URL="jdbc:oracle:thin:@211.238.142.124:1521:XE";	
	//오라클연결을 위한 드라이버 설치 => 시작하자마자 설치되어야 하니까 생성자에 코딩
	// 1번만 수행하게 만들어야해 -> 싱글턴!! (데이터베이스가 나오면 싱글턴으로 코딩해야 한다고 생각하면 됨)
	private static GoodsDAO dao; //싱글턴
	
	public GoodsDAO()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	//GoodsDAO dao = GoodsDAO.newInstance() //어디에서 가져다 쓰더라도 메모리가 동일 -> 싱글턴패턴
	//메모리공간을 하나만 쓰겠다
	public static GoodsDAO newInstance()
	{
		if(dao==null)
			dao=new GoodsDAO(); //값이 널이면 주소값 하나 생성하고 
		return dao; // 주소값이 생성되어 있다면 그 값을 쓰겠다.
	}
	
	//공통모듈 => 메소드마다 공통으로 사용 
	// => 오라클 연결
	// => 오라클 닫기 => 반복 코딩 -> 메소드화
	// => 자동화 ( 스프링 -> AOP ) => 실시간 Task (자바는 실시간이 안된다)
	// 실무에서는 스프링은 많이 사용해
	
	public void getConnection()
	{
		try {
			conn=DriverManager.getConnection(URL, "hr", "happy");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
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
	//총페이지
	public int goodsTotalPage()
	{
		int count = 0;
		//마이바티스 => selectList(String sql) 을 쓰면 아래문장 대체할 수 있다
		
		try {
			//연결
			getConnection();
			//오라클명령문 전송
			String sql="SELECT COUNT(*) FROM goods_all";
			//전송
			ps=conn.prepareStatement(sql);
			//결과값 읽기
			ResultSet rs = ps.executeQuery();
			//데이터가 있는 메모리 위치에 커서이동
			rs.next();
			//가져온 데이터 저장
			count=rs.getInt(1);//첫번째칸의 정수값을 읽어와서
			// Resultset 닫기
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			disConnection();
		}
		
		return count;
	}
	
	
	
	
}
