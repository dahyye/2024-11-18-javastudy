package com.sist.exception;
import java.util.Scanner;
//268page -> 형식
//270page -> 다중 catch
//=>예상예외가 많은 경우에는 다중 catch
public class 예외처리_멀티예외처리_예제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("첫번째 정수 입력 : ");
			String num1 = scan.next();
			System.out.println("두번째 정수 입력 : ");
			String num2 = scan.next();
			
			int n1 =Integer.parseInt(num1);
			int n2 =Integer.parseInt(num2);
			
			System.out.println(n1/n2);
			
			//정수변환 => 윈도우와 웹은 입력값을 무조건 문자로 받아야해서 정수변환이 필요해
			
			
		} catch (NumberFormatException | ArithmeticException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} //이렇게 사용할 수 있어
//			catch (ArithmeticException e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//		}
	}

}
