package com.sist.main;
/*
 
 	인터페이스의 사용 목적 
 	= 서로 다른 클래스를 묶어서 한개의 인터페이스명으로 연결
 		-> 리모컨의 역할
 	= 결합성이 낮은 프로그램
 	  ---------- 수정시에 다른 클래스가 오류...(영향이 없는)
 	  ==> 스프링(로드존슨)
 	= 개발자들이 같은 메소드를 사용 : 표준화
 	= 독립적으로 사용이 가능
 	=확장이 가능 (최근에 jdk1.8부터 확장이 가능)
 		default/static -> 구현된 메소드 처리가 가능하다
 		--> 추상 클래스 대신으로 인터페이스를 쓰기 때문에 추상클래스가 거의 사용되지 않는 분위기
 	= 여러개 기능을 동시에 상속가능(다중상속)
 	= 인터페이스는 자신이 메모리 할당을 할 수 없다
 		-> 상속받은 클래스가 미구현된 메소드 구현 후 사용
 	   	-> 오버라이딩 기법을 사용
 	= 인터페이스는 상속받는 모든 클래스가 반드시 동일한 기능을 가지고 있어야 한다 
 	
 	  	
 	  	
 	 인터페이스의 문법사항
 	 	1. 구성요소
 	 	 변수 : 모든 변수가 상수형만 사용가능(초기값을 반드시 지정)
 	 	 메소드 : 구현이 안된 메소드(추상메소드)
 	 	 ---------변수와 메소드는 only public 
 	 	 default , static 메소드는 구현 가능

 	   	2. 구현 후 객체 생성
 	   		interface A
 	   		class B implements A
 	   			 하위			  상위
 	   			
 	   			A a = new B();
 	   		
 	   	
 	   	
 */
interface A
{
	public void aaa();
	public void bbb();
	public void ccc();
	public void ddd();
	public void eee();
	
}

public class 인터페이스_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//익명의 클래스
//		A a = new A() {
//
//			@Override
//			public void aaa() {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void bbb() {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void ccc() {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void ddd() {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void eee() {
//				// TODO Auto-generated method stub
//				
//			}
//			
			
		
	}

}
