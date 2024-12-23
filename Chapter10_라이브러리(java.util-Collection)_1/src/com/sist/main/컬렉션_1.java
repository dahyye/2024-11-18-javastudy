package com.sist.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/*
 
 	자바 컬렉션
 	---------
 	1. 프로그램 => 데이터관리 (효율적)
 				 -------
 				 1) 스프링 / JSP(MVC) => 데이터관리
 				 	=>  데이터베이스(오라클, MySql)
 				 
 				 2) VueJS / React / Next / Node
 				 	=> 상태관리 ( 데이터가 변경시마다 )
 	
 	2. 데이터베이스 : 데이터를 저장하는 공강
 	
 		-----------------
 		변수 / 상수 => 데이터 한개 저장후 관리 => 데이터가 많으면 관리가 어렵다
 		-----------------
 		배열 => 고정적 => 데이터증가시 새로 배열을 생성해야 함
 		-----------------
 		가변적 => 데이터증가시 자동으로 메모리공간 확장
 		-----------------
 		---------------
 		파일 => 종속적이다 => 다른 파일을 연결해서 사용이 어렵
 		---------------
 		RDBMS => 오라클 ( 관계형 데이터베이스 => 연결성 )
 		---------------
 		=>> 웹에서 가장많이 사용되는 클래스 : ArrayList / String / Map 
 		=> ArrayList는 데이터를 메모리에 저장 후 브라우저로 전송
 		=>웹은 대부분이 Map형식으로 되어 있다 
 			request / response / session / cookie		=> 전부 Map형식으로 저장되어 잇다
 			  요청		응답		  서버저장	  브라우저저장
 		
 		
 	=================================================================================
 	
 	1. Collection 개요
 		=> 배열의 단점을 보완한 클래스 ( 고정형=>가변경데이터 )
 		
 		데이터를 효율적으로 저장하고 관리하기 위한 라이브러리
 		표준화가 되어 있다 ( 모든 개발자가 같은 메소드를 사용)
 		---- 개발이 쉽다
 		---- 프레임워크 => 개발 형식을 통일할 때 사용 ( 스프링 / React / JQuery / Vue ...)
 						=> 분석이 쉽다 => 가독성이 좋다
 		
 		컬렉션은 저장=> Object만 저장(객체만 저장)
 					=> Object가 최상위 데이터형식이기 때문에 항상 형변환 필요
 						ex. 
 							class Sawon
 							{
 								ArrayList list = new ArrayList()
 								list.add(new Sawon) => 오브젝트로 받아
 								Sawon s=list.get(0); => 오류발생
 								  ==>   (Sawon)list.get(0)으로 강제 형변환 시켜줘야해
 			
 	
 	2. Collection 종류
 		
 		List 			
 			ArrayList => 데이터베이스연동
 				순서가 존재(자동으로 인덱스 저장)
	 			데이터 중복 허용
	 			가장 많이 사용되는 컬렉션
	 			비동기적인 방식 
	 				-> 데이터베잉스(오라클)
	 				-> 장점 : 접근 속도가 빠르다
	 				-> 단점 : 데이터가 많을 때 추가, 삭제를 하게 되면 속도가 늦다(인덱스번호 조정때문에) 
	 					=> 데이터 추가시 중간이 아닌 마지막에 추가하는 걸 권장
 			Vector => 네트워크에서 주로 사용
 				Vector를 보완한게 ArrayList
 				동기적 => 네트워크 사용자 정보를 저장			
 				
 			LinkedList => 파일연동
 				데이터에 접근하는 속도가 늦다
 				추가 / 삭제가 빠르다
 				(게시판에서 사용하기 좋아)
 				|
 			   Queue
 			   
 			   		
 			   					ArrayList			LinkedList
 			   	---------------------------------------------------
 			  데이터접근 속도			빠름					느림
 			  데이터(추가/삭제)			느림					빠름
 			  메모리사용 				효율적				비효율적
 			   구조					배열기반				연결리스트기반
 			   
 			   
 			   
 			 ArrayList의 주요 메소드
 			 	1) 데이터 추가
 			 		list.add(Object obj) 
 			 		list.add(int index, Object obj)
 			 	2) 저장된 갯수
 			 		list.size()
 			   	3) 데이터 추출
 			   		list.get(int index)
 			   	4) 데이터를 삭제 
 			   		list.remove(int index)
 			   	5) 데이터를 수정
 			   		list.set(int index, Object obj)
 			   => CRUD : 자료구조 (효율적으로 사용)
 			   => import를 사용한다
 			   		import java.ArrayList
 			   => List => 구현한 클래스 변경이 쉽게 인터페이스를 이용하는 경우
 			   => 단점 : 항상 형변환을 해줘야한다
 			   			-------
 			   			데이터형을 Object가 아닌 데이터형으로 변환 -> 제네릭스
 			   
 		Set
 			HashSet
 			TreeSet
 				
 		Map
 			HashMap
 			HashTable
 			    |
 			Properties
 	
 	3. 제네릭스
 	4. 활용 => 크롤링 / 중복제거 / ArrayList와 ArrayList
 							  --------------------
 							  교집합 / 차집합 / 합집합(중복제거)
 						 Intersect / Minus / Union
 	
 
 
 
 */
