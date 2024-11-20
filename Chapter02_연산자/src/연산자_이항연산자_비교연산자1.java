/*
 
 	비교연산자
 	=> 숫자, 논리만 비교가능
 	=> 문자열은 비교불가 ""=="" (x) / equals() 사용해야해
 	
 		== 같다 => 결과값은 true / false 로 출력 => 조건문활용
 		!= 같지않다  => 오라클 : =, <>  자바스크립트 : ===,!==
 		< 작다
 		> 크다
 		<= 작거나같다
 		>= 크거나같다
 		
 	
 */


public class 연산자_이항연산자_비교연산자1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println(6==7);
		System.out.println(6!=7);
		System.out.println(6<7);
		System.out.println(6>7);
		System.out.println(6<=6);
		System.out.println(6>=6);
		
		System.out.println("=================");
		char c='A';
		int a=65;
		//char은 연산처리되면 무조건 int로 변환
		System.out.println(c==a);
		
		c='0'; // 문자에서 숫자를 표현하려면 '0', '1' => '1'-'0'
		a=0;
		System.out.println((int)'A');
		System.out.println((int)'0');
		
		System.out.println(c==a);
		
		System.out.println((int)'+'); //43
		System.out.println((int)'-');  //45
		System.out.println((int)'*');  //42
		System.out.println((int)'/');  //47
		//유니코드

		boolean bCheck1=false;
		boolean bCheck2=true;
		// =>  ==, != 만 사용할 수 있어
		System.out.println(bCheck1==bCheck2);
		
		String s1= new String("Hellow");
		String s2=new String("Hellow");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		// ==은 주소를 비교하는애
	
		int x=10;
		int y=9;
		System.out.println(x==y++);
		System.out.println(x==++y);
		//비교연산자 => 조건문,반복문 
		//로그인처리할 때, 우편번호 검색할 때, 아이디 중복일 때, 검색처리
	}

}
