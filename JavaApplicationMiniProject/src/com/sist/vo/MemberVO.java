package com.sist.vo;
/*
 이름       널?       유형            
-------- -------- ------------- 
ID       NOT NULL VARCHAR2(20)  
PWD      NOT NULL VARCHAR2(10)  
NAME              VARCHAR2(50)  
SEX               CHAR(6)       
EMAIL             VARCHAR2(100) 
BIRTHDAY NOT NULL DATE          
ADDRESS  NOT NULL VARCHAR2(100) 
REGDATE           DATE          
 
 
 jdbc -> 자바 데이터베이스 연결
  => java.sql안에 들어있음
  
  1. 오라클에 있는 데이터를 모아서 윈도우/웹에 전송
  	------------------------------------ > vo(value object 값만 가지고 있는 클래스
  	
  2. dao -> 데이터베이스 연결
  	=Connection : 데이터베이스 연결
  	=Statement :
  		=Statement : SQL+데이터를 동시에 전송
  		="WHERE no="+no => SQL완성후 전송
  		= PreparedStatement : SQL문장을 전송
  							  나중에 데이터값을 채운다
  			"WHERE name=?"
  			=> 가장 많이 사용되는 방식
  			예) String name,sex,address,phone;
  			   int age,no;
  			   "INSERT INTO tableName VALUES('"+name+"','"+sex+"','"+address+"','"+phone+"','"+age+"','"+no+")'

  				"INSERT INOT tableName VALUES(?,?,?,?,?,?)"
  			
  		=CallableStatement : PROCEDURE 를 호출
  						 	 --------- 오라클 함수
  						 	 PL/SQL -> SQL 중복
  
  	코딩
  	1) 드라이버 등록 -> 한 번 사용(생성자에서)
  		Class.forName("oracle.jdbc.driver.OracleDriver")
  		=> MySQL에서는 "com.mysql.cj.jdbc.Driver"
  		  ------ MARIADB
  		  ------ driver는 각 데이터베이스업체에서 다운받는다
  		 
    2) 오라클 연결/닫기 -> 중복이 많다 -> 메소드처리
   		닫기는 ps.close먼저
   		
    3) Connection 객체 관리 => 가비지컬렉션(바로회수(x))
       -----------------
        => 반드시 한 개만 가지고 사용이 가능
        		----------- 싱글턴 (메모리절약, 객체 재사용)
        		| 데이터베이스 / 서버프로그램

  	4) 코딩순서 => 표준(모든 개발자 코딩이 거의 유사)
  					--------------------
  						| 라이브러리 -> Mabaatis/JPA
  						| 실무 (Spring/Mybatis)
  		(286page)				
  		try
  		{
  			오라클연결
  			SQL문장
  			오라클로 SQL문장 전송
  			실행 후 결과값 가지고 오기
  			List/VO에 값 채우기
  		}
  		catch
  		{
  		  	에러 위치 확인 / 에러 확인 => 복구할 수 없다
  		}
  		finally
  		{
  			오라클닫기
  		}
  
  
  
 */
import java.util.*;

import lombok.Data;

@Data
public class MemberVO {

	private String id,pwd,name,sex,email,address,msg;
	private Date regdate,birthday;
	
}
