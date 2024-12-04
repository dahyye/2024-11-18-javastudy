/*
	사용자로부터 단을 입력받아서 구구단 출력

 */

import java.util.Arrays;
import java.util.Scanner;
public class 메소드_4 {
//	static void gugudan(int dan)
//	{
//		
//		for(int i=1;i<=9;i++)
//		{
//			System.out.println(dan+"*"+i+"="+(dan*i));
//		}
//		
//	}
	static String gugudan(int dan)
	{
		String result="";
		for(int i=1;i<=9;i++)
		{
			result+=dan+"*"+i+"="+(dan*i)+"\n";
			
		}
		return result;
		
	}
	static void process()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("단을 입력하세요(2~9) : ");
		int dan=scan.nextInt();
		gugudan(dan);
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process();
		//System.out.println
	}

}
