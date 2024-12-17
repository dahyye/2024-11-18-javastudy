package com.sist.main;
/*
 
 	응용(x)
 	------
 	=> 목적 
 		=> 추상클래스 / 인터페이스 => 같은 기능
 		             -------
 		             	추상클래스의 기능을 보완
 		             	기능별로 모아서 처리
 		             	----
 		             	=윈도우 이벤트처리
 		             	=Collection
 		             	 1. 순서가 있다, 중복 데이터 저장 허용
 		             	 	List => ArrayList / LinkedList / Stack
 												(Queue)
						 2. 순서가 없다 , 중복 데이터 저장을 허용하지 않는데
						 	Set => TreeSet / HashSet
						 3. 키, 값을 동시에 저장, 키 중복이 없다, 값을 중복이 가능
						  	Map => HashMap, Hashtable
						 
						 =기능별 분리
						 
						 =데이터베이스
						 	=connection / Statement / ResultSet
						 	
						 =네트워크연결
						 	= Socket
						 =쓰레드
 							= Thread => run()
 						
 					----------------------------------------------------라이브러리
 					
 			상속
 					기존의 클래스 기능을 받아서 재사용
 					추상클래스 : extends => 단일 상속
 					인터페이스 : implements => 다중상속
 					MVC구조를 만드는 경우 => 인터페이스 => 어노테이션
 					라이브러리에서 지원하는 인터페이스를 주로 사용
 					---------------
 					기능 처리가 여러개인 경우
 					cgv/롯데시네마/메가박스 -> 
 					
 					
 					class String extends Object
 					class StringBuffer extends Object
 					
 					Object
 					  |
 					------
 					|    |
 
 */
public class 클래스종류정리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object obj = new Object(); 
		String str = "";			
		StringBuffer sb = new StringBuffer();
		
		if(obj instanceof Object) //instanceof 클래스와 클래스의 크기를 비교할 때 사용 //예외처리에서 자주 사용
		{
			System.out.println("obj는 object 클래스 객체");
		}
		if(str instanceof Object)
		{
			System.out.println("str는 object 클래스 객체");
		}
		if(sb instanceof Object)
		{
			System.out.println("sb는 object 클래스 객체");
		}
		if(obj instanceof String) //false
		{
			System.out.println("str는 object 클래스 객체");
		}
//		if(sb instanceof String) //비교불가
//		{
//			System.out.println("str는 object 클래스 객체");
//		}
	}

}
