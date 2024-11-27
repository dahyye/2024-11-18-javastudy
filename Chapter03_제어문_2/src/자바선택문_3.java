// 입력받고 사칙연산을 스위치케이스로 하기

import java.util.*;
public class 자바선택문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner scan = new Scanner(System.in);
		//지역변수 (stack)=> 메모리     , new 생성=> 개발용
		System.out.print("정수1를 입력해주세요 :");
		int num1 = scan.nextInt();
		
		System.out.print("정수2를 입력해주세요 :");
		int num2 = scan.nextInt();
		
		System.out.print("연산기호를 입력해주세요 :");
		//String op=scan.next();  // op변수를 문자열로 선언 => ""문자열로 받아야함
		char op=scan.next().charAt(0);  // 문자로 선언 => ''문자로 받아야해
		
		switch(op) //문자열 //switch(scan.next)
		{
			case ('+') : //String 문자열이라서 "" 큰따음표사용 
				
				System.out.println(num1+"+"+num2+"="+(num1+num2));
				break;
			case ('-') :
				System.out.println(num1+"-"+num2+"="+(num1-num2));
				break;
			case ('*') :
				System.out.println(num1+"*"+num2+"="+(num1*num2));
				break;
			case ('/') :
				if(num2==0)
				{
					System.out.println("0으로 나눌 수 없다");
					break;
				}else
				System.out.println(num1+"/"+num2+"="+(num1/num2));
				break;
				
				/*
				switch(num2)
				{
					case(0) :
						System.out.println("0으로 나눌 수 없다");
						break;
					default :
						System.out.println(num1+"/"+num2+"="+(num1/num2));
				 */
			default :
				System.out.println("연산자를 다시 입력하세요");
		}
	}

}












