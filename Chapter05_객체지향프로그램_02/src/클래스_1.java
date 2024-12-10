/*
 	객체지향프로그램(Object-Oriented Programming, OOD)
 	1. 독립적으로 작동이 가능하게 실행
 		1) 변수 2) 메소드 => 모아서 연결
 						  ---------> 객체
 		기계 : 부품-객체 => 조립(객체를조립) 객체지향프로그램				  
 		부품(컴포넌트) => 컴포넌트 여러개를 묶어서 조립
 		
 		*컴포넌트:프로그래밍에 있어 재사용이 가능한 각가의 독립된 모듈
 		
 	2. 변수가 많거나 소스가 길어지면 => 분석, 수정이 어렵다
 		=> 이를 보안하기 위해
 		-> 동일한 목적이나 기능을 수행하는 변수나 메소드 묶어서
 		한개의 파일을 제작(객체)
 		객체끼리 상호 통신(메소드) 전체프로그램
 		------------------------------
 		예) 컴퓨터
 			cpu/하드디스크/그래픽카드/메모리... => 각각이 객체
 		    ---
 		    메인보드(여기서 조립)
 		    
 	## 객체지향 프로그램 특징
 	1. 회원관련.. => 사용자 데이터 보안이 필요(데이터보호)
 		=> 캡슐화/정보은닉화
 	2. 사이트 => 커뮤니티(공지사항, 묻고답하기, 자유게시판...)
 		=> 재사용:필요시에는 변경이 가능하게(수정,삭제,추가)
 		=> 재사용을 하기 위해서는 상속(메소드 변경) / 포함(있는 그대로 사용) 기능이 필요
 	
 		- 상속 : 중복제거 가능 => 메모리를 효율적으로 사용
 				단점) 속도가 느려진다 / 영향력이 크다
 					=> 스프링에서는 사용빈도가 거의 없다
 					
 	========================================================================
 	
 	클래스 => 객체를 사용하기 위한 설계
 	형식) 
 		[접근지정어][제어어] class ClassName
 		{
 		
 			클래스 블럭에서 선언 => 다른 클래스에서도 사용이 가능
 			-------------------------
 			객체 생성시마다 따로 메모리에 저장되는 변수
 			---------new 생성자()
 			=> 멤버변수 : Heap=> 다른 데이터형을 모아서 저장
 			메모리 공간을 한개만 만들어서 저장
 			=> 공유변수 : static
 			   ------
 			   ex. 영화목록/음악목록/회원관리
 			   오라클은 static 사용 => 공유할 목적이기 때문에
 			----------------------------
 			변수 초기화 => 생성자
 			필요없는 경우 생성자 생략가능 -> 초기화자동생성
 			(int =0; char='0' long=0L String=null boolean=false double=0.0)
 			   
 		}
 	
 	
 		    
 
 
 */
class Member
{
	//변수선언
	String id;
	String name;
	//String sex;
	//String address;
	//String phone;
	//변수초기화(생성자)
	
}

class MemberSystem
{
	Member[] members = new Member[10];
}

public class 클래스_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MemberSystem ms1=new MemberSystem();
		ms1.members[0]=new Member();
		ms1.members[0].id="hong";
		ms1.members[0].name="홍길동";
		
		System.out.println("아이디:"+ms1.members[0].id);
		System.out.println("이름:"+ms1.members[0].name);
		
		MemberSystem ms2=new MemberSystem();
		ms2.members[0]=new Member();
		System.out.println("아이디:"+ms2.members[0].id);
		System.out.println("이름:"+ms2.members[0].name);
		
	}

}
