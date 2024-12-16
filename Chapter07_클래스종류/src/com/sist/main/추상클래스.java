package com.sist.main;
/*
 	
 	추상클래스
 		예를 들어 추상클래스로 예약프로그램을 설계
 			-> 자식클래스 (영화예약, 맛집예약, 항공사예약으로 사용)
 		주목적 : 관련된 클래스를 모아서 한 개의 객체명으로 관리
 				( 서로 다른 클래스를 연결해서 사용 )
 		
 		단점 : 단일상속만 가능
 			  미완성(메소드구현이 안된 경우)
 			  	-> new를 이용해서 객체를 생성할 수 없다
 			  상속을 받아서 메소드를 구현후에 사용
 			  	-> new구현된 클래스의 생성자() -> 오버라이딩기법을 사용
 			  = 선언된 메소드 + 선언이 안된 메소드
 		=> 유지보수가 어려운 프로그램에서 설계를 미리하고 들어갈 때 많이 사용	  
 		public abstract class ClassName
 		{
 			int age; //변수선업
 			
 			void generalMethod() //구현된 메소드
 			{
 				System.out.println("일반 메소드");
 			}
 			
 			abstract void abstractMethod(); //구현이 안된 클래스
 			
 		}

		==> 상속받을 클래스에서 사용방법
		
		class AbstractchildClass extends AbstractClass
		{
			@Override
			void abstractMethod()
			{
				System.out.println("추상 메소드 구현");
			}
		}
 
 		==> 메인
 		
 		public class AbstractMain{
 			public static void main(String args[]){
 			
 			//자식 클래스로 객체 생성
 			AbstractChildClass acc= new AbstractChildClass();
 			acc.abstractMethod();
 			System.out.println(acc.age);
 			acc.generalMethod();
 			
 			버튼()
 			더블클릭()
 			일단 버튼을 누르면 특정 기능을 한다라고 선언만 하고
 			-------------> 개발자 -> 상황에 맞게 처리
 			로그인버튼, 계산기버튼 ,검색버튼... 
 
 */
import java.util.*;
abstract class 도형
{
	public abstract void draw(); //추상메소드
	//상속받는 클래스가 구현해서 사용
	
	public void colorSelect()
	{
		System.out.println("검정색을 사용한다"); //공통속성
	}
}

class 네모 extends 도형
{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("사각형을 그린다!!");
	}
		
}
//abstract 메소드가 있는 경우에는 상속시에 무조건 구현 후 사용해야 한다(문법사항)
class 삼각형 extends 도형
{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("삼각형을 그린다!!");
	}
	
	
}

class 원 extends 도형
{

	@Override
	public void draw() {	//필수사항
		// TODO Auto-generated method stub
		System.out.println("원을 그린다");
	}
	
	public void colorSelect() 	//선택사항
	{
		System.out.println("파란색을 사용");
	}
	
}
public class 추상클래스 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//관련된(상속받은) 클래스를 모아서 한 개의 객체명으로 제어
		//상위클래스 객체명 = new 하위클래스;
		//오버라이딩기법 : 기능을 변경해서 사용한다
		//		-> 메소드명, 매개변수, 리턴형이 동일해야한다
		//      -> 접근지정어는 확대만 가능
		
//		도형 a = new 네모();
//		a.draw();
//		a.colorSelect();
//		
//		a=new 삼각형();
//		a.draw();
//		a.colorSelect();
//		
//		a=new 원();
//		a.draw();
//		a.colorSelect();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("도형선택 : 네모(1) 삼각형(2) 원(3)");
		int mode = scan.nextInt();
		
//		if(mode==1)
//		{
//			네모 a = new 네모();
//			a.colorSelect();
//			a.draw();
//		}else if(mode==2)
//		{
//			삼각형 a = new 삼각형();
//			a.colorSelect();
//			a.draw();
//		}else if(mode==3)
//		{
//			원 a = new 원();
//			a.colorSelect();
//			a.draw();
//		}
		
		
//		도형 a = null;
//		if(mode==1)
//			a=new 네모();
//		if(mode==2)
//			a=new 삼각형();
//		if(mode==3)
//			a=new 원();
//		
//		a.colorSelect();
//		a.draw();
			
		도형[] a = {null, new 네모(), new 삼각형(), new 원()};
		a[mode].colorSelect();
		a[mode].draw();
		

	}

}
