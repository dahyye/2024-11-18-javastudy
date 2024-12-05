import java.util.*;
public class 메소드_예제 {

	static void plus_print(int num1, int num2)
	{
		int sum_plus=num1+num2;
		System.out.println(num1+"+"+num2+"="+sum_plus);
	}
	
	static void minus_print(int num1, int num2)
	{
		int sum_minus=num1-num2;
		System.out.println(num1+"-"+num2+"="+sum_minus);
	}
	
	static void gop_print(int num1, int num2)
	{
		int sum_gop=num1*num2;
		System.out.println(num1+"*"+num2+"="+sum_gop);
	}
	
	static void div_print(int num1, int num2)
	{
		if(num2!=0)
		{
			int sum_div=num1/num2;
			System.out.println(num1+"/"+num2+"="+sum_div);
		}
		else System.out.println("0으로 나눌 없습니다");
	}
	
	static double 예제2(int a, int b, int c)
	{
		int sum=a+b+c;
		double avg = sum/3.0;
		return avg;
	}
	
	static void 예제3(String message, int num)
	{
		for(int i=0;i<num;i++)
		{
			System.out.println(message);
		}
	
	}
	
	static int depositAmout(int balance, int depositAmout)
	{
		balance+=depositAmout;
		System.out.println(depositAmout+"원을 입금하였습니다. 현재 잔액은 "+balance+"원 입니다");
		return balance;
	}
	
	static int withdrawAmout(int balance, int withdrawAmout)
	{
		if(balance>=
				withdrawAmout)
		{
			balance-=withdrawAmout;
			System.out.println(withdrawAmout+"원을 출금하였습니다. 현재 잔액은 "+balance+"원 입니다");
			return balance;
		}
		else System.out.println(withdrawAmout+"원을 출금하려 했으나 잔액이 부족합니다");
		return balance;
	}
	static void isEven(int a)
	{
		if(a%2==0)
		{
			System.out.println("true");
		}else System.out.println("false");
	}
	
	static void isOdd(int a)
	{
		if(a%2!=0)
		{
			System.out.println("true");
		}else System.out.println("false");
	}
	
	static void isMulti(int a, int b)
	{
		if(a%b==0)
		{
			System.out.println("true");
		}else System.out.println("false");
	}
	static void max(int a, int b)
	{
		if(a>b)
			System.out.println(a);
		else if(a<b)
			System.out.println(b);
		else
			System.out.println("a와b가 같다");
	}
//	static void max1(String a)
//	{
//		int max=0;
//		for(int i=0;i<a.length();i++)
//		{
//			if(max<a.charAt(i))
//				max=a.charAt(i);
//		}
//		System.out.println(max);
//	}
	static void max1(int a[])
	{
		int max=a[0];
		for(int i=0;i<a.length;i++)
		{
			if(max<a[i])
				max=a[i];
		}
		System.out.println(max);
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Scanner scan = new Scanner(System.in);
//		System.out.print("정수1을 입력하세요 : ");
//		int num1 = scan.nextInt();
//		
//		System.out.print("정수2를 입력하세요 : ");
//		int num2 = scan.nextInt();
//		
//		plus_print(num1, num2);
//		minus_print(num1, num2);
//		gop_print(num1, num2);
//		div_print(num1, num2);  //예제1
		
		
//		String message = "Hello Java";
//		예제3(message,7);
		
//		int balance=10000;
//		//입금
//		balance=depositAmout(balance,1000);
//	
//		//출금
//		balance=withdrawAmout(balance,2000);
//	
//		System.out.println("최종 잔액 : "+balance);
		
		
//		//메소드예제
//		Scanner scan = new Scanner(System.in);
//		int balance=0;
//		while(true)
//		{	
//			System.out.print("1.입금 | 2.출금 | 3.잔액 확인 | 4.종료 을(를) 입력하세요 : ");
//			int select = scan.nextInt();
//			
//			
//			if(select==1)
//			{
//				System.out.print("금액 입력하세요 : ");
//				int amount = scan.nextInt();
//				balance=depositAmout(balance,amount);
//			}
//			else if(select==2)
//			{
//				System.out.print("금액 입력하세요 : ");
//				int amount = scan.nextInt();
//				balance=withdrawAmout(balance,amount);
//			}else if(select==3)
//			{
//				System.out.println("현재 잔액은 "+balance+"원 입니다");
//			}else if(select==4)
//			{
//				System.out.println("시스템을 종료합니다");
//				break;
//			}else System.out.println("다시 선택하세요");
//				
//		}
		
		isEven(10); isEven(11);


	
		
	}

}
