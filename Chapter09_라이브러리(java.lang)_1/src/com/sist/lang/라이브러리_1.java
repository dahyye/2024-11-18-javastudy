package com.sist.lang;
/*
 	
 	StringBuffer : 임시로 문자열을 저장해서 => 한 번에 출력
 	=> append() : 문자열 결합
 	
 	Math
 	=> random() : 임의발생(0.0~0.9) => nextInt(100)+1;
 	=> ceil() : 올림(총페이지 구할 때 사용)
 	
 	Wrapper
 	=> 데이터를 쉽게 다루기 위해서 클래스화한 클래스
 	=> 제네릭스 : 데이터형의 통일화 => 형변환없이 사용
 		=> Collection
 	=> int => Integer : 문자열을 정수형 변환
 	=> long => Long : 문자열을 long으로 변경
 	=> double => Double : 문자열을 실수로 변경
 	=> boolean => Boolean : 문자열을 논리형 변경
 		Boolean.parseBoolean() 형식으로 사용
 	----------------------------------------------
 		Integer i = 100; -> 오토박싱
 		int ii = i; => 언박싱
 
 */
public class 라이브러리_1 {
	public static void main(String[] args) {
	
		int count=135;
		int totalpage=(int)(Math.ceil(count/10.0));
		
		
		
		System.out.println(totalpage);
		
	}
	
}
