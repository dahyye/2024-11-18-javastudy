package com.sist.main;
/*
 	멜론 / 지니뮤직
 	------------- 따로 저장
 	
 	=join => 교집합
 	=union => 합집합
 	=minus => 차집합
 	
 	컬렉션 : 배열의 단점을 보완
 	
 	set : hashSet / TreeSet
 		순서가 없다
 		데이터의 중복을 허용하지 앟는데
 		중복제거할 때 사용
 	
 	Map : HashMap / HashTable
 		두 개를 동시에 저장(키, 값)
 		키는 중복할 수 없다 / 값은 중복이 가능
 		웹 -> 클래스 관리자
 		=> HttpServletRequest
 		   HttpServletResponse
 		   HttpSession
 		   Cookie
 		   --------------------Map
 		   => 스프링 / MyBatis
 		  
 	
 	ArrayList
 		=> 복사
 		   addAll()
 		
 		=> 순차적으로 출력하는 방법
 		   iterator()
 		   listIterator
 		   => 출력이 어려운 경우
 		=> Set <=> 복사가 가능
 		
 	ArrayList 
 		단순한 목록형 데이터를 관리하기 용이
 		---------------
 		데이터베이스(오라클)
 		추가/삭제/수정이 없는데이터
 	
 		  
 
 
 */
import java.util.*;


public class ArrayList_정리 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("박문수");
		list.add("심청이");
		list.add("강감찬");
		list.add("심청이");
		list.add("홍길동");
		list.add("박문수");
		//중복된 데이터 출력 가능
		for(String name:list)
		{
			System.out.println(name);
		}
		System.out.println("===== 복사 =====");
		
//		ArrayList<String> list2 = new ArrayList<String>();
//		list2.addAll(list);
//		for(String name:list2)
//		{
//			System.out.println(name);
//		}
		
		Set set = new HashSet();  
		set.addAll(list);
		//중복을 허용하지 않는다 => 순차적이 아니라서 관리하기 어렵다
		// 중복제거할 땐 Set을 사용했다가 다시 ArrayList로 바꿔줘야 데이터 관리가 쉽다
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.addAll(set);
		for(String name:list2)
		{
			System.out.println(name);
		 }
		
	}
	
}
