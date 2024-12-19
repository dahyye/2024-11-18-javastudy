package com.sist.lib;

class Sawon2
{
	//데이터 은닉 후 메소드로 접근 -> 캡슐화 => 데이터 손실 방지
	private int sabun;
	private String name;
	
	
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	//초기화
	public Sawon2(int sabun, String n)
	{
		this.sabun = sabun;
		name = n;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		Sawon2 s=(Sawon2)obj; //클래스형변환
		return name.equals(s.name) && sabun==s.sabun;
	}
	
	
	//equals를 재정의해서 객체주소 상관없이 멤버변수값이 같으면 true값이 나오게 만들었다.
	
}
public class 라이브러리_Object_4_1 {

	public static void main(String[] args) {
		Sawon2 s1 = new Sawon2(1, "홍길동");
		Sawon2 s2 = new Sawon2(1, "홍길동");
		//equals는 재정의가 없으면 주소를 비교하고
		//재정의시에는 멤버변수의 값을 비교 -> String
		if(s1.equals(s2))
		{
			System.out.println("같다");
		}
		else
		{
			System.out.println("다르다]");
		}//주소값비교 //다르다
		
		Sawon2 s3 = s1;
		
		if(s1.equals(s3))
		{
			System.out.println("같다");
		}
		else
		{
			System.out.println("다르다]");
		}//주소값비교 //같다
		
		
		
		
	}
}
