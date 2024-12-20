package com.sist.lang;
/*
 	java.lang
 	
 	1. Object 
 	 	: 최상위 클래스 : 모든 클래스의 상위 클래스
 	      ----------
 	      관리하는 기능 : 객체와 관련
 	      객체 소멸 / 객체 복제 / 객체 비교 / 객체 생성
 		 finalize  clone	 equals   	getClass
 		 
 	2. String : 문자열 관리 클래스
 		=> 웹 3대 클래스
 			String / ArrayList / Integer
 			
 		=> 오라클 3대 클래스
 			Connection / ResultSet / Statement
 			
 			
 		기능
 		1) trim() : 공백제거
 		2) length() : 문자열 길이
 		3) subString() : 문자를 자르는 경우
 		4) indexOf() :문자 위치 찾기(앞부터)
 		   lastindexOf() : 문자 위치 찾기(뒤부터)
 		5) equals() : 문자열 비교
 		6) contains() : 포함여부
 		7) startsWith() : 시작문자열 -> 방문한 맛집 찾을 때 사용
 		   endsWith() : 끝 문자열
 	**	8) valueOf() : 다른 데이터형 문자열 반환
 		9) replace() : 문자열 변환 (한번만)
 		   replaceAll() : 문자열 변환 (모두)
 		10) split : 문자열 자르기
 		
 	3. StringBuffer
 	 
 	4. Math 
 		random() / ceil()
 		=> 모든 메소드가 static으로 만들어진다
 			Math.random() Math.ceil -> 객체생성없이 바로 사용
 	
 	5. System
 		println() print() printf() 
 		gc() exit()
 	
 	6. Wrapper
 		: 기본형데이터를 클래스화 시켜서 사용이 편리하게 만들어주는 클래스
 		byte -> Byte
 		short -> Short
 		int -> Integer
 		long -> Long
 		double -> Double
 		float -> Float
 		char -> Char
 		boolean -> Boolean
 */
import java.io.*;
import java.util.*;
public class 라이브러리_2 {

	public static void main(String[] args) {
		try {
//			// -> 로그파일만들 때 사용
			long start = System.currentTimeMillis();
			FileReader fr = new FileReader("c:\\javaDev\\movie.txt");
			int i=0;
		//	String data="";
			StringBuffer sb=new StringBuffer();
			//문자열 결합의 최적화
			//파일읽기 => 웹사이트 => JTML
			while(fr.read()!=-1)
			{
				sb.append((char)i);
				//data+=(char)i;
				
			}
			fr.close();
			String data = sb.toString();
			System.out.println(data);
			//System.out.println(data);
			//
			
			long end = System.currentTimeMillis(); //시간측정할 때 사용
			System.out.println("걸린시간: " + (end-start));
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}
	
}
