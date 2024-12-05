/*
 	**크롤링 : 웹사이트(website), 하이퍼링크(hyperlink), 데이터(data), 정보 자원을 자동화된 방법으로 수집, 분류, 저장하는 것.
 	
 	
 	
 	String 클래스 => char[] 을 제어
 	=> 문자 여러개 저장하는 공간
 	   ---------문자열 : ""  char : ''
 	=> 문자열을 저장하는 일반데이터 / 기능(메소드)을 가지는 클래스형
 	=> 웹/윈도우=> 자바로 만들 수 있는 모든 프로그램의 핵심
 		=> 오라클 : varchar2 / clob, MySql : varchar, text
 		=> c/c++ : 문자열이 없다 => char[], char*
 	=> 문자열 저장하는 방법
 		String name = "홍길동";    				=> 문자열 저장하는 방법
 		String name = new String("홍길동");		=> 클래스로 저장하는 방법
 		
 			**** 객체지향 프로그램 : 변수 / 메소드
 		
 		
 	=> String에서 지원하는 기능(메소드)
 		#메소드
 		리턴형(처리 결과값) 메소드명(매개변수)
 		------------------
 		데이터형
 		{
 			요청처리
 			결과값 전송
 		}
 		
 		리턴형 : 결과값 1개
 		매개변수 : 없는경우    /    1개인경우     /    여러개인경우
 				random()	 substring(1)	 substring(1,4)
 				langth()
 			
 		메소드 : 라이브러리 => 이미 만들어져 있는 상태
 			   **** 사용자 정의 => 직접 만들어서 처리
 			   
 		String에서 사용하는 메소드
** 		1. length() : 문자의 갯수 ( 한글 / 알파벳 ) => 동일
 					  * 알파벳 -> 저장시 1byte : ASC / Unicode
 					  * 한글 -> 저장시 2byte : Unicode (이클립스 설정이 "UTF-8"로 되어 있어서 안깨져)
 					  
 					  가급적이면 받을 때는 데이터형이 같거나 큰 데이터형으로 받는다 (권장)
 					  작은 데이터형으로 받아야 할 경우 -> 형변환을 해서 사용한다
 					   
 		   EX.
 		   String word = "홍길동";
 		   int len=word.length(); //word변수 안에 있는 글자의 수
 			=> 비밀번호 글자수체크, 입력여부 확인, 유효성검사에서 많이 사용

		2. charAt() :원하는 위치의 문자 한개 추출
 			------------------
 			char charAt(int index)
 			결과값 		매개변수->index번호에 해당하는 문자를 추출요청
 			
 			------------------
 			"Hello Java"
 		     0123456789
 		     
 		     charAt(1)='e', charAt(6)='J'
 		     => 문자열의 인덱스 번호는 0번부터 시작한다!!
 		     => 줄거리 / 회사소개 시 사용
 		     
 		     EX.
 		     String msg="Hello Java";
 		     char c=msg.charAt(6);
 		     System.out.println(c);
 		     => 출력값 : J
 		
** 		3. indexOf : 지정된 문자나 문자열의 인덱스번호를 찾아주는 역할
 			=> 웹 (MVC)
 		   => 브러우저에서는 html이 실행되는 언어(자바는 아니다)
 		   ----------------------
 		   int indexOf(char c)
 		   int indexOf(String c) 
 		   =>오버로딩 기법(중복메소드 선언) => 새로운 기능을 추가
 		   ----------------------
 			****오버로딩/오버라이딩
 				  |		 |
 				 new   modify
           
 		   EX.
 		   String msg="Hello Java";
 		   int index=msg.indexOf('J');
 		   => 출력값 : 6
 		   int index=msg.indexOf('k');
 		   => 출력값 : -1  // 데이터가 없으면 -1 출력
 			
 		   문자열을 찾는 경우에는 첫번째 문자으 인덱스번호 추출
 		   => 대소문자를 구분해야 한다
 		   
 		   
** 		4. lastIndexOf : 뒤에서부터 요청된 문자의 인덱스 번호 추출
 		  ----------------------------
 		  int lastIndexOf(char c)
 		  int lastIndexOf(String c)
 		  => URL / 파일경로 / 확장자
 		  
 		  EX.
 		  String msg = "Hello Java"
 		  int len=mas.indexOf('a');   // 7
 		  int len=mas.lastindexOf('a'); // 9
 		  ----------------------------
 		  
** 		 5. contains() : 포함하는 문자가 있는지 확인 
 		 	=> 검색기에서 사용
 		 	-----------------------------
 		 	boolean contains(String s)
 		 	결과값 (true/false)=>if문에서 주로 사용
 		 	-----------------------------
 		 	
 		 6. 서제스트(자동완성기) => 네이버 / 구글의 완성기를 가져와서 프로젝트 할 때 응용 or 쿠키에 저장했다가 뿌리기
																	       ~~~~~~~~~~~~~~~~~~~
																	       타켓형 광고응용가능
 		 	startsWith() : 시작하는 문자열이 같은 경우
 		 	 			  => 자음만 가지고도 찾을 수 있는데 오라클에서 만들어 볼 예정(Procedure)이용해서
 		 	
 		 	endsWith() : 끝나는 문자열이 같은 경우
 		 	-----------------------------
 		 	boolean startsWith(String s)
 		 	결과값 (true/false)=>
 		 	
 		 	boolean endsWith(String s)
 		 	결과값 (true/false)=>
 		 	-----------------------------
 		  => 공백이 있으면 못찾아
 		  => endsWith 보다는 startsWith가 더 많이 사용된다
 		  => startsWith 사용하는 곳 => 맛집에 관련한 사이트에서 맛집을 food_1 food_2 food_3 ..으로 저장하는데
 		   		  					시작부분이 같아서 startsWith를 활용하면 한 번에 찾을 수 있어
 		   		  					
 		
 		7. 변환
 			replace() => 문자/문자열 변환
 			-----------------------------
 			String replace(char old, char new)
 			String replace(String old, String new)
 			-----------------------------
 		    EX.
 		    String msg="Hello Java";
 		    String s=msg.replace('a','b');
 		    출력값 -> s="Hello Jbvb"
 		    String msg="Hello Java";
 		    String s=msg.replace("Java","Oracle");
 		    
 		    출력값 -> s="hello Oracle
 		    
 		    replaceAll() => 전체변경
 		    -----------------------------
 			String replaceAll(String regex, String s)
 							  패턴을 적용해서 변경
 			=>[0-9]{1,3)\\.[0-9]{1,3)\\.[0-9]{1,3)\\.[0-9]{1,3)
 			ip주소 패턴 -> 모든 아이피를 가져올 수 있어(ex.198.45.11.1)
 			-----------------------------
 		   	맛있다, 맛있나, 맛있니, 맛있어 -> 전체 찾고 싶으면 맛있* 식으로 찾으면 전체 찾을 수 있다
 		   	
** 		 8. trim() : 좌우의 공백을 제거
					=> 입력여부 => 데이터를 자르는 경우에 공백을 제거(원형)
 		    -------------------------------
 		    String trim()
 		    
 		    String msg=" Hello Java ";
 		    String s=msg.trim()
 		    	=>="Hello Java" 
 		 
 		 
 		 9. toUpperCase() : 대문자 변환
 		 	toLowerCase() : 소문자 변환
 		 	---------------------------
 		 	String toUpperCase()
 		 	String toLowerCase()
 		 	---------------------------
 		 	EX. 
 		 	String msg="Java";
 		 	String s=msg.toUpperCase()
 		 		s=>"JAVA"
 		 	String s=msg.toLowerCase()
 		 		s=>"java"
 		 
 		 
 		 
** 		 10. valueOf() : 모든 데이터형을 문자열로 변환할 때 사용
 		    ----------------------------
 		 	String valueOf(int i)
 		 	String valueOf(char i)
 		 	String valueOf(boolean i)
 		 	String valueOf(float i)
 		 	String valueOf(double i)
 		 	String valueOf(char[] i)
 			=>static으로 제작 => 변수선언 없이 클래스명으로 접근이 가능
 			Scanner scan=new Scanner(System.in);
 			은 변수선언을 해줘야하지만
 			Math.random()처럼 String.valueOf도 클래스며으로 접근
 			
 			중복메소드 정의 => 메소드명은 같고 매개변수(들어가는 값)의 데이터형만 달라
 		
** 		 11. substring() : 문자열 자르기
 		 		=> 주소자르기, 전화번호(010-1234-5678)에서 -빼고 출력
 		 	--------------------------------
 		 	String substring(int begin)
 		 	->begin부터 마지막 문자열까지 
 		 	String substring(int begin, int end)
 		 	->begin부터 end전까지
 		 	--------------------------------
 		 	EX.
 		 	String s="aaa.java"
 		 	String ext=s.substring(4);
 		 	=> 문자열이 짧아서 찾기 쉽지만 길면 indexOf나 lastindexOf를 
 		 		사용해서 위치를 먼저 찾고 문자열 자르기
 		 	
 		 	Ex.
 		 	String s="Hello Java"
 		 	String ext=s.substring(2,5)
 		 		=>"llo"
 		 
 		 
 		 
** 		 12. split() : 단어별 구분
 		 	------------------------------
 		 	String[] split(String regex)
 		 	== 1|제목|출연|상영일...
 		 	------------------------------
 		 13. format() : 변환
 		 	=> %.2f에서만 쓸거야
 		 	-----------------------------
 		 	String format(String s, object obj...)
 		 									// 가변매개변수 -> 원하는 갯수만큼 사용이 가능
 		 	format("%d %d %d", 10,20,30)								 
 		 	-----------------------------
 		 	
 **		 14. equals() : 저장된 문자열아 같은지 비교
 		  	=> 아이디처리, 비밀번호찾기
 			--------------------------
 			boolean equals(String s)
 		 	--------------------------
 		 
 		 
 		 	
 */				  
 import java.util.Scanner;
public class 문자열_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a=10;
		int b=20;
		System.out.println(a+b);
		System.out.println(String.valueOf(a)+String.valueOf(b));
		//출력값 30 / 1020
		//a="10", b="20" 으로 변환하기 때문에 +가 연산이 아닌 문자열결합으로 표현됨
		
		
//		String msg = " Hello Java";
//		if(msg.startsWith(" Hello")) //공백제거하려면 msg.trim().startsWith("Hello")
//		{
//			System.out.println("yes");
//		}else
//		{
//			System.out.println("no");
//		}



//		String[] data= {"자바와 JSP", "혼자 배우는 자바", "스프링과 자바", "자바의정석", "자바 기초", "스프링 부트와 자바"};
//		
//		Scanner scan =new Scanner(System.in);
//		System.out.print("검색어 입력 : ");
//		String fd=scan.next();
//		
//		for(String d:data)  // 향상된 for문 원소를 하나씩 꺼내서 대입하면서 비교
//		{
//			if(d.startsWith(fd)) {
//				System.out.println(d);
//			}
//		}
	}

}
