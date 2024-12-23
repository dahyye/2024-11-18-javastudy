package com.sist.main;
/*
 	제네릭
 	1) 데이터형을 변경해서 사용이 쉽게 만든다
 		ex. List<String> list = new List<String>();
 		=> 리턴형 / 매개변수 => Object => 원하는 데이터형으로 변경이 가능
 	2) 한 번에 데이터형 통일이 가능하다
 	
 	3) 형변환 없이 사용이 가능 => 소스 간결 / 가독성
 	
 	4) Object 단점 : 데이터 읽기가 어렵다
 		Object는 어떤 데이터형이든 설정이 가능 -> 데이터의 통일성 없다 -> 반복문 사용이 어려워
 		==> 데이터 통일해서 저장하는게 필요해
 	
 	5) 사용자 정의가 없다 -> 표준화
 	6) 배열과 동일시 => 같은 데이터형만
 					 --------- 제어가 쉽다
 	7) 사용법
 		int : <Integer>, double : <Double> 
 		
 		임시 데이터형 
 		T / E / K / V
 		=>T/E => 클래스
 		  type/element
 		=>K/V => Map
 		  key/value
 	
 		
 		객체의 데이터형 안정성 => 제어문 사용이 편하다
 		형변환을 하지 않기 때문에 소스가 간결하다
 		명시적으로 코딩 => 유지보수시 어떤 데이터가 첨부하는지 확인이 편하다
 	
 	
 */						

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
class Box<T>
{
	T t;
	public void setT(T t)
	{
		this.t=t;
	}
	
	public T get()
	{
		return t;
	}
}

class Member1 {

    private String name;
    private String id;
    private String password;
    private int age;
}
public class 제네릭_Collection_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Box<String> b = new Box<String>();
//		b.setT("Hello");
//		String s = b.get();
//		System.out.println(s);
		
		List list = new ArrayList();
		
		Member1 mem1 = new Member1();
		mem1.setName("홍길동");
		
	}

}
