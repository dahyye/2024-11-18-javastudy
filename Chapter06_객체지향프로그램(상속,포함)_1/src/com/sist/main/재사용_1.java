package com.sist.main;

/*
 	제어어 
 	static  : 공통적인
 	final : 마지막인 => 상수 / 변경하지 않는 메소드
 	abstract : 추상적인 => 공통 기반
 	synchronized : 동기적인 => 쓰레드
	
	194page 6장 상속!!
	
	상속(웹, 스프링 => 사용빈도 거의 없다)
	-------------------------------
	상속 : 목적 / 형식 / 메모리구조
		=> 목적
		기존의 클래스(이미 만들어져 있는 클래스) => 신뢰성이 뛰어나다
			=라이브러리 클래스
			=사용자정의 클래스
		재사용을 할 때 / 변경 사용, 추가 사용
		=> 반복제거 / 소스를 줄이는 경우
		=> 상송에서는 예외조건
		1. 생성자 2. static 3. 초기화블럭
		** 상속은 된다 하짐나 사용을 못해 => private(protected)
		
	 	형식
	 	clss A
	 	calss B extends A
	 		 (자식)     (부모)

		=> 상속을 내리는 클래스
			부모클래스, 슈퍼클래스, 베이스클래스
		=> 상속을 받는 클래스
			자식클래스, 서브클래스, 파생클래스
			
		=> 클래스의 크기가 결정 => 형변환
		   ----------
		   상속 내리는 클래스 > 상속 받는 클래스
		   
		   
		   class A
		   {
		   		int a,b;
		   }
		   
		   class B extends A
		   {
		   		int c;
		   		//보이지 않지만 int a,b도 있다고 생각해야해
	
		   }

			A
			↑	A가 부모클래스 B가 자식클래스
			B	화살표 방향 잘 기억하기

			***상속을 내리는클래스 => 상속받은 클래스의 변수나 메소드 제어 불가
			    -------------
			    this, super 둘 다 가지고 있어
			    근데 상속을 내리는 클래스의 super는 object에 대한것
			    자바의 모든 클래스는 Object로부터 상속을 받아 
			    
				but 상속을 받는 클래스 => 상속내린 클래스는 제어할 수 있다
					--------------
					this(자신것 제어), super(상속받은것)
					
					
			* 자바에서 자동으로 추가하는 것들
				import java.lang.* => String, System..
				class A extends Object
				자바의 모든 라이브러리는 예외처리를 가지고 있다(생략하고 있어서 안보이는 것)
				
	201page
	상속특징
		단일 상속 수정가능(변수오버라이딩, 메소드오버라이딩)
		상속을 두개이상 받는 경우
			class A
			class B
			class C extends A,B => 오류
			
			class A extends
			class B extends A  => 이렇게 상속받아야해
			class C extends B
			
			
					A
					|
				---------
				|		|
				B		C
				|		|
			---------   ----------
			|		|	|		 |
			D		E	F		 G
			
			상속의 단점 속도가 느려진다
			영향력이 많이 존재
			
 */
class Sawon // extends Object 가 생략되있다고 생각하면 된다
{
	public Sawon()
	{
		System.out.println("사원객체생성!");
	
	}
	public void display()
	{
		System.out.println("사원객체활용");
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		//소멸자 함수
		System.out.println("객체 소멸!");
	}
	
}
public class 재사용_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sawon sa = new Sawon();
		sa.display();
		sa=null;
		System.gc(); //메모리를 회수해라
	}

}
