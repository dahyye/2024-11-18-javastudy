package com.sist.inter;
//Impl -> Service를 구현할 때 사용
/*
 	사용자 요청 -> controller -> Service -> ServiceImpl
 
 
 */
public class HelloImpl implements Hello {

	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println(name+"님 환영합니다");
	}

}
