package com.sist.main;
/*
 	추상클래스
 	=미완성 클래스 : 자신이 메모리 할당을 할 수 없다
 	 ---------
 	 abstract class A  => A a=new A(); 오류!!
 	 
 	=> 추상 클래스
 		기능이 여러가지인 경우 : 프로그램에 맞게 구현
 		----------------
 		마우스 : 업체 => 운영체제에 맞게 구현하려면 MS사에서 제공하는 추상 클래스를 구현
 		
 		--------------------------------------------------------------
 		데이터베이스의 모든 클래스는 추상클래스로 만들어져 있다
 		 => 개발자가 데이터베이스에 맞게 구현
 		 => 오라클 / MySQL / MariaDB......
 		 //실무에 나가면 오라클은 비용이 비싸서 MySQL이나 MariaDB를 사용하는 경우가 많아
 		  * SQL문장은 표준화(데이터형, 함수)
 		
 		public abstract class ClassName
 		{
 			public abstract 리턴형 메소드명(매개변수..);
 		}
 		
 	1. 추상클래스는 클래스마다 같은 메소드인데 따로 구현해야할 때 사용
 	2. 필요시마다 구현해야 한다
 	3. 멤버변수도 가지고 있다
 	4. 메모리 할당은 반드시 상속받은 클래스를 이용한다
 	5. 관련된 클래스를 모아서 관리
 	6. 미완성 클래스(메소드구현이 없는 경우)
 	7. 추상메소드가 없을 수도 있다
 	
 	 		
 	         ( 발전 )
 	   추상클래스 => 인터페이스
 	=> 단일 상속 => 다중 상속
 	=> 뱐스 => 상수
 	=> 기본 => 다른 클래스에 영향이 없게 만드는 클래스
 */
public class 추상클래스_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
