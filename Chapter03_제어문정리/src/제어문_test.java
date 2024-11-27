import java.util.*;
public class 제어문_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		1. 구구단 중 원하는 단수 입력 받아 결과를 출력하기
//		
//		Scanner scan=new Scanner(System.in);
//		System.out.print("단수를 입력하세요 : ");
//		int dan=scan.nextInt();
//		int i=1;
//		
//		while(i<=9)
//		{
//			System.out.print("");
//			System.out.printf("%dx%d=%d\t",dan,i,i*dan);
//			i++;
//		}

//		
		
			
		
//2. 1~100사이 정수 중에서 8의 배수 출력하기
		
//		int a=1;
//		int i=1;
//		
//		while(i<=100)
//		{
//			
//			if(i%8==0)
//			{
//				System.out.print(i+" ");
//			}
//			i++;
//			
//		}
		
		
//3. 1~100사이 정수 중에서 4의 배수이거나 7의 배수인 정수를 출력하기		
		
//		int a=1;
//		int i=1;
//		
//		while(i<=100)
//		{
//			
//			if(i%4==0||i%7==0)
//			{
//				System.out.print(i+" ");
//			}
//			i++;
//			
//		}
		
		
//4. 1~100사이 정수중에서 일의 자리 수가 3 또는 6 또는 9인 정수를 출력하기
		
//		int a=1;
//		int i=1;
//		
//		while(i<=100)
//		{
//			
//			if(i%10==3||i%10==6||i%10==9)
//			{
//				System.out.print(i+" ");
//			}
//			i++;
//			
//		}
		
		
		
		
//5. 사용자에게 문자열을 입력받아 모음의 개수를 출력하기 (a, e, i, o, u)
		
//		Scanner scan=new Scanner(System.in);
//		System.out.print("문자열를 입력하세요 : ");
//		String a=scan.next();
//		
//		int i=0;
//		int count=0;
//		//System.out.println(a.length()-1);
//		while(i<=a.length()-1)
//		{
//			if(a.charAt(i)=='a'||a.charAt(i)=='e'||a.charAt(i)=='i'||a.charAt(i)=='o'||a.charAt(i)=='u')
//			{
//				count++;
//			}
//			
//			i++;
//		}
//		System.out.println("모음의 수는 "+count);
//		
		
		
//6. 사용자에게 1 ~ 9사이의 정수를 입력받아 2자리의 자연수 중 각 자리수의 합이 입력값과 동일한 수 출력하기
//		입출력예) 6 => 15 24 33 42 51 60 

//		Scanner scan=new Scanner(System.in);
//		System.out.print("1~9사이의 정수를 입력하세요 : ");
//		int a=scan.nextInt();
//		int i=10;
//		int sum=0;
//		while(i<100)
//		{
//			if(a<1||a>9)
//			{
//				System.out.println("1~9자리의 수로 다시 입력하세요");
//				break;
//			}
//			else
//			{
//				sum=i%10+i/10;
//				
//				if(a==sum)
//				{
//					System.out.printf("%d => %d\n",a,i);
//				}
//			}
//			i++;
//		}
		
		
		
		
//7. 10부터 20까지 순서대로 출력 
//		int i=10;
//		while(i<=20)
//		{
//			System.out.println(i+" ");
//			i++;
//		}
		
		
		
		
		
//8. 10부터 20까지 역순으로 출력 	
//		int i=20;
//		while(i>=10)
//		{
//			System.out.println(i+" ");
//			i--;
//		}
		
		
//8-1 문자열을 입력받아서 거꾸로 출력하기
		
//		Scanner scan=new Scanner(System.in);
//		System.out.print("문자열 입력하세요 : ");
//		String a=scan.next();
//		int i=a.length()-1;
//		while(i>=0)
//		{
//			System.out.print(a.charAt(i));
//			i--;
//		}
//		System.out.println();
		
		
		
		
//9. 사용자가 입력한 5개의 정수 중 가장 큰 값을 출력하기

//		Scanner scan=new Scanner(System.in);
//	
//		int max=0;
//		int i=1;
//		while(i<=5)
//		{
//			System.out.print("정수를 입력하세요 : ");
//			int a=scan.nextInt();
//			
//			
//			if(a>max)
//			{
//				max=a;
//			}
//			i++;
//				
//		}
//		System.out.println(max);
		
		
		
		
		
		
//사용자에게 문자열 3개를 입력받아 길이값의 합을 출력하고, 가장 긴 문자열을 출력하기
		
		
//		Scanner scan=new Scanner(System.in);
//		
//		int sum=0;
//		int max=0;
//		String maxStr="";
//		int i=1;
//		while(i<=3)
//		{
//			System.out.print("문자열을 입력하세요 : ");
//			String a=scan.next();
//			
//			sum+=a.length();
//			if(a.length()>max)
//			{
//				max=a.length();
//				maxStr=a;
//			}
//			i++;
//			
//		}
//		System.out.println("길이값의 합 : "+sum);
//		System.out.println("가장 긴 문자열 : "+maxStr);
//		
		

		
		
	}

}
