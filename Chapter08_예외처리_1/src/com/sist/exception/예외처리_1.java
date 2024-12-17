package com.sist.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/*
 	변수 - 데이터형
 	연산자 / 제어문
 	배열 -> 1차원
 	클래스 / 객체생성 / 메소드
 	상속 -> 오버라이딩
 	인터페이스
 	예외처리
 	라이브러리 -> 조립
 	(Collection/IO)
 	------------------- 웹
 	12장 (오라클) 필수!!
 	
 	
 	8장 예외처리 (263page)
 	
 		목적 : 사전에 에러를 방지하는 목적
 			 -> 비정상 종료를 방지하고 정상상태를 유지
 		예외처리 : 에러발생 시 에러를 건너뛴다
 				if문으로 처리하기 어려운 경우->예외처리 사용
 		
 		에러발생 
 			사용자
 				입력오류 -> 유효성 검사 -> if(javascript) 
 			개발자
 				실수 -> 배열인덱스, 정수변환, 형변환
 		----------------------------------------------
 				컴파일		  인터프리터
 		A.java =====> A.class =====> 화면출력
 				javac		   java
 				 |				|
 								|
 							   에러
 							  -----
 							  실시간에러 RuntimeException
 							  => 경우에 따라 예외처리
 				
 				컴파일시에 반드시 예외처리가 필요
 			
 			=> CheckException : 필수적으로 예외처리
 					IO(파일 입출력)
 					-> IOException
 					네트워크( 서버/ URL,IP )
 					-> MalfornedURLException
 					SQL(데이터베이스)
 					-> SQLException
 					쓰레드
 					->InterruptedException
 			=> UnCheckException : 필요시에만 예외처리
 					배열범위를 초과
 					정수변환
 					0으로 나누는 경우
 					객체가 null값
 					클래스의 형변환 오류
 				
 		1. 사전에 차단(우선시 => if) => 예외처리
 		2. 에러
 			= 에러 -> 소스상에서 수정이 불가능한 에러
 					 메모리가 부족, 이클립스
 					 치명적인 에러 => 처리가 불가능
 			= 예외처리 -> 소스상에서 수정이 가능한 에러
 					파일읽기에서 경로나 파일명이 다른경우
 					데이터베이스에서 SQL문장이 틀린경우
 					크롤링시 url주소 잘못입력
 				
 		3. 예외처리 방법
 			=예외복구 : try ~ catch
 					  ---   ------예외발생시 처리 복구
 					  정상수행
 					  => 직접처리
 					  
 			=예외회피(떠맏기기) : throws
 					  => 간접처리
 					  => 라이브러리에 많이 존재
 					  => 사용시 예외처리를 하고 사용해라
 					  
 			=임의 발생 : 견고한 프로그램 여부 = > throw
 					  
 			=지원하지 않는 예외 : 사용자 정의 예외처리
 			 --------------
 			 	public class MyException extends Exception
 			 	{
 			 	
 			 	}
 				
 				
 				
 		예외처리를 하는 경우 : 예외가 많이 예상되는 경우
 		catch를 여러개 사용 가능
 		*주의점 
 		 순서가 존재
 		
 		문자열로 받아서 정수로 변경 후 배열에 저장 -> 두 값을 나눈 값을 출력
 		-> 예외처리 3개예상
 		1. 정수로 안들어 온 경우
 		2. 배열크기 초과한 경우
 		3. 나눌 값이 0인 경우
 		
 		사전에 에러방지 => 에러 예상하면서 소스코딩 필요
 		
 	
 	266page 계층도
 	
 										object
 									  	|
 								   	Throwable
 								      	|
 						---------------------------------------
 						|									  |
 					  Error								  Exception
 					  ----- 처리가 불가능					     |
 					  		메모리부족							 |	
 					  		->ElasticSearch					 |
 					  		->루씬->구글(검색엔진)				 |
 					  		->데이터베이스(NoSQL)				 |
 									  						 |
 									  ------------------------------------------------
 									  |												 |
 									Check										   UnCheck			
 									=>반드시 예외처리(강제성)							   =>필요시에만 예외처리(강제성x)
 									=>컴파일러가 감시								   => 컴파일러가 관여하지 않아
 								-------------------								   => 예외처리가 없을 수 있다
 								|												   => 에러가 많이 발생하는 부분에서는
 							IOException : 입출력											예외처리를 하는 게 좋아
 							 -> 파일												   => 웹 / 윈도우 => 정수입력
 							 -> 메모리											   => " 10"-> 정수형 변경이 안된다->trim()
 							 -> 네트워크											   => 웹에서는 board_llis.jsp?page = 10 => 오류
 																												---공백있으면 오류 																																			
 							SQLException : 오라클								
	 							오라클(데이터베이스)
	 							-> SQL문장
	 							-> INSERT/UPDATE/DELETE
	 							   SELECT
	 							   ------JOIN / SUBQUERY
	 							   ------FUNCTION
	 							   		 PROCEDURE
	 							   		 TRIGGER
	 							   
	 							 SQL-DQL : SELECT(검색)
	 							 	 DML : INSERT UPDATE DELETE
	 							 	 DCL : GRANT(권한부여) REVOKE(권한해제)
	 							 	 TCL : COMMIT ROLLBACK
	 							 	 DDL : CREATE ALTER DROP
 							ClassNotFoundException
 								Class.forName("패키지.클래스명")
 								-> 리플렉션->클래스정보
 							InterrutedException : 쓰레드 충돌방지
 							
 							MalformedURLException : URL관련
 							
 							=> java.io / java.sql / java.net -> 이게 나오면 예외처리를 해야한다 생각
 							   ----------------------------- CheclException!
 								
 							IllegalAccessException : 매개변수에 잘못된 데이터를 전송
 							----------------------
 							웹 => 400(Bad Request) 잘못된 데이터값		
 								 200 => 정상수행
 								 403 => 접근거부
 								 404 => 파일Not Found 
 							***	 500 => 자바 소스 오류
 								 415 => 한글 변환코드 오류	
 									
 								
 						UncheckException
 							=> RuntimeException
 									ArrayIndexOutOfBoundsException : 배열범위 초과
 									NullPointerException : 
 									 	A a;
 									 	a.display(); // 객체 주소가 지정되지 않은 경우
 									ArithmeticException : 0으로 나눴을 때
 									    10/0
 									ClassCastEexception :
 										class A
 										class B extends A
 										B b=(B)new A(); => 오류
 										A a=new B();
 										B b=(B)a; => 이렇게 사용해야해
 									NumberFormatException : 문자열을 정수형으로 반환할 때 생기는 오류

 				
 			=> catch 여러개인 경우
 				계층 순서로 적용
 				
 				catch(Exception e)
 				catch(NumberFormatException)
 				catch(IOException e)
 				//에러
 				// 상위클래스일 경우 에러잡는 범위가 더 크다
 				
 				catch(NumberFormatException)
 				catch(IOException e)
 				catch(Exception e)
 				//이렇게 순서변경해야해
 				
 				
 			=> 예외처리의 기본
 				try ~ catch : 가장 많이 사용되는 예외처리
 				=> 정상 수행 => 에러발생하면 catch처리 -> 스킵
 									   --------에러처리 후 복구
 									   		   -> 대부분 에러위치확인, 어떤 에러인지 확인 정도의 역할
 				try
 				{
 					정상수행
 				}catch(예상되는 예외클래스)
 				{
 					오류발생시 수행
 				}
 				
 				문장1
 				문장2
 				try
 				{
 					문장3
 					문장4(에러)
 					문장5
 				}catch(예상되는클래스)
 				{
 					문장6
 					복구문장(잘 안쓰긴해)
 				}
 				문장7
 				문장8
 				
 				==> 문장1,문장2,문장3,문장6,문장5,문장7,문장8
 				
 				
 			System.out.println(1);          
	        System.out.println(2);
	        try {
	            System.out.println(3);
	            System.out.println(0/0);
	            System.out.println(4);      // 실행되지 않는다.
	        } catch (ArithmeticException ae)    {
	            if (ae instanceof ArithmeticException) 
	                System.out.println("true"); 
	            System.out.println("ArithmeticException");
	        } catch (Exception e)   {
	            System.out.println("Exception");
	        }   // try-catch의 끝
	        System.out.println(6);
	        
 			==> 1 2 3 true ArithmeticException 6 출력
 			
 			
 			
 			
 */				



public class 예외처리_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}