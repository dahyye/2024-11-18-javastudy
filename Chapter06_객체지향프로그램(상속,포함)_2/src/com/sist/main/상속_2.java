package com.sist.main;
/*
 	실무에서 계속 쓸 자바 내용
 	1. 변수
 	2. 연산자
 	3. 제어문
 	4. 메소드
 	5. 멤버변수
 	6. 생성자
 	7. 오버라이딩
 	8. 인터페이스
 	9. 예외처리
 	
 
 	메소드 오버라이딩 => 메소드의 기능 변경 -=> 유지보수
 	--------------------------------------------------
 	오버라이딩의 조건 ******* 인터페이스
 	1. 상속 => 상속받은 메소드를 변경해서 사용
 	2. 메소드명이 동일
 	3. 매개변수가 동일
 	4. 리턴형이 동일
 	5. 접근지정어가 범위확대는 가능. 축소는 불가능
 	
 	class A
 	{
 		void display()
 		{
 		}
 	}
 	class B extends A
 	{
	 	1. void display(){}
	 	2. public void display(){}
	 	3. protected void display(){}
	 	4. private void display(){}  ==> 오류 : 범위축소가 불가능
 	}
 	
 	
 	interface A
 	{
 		void display(); // public abstract가 생략되어 있어
 		int a; //오류 값이 들어가야해 -> int a=10;
 	}
 	class B implements A
 	{
 		void display(){}; -> 오류 public이 붙어야해
 	
 */
class Animal
{
	int a=10;
	public void run()
	{
		System.out.println("걷는다");
	}
}

class Dog extends Animal
{
	int a=20;
	public void run()
	{
		System.out.println("네발로 걷는다");
	}
	
}

class Human extends Animal
{
	int a=30;
	public void run()
	{
		System.out.println("두발로 걷는다");
	}
}


public class 상속_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//관련 클래스가 여러개 있는 경우 -> 상위 클래스로 이용
		// 객체를 한개만 생성해서 사용
		Animal ani = new Animal();
		ani = new Human();//상위클래스를 이용해서 한 번에 제어
		ani.run();
		System.out.println(ani.a);
		ani = new Dog();
		ani.run();
		System.out.println(ani.a);
	}

}
