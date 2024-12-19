package com.sist.exception;

import java.util.*;
import java.sql.*;
/*
 	클래스 요소
 		라이브러리
 			네트워크 : java.net
 			오라클 : java.sql
 			파일 : java.io
 			전체적으로 사용 : String, Object
 					java.lang => 가장 많이 사용되는 클래스
 								import문 생략, 자동추가
 			**자동생성
 			1. import java.lang 
 			2. class ClassName extends Object
 					           --------------
 					           객체 생성 / 객체 정보 / 객체 소멸 
 										*toString   finalize()
 								객체 비교 / 객체 복제
 								*equals   *clone
 								 ==> 프로그램에 맞게 오버라이딩해서 사용하기도 함
 			3. 생성자가 없는경우 기본생성자(default) 자동추가 ->
 				**생성자는 시작과 동시에 처리 / 초기화 할 때 사용(파일, 데이터베이스)
 					-> 초기화블럭(인스턴스블럭, 정적블럭)
 			4. 각 클래스마다 기능 => 메소드
 				메소드 : 한가지 기능 수행
 				  -> 반복이 많은 경우, 재사용할 목적
 				 **메소드에서 필요시 에러를방지하기 위해 예외처리
 				 -----------------------
 				  |라이브러리중에 CheckException => 반드시 처리
 				  |try~catch를 주로 사용
 				 
 				 **static메소드 / static 블럭
 				 1) static만 사용이 가능
 				 2)	인스턴스 사용시에는 반드시 객체 생성 후 사용
 				 3) static은 컴파일시에 자동으로 저장
 				 	인스턴스는 객체를 생성해줘야 저장됨
 			
 				=> 사용자 변수 : 클래스 전체 / 다른 클래스
 				   => 벤치마킹
 				=> 초기화 방법 : 생성자, 초기화블록
 				=> 기능 설정 : 무슨 기능을 가지고 있는지 여부
 				   => 어떤 기능 : 메뉴, 버튼
 				   => 결과화면 => 리턴형
 				   => 매개변수
 				
 				=> 라이브러리를 사용하다보면 예외처리가 필요한 경우가 있다
 					1. 메소드안에서 예외처리를 할 때 
 						[접근지정어] 리턴형 메소드명(사용자요청값=매개변수) 
 						{
 							String a=""; //리턴할 변수 선언
 							 //{}안에서 변수선언을 하면 {}가 끝나면 자동으로 사라져서 오류날 수 있다
 							try
 							{
 							}
 							catch
 							{
 							}
 							finally
 							{
 							}
 							return s;	 
 								 
 						}
 						
 						=> 전체적 사용 => 멤버변수
 						   사용하고 버리는 변수 => 지역변수
 					
 		JDBC : 원시소스
 		  |
 		DBCP : 미리 연결 => 속도
 		  |
 		MyBatis : google제공
 		  |
 		 JPA 
 
 */
public class MemberDAO {
	//멤버변수 => 클래스 전체적으로 사용하는 변수
	private Connection conn; //null값으로 초기화되어있어 // 오라클 연결
	private PreparedStatement ps; //오라클에 명령문 전송 / 결과값 읽기
	private final String URL="jdbc:oracle:thin:@211.238.142.124:1521:XE"; //변경금지->상수 //맨뒷자리 컴퓨터 연결
	//오라클은 공유된 데이터 => static변수
	
	//초기화
	public MemberDAO() //throws => 호출하는 위치에서 예외처리를 또 해줘야 하기 때문에 try~catch 사용
	{
		//드라이버 등록  빌드패스로 ojdbc8.jar 등록
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (Exception e) { //ClassNotFoundException 생각안나면 Exception
 			// TODO: handle exception
			System.out.println(e.getMessage());
			//에러 확인 (getMessge() or printStackTrace())
			
		}
		
	}
	
	//오라클 연결 => 문장전송 => 결과값읽기 => 오라클 닫기
	//열고 닫고는 중복 -> 공동모듈
	// getConnection()   disConnection() 앞으로 계속계속 나올예정 
	
	public void getConnection()
	{
		
	}
	
	public void disConnection()
	{
		
	}
	
	
	
}
