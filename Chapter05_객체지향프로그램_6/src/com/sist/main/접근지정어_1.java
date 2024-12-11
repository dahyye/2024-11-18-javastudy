package com.sist.main;

import java.util.Arrays;

/*
 	패키지(폴더) : 관련된 클래스를 모아서 관리
 	com.회사명.클래스종류
 			----------
 				=> vo : 사용자 정의 데이터형
 				=> dat : 오라클 연동 ( 테이블당 1개)
 				=> manager : Open API, 크롤링
 				=> model : 브라우저 연결 => 데이터 전송
 			 ** => commons : 공통으로 사용되는 기능
 					중복제거 -> static -> 공통모듈
 			 ** => service : dao+model
 			 ** => controller : 사용자 요청 => model
 		윈도우
 		=> view : 화면 UI
 		=> dao / vo / controller 
 
 		=>client / server
 		
 		
 		회원가입
 			오라클 연결 =>static
 			데이터를 오라클 전공 =>iINSER
 			오라클 닫기 =>static
 		회원수정
  			오라클 연결 =>static
 			데이터를 오라클 전공 => UPDATE
 			오라클 닫기 =>static		
 		회원탈퇴
 			오라클 연결 =>static
 			데이터를 오라클 전공 =>DELETE
 			오라클 닫기 =>static
 			
 			 
 */

class Util
{
	//중복없는 난수 => 예약 가능한 날짜를 임의로 설정
	//값 읽기(get), 값 설정(set), 존재여부(is)=>boolean, 삭제(작은단위 remove, 큰단위 delete()
	public int[] getRand(int count)
	{
		int[]com=new int[count];
		for(int i=0;i<com.length;i++)
		{
			com[i]=(int)(Math.random()*100)+1;
			for(int j=0;j<i;j++)
			{
				if(com[i]==com[j])
				{
					i--;
					break;
				}
				
			}
		}
		return com;
	}
	
	public void getRand(int[] com)
	{
		for(int i=0;i<com.length;i++)
		{
			com[i]=(int)(Math.random()*100)+1;
			for(int j=0;j<i;j++)
			{
				if(com[i]==com[j])
				{
					i--;
					break;
				}
				
			}
		}
		//return com;
	}
	
//	public void display()
//	{
//		System.out.println("display() 진입 2 6");
//		
//		System.out.println("display 기능처리 3 7");
//		
//		
//		System.out.println("display() 종료 4 8");
//	}
	
}
public class 접근지정어_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Util util = new Util();
		int day=(int)(Math.random()*16)+5;
		int[] arr= new int[day];
		util.getRand(arr);
		Arrays.sort(arr);
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		
		
//		int day=(int)(Math.random()*16)+5;
//		int[] arr = util.getRand(day);
//		//			 객체명.메소드(값)
//		Arrays.sort(arr);
//		for(int i:arr)
//		{
//			System.out.print(i+" ");
//		}
		
//		System.out.println("main에서 display호출 전 1");
//		util.display();
//		System.out.println("main에서 display호출 완료 5");
//		util.display();
//		System.out.println("main 종료 9");
	}

}
