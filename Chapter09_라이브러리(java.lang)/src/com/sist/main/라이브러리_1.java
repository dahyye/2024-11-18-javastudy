package com.sist.main;
/*
 	자바에서 지원하는 라이브러리
 			     --------
 			     프로그램에 필요한 클래스를 모아서 
 	=>라이브러리중심 => 조립
 	=>Scanner / System / String
 	
 	=> 라이브러리
 		1. 자바에서 지원
 			java.lang = 9
 				Object 	**
 				System
 				String 	**
 				StringBuffer
 				Math
 				Wrapper : 데이터형을 클래스화	**
 					Integer	**
 					Double	**
 					Boolean	**
 					Byte
 					Float
 					Long	**
 					
 			java.util = 10
 				Scanner
 				Date / Calendar
 				Collection -> 배열대체
 				----------
 					List / Set / Map
 					----------------(인터페이스)
 					List : ArrayList, Vector, LinkedList, Stack
 					Set : TreeSet,HashSet(중복없는 데이터)
 					Map : HashMap, Hashtable
 					
 				
 			java.io = 11
 				=> FileReader, FileWriter
 				=> InputStream, OutputStream
 				=> BufferedReader, BufferedWriter
 				=> BufferedInputStream, BufferedOutputStream
 				=> 입출력 : 파일 / 메모리 / 네트워크
 				=> ~Stream, Reader/Writer
 					------	--------------
 					1byte		2byte
 					->네트워크		->한글포함, 파일업로드, 다운로드
 				
 			java.sql = 12
 				=> Connection 
 				=> Statement
 				=> ResultSet
 			-------------------
 			java.net 
 				=> URL / ServerSocket / Socket
 				
 			java.text
 				=> SimpleDateFormat / MessageFormat / DecimalFormat
 				
 			java.lang.reflect
 				=> 리플렉션 => 메소드, 클래스, 변수, 생성자를 제어할 때
 			****Annotation, 열거형
 			
 			J2SE
 			웹 라이브버리 : JSP / Servlet / Spring ==> 2차자바
 			J2EE
 			J2ME(x)모바일 => Kotlim => Dart(Flutter) 
 			
 			-------------------
 			javax.swing(x) => 한 번 사용시 폐기
 			-------------------1.0
 			=>javax.http
 			=>javax.servlet.http
 			=>org.springframework
 			
 			
 					| MyBatis / JPA
 					| Oracle / MySQL(MariaDB)	
 			Java / Oracle / JSP / Spring / Spring-Boot
 			------------------------------------------- Back
 			HTML / CSS / JavaScript => TypeScript(고민중)
 			-----------------------
 							|
 						JQuery / VueJS / ReactJS / NodeJS / NextJS
 						--------------------------------------------
 						
 			1. 데이터 분석 : 파이썬(넘파이, 판다스, Matplotlib)
 							Spring <==> 파이썬
 										  |
 										Django
 										
 			2. 검색엔진 : ElasticSearch, 
 			
 			
 		2. 외부업체 지원
 		3. 사용자 정의 : 잘 만들어진 클래스 / 자주쓰는 클래스
 			=> .jar
 			
 			
 	=====================================================================================
 	
 	9장 
 		java.lang 
 			1. import를 생략할 수 있다 => 자동추가
 			   ------> 가장 많이 사용하는 라이브러리(String, System)
 			2. 대표 클래스
 				= Object : 모든 클래스의 상위 클래스
 						   --------- 모든 클래스는 object를 상속받고 있다
 						  
 						 public class A extends object
 										---------------(생략가능)
 										
 						 : 모든 클래스에서 사용하는 기능(메소드)
 					**	 : toString() : 객체주소
 						 	=> 명시작 / 묵시적
 						 	   A a=new A();
 						 	   => 명시적 : System.out.println(a.toString())
 						 	   => 묵시적 : System.out.println(a)
 						 	   둘은 같은 값 
 							=> 객체의 값이 정상적으로 들어갔는지 확인할 대 자주 사용이 된다
 							=> 객체를 문자열화 시킨다
 					**	: clone() : 객체를 복제할 경우
 							=> 객체 복사
 							=> 얕은 복사 -> 같은 주소를 이용
 									  -> Class By Reference
 									  
 							=> 깊은 복사 -> clone => 새로운 메모리에 저장
 									-> 게임(아바타) -> prototype
 						: finalize() : 소멸자 => 메모리 해제시에 자동 호출
 						  ----------System.gc() : 바로회수
 						  			프로그램 종료 시 회수 
 					**	: equals() : 객체 비겨 => 재정의(오버라이딩)
 						: hashCode()  : 비교
 						
 						
 */
class Student
{
	
	private String name;
	private String phone;
	private String address;
	
	public Student(String name, String phone, String address)
	{
		//지역변수 / 매개변수
		/*
		 	1. 지역변수, 매개변수를 먼저 찾기
		 	2. 멤버변수 찾기
			
			**지역변수 우선 순위
		 
		 */
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	public void print()
	{
		System.out.println("이름 : "+name);//원래는 this.name 인데 충돌 될 변수가 없어서 그냥 사용
		System.out.println("주소 : "+address);
		System.out.println("전화번호 : "+phone);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		System.out.println("이름 : "+name);//원래는 this.name 인데 충돌 될 변수가 없어서 그냥 사용
		System.out.println("주소 : "+address);
		System.out.println("전화번호 : "+phone);
		return super.toString();
	}
	
	
}

public class 라이브러리_1 {
	public static void main(String[] args) {
		Student s1 = new Student("홍길동", "010-1111-1111", "서울");
		Student s2 = new Student("심청이", "010-2222-2222", "경기");
		//s1.print();
		System.out.println(s1); //묵시적
		//s2.print();
		System.out.println(s2.toString()); //명시적
	}

}
