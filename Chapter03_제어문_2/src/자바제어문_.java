/*
 
 	자바에서 지원하는 제어문 => 54page~83page
 	** 변수 / 연산자 / 제어문 => 기본
 	** 메소드 / 객체지향 프로그램
 	** 라이브러리 => 조립
 	
 	
	 1. 제어문
	 
	 2. 조건문 =? 사용자 요청에 맞게 처리 => 필요하면 수행 => 건너뛴다
	 			ex. 검색, 상세보기, 아이디로그인, 중복체크	
	 			
	 3. 선택문
	 4. 반복문
	 5. 반복제어문
	 
 사용자로부터 정수 2개, 연산자를 입력받고 (중첩 조건문 =>나누기값이 0여부 확인
 프로그램은 비정상 종류가 없는 프로그램이여야해, 사전에 오류를 방지
 웹 => 비정상 종료를 방지 => 에러가 발생 => 건너뛴다 ( 다음문장으로 ) => 예외처리
 */

import java.util.*;
public class 자바제어문_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner scan = new Scanner(System.in);
		System.out.print("정수1을 입력해주세요 : ");
		int num1 = scan.nextInt();
		
		System.out.print("정수2을 입력해주세요 : ");
		int num2 = scan.nextInt();
		
		//자바에서 클래스를 저장할 대 반드시 new를 동적 메모리로 할당
		//malloc(클래스크기) => 메모리를 만들어준다
		//				  => 승격 : new
		// free() => delete : 자바 => 자동 메모리 회수 
		System.out.print("연산자(+,-,*,/)를 입력해주세요 : ");
		char op = scan.next().charAt(0);
		
		System.out.println("num1="+num1);
		System.out.println("num2="+num2);
		System.out.println("op="+op);
		
		if(op=='+')
			System.out.println(num1+"+"+num2+"="+(num1+num2));
		
		else if(op=='-')
			System.out.println(num1+"-"+num2+"="+(num1-num2));
		
		else if(op=='*')
			System.out.println(num1+"*"+num2+"="+(num1*num2));
		
		else if(op=='/')
		{
			if(num1==0||num2==0)  // 오류처리 
			{
				System.out.println("0으로 나눌 수 없습니다");
			}
			else
			{
				//System.out.println(num1+"/"+num2+"="+(num1/num2));;
				System.out.printf("%d/%d=%.2f", num1, num2,(num1/(double)num2));   // 결과값이 소수점일 때
			}
		}
		else  // 오류처리 
		{
			System.out.println("연산자를 다시 확인해주세요");
		}
		
	}

}
