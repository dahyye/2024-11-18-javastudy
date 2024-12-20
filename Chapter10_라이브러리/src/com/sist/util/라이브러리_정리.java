package com.sist.util;

/*
 
 	java.lang : 자바의 기본 라이브러리
 			=> import 생략
 		1. Object
 			clone() 복제
 			equals() 비교
 			toString() 객체 주소 문자열변환
 		
 		2. StringBuffer : 문자열 결합해서 제어
 			append()사용
 		
 		3. Math : 수학관련
 		 	ceil() : 올림
 		 	random() : 난수발생
 		 	
 		4. System
 			println()
 			gc() : 메모리 즉시 회수
 			exit() : 프로그램 종료
 			
 		5. Wrapper : 데이트형을 클래스화 / 제네릭스<>
 			Integer -> parseInt()
 			Double -> parseDouble
 			Boolean -> parseBoolean()
 			-> 윈도우 / 웹 / 크롤링 => 문자열로 받아와
 			 		
 		6. String : 종류 많아 (이전예제 참조)
 			
 			
 	java.util : 프로그램 개발 시 유용하게 사용하는 라이브러리
 		
 		1. Random : 임의의 수 추출
 			nextInt(100) : 0~99까지 중 랜덤
 		
 		2. StringTokenizer : 구분자별 문자를 잘라서 저장
 			countTokens() : 토큰 갯수
 			hasMoreTokens() : while문처름 루프돌릴 때 사용
 			nextToken() : 자른 데이터 읽기
 		
 		3. Date : 시스템의 시간 / 날짜 
 				  기능은 거의 없지만 오라클 날짜 데이터와 호환가능
 				  
 		4. Calendar : Date 보완한 클래스
 			날짜 관련 기능(오늘 날짜, 시간, 요일, 마지막날짜)
 			
 	----------------------------------------------------------
 			
 		Collection => util라이브러리의 핵심!!!!!
 		----------
 		표준화되어 있다 / 가변형 / 항상 0번부터 순서 유지
 			
 			ArrayList : 비동기 => 데이터베이스
 			Vector : 동기 => 네트워크 : 접속자 정보 저장
 			Map : 웹 => 클래스 관리 => MyBatis / Spring
 			Set : 중복 제거
 			
 			=>LinkedList => c언어와 호환할 때 주로 사용
 					|
 					Queue
 			
 			=> 웹에서는 배열을 잘 안스고 대부분 ArrayList를 사용
 			 (배열은 크기가 고정되어 있기 때문에)
 			 
 			 
 			
 
 
 */
public class 라이브러리_정리 {

}
