package com.sist.main;
/*
 
 	추상클래스
 		=> 구현이 안된 메소드를 가지고 있다
 		=> 객체를 직접 생성이 불가능
 		=> 사용시에는 상속을 받은 하위 클래스에서 확장해서 사용
 		=> 역할 / 필요성 
 			상속을 통해서 코드를 재사용 => 강제로 메소드 구현을 하는 역할
 									-----------------------
 									  확장성 / 유지보수가 용이
 									  상속을 받아서 오버라이딩(기능변경)한다
 		
 		=> 형식
 			public abstract class ClassName
 			{
 				---------------------------------
 				변수(멤버변수, 정적변수)
 				---------------------------------
 				생성자 : 변수 초기화
 				---------------------------------
 				구현된 메소드 : 필요시에만 오버라이딩 
 							=> 있는 그대로 사용이 가능
 				---------------------------------
 				미구현 메소드 : 상속시에 강제로 구현
 				---------------------------------
 			}
 			==> 관련이 있는 클래스를 여러개 모아서 관리	
 				--------------
 				기능이 비슷한 클래스
 				--------------- 웹 (Model)
 				Model -> 사용자 요청처리 => 결과값을 브라우저로 전송
 				=> 소스가 간결하다(조건문 없이 사용이 가능)
 				-=> Map 클래스를 이용해서 클래스를 싱글턴으로 처리(메모리 절약)
 			
 		
 		인터페이스 : 추상클래스의 단점을 보완한 클래스의 일종
 		------ 자바에서 객체가 어떻게 행동해야(동작)하는지 정의한 타입
 				=> 주로 메소드만 사용한다
 				=> 이런 기능을 가지고 있다 하는 기능설계
 				=> 사전적 의미 : 결합성(서로 다른 클래스 연결해서 사용)
 							  접속기(리모컨역할)
 			    => 컴퓨터와 사용자간의 통신 (API)
 			    => 장점
 			    	1. 코드의 표준화 : 같은 메소드를 사용(내용구현은 다를 수 있다)
 			    	2. 설치만 되어 있다 : 프로그래머가 구현해서 사용
 			    	3. 다른 클래스와 연결시 편리하다
 			    	4. 결합성을 낮게 만든다
 			    	5. 다중 상속이 가능하다
 			    	6. 소스의 통일화 => 분석이 쉽다
 			    	   ---------
 			    	   FrameWork(형식이 동일)
 			    	   | 스프링/Jquery/VueJS/Sokcet
 			    	7. 독립적으로 사용이 가능(원격) : ServerSocket / Socket
 			    	8. 유지보수가 쉽다
 			    	9. 여러개 클래스를 모아서 관리할 수 있다(한개의 객체명으로 제어)		
 				
 				
 				형식
 				public interface interface명
 				{
 					-----------------------------------
 					변수 => 상수형 변수만 사용이 가능
 					(public static final) 데이터형 변수명=값;
 					      생략가능
 					-----------------------------------
 					구현이 안된 메소드
 					(public abstract) 리턴형 메소드명(매개변수);
 					-----------------------------------
 					구현이 되어 있는 메소드
 					default 리턴형 메소드(매개변수)
 					{
 					}
 					-----------------------------------
 					static 리턴형 메소드(매개변수)
 					{
 					}
 					-----------------------------------
 				}
 				
 			컴파일러가 자동 추가하는 소스
 			1. import java.lang.*;
 					 ----------- String, System....
 			2. 모든 클래스는 Object클래스를 상속받는다
 			3. 메소드에서 void는 return을 생략하는데
 				이 경우 자동으로 추가되어 있다고 생각하면 된다
 				public void display()
 				{
 					return;//생략
 				}
 			4. 인터페이스에서
 			 	변수 -> public static final이 생략
 				메소드 -> public abstract
 				default -> public
 				static -> public 
 		
 				추상클래스				인터페이스
 		상속		단일상속				다중상속
 				extends				implements
 		
 					 
 			인터페이스 -> 인터페이스 extends
  			인터페이스 -> 클래스	   implements
 			클래스 	-> 인터페이스 (x)
 			
 		
 		다중상속(보통 윈도우나 네트워크에서 많이 나와/웹에는 많이 사용x)
 		interface A
 		interface B
 		class c implements A,B -> 다중상
 				
 				
 */
interface I
{
	public void aaa(); //강제성 무조건 오버라이드해야해
	//public생략
	default void ccc()
	{
		
	}// 필요하면 가져다쓰고 아님말고
	//public생략
	static void ddd()
	{
		
	}
}
class A implements I
{

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
	
	}
	
}
class B implements I
{

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}
	
}
class C implements I
{

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}
	
}
public class 정리_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
