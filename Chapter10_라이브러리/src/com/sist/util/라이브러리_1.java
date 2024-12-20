package com.sist.util;
/*
 	10장
 	
 	java.lang : 자바 기본이 되는 클래스의 집합
 	--------- Object / String StringBuffer
 			  Math / Wrapper(Integer/Double/Boolean)
 	java.util : 프로그램에서 많이 사용되는 유용한 클래스의 집합
 	=> 반드시 import 사용
 		1. 날짜
 			Date => Calendar(보완)
 		2. 문자열 분리
 			StringTokenizer : split => 정규식
 		3. 랜덤
 			Random
 		4. Collection => 자료구조
 			
 			Collection
 				|
 		------------------------
 		|			|			|
      List			Set			Map
 		|			|			|
 	ArrayList		HashSet		HashMap
 LinkedList-Queue	treeSet		HashTable
 	vector	
 		
 	java.io : 입출력(메모리/네트워크/파일)
 	java.net : 네트워크(socket, URL)
 	java.text : 변환(문자열, 날짜, 숫자)
 	java.lang.reflect : 정규식
 	java.sql : 데이터베이스 연동
 	--------------------------------
 	웹 / 오픈소스(외부 라이브러리)
 		 org / com
 
 
 */
import java.util.*;
//Scanner은 잘 안쓸예정 -> 입력창이 만들어 질 예정이라서
public class 라이브러리_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		// r.nextInt() => int 전체
		// r.nextInt(100) =>0~99
		// r.nextInt(100) =>1~100
//		int i=r.nextInt(100)+1;//1~100
//		System.out.print(i);
		
		int[] com = new int[6];
		for(int i=0;i<com.length;i++)
		{
			com[i] = r.nextInt(45)+1;
			for(int j=0;j<i;j++)
			{
				if(com[i]==com[j])
				{
					i--;
					break;
				}
			}
		}
		
		Arrays.sort(com); //배열에 대한 제어 //java.util에 들어있다
		//출력
		for(int i:com)
		{
			System.out.print(i+" ");
		}
		
		System.out.println();
		for(int i=com.length-1;i>=0;i--)
		{
			System.out.print(com[i]+" ");
		}
		
	}

}