public class 컬렉션_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList ilist = new ArrayList();
		//경고 -> Arraylist는 항상 제네릭스를 해야하는데 안해서
		ilist.add("홍길동");
		ilist.add("심청이");
		ilist.add("강감찬");
		ilist.add("박문수");
		ilist.add("춘향이");
		
		System.out.println("현재 등록된 인원 : "+ ilist.size());
		for(int i=0;i<ilist.size();i++)
		{
			String name = (String)ilist.get(i);
			System.out.println(i+"." + name);
		}
		
		System.out.println("=======원하는 위치에 데이터 추가======");
		ilist.add(2, "이순신");
		System.out.println("현재 등록된 인원 : "+ ilist.size());
		for(int i=0;i<ilist.size();i++)
		{
			String name = (String)ilist.get(i);
			System.out.println(i+"." + name);
		}
		
		System.out.println("=======원하는 위치에 데이터 삭제======");
		ilist.remove(3);
		System.out.println("현재 등록된 인원 : "+ ilist.size());
		for(int i=0;i<ilist.size();i++)
		{
			String name = (String)ilist.get(i);
			System.out.println(i+"." + name);
		}
		
		//데이터 추가 삭제시 인덱스번호 자동 변경 => 오라클은 자동 처리가 안된다 ( 출력 )
		
		System.out.println("=======원하는 위치에 데이터 수정======");
		ilist.set(2, "심청이수정");
		System.out.println("현재 등록된 인원 : "+ ilist.size());
		for(int i=0;i<ilist.size();i++)
		{
			String name = (String)ilist.get(i);
			System.out.println(i+"." + name);
		}
		
		System.out.println("========== 전체삭제 ==========");
		ilist.clear();
		System.out.println("현재 등록된 인원 : "+ ilist.size());
		if(ilist.isEmpty()) // 장바구니 구현할 때 사용
		{
			System.out.println("저장공간이 비워져있다");
		}
		else
		{
			System.out.println("저장공간에 데이터가 존재합니다");
		}
		
		
		
		
		
		ArrayList alist = new ArrayList();
		LinkedList list = new LinkedList();
		
		for(int i=0;i<100000;i++)
		{
			alist.add(i);
			list.add(i);
		}

		System.out.print("ArrayList Access시간 : ");
		
		
		long start = System.currentTimeMillis();
		for(int i=0; i<alist.size();i++)
		{
			alist.get(i);
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		System.out.print("LinkedList Access시간 : ");
		start = System.currentTimeMillis();
		for(int i=0; i<list.size();i++)
		{
			list.get(i);
		}
		end = System.currentTimeMillis();
		System.out.println(end-start);
		
		System.out.print("ArrayList 데이터추가시간 : ");
		
		
		start = System.currentTimeMillis();
		alist.add(50000, "데이터");
		alist.remove(2);
		end = System.currentTimeMillis();
		System.out.println(end-start);
		
		System.out.print("LinkedList 데이터추가시간 : ");
		start = System.currentTimeMillis();
		list.add(50000, "데이터");
		list.remove(2);
		end = System.currentTimeMillis();
		System.out.println(end-start);
	}

}
