package com.sist.exception;
/*
 	자바:
 	
 		javac : 컴파일 , java : 인터프리터(런타임), 논리적에러
 		
 		컴파일에러 : 컴파일시에 에러발생 -> 문법상에러
 		런타임에러 : 실행시에 에러발생 -> 사용자 입력에 대한 에러, 출력에 대한 에러(변수, 배열범위)
 		-------> 에러가 발생, 발생하지 않을 수도 있음
 		논리적에러 : 웹에서 발생 
 		-------> 에러잡기가 가장 어렵다=> 실행은 되는데 원하던 동작과 다른 동작을 할 때
 		---------------------------------------------------------------------
 		프로그램에서 가장 중요
 		 -> 다른 개발자가 분석할 수 있게 가독성이 좋아야 함(개발/유지보수)
 		 -> 속도 -> 최적화
 		 -> 견고성 : 에러발생시 종료하지 않고 정상 수행이 가능하게 만든다
 		 	====
 		 	1. 에러를 사전에 방지하는 방법
 		 		우선시 -> if문=> 처리가 어려운 문장 예외처리
 		 	2. 예외처리가 등장
 		 		**변수 초기값 
 		 		우선시 : 명시적 초기화
 		 		=> 명시적 초기화가 안되는 경우 -> 외부에서 읽어서 데이터 대입
 		 		-> 생성자 / 초기화블럭
 		 	=> 가벼운 에러 => 수정이 가능한 에러
 		 	 예) FileReader fr= new FileFeader("경로명/파일명") 
 												---------수정
 			웹에서는 번호로 에러표시(브라우저)
 			404 : 요청한 파일이 없는 경우
 			500 : 자바소스오류
			400 : Bad Request
			412 : GET/POST/PUT/DELETE
			403 : 스프링 보안(접근불가)
 			
 			
 			url주소 맨 마지막에 파일명을 지정 
 					  ---------------
 					  없는 경우 => 명령어(MVC)
 					  
 					  
 			265page 예외처리 종료 & 계층도
 			
 			예외처리 종류
 				예외복구 : try ~ catch ~ finally => 가급적이면 예외처리로 주로 사용
 						try
 						{
 						
 						}
 						catch(에러종류)
 						{
 							에러가 발생시에 복구 / 에러 확인
 											  ~~~~~~~
 											  에러메세지 출력 getMessage()
 											  에러위치 확인 printStackTrace()
 						}
 						finallt
 						{
 							//생략가능
 							//try~catch 상관없이 무조건 수행하는 문장이 있는 경우
 							 => 서버연결해제, 오라클닫기, 패일닫기 에서 사용
 						}
 				
 				예외회피 : throws => 메소드 선언 뒤에 서술
 						 => 예약, 떠맡기기 -> 다음에 사용시에 예외처리를 해서 사용
 						 => 라이브러리에서 주로 제공
 				임의로 발생 : 테스트, 배포전에 확인 => throw
 							정상상태 유지
 							throw new Exception();
 				사용자 정의 예외 : 자바에서 지원하지 않는 예외처리가 있는 경우
 								class MyException extends Exception
 								{
 								}
 								=> 예외를 if문으로 해결하기 때문에 많이 나오는 형태는 아니다
 								
 			
 			
 				실무에서는 
 				try
 				{
 				}catch(Exception e)
 				{
 					모든 예외를 처리
 				}
 			
 			
 			==> 서버/오라클 연동
 				try
 				{
 					오라클 연결
 					SQL문장 전송
 					결과값 받기
 				}chatch(Exception e)
 				{
 					오류발생시 처리
 				}
 				finally
 				{
 					오라클 닫기
 				}
 					  
 
 
 		266pate
 		자바에서 지원하는 클래스(라이브러리)
 		CheckException : 컴파일시에 예외처리여부 확인
 		   => 반드시 예외처리를 해야 사용이 가능 
 		   => java.io / java.sql / java.net
 		   		:IOException
 		   		:SQLException
 		   		:MalformedURLException
 		   		
 		   => java.lang => 리플렉션
 		   		:ClassNotFountException
 		   		:InterruptedException(쓰레드관련 -> 충돌방지)
 		   => javax.http.* -> JSP관련 -> 최근에 사라졌다
 		   		=> jakarata로 변경
 		   			
 		UnCheckException : 예외처리여부 확인이 없다
 		   => 필요시에만 예외처리
 		   		:NullPointerException 클래스 메모리 할당이 없는 경우 
 		   		:NumberFormatException 문자열 => 정수변환
 		   		:ArrayIndexOutOfBoundsException 배열범위초과
 		   		:ClassCastException
 		   		:ArthmeticException 0으로 나눈 경우
 		   		==>UnCheckException을 한 번에 처리 : RuntimeException 사용
 		==> 전체 오류 처리 Exception 사용
 		
 	예외처리
 
 	=> 정의
 	
 
 	=> 목적
 		
 		
 		   
 */	
public class 예외처리_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
