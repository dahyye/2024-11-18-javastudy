/*
 
 	클래스 
 		데이터형 클래스 : 멤버변수만 가지고 있는 경우
 		사용자 정의 데이터형 : ~VO, ~DTO
 		액션 클래스(기능) : 메소드만 가지고 있는 경우
 		연결용 : 오라클 연결(~DAO) / 브라우저 연결(~Model(~Controller, ~Action))
 		
 		      (HTML,CSS)    
 		브라우저 ======== 자바 ========= 오라클
 		  backend   //  frontend
 	
 	
 	변수 => 사용하기 위해서 초기값(초기화)
 	1. 명시적 초기화
 		int a=10;
 	2. 생성자
 		클래스를 메모리에 저장할 때 호출하는 메소드 
	 		new 생성자()
	 		news는 메모리 공간 생성, 생성자는 초기값 주입
	 		=> 멤버변수의 초기화 담당
 		특징
 			클래스명과 동일 
 			class A => A()
 			
 			리턴형이 없다
 			여러개 만들 수 있다 (오버로딩)
 				오버로딩의 조건
 				1) 메소드명이 동일
 				2) 리턴형은 관계 없다
 				3) 매개변수 => 갯수나 데이터형이 다른 경우
 				4) 접근지정어는 관계없다
 				5) 한 개의 클래스안에서 존재
 				ex. class A => A()
 				 			   A(int a)
 				 			   A(int a, int b)
 				 			   A(String S)
 			상속에서 예외가 된다
 			생성자가 필요한 위치
 				A() => 매개변수가 없는 생성자 => 디폴트 생성자
 				생성자가 없는 경우에는 컴파일러에 의해 생성 -> 디폴트 생성자
 				오라클 연결할 때 필요 (시작과 동시에 연결되기 때문에)
 				서버연결할 때 / 자동로그인처리할 때 / 파일읽어서 데이터를 저장할 때
 		
 		 용도
 		 	변수 초기화(명시적인 초기화가 안되는 경우)=> 구현후에 데이터 처리
 		 	시작과 동시에 처리하는 기능이 있는 경우 => 윈도우 초기화(화면UI), 파일읽기
 		 	
 		 생성자 호출
 		 	new 생성자() = 메모리가 생성
 		 	new 생성자() = 메모리가 생성
 		 	new 생성자() = 메모리가 생성
 		 	==> 각각 다른 메모리가 생성되기 때문에
 		 		한 번만 호출하는게 좋아
 			
 			
 			
 			
 			
 */
class Student
{
	//변수선언
	int hakbun;
	String name;
	String sex;
	
	//초기화(생성자사용)
	Student()
	{
		System.out.println("Student() 디폴트 생성자 Call");
		hakbun=2;
		name="심청이";
		sex="여자";
	}
	// 생성자 여러개 사용이 가능
	Student(int h, String n, String s)
	{
		hakbun=h;
		name=n;
		sex=s;
	}
	Student(int h, String n)
	{
		this(); // 자신안에 있는 생성자 호출할 때
		//반드시 첫 줄에 사용해야한다
		hakbun=h;
		name=n;
	}

	Student(String n,String s)
	{
		name=n;
		sex=s;
	}
	
	//Student(10.5, 'A', 100) 입력값과 같은 형식이 없으면 입력값보다 큰 형식을 찾아서 실행
	Student(int a, int b, int c)
	{
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
	Student(char a, double b, int c)
	{
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
	Student(double a, double b, double c)
	{
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
public class 클래스_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Student hong = new Student();
//		System.out.println("이름 : "+hong.name);
//		System.out.println("성별 : "+hong.sex);
//		System.out.println("학번 : "+hong.hakbun);
//		
		Student hong = new Student(1,"홍길동","남자");
		Student shim = new Student(2,"심처이","여자");
		Student park = new Student(3,"박문수","남자");
		
		System.out.println("이름 : "+hong.name);
		System.out.println("성별 : "+hong.sex);
		System.out.println("학번 : "+hong.hakbun);
		
		System.out.println("이름 : "+shim.name);
		System.out.println("성별 : "+shim.sex);
		System.out.println("학번 : "+shim.hakbun);
		
		System.out.println("이름 : "+park.name);
		System.out.println("성별 : "+park.sex);
		System.out.println("학번 : "+park.hakbun);
		
		Student lee = new Student(4,"이순신");
		System.out.println("이름 : "+lee.name);
		System.out.println("성별 : "+lee.sex);
		System.out.println("학번 : "+lee.hakbun);
		Student d= new Student(10.5, 'A', 100);
	}
	

}
