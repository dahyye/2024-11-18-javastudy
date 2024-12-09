/*
 ---------------------------------------------------------
 		메모리 저장되는 시점  			메모리 해체되는 시점
----------------------------------------------------------
인스턴스		객체생성						프로그램 종료
		  new 생성자()					=>Heep 영역
		  								=>GC
----------------------------------------------------------
공유변수	 컴파일시에 자동으로 메모리 저장        프로그램 종료
									 =>MethodArea 영역
----------------------------------------------------------
지역변수     메소드 호출시


----------------------------------------------------------  


메모리영역
 	1. MethodArea : method, static
 	2. stack : 지역변수, 매개변수
 	3. Heap : 배열, 인스턴스 변수
생성자 => 초기화블럭
		호출하지 않는다 => 자동수행
			단점 : 상속의 예외조건
		class ClassName
		{
			
			{
				//인스턴스 블럭 => 구현가능
			}
			
			static
			{
				//static 블럭 => static변수의 초기화
				DB연동 / 웹 : 쿠키읽기, 데이터베이스연결, 서버연결
			}
			
		}
	 => 초기화 시작하는 프로그램 ( 생략가능)
	 => 반드시 클래스명과 동일해야함
	 ex. Scanner scan = new Scanner(System.in)
	  						~~~~~~~~
	  						 생성자
	  				꼭 new를 사용해야해
	  				new = 클래스의 메모리 크기를 확인하고 배정
	  				생성자 => 초기화해주는 역할이라고 생각하면 됨
	  						 
	  		Systen.in
	  		scan.nextInt();	=> .은 주소 접근 연산자			 
	  				
변수 => 명시적 초기화 int age=20; 	
웹 => 자동로그인(쿠키에서ID)
	class ClassName
	{
		//선언만 가능 => 구현은 불가능
		int a;=>선언
		a=10;=> 이것도 구현
		int age=10; 이렇게 선언과 동시에 초기화는 가능
	}
	
	
기능 => 메소드 : 한개의 기능을 수행하게 만든다
		인스턴스 메소드 - 따로 생성, 작동 ex. 계산기를 2개 켜-> 한 개에 숫자입력할 때 다른 계산기는 반응없음
		static 메소드 - 공유 =-> 한개만 생성
						ex. Math.random() 클래스명으로 접근
		추상 메소드 - 선언=> 필요시마다 구현, 설계
					추상클래스 / 인터페이스
					
		종단 메소드(수정불가능)

 
 객체지향의 3대 특성
 	= 데이터 보호 목적 => 캡슐화(데이터 은닉화)
 						lombok
 	= 재사용 => 상속, 	포함
 			  is-a  has-a
 	= 수정, 추가를 쉽게 만든다
 		다형성 => 오버라이딩 / 오버로딩
 
 접근 지정어
 	public => 모든 클래스에서 가능 
 	protected => 같은 폴더안에섬나 접근이 가능
 				상속받은 클래스는 다른 폴더에서도 접근이 가능
 	default => 같은 폴더에서만 접근이 가능 *****
 	private => 자신의 클래스에서만 접근이 가능
 
 클래스 종류 
 	일반클래스
 	추상클래스 => 보안인터페이스
 	내부클래스
 		= 멤버 클래스 => 변수 / 메소드를 공유
 			=> 쓰레드, 네트워크에서 많이 사용
 			class A => 서버 (연결담당)
 			{
 				class B => 통신담당 => 쓰레드
 				{
 				
 				}
 			}
 			
 		= 익명의 클래스 => 상속없이 오버라이딩 할 경우
 			=> 빅테이터나 데이터분석에서 많이 사용
 			
 		= 지역 클래스 (거의 사용빈도가 없다)
 			=>메소드안에 클래스가 선언
 			(메소드안에서만 사용)
 			class A
 			{
 				public void aaa()
 				{
 					class B
 					{
 					
 					}
 				
 				}
 				
 			}
 		
 		*********** 어떤 프로그램에서 사용하는지를 잘 알아야 좋아 ***********

 예외처리 : 사전에 에러방지, 비정상 종료를 방지하고 정상상태를 유지할 수 있게
 	= 예외복구 try~catch
 	= 예외회피 throws Exception
 	
 	예외처리가 반드시 필요한 클래스			 생략이 가능
 		컴파일시에 확인					실행시에 확인
 		CheckException				UnCheckException
 		(개발자에러)					(사용자에러)
 		
 		10장부터는 모든 클래스가 예외처리를 가지고 있다
 			java.io(입출력) / java.sql(오라클) / java.net
 		
 	
 	예외 : 소스상에서 수정이 가능한 에러
		메모리 할당할 공간이 없는 경우는 수정불가능 => 종료 -> 에러
 
 
 */

class Person{
	int age;
	String name;
	boolean isMarried;
	int numberOfChildren;
}

class ShopOrder{
	
	int orderNumber;
	String id;
	String orderDate;
	String name;
	String odrerProduct;
	String address;
	
	
}

public class 클래스_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.age = 40;
		person.name = "Davis";
		person.isMarried = true;
		person.numberOfChildren = 3;
		
		System.out.println("나이 : "+person.age);
		System.out.println("이름 : "+person.name);
		System.out.println("결혼여부 : "+person.isMarried);
		System.out.println("자녀 수 : "+person.numberOfChildren);
		
		
		
		
	}

}
