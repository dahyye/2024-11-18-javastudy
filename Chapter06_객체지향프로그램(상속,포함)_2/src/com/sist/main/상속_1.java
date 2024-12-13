package com.sist.main;
/*
 	상속의 변경(수정)
 	~~~~~~~~~~~~~~> 오버라이징
 	1. 변수 오버라이징
 	
 	2. 메소드 오버라이징
 
 
 */
class Super
{
	String name;
	int age;
	//초기화
	public Super()
	{
		name="홍길동";
		age=25;
				
	}
}

class Sub extends Super
{
	//변수오버라이딩
	String name;
	int age;
	
	public Sub()
	{
		name="심청이";
		age=27;
	}
	public void display()
	{
		System.out.println("Super:name = "+super.name);
		System.out.println("Super:age = "+super.age);
		//super => 상속 내린 클래스의 변수, 메소드
		System.out.println("This:name = "+this.name);
		System.out.println("This:age = "+this.age);
	}
	
}


public class 상속_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sub sub = new Sub();
		sub.display();
	}

}
