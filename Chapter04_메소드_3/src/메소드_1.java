/*
	1. 형식 / 문법
	2. 간단한 예제 => 흐름 ( 동작 => 호출 )
	3. 약간의 응용 => 확장
	
	일반 자바 => 오라클 연결 자바 => 웹 연결 자바
	------------------------------------
	통합 : 스프링!
	
	
	형식)
	[접근지정어][옵션] 리턴명 메소드명(매개변수)
	{
	
	
	}
	
	
	접근지정어 : private public default 등
				선언을 안하면 자동으로 default
					=> 같은 폴더(패키지)에 존재할 때 사용가능
				
	옵션 : final 변경불가능
		  abstract 선언만
		  static 자동 저장 => 공유가능
	
	
 */
public class 메소드_1 {
	static void display()
	{
		int i=1;
		System.out.println("i : "+1);
		i++;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		display();
		display();
		display();

	}

}
