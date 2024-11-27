/*
 
 	웹개발==>데이터베이스(SQL)
 	server단 : Back => 자바 / 스프링 / 데이터베이스
 	db단 : DBA(보통 경력필요)
 	View단 : Front => 자바스크립트 / jquery => vueJS => Reack => Next
 	
 	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~필수과정
 	
 	**우대사항 MSA(작은단위의서버만들어서?) / DevOps / AWS 
 			=>Spring Cloud
 			
 	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 고민

 			자바 / 파이썬 => 데이터분석 (Numpy, Pandas, Matplotlib)
 						=> DJango <==> Spring
 						=> ElasticSearch : NoSQL
 						------------------google
 						=> 코딩테스트 ( 알고리즘 짜는 방법에 대해 )
 						
 	
 	조건문 : **단일조건문 / **선택조건문 / 다중조건문
 	선택문 : switch~case
 	반복문 : **for / **while / do~while
 	반복제어문 : **break / continue
 
 
 */
/*
 
문제6. 임의의 문자를 추출하여 대문자인지 소문자인지 확인하는 프로그램 작성
		랜덤으로 0,1을 받아서 0이면 대문자 1이면 소문자 랜덤출력(대소문자 범위설정해서 +
 
 
 */
import java.util.*;
public class 반복문_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		
		
				
		Scanner scan = new Scanner(System.in);
		System.out.print("정수1 입력 : ");
		int a = scan.nextInt();
		
//		
		if(a>=0) // max 값과 min값에 각각 1,100을 초기값으로 넣은 이유 (비교하기가 쉬워)
			System.out.println(a+"는 양수");
		else 
			System.out.println(a+"는 음수");
		
		
//		
//		//4*5별채우기
//		for(int i=1;i<=4;i++)
//		{
//			for(int j=1;j<=5;j++)
//			{
//				System.out.print("*");
//			}
//			System.out.println();
//				
//		}
//		
//		//99단
//		for(int i=1;i<=9;i++)
//		{
//			for(int j=2;j<=9;j++)
//			{
//				System.out.printf("%2dx%2d=%2d\t",j,i,j*i);
//			}
//			System.out.println();
//		}
//		
		
		
		
		
		
		
		
	}

}
