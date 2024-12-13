package com.sist.main;
/*
 
 	상속 / 포함
 	
 	=> 
	 	게시판이 1500줄정도 코딩
	 	(글쓰기, 상세보기, 목록출력, 검색 삭제 등) => CRUD(Create, Read, Update, Delete)-> HTML/CSS,JavaScript 할 줄 알아야해
	 	
	 	자유게시판, 댓글게시판, 갤러리게시판, 묻고답하기 등 
	 	게시판 기능이 들어가는 곳이 많은데
	 	이걸 다 코딩하려면 소스도 길어지고 힘든데
	 	게시판을 상속받으면 간단하게 만들 수 있어
 
 	=> 상속을 받으면 데이터형이 두개가 생긴다
 	 	
 	 	Class 동물
 	 	{
 	 	}
 	 	Class 개
 	 	{
 	 	}
 	 	
 	 	개 a = new 개();
 	 	동물 b = new 개();
 		
 		int, double, char 만 데이터형이 아니라
 		class도 데이터형이다(사용자정의 데이터형)
 		
 		오버라이딩(메소드 재정의) => 덮어쓴다 
 							  ------- 구조가 동일
 		
 			1. 상속이 존재 => 클래스에서 상속없지 재정의(오버라이딩) -> 익명의 클래스
 			2. 매소드가 동일
 			3. 매개변수가 동일
 			4. 리턴형이 동일
 			5. 접근지정어 확장이 가능 / 축소하면 오류 발생
 				private < default < protected < public 
 				=> 메소드는 특별한 경우가 아니면 public으로 사용
 				=> 클래스 / 생성자 / 메소드 -> public
 				=> 멤버변수 -> private ( 데이터 보호)
 					필요시에 사용이 가능 getter/setter 
 				=> 윈도우는 보안이 필요x -> Button, TextField -> default
 		
 		상위 클래스를 이용한다라는 뜻은
 			
 			관련된 클래스를 여러개 묶어서 사용
 			한 개의 객체명으로 처리가 가능
 				변수가 많거나 / 객체가 많으면 -> 제어가 어렵다
 				-> 한 개의 이름을 제어하는게 좋다(상위클래스/인터페이스)
 												   -------
 												   	클래스의 일종 / 다중상속 -> 스프링 기반
 												  
 		상속의 예외 조건 / 접근지정어
 		------------
 			static : 공유 데이터 => 사용은 가능
 			생성자 
 			초기화블럭
 			
 		상속이 있는경우
 		-상속을 내리는 클래스가 매개변수가 있는 생성자가 있으면
 		
 		class A
		{
			public A(String s)
			{
				System.out.println(s);
			}
		}
		class B extends A  //오류
		{
			
		}
		
		매개변수가 있는 생성자가 있으면 오류
		이럴 땐 class B안에 
		public B(String s)
		{
			super(s);
		}
		매개변수 s를 호출하고 클래스 A를 호출해야 오류가 안난다
 		
 */
class A
{
	public A() {}
	public A(String s)
	{
		System.out.println(s);
	}
}
class B extends A  //오류
{
	public B(String s)
	{
		super(s);
	}

	public B() {
		super(); //상위클래스 생성자 호출할 때 사용
	}

	
	
}

public class 상속_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
