package com.sist.win;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*; //윈도우관련
/*
 	상속=> 기존의 클래스를 재사용 => 추가, 변경해서 사용
 		  ----------
 		  사용자정의, 라이브러리 => 라이브러리를 변경해서 사용하는 상속이 많다
 		  => 코드의 재사용이 가능(개발 속도가 빠르다)
 		  => 코드 관리가 용이하다
 		  => 코드 간결해진다
 		  => 기존의 클래스는 이미 검증된 상태 : 신뢰성이 높다
 	
 	상속 : is-a => 변경 후 사용
 	포함 : has-a => 있는 그대로 ㄷ사용
 	
 	A a=new A()
 		A클래스가 가지고 있는 변수, 메소드 사용
 	B b=new B()
 	
 	A c=new B()
 	 	A클래스, 메소드는 B클래스가 가지고 있는  
 	
 	
 */
//class A
//{
//	int a=10;
//	void display()
//	{
//		System.out.println("A클래스가 가지고 있는 display");
//	}
//}
//
//
//class B extends A
//{
//	int a=100;
//	void display()
//	{
//		System.out.println("B클래스가 가지고 있는 display");
//	}
//}
//윈도우는 중요하지 않다
public class 윈도우상속 extends JFrame{ //윈도우 상속
	//윈도우 설정 -> 시작하자마자 윈도우가 생성되어야 하기 때문에 생성자에 코딩
	JButton b1=new JButton("North");//포함클래스
	JButton b2=new JButton("East");
	JButton b3=new JButton("West");
	JButton b4=new JButton("Center");
	JButton b5=new JButton("South");
	public 윈도우상속()
	{
		//레이아웃
		//1자로 배치
		setLayout(new FlowLayout());
		//임의의 열과 행으로 똑같이 나눠서 배치하는 레이아웃
		//setLayout(new GridLayout(5,1));
		add(b1);add(b2);add(b3);add(b4);add(b5);
		//BorderLayout
//		add("North",b1);
//		add("South",b5);
//		add("Center",b4);
//		add("East",b2);
//		add("West",b3);
		setSize(640,400);//크기결정
		setVisible(true);//윈도우 요청
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new 윈도우상속();
		
//		A aa= new A();
//		System.out.println(aa.a);
//		aa.display();
//		
//		B bb=new B();
//		System.out.println(bb.a);
//		bb.display();
//		
//		//클래스가 많은 경우 => 모앙서 한개으 이름으로 제어
//		A cc=new B();
//		System.out.println(cc.a);
//		cc.display();
	}

}
