/*
 
 	문자열
 	
 	기능(메소드) -> 반드시 결과값(리턴형/반환형) ex.int scan.NextInt()
 	
 	String 문자열을 저장하는 데이터형(길이의 제한이 없다)
 		=> 일반 데이터형으로도 사용가능 / 클래스형으로도 사용이 가능
 		
 		선언방식
 			1. String name="홍길동";  // 더 많이 사용
 			2. String name=new String("홍길동"); // 새로운 메모리 공간에 저장하라는 뜻
 			
 		기능(메소드)
 			=>문자열은 비교연산자를 사용하지 않는다
 			1. 비교기능 **암기필요
 				equals() -> == => 아이디 로그인처리할 때 주로 사용
 				equalsIgnoreCase() -> 대소문자 구분없이 비교
 				contains() -> 포함문자 => 검색할 때 
 				------------
 				startsWith() // 인터넷 검색할 때 자바검색하면 자바로시작하는 다른 문장들 연관에 보여주는 그런 그닝
 				endsWith()  //확장자 가져올 때 많이 사용
 				-------------->자동완성 / 서제스트
 			2. 변경
 			3. 문자열 분해
 			4. 제어
 				
 
 */
//사용자의 입력값을 받아서 로그인처리 => ID/PWD -> 로그인
import java.util.*;
public class 문자열_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final String ID = "admin";
		final String PWD = "1234"; //final사용하면 고정값
		
		Scanner scan = new Scanner(System.in);
		// equals라는 연산자는 비교값이 같으면 true / 다르면 false
		
		while(true)
		{
			System.out.print("ID입력하세요 : ");
			String id=scan.next();
			System.out.print("PWD입력하세요 : ");
			String pwd=scan.next();
//			scanner =>  정수 = scan.nextInt()
//						문자열 = scan.next()
//						실수 = scan.nextDouble()
//						논리 = scan.nextBoolean()
//						String => 변경이 불가능 => 확장할 수 없다 => 제공한 내용으로만
			
			if(ID.equals(id) && PWD.equals(pwd)) // 로그인 가능한 상태 //아이디는 대소문자구분 확실히
//				equalsIgnoreCase는 대소문자 구분없이 비교 admin==ADMIN // 검색어는 대소분자 구분없이 비교해야해 
			{
				System.out.println("로그인 되었습니다");
				System.out.println("메인페이지로 이동\n");
				break;
			}
			else
			{
				System.out.println("아이디나 패스워드가 틀렸습니다");
				System.out.println("다시입력하세요\n");
			}
			
		}
		
		
		
		
		
		
	}

}
