/*
  정수 2개와 연산자(+,-,*,/)를 입력 받아 사칙 연산하는 
 
  프로그램을 만들어라 (switch~case 사용) 
*/

import java.util.*;
public class number2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int a = scan.nextInt();
		
		System.out.print("정수 입력 : ");
		int b = scan.nextInt();
		
		System.out.print("연산자(+,-,*,/) 입력 : ");
		char c = scan.next().charAt(0);
		
		switch(c) //바로  scan.next를 받을 수도 있어
		{
			case('+') :
				System.out.println(a+"+"+b+"="+(a+b));
				break;
			case('-') :
				System.out.println(a+"-"+b+"="+(a-b));
				break;
			case('*') :
				System.out.println(a+"*"+b+"="+(a*b));
				break;
			case('/') :
			{
				if(b==0)
				{
					System.out.println("0으로 나눌 수 없다");
				
				}else
				{
				System.out.println(a+"/"+b+"="+(a/(double)b)); //소수점까지 출력
				}
				break;
			}
				
				
				
		}
		
		
	}
	
}
