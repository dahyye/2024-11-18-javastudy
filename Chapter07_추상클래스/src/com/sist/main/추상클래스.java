package com.sist.main;
/*
 	추상클래스의 목적
 		여러개의 클래스를 한 개로 제어
 		-----------------------
 		데이터베이스
 		기능	
 			-> 공통으로 설정 -> 모든 클래스가 공동 사용
 				=> 구현(ex. 드라이버설정, 오라클 연결, 오라클 닫기)
 			-> 클래스마다 다른 내용 출력
 				=> 미구현(목록, 검색, 추가...)
 				=> emp(사원정보), dept(부서정보), book(교재)
 				
 				
 		1. 상속을 받는다
 		2. 구현되지 않은 메소드 구현해서 사용
 		3. 추상클래스를 이용해서 모든 클래스를 연결해서 사용
 		4. 공통기능과 미구현 확인
 		5. 오버라이딩해서 사용해야한다
 		6. 반드시 상속을 받아서 처리한다(단일상속) extends
 		7. 형식
 		
 		public abstract class ClassName
 		{
 			------------------------
 			변수 : 멤버변수
 			------------------------
 			생성자
 			------------------------
 			메소드(구현메소드)-상속받은 모든 클래스가 동일한 기능
 			------------------------
 			메소드(미구현메소드)-기능은 동일하지만 처리하는 내용이 다른 겨웅
 			------------------------
 		}
 		
 		클래스 객체 생성하는데 new를 사용하지 않는다 -> 추상클래스/인터페이스
 		ex. Class cls=Class.forName();
 			Calendar cal = Calendar.newInstance();
 			
 */
abstract class Button
{
	public abstract void click();
		
}

class Login extends Button
{

	@Override
	public void click() {
		// TODO Auto-generated method stub
		System.out.println("버튼클릭 후 로그인 요청");
	}
	
}
class Join extends Button
{

	@Override
	public void click() {
		// TODO Auto-generated method stub
		System.out.println("버튼클릭 후 회원가입 요청");
	}
	
}
class Calc extends Button
{

	@Override
	public void click() {
		// TODO Auto-generated method stub
		System.out.println("버튼클릭 후 계산기요청");
	}
	
}
public class 추상클래스 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Button btn = new Login();
		//상위			  하위
		//변수 -> 상위클래스 => 주소값이 없다 -> 선언된 클래스
		//메소드 -> 하위 클래스 => 주소를 가지고 있다 -> 생성자
		btn.click();
		
		btn = new Join();
		btn.click();

		btn = new Calc();
		btn.click();
		//관련된 클래스를 여러개 모아서 한개의 객체명으로 처리
		//클래스는 가급적이면 배열처리를 하지 않는다
		//결합성이 낮은 프로그램을 구현할 때 사용***
	}

}
