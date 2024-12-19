package com.sist.lib;

//toStirng() : 객체를 문자열로 
/*
 	Object 클래스
 	1. 모든 클래스에 상속을 내린다
 	2. Object는 가장 큰 데이터형 => 모든 데이터값을 받을 수 있다
 		Object o=1;
 		Object o="";
 		Object o=10.5;
 	3. 모든 객체가 사용할 수 있는 기능을 제공
 	   ----------------------------- 메소드
 	4. java.lang => object외에 다른 클래스는 final이다
 							  -------------------
 							  상속을 받아서 변경이 불가능
 	5. Object 
 	   ------
 	   	finalize() / clone() / toString() / hashCode() / equals()
 	   	--------------------------------------------------------
 	   
 	   상속을 내리면 상위클래스는 하위클래스의 메소드나 변수를 적용할 수 없어
 	   그래서 Object(상위클래스)는 String(하위클래스)를 제어할 수 없어
 	   	=> 오버라이딩된 변수나 메소드만사용이 가능해
 	   	
 	   	toString() : 문자열 변환 / 객체의 정보 확인
 	   	----------멤버변수 확인 => 오버라이딩
 	   							------장점 : 상위클래스로 객체를 선언해도 오버라이딩된 메소드호출된다

 	   	
 	   	class A
 	   	class B extends A
 	   	
 	   	A a = new B()  => 동적 바인딩
 	   		  -------
 	   		  A가 가지고 있는 메소드 -> 오버라이딩된 메소드 호출
 	   		  
 	   	A가 가지고 있는 변수 : 주소가 없다
 	   	=> 정적바인딩
 	   	
 	   	
 	   	
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class 라이브러리_Object_1 extends JFrame implements ItemListener{  //선택할 때마다 값을 가져온다

	JComboBox box = new JComboBox();
	JLabel la = new JLabel();
	public 라이브러리_Object_1()
	{
		box.addItem("홍길동:남자"); //문자열처럼 보이지만  addItem(Object) 
		box.addItem("심청이:여자");
		box.addItem("박문수:남자");
		box.addItem("이순신:남자");
		box.addItem("김두한:남자");
//		box.addItem(10);  //가능
//		box.addItem(10.4);  //가능
		
		// object를 매개변수나 리턴형으로 받으면 사용할 때 반드시 형변환 필요
		
	//	box.addItem("박문수:남자");
	//	box.addItem("이순신:남자"); 
	//	
		//object의 단점은 출력은 가능하나 문자열 제어는 불가능
		
		setLayout(null);
		box.setBounds(10,15,100,35);
		add(box);
		
		la.setBounds(10,100,300,35);
		add(la);
		
		setSize(400,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		box.addItemListener(this);//이벤트등록
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 라이브러리_Object_1();
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==box)
		{
			String obj = box.getSelectedItem().toString();
			String[] datas = obj.split(":");
			la.setText("이름 : "+datas[0]+", 성별 : "+datas[1] );  //오류 (String)인데 (Object)로 받았어
		}
	}

}
