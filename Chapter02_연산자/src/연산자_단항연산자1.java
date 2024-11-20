
/*

 	자바에서 지원하는 연산자
 	=> 연산자, 피연산자
 	    10+20
  	 + ->연산자 , (10,20) ->피연산자
  	 
  	 1. 피연산자가 1개인 경우:단항연산자
  	 2. 피연산자가 2개인 경우:이항연산자
 	 3. 피연산자가 3개인 경우:삼항연산자6
 	 
 	 => 데이터 저장 => 연산처리/제어처리 => 처리된 결과 출력
 	 				~~~~~~~~~~~~
 	 				소스코딩이 가장 많은 곳(알고리즘)
 	 				재사용이 많은 부분 => 관련된 소스를 묶어서 관리 => 메소드
 	 
 	 => 변수 / 연산자 / 제어문
 		변수 : 한 개를 저장해서 가공후에 출력
 			-> 데이터형을 어떻게 설정할 지( int, char, double )
 			   ex.학점같은 경우는 보류가 뜰 수도 있고 +,-도 있어서 string으로 잡아야해
 			 변수에서 가장 많이 사용되는 데이터형 => int, long, double, char, boolean
 		
 		웹 / 윈도우 => 보통 문자열을 사용
 		입력하는 창이 JTextField <input type = "text">
 		
 		
 	38page
 	1. 단항연산자
 		증감연산자 a++, a-- : 1증가,1감소
 		 => 반복문에서 주로 사용
 		 =>총알, 아바타 이동에서 사용(게임)
 		 
 		 1)전치연산자
 		 	++a
 		 	int a=10;
 		 	int b=++a;
 		 	출력값 a=11 b=11
 		 	
 		 	int a=10;
 		 	System.out.println(++a);
 		 	출력값 11
 		 	
 		 2)후치연산자
 		 	a++
 		 	int a=10;
 		 	int b=a++;
 		 	출력값 a=11 b=10
 		 	
 		 	int a=10;
 		 	System.out.println(a++);
 		 	출력값 10
 		 	System.out.println(a);
 		 	출력값 11
 		 	
 			for(int i=1;i<=10;i++){
				System.out.println(i);
		}
 */

public class 연산자_단항연산자1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		int a=10;
		System.out.println(a++);
		System.out.println(a);
		
		int b=10;
		System.out.println(++b);
		System.out.println(b);
*/
		
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=10;j++) {
				
				System.out.println(i+"와"+j);
			}
			
			
		
		}
		
	}

}
