package com.sist.main;

import java.util.ArrayList;

/*
 	논리적 관계
 	1. 상속 : is-a
	 	class 동물{}
	 	class 개 extends 동물{}
	 	
	 	개가 동물을 상속받았다 => 개는 동물이다 
	 	논리적으로는 부모클래스가 더 큰 개념
	 	
 	2. 포함 : has-a ( 클래스안에 클래스를 포함 )
 	
 	221page~
 		
 	상속 형변환
 		상위클래스 객체 = new 하위클래스생성자()
 		double d=10; => 10.0으로 자동형변환
 		
 		int a = 10.0 => 하위클래스가 더 크면 오류
 		int a = (int)10.0 => 강제 형변환 
 		하위클래스 객체 = (하위클래스) new 상위클래스() => 오류
 			라이브러리는 클래스를 리턴할 경우 
 						Object로 받는다
 */

class Sawon
{
	String name;
	String dept;
	String loc;
	
	public void display()
	{
		System.out.println("이름 : "+name);
		System.out.println("부서 : "+dept);
		System.out.println("근무지 : "+loc);
	}
}
public class 재사용 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList(); //ArrayList는 Object클래스
		//ArrayList<Sawon> list = new ArrayList<Sawon>(); //ArrayList는 Object클래스
		Sawon s1 = new Sawon();
		s1.name = "홍길동";
		s1.dept = "개발부";
		s1.loc = "서울";
		list.add(s1);
		//list.add(10);
		Object obj = list.get(0);
		Sawon s = (Sawon)list.get(0); //상위클래스로 받았기 때문에 강제 형변환 필요
		s.display();
	}

}
