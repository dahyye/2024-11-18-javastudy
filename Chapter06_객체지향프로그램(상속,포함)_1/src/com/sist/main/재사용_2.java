package com.sist.main;

class 사람
{
	String name, sex, address, phone;
	int age;
	public 사람()
	{
		System.out.println("사람 메모리 할당");
	}
}

class 회사원 extends 사람
{
	int sabun;
	String dept, job, loc;
	int pay;
	public 회사원()
	{
		System.out.println("회사원 메모리 할당");
	}
}
public class 재사용_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		사람 a=new 회사원();
		//묵시적 형변환
		회사원 b=(회사원)a;
		//강제형변환
	}

}
