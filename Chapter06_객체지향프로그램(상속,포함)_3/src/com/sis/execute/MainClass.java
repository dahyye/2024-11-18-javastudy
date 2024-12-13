package com.sis.execute;

import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// A=1, B=2, C=3, D=4
		Scanner scan = new Scanner(System.in);
		System.out.print("A(1), B(2), C(3), D(4) : ");
		int select = scan.nextInt();
//		if(selec==1)
//		{
//			A a=new A();
//			a.excute();
//		}else if(selec==2)
//		{
//			B b=new B();
//			b.excute();
//		}else if(selec==3)
//		{
//			C c=new C();
//			c.excute();
//		}else if(selec==4)
//		{
//			D d=new D();
//			d.excute();
//		}
		// i=new A(), i=new B()	
		//상속이 없는 경우에는 배열을 만들 수 없다
		I[] i= {null,new A(), new B(), new C(), new D()}; //상위클래스로 받아
		//select를 1부터 받기 때문에 i[0]을 null값으로 만들기
		i[select].excute();
		//select가 1일 때 i[1].excute => i[1]은 new A() => new A().excute => A클래스의 메소드 중 excute를 불러와라 라는 뜻 
		//데이터가 혼합되어 있을 땐 Object : 모든 데이터형 받을 수 있다.
		//Object[] i= {"",'',10.0};
		//모든 클래스는 Object를 받는다
	}

}
