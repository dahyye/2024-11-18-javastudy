package com.sist.lib;

// finalize() -> 소멸자 함수 ==> 객체가 메모리에서 해제될 때 자동호출하는 함수
/*
 
 
 */

class Sawon //extends Object 생략 된 상태
{
	private int sabun;
	private String name;
	
	public Sawon()
	{
		sabun=1;
		name="홍길동";
		System.out.println("객체 생성 = 초기화 완료");
	}
	
	public void print()
	{
		System.out.println("사번: "+sabun);
		System.out.println("이름: "+name);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("사원 객체 소멸 : Heap에서 사라진다");
	}
	
	
	
}
public class 라이브러리_Object_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sawon sa = new Sawon();//객체생성
		sa.print();//객체활용
		sa=null;//주소값 지우기
		
		//프로그램이 종료되어야 회수되기때문에 확인할 수가 없어 -> 직접회수를 실행해서 확인해보기(가비지컬랙션호출)
		System.gc(); 
		//null, 사용하지 않는 데이터가 있으면 데이터회수
		
		//==> 객체의 생명주기
		
		
		Object o = 10;  //AutoBox => 일반 데이터형과 동일 취급
		int i=(int)o; //형변환 //UnBox
		
		
		
		
		
	}

}
