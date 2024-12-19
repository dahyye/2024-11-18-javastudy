package com.sist.exception;
/*
 	
 	예외처리와 관련없는 소스
 	변수선언 / 클래스 객체선언
 	try
 	{
 		실행이 가능한 소스 코딩(정상 수행)
 		에러가 발생할 수 있다 => 사전에 방지하는 목적
 		에러가 난 경우 => catch로 이동
 		=>if~else비슷
 	
 	}
 	catch(예외클래스)
 	{
 		에러확인이 가능
 			getMessage() => 에러메세지 확인
 			printStackTrace() =>  에러난 곳 확인
 		다중catch사용가능 => 한 개로 통합하고 싶을 땐 주로 Exception을 사용(or Throwable(에러까지가능))
 	}											 ----------예외만가능
 	finally
 	{
 		try~catch와 상관없이 무조건 수행
 		=> 서버닫기/오라클닫기/파일닫기 등을 수행할 때 주로 사용
 	}
 	
 	try에 에러문장이 없이 정상수행하면 catch는 수행하지 않고 바로 finally를 수행한다
 	
 	throws
 	특별한 경우가 아니면 사용자 정의에서는 많이 사용하지 않는다
 	--------- 소스가 많은 경우 (try 설정이 어려운 경우)
 			  ~~~~~~~~~~~~
 			  	
 	
 	메소드() throws 예외클래스,  예외클래스, 예외클래스
 			--------------------------------
 			컴파일러에 알려준다(예외선언)
 			--------------
 			다음 호출시에 처리한 다음에 사용하겠다
 
 
 */
public class 예외처리_예외복구 {
	
	public void display() throws Exception
	{
		System.out.println(10/0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//static안에서는 인스턴스가 사용이 불가능 -> 사용시에는 반드시 객체생성 후 사용
		//static은 바로 사용이 가능
		예외처리_예외복구 a = new 예외처리_예외복구();
		try {
			a.display();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("정상수행");
	}

}
