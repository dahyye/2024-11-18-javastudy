/*
1. 1~10까지 출력하는 메소드를 구현하시오
2. 1~10까지 합을 구하는 메소드를 구현하시오
3. 1~n까지 합을 구하는 메소드를 구현하시오
4. 두 정수의 나눗셈 결과를 구하는 메소드를 구현하시오(실수)
5. 문자열의 소문자를 대문자로 바꾸는 메소드를 구현하시오 a=97, 122 A=65 90
6. 문자열을 입력받아서 좌우 대칭인지 확인하는 메소드를 구현하시오
7. 문자열을 거꾸로 출력하는 메소드를 구현하시오

8. 학점을 구하는 메소드를 구현하시오
9. 년도를 입력받아서 윤년인지 여부를 확인하는 메소드를 구현하시오
10. 두수를 입력받아 큰 수를 출력하는 메소드를 구현하시오.
11. 입력 받은 값이 짝수인지 홀숨인지 판별하는 메소드를 구현하시오
12. 3의 배수를 판별하는 메소드를 구현하시오
13. 년,월,일을 입력받아서 요일을 구하는 메소드를 구현하시오
14. 메소드를 정의하여 입력받은 숫자를 거꾸로 뒤집은 쉬를 출력하는 프로그램을 작성하세요=7
 */
import java.util.*;
public class 메소드_test {

	static void print(int num)
	{
		for(int i=1;i<=num;i++)
		{
			System.out.print(i+" ");
		}
	}
	static int sum(int num)
	{
		int sum=0;
		for(int i=1;i<=num;i++)
		{
			sum+=i;
		}
		return sum;
	}
	static void div1(int num1, int num2)
	{
		double result = 0.0;
		if(num2==0)
		{
			System.out.println("0으로 나눌 수 없다");
		}
		else
		{
			System.out.println(num1+"/"+num2+"="+num1/(double)num2);
		}
	}
	static String div3(int num1, int num2)
	{
		double result = 0.0;
		if(num2==0)
		{
			return "0으로 나눌 수 없다";
		}
		else
		{
			return (num1+"/"+num2+"="+num1/(double)num2);
		}
	}
	static double div2(int num1, int num2)
	{
		double result = 0.0;
		result=num1/(double)num2;
		return result;
	}
	//대소문자 변환
	static char change(char a)
	{ //a=97, 122 A=65 90
		if(a>=97&&a<=122)
		{
			a-=32;
		}
		else
		{
			a+=32;
		}
		return a;
	}
	static void change2(String s)
	{
		s=s.toUpperCase();
		System.out.println(s);
	}
	static String change3(String s)
	{
		return s.toUpperCase();
	}
	
	//문자열을 입력받고 좌우 대칭인지 확인하는 메소드를 구현하시오
	static boolean check (String a)
	{
		boolean bCheck=false;
		for(int i=0; i<a.length()/2;i++)
		{
			if(a.charAt(i)==a.charAt((a.length()-1)-i))
			{
				bCheck=true;
			}
			else
			{
				bCheck=false;
				break;
			}
		}
		return bCheck;
	}
	static String check1 (String a) //강사님//대칭일 때 오류체크넣기
	{
		String res="";
		boolean bCheck=true;
		for(int i=0; i<a.length()/2;i++)
		{
			char start=a.charAt(i);
			char end=a.charAt(a.length()-1-i);
			if(start!=end)
			{
				bCheck=false;
				break;
			}
		}
		if(bCheck==true)
			res="좌우대칭입니다";
		else
			res="좌우대칭이 아닙니다";
		
		return res;
				
	}
	//문자열을 거꾸로 출력하는 메소드를 구현하시오
	static void print_down(String a)
	{
		//System.out.println(new StringBuilder(a).reverse());
		for(int i=a.length()-1;i>=0;i--)
		{
			System.out.print(a.charAt(i));
		}
	}
	

	
	static boolean check_year(int year)
	{
		boolean bCheck = false;
		if(year%4==0 && year%100!=0 || year%400==0)
		{
			bCheck = true;
		}
		else
			bCheck = false;
		
		return bCheck;
	}
	//13. 년,월,일을 입력받아서 요일을 구하는 메소드를 구현하시오
	
	static void date(int year, int month, int day)
	{
		int total=(year-1)*365
				+(year-1)/4
				-(year-1)/100
				+(year-1)/400;  //윤년처리
	
		//전달까지의 날 수
		int[] lastday= {31,25,31,30,31,30,31,31,30,31,30,31};  //월별 날 수
		if(year%4==0 && year%100!=0 || year%400==0)
			lastday[1]=29;
		else
			lastday[1]=28; //2월날짜 변경하기 위한 코드
		
		for(int i=0;i<month-1;i++)
		{
			total+=lastday[i];
		}
		
		//입력날
		total+=day;  // 
		//요일구하기
		char[] strWeek= {'일', '월', '화', '수', '목', '금', '토'};
		int week = total%7;
		
		System.out.println(year+"년도\t"+month+"월"+strWeek[week]+"요일입니다");
		System.out.println();
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int num=10;
//		print(num);  //1번 
		
		
//		System.out.println();
//		System.out.println(sum(num)); //2번, 3번
		
		
//		Scanner scan=new Scanner(System.in);
//		System.out.print("정수1 입력 : ");
//		int num1 = scan.nextInt();
//		System.out.print("정수2 입력 : ");
//		int num2 = scan.nextInt();
//		div1(num1,num2);
//		System.out.println(num1+"/"+num2+"="+div2(num1,num2));//4번
		
		
//		Scanner scan=new Scanner(System.in);
//		System.out.print("알파벳 입력 : ");
//		char ch = scan.next().charAt(0);
//		System.out.println(change(ch));//5번
		
		
//		Scanner scan=new Scanner(System.in);
//		System.out.print("문자열 입력 : ");
//		String str = scan.nextLine();
//		System.out.println(check(str));//6번
		
//		Scanner scan=new Scanner(System.in);
//		System.out.print("문자열 입력 : ");
//		String str = scan.nextLine();
//		print_down(str);				//7번
		
		
//		Scanner scan=new Scanner(System.in);
//		System.out.print("년도 입력 : ");
//		int year = scan.nextInt();
//		System.out.println(check_year(year));
//		
		
		Scanner scan=new Scanner(System.in);
		System.out.print("년도 입력 : ");
		int year = scan.nextInt();
		
		System.out.print("월 입력 : ");
		int month = scan.nextInt();
		
		System.out.print("일 입력 : ");
		int day = scan.nextInt();
		
		date(year, month, day);
		
		
		
	}

}
