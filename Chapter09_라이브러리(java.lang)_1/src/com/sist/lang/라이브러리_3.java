package com.sist.lang;
/*
 
 Wrapper
 		: 기본형데이터를 클래스화 시켜서 사용이 편리하게 만들어주는 클래스
 		byte -> Byte
 		short -> Short
 		int -> Integer
 		long -> Long
 		double -> Double
 		float -> Float
 		char -> Char
 		boolean -> Boolean
 		
 		목적 : 문자열이 들어왔을 때 변환하기 위해서
 	  		: 데이터의 통일화 (제네릭스)
 	  						<클래스형> ex) <Integer>
 	  	  	: 일반 기본형과 호환
 	  	  		Integer i = 10;  /  int i=10;
 				Integer i = (int)10.5;
 			
 
 */
import java.util.*;
public class 라이브러리_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		Integer i = scan.nextInt();
		
		//8진법
		System.out.println(Integer.toOctalString(i));
		//16진법
		System.out.println(Integer.toHexString(i));
		//이진법
		System.out.println(Integer.toBinaryString(i));
		//정수의 법위(데이터형의 범위)
		System.out.println(Integer.MIN_VALUE); //최소 
		System.out.println(Integer.MAX_VALUE); //최대
		
		System.out.print("첫번째 문자열 입력 : ");
		String s1=scan.next();
		System.out.print("두번째 문자열 입력 : ");
		String s2=scan.next();
		
		System.out.println("s1+s2 : "+s1+s2);
		System.out.println("Integer.parseInt 사용 : "+(Integer.parseInt(s1)+Integer.parseInt(s2)));
		
	}

}
