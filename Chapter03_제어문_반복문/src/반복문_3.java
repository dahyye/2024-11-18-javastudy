/*
 사용자로부터 값을 받아서 구구단 출력 
*/

import java.util.*;
public class 반복문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		Scanner scan = new Scanner(System.in);
		System.out.print("구구단 단 수를 입력하세요 : ");
		int a = scan.nextInt();
		System.out.println("=====결과값=====");
		for(int i=1 ; i<=9 ; i++)
		{
		
			System.out.println(a+"*"+i+"="+(a*i));
		}
		*/
		for(int i=1 ; i<=9 ; i++)
		{
			System.out.println(i+"단");
			for(int j=1 ; j<=9 ; j++)
			{
				System.out.println(i+"*"+j+"="+(i*j));
			}
		}
		
		
	}

}
