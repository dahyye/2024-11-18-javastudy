package com.sist.lib;

import java.util.Objects;

/*
 * 
 	Object 클래스는 모든 데이터형(기본형), 모든 클래스 대입이 가능
 									-> 사용시에는 반드시 형변환
 									-> 라이브러리 => 클래스를 매개변수, 리턴형으로 사용시
 												   대부분이 Object형으로 되어있어
 	
 	
 	toString() 주소값출력
 	clone() 복제해서 새로운 메모리에 저장
 	equals() 객체비교(기본은 주소값, 오버라이딩해서 변수비교가능)
   --------------- 위에 3개 중요 ------------------------
 	finalize() 소멸자 함수(객체 메모리 해제 -> 자동호출)
 	hashCode() 객체마다 구분 번호를 가지고 있다
 	
 */
//hashCode() 객체의 구분자
class Member2
{
	private int mno;
	private String name;
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//초기화
	public Member2(int mno, String name) {
		
		this.mno = mno;
		this.name = name;
	}
	
	public void print()
	{
		System.out.println("회원번호 : "+ mno);
		System.out.println("이름 : "+name);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		
		
		return Objects.hash(mno, name);
	}
	
	
	
	
}
public class 라이브러리_Object_5 {
	public static void main(String[] args) {
		
		Member2 m1 = new Member2(1, "박문수");
		Member2 m2 = new Member2(1, "박문수");
		
		System.out.println("m1 : "+m1);
		System.out.println("m2 : "+m2.toString());
		System.out.println("m1_hash : "+m1.hashCode());
		System.out.println("m2_hash : "+m2.hashCode());
		
		//주소값이 달라
		/*
		m1 : com.sist.lib.Member2@6a6824be
		m2 : com.sist.lib.Member2@3ada9e37
		m1_hash : 1785210046
		m2_hash : 987405879

		변경 후
		m1_hash : 47807637
		m2_hash : 47807637
	
		 */

		
		
		
	}
}
