package com.sist.exception;
/*
	예외처리 순서
		Unchecked
 	---------------------
 		Throwable
 			|
 		Exception : 예외처리의 모든 것을 잡을 수 있다
 			|
 		RuntimeException : 배열범위초과, 0으로 나누는 경우, 정수변환 ..
 	----------------------
 	.... 나머지는 순서 없음
 	....
 	....
 	
 	
 	try 
 	{
 		int a=10;
 	}
 	catch
 	{
 		int b=20;
 	}
 	여기서 a,b는 사용못해
 	사용하고 싶으면 try구문 전에 int a,b를 선언해줘야해
 
 */

import java.util.Scanner;
public class 예외처리_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int[] arr=new int[2];//입력값이 배열범위를 초과할 수 있고, 나누는 값이 0일 수 있다
		try {
			System.out.print("첫번째 정수 입력: ");
			String s1=scan.next();
			System.out.print("두번째 정수 입력: ");
			String s2=scan.next();
			
			arr[0]=Integer.parseInt(s1);
			arr[1]=Integer.parseInt(s2);
			
			int result=arr[0]/arr[1];
			System.out.println("result = "+result);
			
			
		}
		
		catch (ArrayIndexOutOfBoundsException e)
		{
			// TODO: handle exception
			System.out.println("배열 범위 초과");
			//에러 메세지 출력
			System.out.println(e.getMessage());
			//에러 위치 출력
			e.printStackTrace(); //초반에는 이 코드를 권장
			System.out.println(e.toString());
		}
		catch (ArithmeticException e)
		{
			// TODO: handle exception
			//System.out.println("0으로 나눌 수 없다");
			System.out.println(e.getMessage());
			//e.printStackTrace();
			System.out.println(e.toString());
		}
		catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("정수변환문제");
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println(e.toString());
		}
		catch (RuntimeException e) //ArrayIndexOutOfBoundsException와 ArithmeticException를 동시에 할 수 있는 예외처리
		{
			// TODO: handle exception
			System.out.println("오류발생");
			System.out.println(e.toString());//통으로 잡으면 코드짜기는 쉽지만 어디서 오류가 생긴거지 확인하기가 어려워
											//가급적이면 하나씩 잡는게 좋아 
		}
		System.out.println("정상수행");
		
		
	}

}
