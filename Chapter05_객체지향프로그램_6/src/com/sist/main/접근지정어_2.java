package com.sist.main;
/*
 	메소드는 특별한 경우가 아니면 보통 인스턴스로 만들어진다
           ---------> 반복이 많은 경우 static
           
    웹 => 모든 메소드 적용 => 한글변환 => static 적용
    Footer에 데이터를 전송할 때 static적용      
           
    다른 클래스에서 메소드 호출시
    1. 객체 생성
    	클래스명 객체명 = new 생성자();
     	------			  ------
    2. 메소드 호출
    	객체명.메소드()
    		 -------> 3가지는 public 으로 생성해야 쓰기 편해
    3. 멤버변수 => 감춰야해 => 정보은닉 => static -> 사용가능하게 기능 만들어주기(getter, setter)
    	데이터 은닉=> 메소드를 이용해 접근 ==> 이런 방식을 캡슐화라고 한다
*/
public class 접근지정어_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
