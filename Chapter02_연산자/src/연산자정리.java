/*
 	데이터저장(변수) ===> 요청 처리 ===> 화면 출력
 					연산자/제어문
 	
 	
 	단항연산자
	 	증감연산자  => ++/--	 
	 	형변환연산자 => 실수->변수 => (데이터형)변수 값 => 크기 순서를 잘 기억하기
	 										byte < short,char < int < long < float < double
	 											       <==				=> 
	 											     DownCasting	UpCasting	
	 											        강제형변환		 자동형변환
	 											      변수 => 작은 데이터는 저장가능
	 											      long a=10 => int데이터를 자동으로 long으로 변환
	 											      int a='A' => int데이터로 인식
	 											      int a=10.0 => 오류
	 											      
	 											      형변환 => 클래스형변환
	 											      
	 	부정연산자  => 조건문이나 반복문에서 조건을 줄 때 사용
	 	   			!(boolean으로 사용이 가능 => !true=false, !false=true
 	   
 	 이항연산자
 	 	산술연산자  => ( +, -, *, /, % ) => 가장 많이 사용되는 연산(합/평균) 
 	 								  => 웹프로그램 특징 : 로직이 없다, 흐름따라
 	 				산술규칙
 	 				1) 같은 데이터형만 연산이 가능
 	 					long + int = long 자동으로 큰 데이터형으로 변경 후 연산
 	 					10.0 + 10 = 10.0 + 10.0 = 20.0
 	 				2) int이하의 데이터형(byte, char, short)을 연산 => 결과값이 int
 	 				3) char는 연산시에 자동으로 정수형으로 변경 후 처리
 	 				
 	 				연산처리 방식
 	 				+ : 더하기, 문자열결합
 	 					ex. 5+"5"=55
 	 						"5"+5=55 (문자열)
 	 				/ : 0으로 나눌 수 없다(오류발생)
 	 				    정수 / 정수 = 정수
 	 				    10 / 3 = 3.333(x) 3(o)
 	 				% : 나머지
 	 					부호의 위치를 잘 봐야함
 	 					5%2=1
 	 					-5%2=-1
 	 					-5%-2=-1
 	 					부호가 왼쪽을 따라감
 	 					
 	 	---------- 조건문 / 반복문 => 결과값이 true /false 로 나와				
 	 	비교연산자	 => 문자열은 비교할 수 없다 / 문자, 숫자, 논리만 비교할 수 없다
 	 			 => ==, !=, <, >, <=, >=  기준점이 왼쪽
 	 			 ex. 'A'=='a' => false
 	 			 보통 if문안에서 조건으로 사용
 	 			 if(부정연산자/비교연산자/논리연산자)
 	 			 => 조건문 : 필요시 사용, 불필요시 건너뛴다
 	 			 => 반복문 : 게임
 	 	논리연산자
 	 			&& => 범위를 포함할 때 주로 처리(기간)
 	 				char a='B';
 	 				a>='A'&& a<='Z'
 	 			
 	 			|| => 범위밖에 있는 경우에 주로 처리
 	 				a<'A'|| a>'Z'
 	 				int score;
 	 				score<0 || score>100 => 다시 입력하시오
 	 				
 	 			(조건) && (조건), (조건) || (조건)
 	 			=>결과값을 true or false
 	 			
 	 			&& 일 때 앞 조건이 false라면 뒷 조건은 실행하지 않는다
 	 			|| 일 때 앞 조건이 true라면 뒷 조건은 실행하지 않는다
 	 			 = > 효율적인 연산 
 	 	----------
 	 	대입연산자
 	 	
 	 	
 	
 */
//점수를 랜덤으로 받아서 60점 이상 & 짝수 => true출력 
public class 연산자정리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//점수 랜덤으로 받아오기
		int score=(int)(Math.random()*101); //0~100까지 사용할 때 
		System.out.println("score : "+score);
		
		boolean bCheck = score>=60 && score%2==0;
		System.out.println("bCheck : " + bCheck);
		
		char sex='W';
		int jumsu=87;
		
		bCheck= sex=='W'||(jumsu%2==0);
		System.out.println("bCheck : " + bCheck);
		
		
		
	}

}
