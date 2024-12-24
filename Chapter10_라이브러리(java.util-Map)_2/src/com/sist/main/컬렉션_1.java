package com.sist.main;
/*
 	Collection Framework
 	1) 다수의 데이터를 쉽고 효율적으로 처리가 가능하게 만든
 		--------
 		표준화된 클래스 집합( 자바에서 지원 라이브러리 )
 	2) 자료구조 => CRUD(읽기/추가/삭제/수정)
 	3) 배열의 단점 보완 => 고정 => 가변
 	 	=> 동적으로 변환(메모리 추가, 삭제 자동 조절)
 	4) 단점 => 모든 데이터를 저장할 수 있다
 			  -------- 제어하기 어렵다 ( Object )
 			  한가지 데이터형만 저장해서 사용하는 것을 권장
 			  ----------------
 			  제네릭을 이용한다
 	=> 제네릭
 		1) 데이터형 통일화(Object=>원하는 데이터형으로 변경)
 		2) 소스가 간결하다
 		3) 어떤 데이터를 저장하는지 확인이 가능(명시적)
 		4) 형변환이 필요없다
 		5) 컬렉션에서 주로 사용
 		6) 제네릭을 지정시에는 반드시 클래스형으로만 사용이 가능
 			=> 기본형은 사용할 수 없다
 			   ----------------- 자바에 지원 => Wrapper
	   		   Wrapper : 기본형을 클래스화
	   		   T   /   E   /   K   /   V  
	   		  type	element	  key	  value  
 			  클래스	클래스	
 			  
 			  
 			List			Set				Map
 			순서가있다		순서가 없다 	  	key, value를 동시에 저
 			중복허용		중복불가			key-중복없다 value-중복가능
 			
 
 		List-ArrayList : 데이터베이스(목록)
 						 브라우저로 전송
 						 웹
 		
 		LinkedList	: 수정 / 삭제 / 추가시 속도가 빠르다
 					  => 일반 윈도우 ( 게시판 )
 					  
 		Vector : 동기화 => 네트워크
 		---------------------------------------		 
 		==> add() , set(), get(), remove()
 		----------------------------------> CRUD
 										create / read / update / delete
 							오라클에서는:  INSERT / SELECT / UPDATE / DELETE
 		size() isEmpty() clear() addAll() subList() 
 		
 		
 		Set
 		*** => HashSet
 		=> TreeSet
 		1) List 데이터중에 중복제거
 		   ------------------- DITINCT
 		2) 순서가 없다
 		3) 데이터 중복을 허용하지 않는다
 			=> id / 장바구니
 			   ----------- Map
 			=> 장르 / 부서 / 직위
 		4) HashSet : 접근이 빠르다
 		   TreeSet : 정렬 / 검색
 		5) 주요메서드
 			add() remove() clear() iterator():한번에 데이터 모아서 출력
 			headSet() tailSet()
 			--------- 최신방문
 		 
 */

import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor

class Sawon
{
	private int sabun; 
	private String name;
	
//	public int getSabun() {
//		return sabun;
//	}
//	public void setSabun(int sabun) {
//		sabun = sabun;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public Sawon(int sabun, String name) {
//		sabun = sabun;
//		this.name = name;
//	}
//	@Override
//	public int hashCode() {
//		// TODO Auto-generated method stub
//		return (sabun+name).hashCode();
//	}
//	@Override
//	public boolean equals(Object obj) {
//		// TODO Auto-generated method stub
//		if(obj instanceof Sawon)
//		{
//			Sawon s = (Sawon)obj;
//			return name.equals(s.name)&& sabun==s.sabun;
//		}
//		return super.equals(obj);
//	} 
//	
	
}
public class 컬렉션_1 {
	Sawon s1 = new Sawon(1,"홍길동");
	Sawon s2 = new Sawon(1,"홍길동");
	//
	Set<Sawon> set = new HashSet<Sawon>();
	/*
	 	HashSe<Sawon> set = new HashSe<Sawon>();
	 	Set<Sawon> set = new HashSet<Sawon>();
	 	//인터페이스로 접근 => 이렇게 쓰는 이유 : 유연성
	 	 	set = new TreeSet(Sawon);
	 	 	
	*/
}
