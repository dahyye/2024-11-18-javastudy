/*
 	1. 클래스 구조
 		클래스는 객체를 생성하기 위한 설계
 			   ---
 			    속성 / 동작
 			   (변수)(메소드)
 			   
 		class ClassName
 		{
 			변수
 			=멤버변수(인스턴스) : 객체 생성시마다 메모리에 따로 저장
 			=정적변수(static) : 메모리 공간 1개 생성
 								=> 모든 객체가 공유해서 사용
 								
 			형식) 
 				멤버변수=> [접근지정어] 데이터형 변수명;
 				정적변수=> [접근지정어] static 데이터형 변수명;
 				
 		----------------------------------------------------------
 			생성자
 				멤버변수 설정 => 초기화
 				생성자 설정 안하면 0 or null으로 초기화
 				초기화방법
 					1. 명시적 초기화 : 값을 임의로 설정
 						class 영역은 선언만 하는 영역
 					2. 구현 후 초기화 : 파일읽기 / 데이터베이스
 						연산자 / 제어문 ... 구현 => 클래스 영역에서 설정이 불가능
 						=생성자 : 인스턴스변수/static변수 설정이 가능
 						=인스턴스블럭 : 인스턴스변수/static변수 설정이 가능
 						=static블럭 : static변수 설정이 가능 => 객체 생성 후 사용
 						
 						특별한 경우가 아니면 줒로 생성자를 이용한다

 				생성자 특징
 					클래스명과 동일
 					오버로딩이 가능
 					리턴형이 없다
 					class A
 					{
 						void A(){} => 일반 메소드
 						A(){} => 생성자
 					}
 					
 					다른클래스 사용이 가능=>public
 		
 		----------------------------------------------------------
 			메소드 : 동작, 행위 => 기능처리
 					=> 데이터 결과값 전송
 					=> 다른 클래스와 연결
 			형식)
 				[접근지정어] 리턴형 메소드명(매개변수...) => 선언부
 				{
 					구현부
 					return 값
 				}
 				
 				메소드에서 접근지정어는 특별한 경우를 제외하고
 				일반적으로는 public을 사용
 				리턴형과 리턴값은 데이터형이 같아야한다
 				리턴형이 void인 경우에는 return 생략가능
 		}
 
 	2. 멤버변수
 		-------------------------------------------------------
 		멤버변수 : Heap영역 => 클래스 종료시까지 사용
 				=> 클래스에 있는 모든 곳에서 사용 가능
 				=> 다른 클래스 사용 가능
 				=> 생성 : new 를 이용해서 객체 생성
 		-------------------------------------------------------
 		정적변수 : MethodArea
 		-------------------------------------------------------
 		지역변수 : Stack => 메모리 자체관리(gc) => {}가 끝나면 자동으로 사라진다
 		매개변수 : 메소드 호출시 생성
 				 메소드안에서만 사용이 가능
 		-------------------------------------------------------
 	3. 생성자
 	
 	4. 메소드
 	
 	5. 접근지정어
 		클래스, 메소드, 멤버변수만 사용이 가능 / 지역변수에서는 사용불가(지역변수에서는 final만 사용가능)
 		private : 자신의 클래스에서만 사용가능
 					은닉화=> 모든 멤버변수는 private
 		protected : 같은 패키지안에서만 사용이 가능, 상속받은 클래스에서는 사용가능 => 사용빈도가 거의 없다
 		public : 모든 클래스에서 사용이 가능=> 클래스, 메소드, 생성자
 		default : 같은 패키지안에서만 사용이 가능 => 윈도우(버튼, 편집기)에서 사용 / 개인정보가 없기 때문에
 		
 		접근범위
 		private < default < protected < public
 		
 		
 	
 	6. 캡슐화
 		데이터 보호 목적 => 데이터 감춘다 (private) => 필요시사용해야하는데 그 때 사용하는게 메소드
 		 				=> 값을 저장(setter), 값을 읽기(getter)
 	
 	7. 패키지
 		폴더개념 : 관련된 클래스를 모아서 검색이 쉽게
 		다른 패키지를 사용하고 싶을 땐 import 사용해야해
 		=> 패키지명에 키워드는 사용이 불가능
 		-> 소문자로 사용
 		-> 공백, 특수문자 사용불가능
 		-> 클래스 분리하기 위해사용
 		-> com(org).회사명.종류
 						 vo, dao,io	
 		
 	8. static을 사용시에 주의점
 			static메소드 안에서
 			1. static변수 사용이 가능
 			2. static 메소드 호출이 가능 -> 인스턴스는 반드시 객체
 			3. this, this() 사용이 불가능
 				this는 자신의 객체 주소를 가지고 있다
 					보통 인스턴스 변수와 지역변수를 구분할 때 사용
 				this()는 생성자 안에서만 사용이 가능
 					생성자 안에서 다른 생성자를 호출할 때 사용
 					맨 위에서만 사용해야한다
		static{}을 사용하는 방법
 			static 변수로 배열/ 클래스 => 초기화시에 주로 사용
 			블럭안에서는 static만 처리할 수 있다
 	
 	
 	class A
 	{
 	 	String name;
 	 	int age;
 	 }
 	 
 	 A a = new A();
 	 A b=a; 
 	 
 	 이 때 a,b는 같은 주소값을 가지기 때문에
 	 b값을 변경하면 a값도 바뀐다
 	
 	
 	
 */
public class 객체지향_정리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1= new String("Hello");
		String s2 = new String("Hello");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println((s1==s2));
		System.out.println(s1.equals(s2));

	}

}
