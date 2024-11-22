/*
  ctrl + space 도움받기
  sysout -> System.out.println();
  main -> public static void main(String[] args) {
  주석 종류
  // 한줄  /*  (여러줄)
  
  
  ==== 수업 진행과정====
  
  1.변수 데이터형 (메모리에 저장하는 크기)
	데이터를 RAM에 저장 -> 프로그램 종로 시 사라져
    영구적인 저장 방식은 파일 / RDBMS(오라클) ->공유데이터
  
  2.사용자 요청에 따라 데이터 처리
  	연산자 / 제어문
  
  3.여러개를 동시에 저장하는 방법 2가지
  	* 같은 데이터만 저장하는 방식 ( 정수만 or 실수만 ) -> 배열
 	* 서로 다른 데이터를 저장하는 방식 -> 클래스 -> 객체지향
 	   재사용하기가 좋아 ( 기존에서 수정, 추가가 용이 )
 
  4.데이터를 모아서 관리 : 배열, 클래스 
 	명령문을 모아서 관리 
 	
  ========================= 메소드
  
  5. 객체 재향 프로그램 
     프로그램의 원칙 : 가독성, 재사용, 최적화(속도)
 	
  6. 예외처리
  	 종료하지 않는 프로그램
 	 ( ex. 계산기에서 10을 0으로 나누면 계산기를 종료하는게 아니라
 	 	'0으로 나눌 수 없습니다' 라는 글씨가 나옴 )
 	
  7. 라이브러리
  	자바에서 지원하는 기능 (클래서/메소드)
 	IO(파일입출력) / 네트워크
 	-> Web 프로그램이 이걸 기반으로 하고 있어
 	
  8. 미니프로젝트
 	파일기반으로
 	
 	----------------------------------------
 	
 	2page
	 	자바 실행과정
	 	->프로그램 언어 : c, c++, java, c#, python
	 		자바언어는 프로그래머만 인식하는 언어 -> 컴퓨터는 모르는 언어
	 		컴퓨터가 인식할 수 있게 변경해주는 과정을 '컴파일'이라고 해
	 		ex) 'A' = 65 = 100001(바이너리코드,기계어)
	 			=> 모든 문자마다 번호를 가지고 있어 (UniCode)
	 			=> 0~65535
	 		
	 		c/c++ -> A.c -> A.obj(컴파일된 파일) -> A.exe
	 						 
	 							  바이트코드 : 모든 운영체제에서 동일하게 사용 (.class 파일을 배포파일이라고 생각하면 됨)
	 		java -> A.java    ->    A.class    ->    화면출력
	 						javac			  java
	 					   (컴파일)		 (한줄씩 읽어서 출력)->인터프리터
	 		
	 		java는 컴파일, 실행 총 2번의 소스 검증 과정을 거쳐야 하기 때문에 보안이 뛰어남
	 		제임스고슬링이 자바는 해킹이 어렵다 라고 이야기 했다
	 		
 		
 		
 	5page
 		이클립스는 코딩시마다 자동으로 컴파일이 된다
 		장점은 코딩을 할 때 바로 에러를 출력해줘
 		javac는 자동처리 -> java(실행) -> ctrl + F11
 		
 	6page
 		개발환경 구축방법
 		1. JDK -> jdk.java.net/17 ( 다운로드 위치 )
 		   oracle / openjdk(무료)
 		   			-1.8이상은 무료 (1.8이 호환성이 좋아 sun에서 만든 마지막버전)
 		   Spring Framework -> 단점이 11버전까지 사용이 가능
 		   Spring Boot -> 17버전부터 사용이 가능
 		자바의 단점이 버전호환이 어렵다는 점 
 		
 		2. 설치 후 환경설정
 			내pc -> 오른쪽마우스 -> 속성 -> 고급시스템설정 -> 환경변수 선택
 			시스템변수에서 classpath(.;c:\jdk17.0.2\lib , path(c:\jdk17.0.2\bin) 설정
 			(리눅스 사용할 땐 .bashrc)
 		
 		3. 편집기
 			인텔리J ( 무료, 유료버전이 나눠져 )
 			=> Back-End / Front-End
 			
 			
 			Eclipse -> IBM에서 나온 통합 개발 툴 ( IDE ) -> 무료
 			=> back-end ( java/Web/Spring)
 			=> eclipse.org
 			
 			파일 생성 방식
 			File -> new -> JavaProject -> 프로젝트 폴더를 생성
 			-> src안에 class를 생성 ( 반드시 main 체크해서 만들기 ) / 메인이 시작점, 자동으로 실행  
 			
 			주의점
 			1)자바파일명과 클래스명은 동일해야한다
 			2)대소문자 구분**
 			 - 자바개발자의 약속
 			   클래스명의 시작은 대문자로 시작 MainClass(헝거리언식 표기법) or Main_class
 			   변수, 메소드는 소문자로 시작
 			   상수는 전체를 대문자사용
 			   가급적이면 의미를 부여한다(알아보기 쉬워) -> 3~7자리정도로
 			3) 문장이 종료될 땐 ; 사용
 			4) 변수(변경가능) int age;
 			   상수(변경불가) final int AGE;
 			   리터널(실제 저장된 값) age=20; 일 때 20이 리터널값
 			   
 	23page
 	   자바의 구성요소
 	   public class ClassName {                          => 클래스 시작

			public static void main(String[] args) {     => 메소드 시작
			// TODO Auto-generated method stub  	     
														 => 기능 수행, 소스 코딩
			}											 => 메소드 종료

		}											     => 클래스 종료
 		
 		
 		확장
 		public class ClassName {      
 		=========================
 				변수
 		=========================
 			생성자->변수의초기화
 		=========================
 			사용자 정의 메소드(함수)
 			->게시판목록
 			->게시판등록
 			->게시판상세
 			->게시판수정
 		=========================
 				main()
 		=========================
 		
 		}
 	
 		자바는  CBD프로그램 조립하는 프로그램이라고 해 
 		
 	22page
 		들여쓰기
 		자바소스를 이클립스로 사용할 때 ctrl + shift + f 누르면 자동 들여쓰기
 	
 	23page
 		주석-> 컴파일 예외
 		HTML -> <!-- -->
 		CSS -> //
 		python -># (한줄), """  """(여러줄)
 		JSP <%-- --%>
 		
 		주석 단축키 
 		// -> ctrl + / 
 		/*  -> ctrl + shift + /
 		해체할 땐 / 대신에 \ 사용하기
 		
 		
 */

import java.util.Scanner;

public class 자바소개_특징 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		new Scanner(null)
		
		  System.out.println(); System.out.println(); System.out.println();
		  System.out.println(); System.out.println(); System.out.println();
		 
		
	}

}
