/*
	부정연산자 : ! 
		=> 주로 조건문에서 많이 사용
 		ex. 로그인이 안된 경우, 예약가능날짜가 아닌 경우, 게임에서는 턴할 때 많이 사용
 		
 		부정연산자의 단점 : boolean만 사용가능 !true=false
 		
 		ex. boolean bCheck=false;
 			!bCheck
 			=> true로 변경된다
 
 
 
 
 
 */
public class 연산자_단항연산자2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean bCheck=false;
		System.out.println(bCheck);
		bCheck=!bCheck;
		System.out.println(bCheck);
		
		int kor=75;
		if(!(kor>60)) {
			System.out.println("탈");
			//!는 반대의 효과
		}
		else
		{
			System.out.println("합");
		}
		
		
	}

}
