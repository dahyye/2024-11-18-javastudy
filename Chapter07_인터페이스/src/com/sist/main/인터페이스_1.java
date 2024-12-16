package com.sist.main;
/*
 	인터페이스
 	-------
 	1. 인터페이스는 추상클래스의 일종이다(클래스와 동일하게 취급)
 	2. 추상클래스 : 단일 상속
 	   인터페이스 : 다중 상속
 	3. 인터페이스는 변수가 아닌 상수만 사용한다
 				 구현이 안된 메소드만 존재한다.
 	4. 서로 다른 클래스를 모아서 한 개의 이름으로 연결
 	5. 결합성이 낮은 프로그램 구현 -> 유지보수가 뛰어나다
 			인터페이스를 수정하면 관련된 모든 클래스에 오류가 발생
 			인터페이스는 고정해야 한다
 			
 	6. 인터페이스는 변수나 메소드가 모두 public
 	
 		ㅇㅖ)
 			public interface interface명
 			{
 				int a=0; int 앞에 (public static final)이 생략되어 있다
 				------------------상수형
 				void display(); (public abstract)
 				-------------------구현이 안된 메소드
 				default void aaa()  (public)
 				{
 				}
 				static void bbb()   (public)
 				{
 				}
 		
 		상속받아서 구현 -> 오버라이딩
 		1. 메소드명 동일
 		2. 메개변수 동일
 		3. 리턴형 동일
 		4. 접근지정어는 확대할 수 있다 (축소하면오류)
 		
 			private < default < protected < public 
 			
 			interface A
 			{
 				void display(); //public 이 안보이지만 생략되어 있다
 			}
 			
 			class B implements A
 			{
 				public void display()  // public을 안쓰면 default값으로인식하기 때문에 
 										//꼭 public을 사용해줘야해
 				{
 					
 				}
 	
 		
 		상속
 				  extends
 		interface ====> interface 
 				implements
 		interface ====> class
 				(x)
 		class =====> interface
 		
 		
 		interface A
 		interface B extends A
 		interface C extends B
 
 
 		=> interface는 다중상속이기 때문에
 			interface A
 			interface B
 			interface C extends A,B
 			
 		interface A
 		interface B
 		class C
 		class D extends C interface A,B
 		
 		 ex. class Window extends JFrame implements
 		 							KeyListener, MouseListerner
 		 							
 			인터페이스가 가장 많은 곳이 
 			window(버튼, 마우스 등 이벤트관련은 구현이 안되어 있다)
 			쓰레드 : 동작을 개발자가 만들어야해
 			데이터베이스 연결
 			웹 연동
 			
 			
 			
 			
 */

interface A
{
	public static int a=1;
	
	void aaa(); //public abstract 
	
	default void bbb() //public 생략
	{
		
	}
	
	
}

class B implements A
{
	public void aaa(){}
}

public class 인터페이스_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
