/*
 
 	구성요소
 		=> 멤버변수
 			공통으로 사용하는 변수여부(static)
 			정보 전체 / 데이터 관리 => 오라클(static) - 공유된 데이터
 		=> 생성자 / 초기화 블럭
 		  -----> 생력이 가능 / 오라클 연동(드라이버 등록)
 		  		윈도우의 레이아수 
 		  		웹 => 자동 로그인
 		  static 블럭 : Mybatis연동
 		  
 		  
 		 
 		=> 활용 -> 메소드
 					다른 클래스 연동(메시지)
 					기능 처리 => 재사용			
 				1. 메소드 형식         ------> 사용자가 요청한 결과값, 반드시 한개값만 설정
	 				[접근지정어][제어어] 리턴형 메소드명 (매개변수..)
 	 				=> 다른 클래스와 연결 => 공개(public)
 					접근지정어
 						public
 						protected - 같은폴더(패키지), 상속받은 클래스
 						private - 자신의 클래스 영역에서만(정보은닉화)
 						default - 아무것도 안적었을 때, 같은 폴더 안에서만 접근가능

 					제어어
 						static - 공통으로 적용되는 메소드
 						final - 종단 메소드, 확장 변경이 불가능
 						abstract - 선언만 할 때
 						--------> 프로그램에 맞게 구현해서 사용
 								버튼 => click();
 								추상클래스 / 인터페이스
 					
 					리턴형
 						(값이 없는 경우에는 void)
 						기본형
 						배열
 						클래스
 					
 					메소드명
 						소문자로 시작, 약간의 의미만 부여
 						ex. aaa()x login()o
 						두개의 단어를 이용
 						ex. 파일이름을 가지고 온다-> getFileName()
 					
 					매개변수
 						사용자로부터 요창값을 받는다
 						여러개 사용 가능
 
 
 */
import java.util.Date;
public class 클래스_1 {
	int a=10;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		
//		Date date = new Date();
//		System.out.println(date);
		
		클래스_1 aa = new 클래스_1();
		System.out.println(aa.a);
		System.out.println(new 클래스_1().a);
	}

}
