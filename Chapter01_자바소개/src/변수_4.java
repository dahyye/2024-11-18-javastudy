/*
 
 문자열 결합
 문자열 => " "
 3+""+4 = 34
 7+"7"+7 = 777
 System.out.println(7+7+"3"+7+7); -> 14377 로 결과값이 나와
 " "문자열과 결합되면 문자열로 바뀌기 때문에
 앞에 7+7은 14로 변하고  "3" 문자열 3과 만나면서 문자열로 변환    그래서 뒤에 +7+7은문자열로 이어짐
 
 boolean은 true/false로만 표시할 수 있는데
 보통 비교연산자에서 많이 사용
 	boolean a =6<7; => true
 	로그인 / 아이디중복체크 / 검색어 / 장바구니 / 댓글
 	
 	네트워크 전송이 보통 바이트로 되어있어 , 파일전송
 	
 	
 		int aa = 10;
		int bb = 20;
		int temp;
		temp=aa;
		aa=bb;
		bb=temp;
		System.out.println("변환 후 aa는"+aa );
		System.out.println("변환 후 bb는"+bb );
		
	
 */
public class 변수_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean a =6<7;
		System.out.println(a);
		
	
		
	}

}
