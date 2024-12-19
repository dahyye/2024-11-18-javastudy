package com.sist.lib;
/*
 	equals()
 	
 		Object에서는  객체 비교할 때 사용
 		String에서는 문자열만 비교 => 오버라이딩
 
 */

class Human
{
	String name;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Human(String n)
	{
		this.name = n;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Human)  //객체비교
		{
			Human s = (Human)obj;  //메소드역할 -> 형변환
			return name==s.name;
		}
		else return false;
	}
	
}
public class 라이브러리_Object_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human h1 = new Human("홍길동");
		Human h2 = new Human("홍길동"); 
		
		if(h1.equals(h2))
		{
			System.out.println(h1+"과 "+h2+"는 같다");
		}
		else
			System.out.println(h1+"과 "+h2+"는 다르다");
		
	}

}
