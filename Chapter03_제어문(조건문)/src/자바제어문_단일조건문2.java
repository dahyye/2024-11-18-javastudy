
/*
 	정수 2개를 받아
 	사용자 요청에 따라 계산
 	간단한 계산기 / 사칙연산만 사용

 
 */
import java.util.Scanner;

import javax.swing.JOptionPane;
public class 자바제어문_단일조건문2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		System.out.print("첫번재정수를 입력해주세요 : ");
		int a=scan.nextInt();
		System.out.print("두번재정수를 입력해주세요 : ");
		int b=scan.nextInt();	
		
		System.out.print("연산자(+(43),-(45),*(42),/(47))를 입력해주세요 : ");
		int op=scan.nextInt();		
		
		/*
		System.out.println((int)'+');//43
		System.out.println((int)'-');//45
		System.out.println((int)'*');//42
		System.out.println((int)'/');//47
		
		*/
		
		if(op=='+') {
			int result=a+b;
			System.out.printf("%d%c%d=%d\n",a,op,b,result);
		}
		/*
		if(op=='-') {
			int result=a-b;
			System.out.printf("%d%c%d=%d\n",a,op,b,result);
		}
		*/
		
		if(op=='-') {
			JOptionPane.showMessageDialog(null, a+"-"+b+"="+ (a-b));
		} 
		
		
		if(op=='*') {
			int result=a*b;
			System.out.printf("%d%c%d=%d\n",a,op,b,result);
		}
		if(op=='/') {
			if(b==0)
				System.out.println("0으로 나눌 수 없다");
			if(b!=0)
			{
			int result=a/b;
			System.out.printf("%d%c%d=%d\n",a,op,b,result);
			}
		}
		
		
		
	}

}
