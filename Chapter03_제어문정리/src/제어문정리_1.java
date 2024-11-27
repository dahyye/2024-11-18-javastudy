/*
 
 
 	
 영문 대문자를 입력받아 'A'이면 "훌륭합니다.", 'B'이면 "좋습니다.", 'C'이면 "보통입니다.", 'D'이면 "노력하세요." 그 이외 문자는 "잘못 입력하셨습니다."라고 출력하는 프로그램
 
 */
import java.util.*;
public class 제어문정리_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Scanner scan=new Scanner(System.in);
//		System.out.print("영문 대문자를 입력하세요 :");
//		char ch = scan.next().charAt(0);
//		
//		switch(ch)
//		{
//			case 'A' :
//				System.out.println("훌륭합니다");
//				break;
//			case 'B' :
//				System.out.println("좋습니다");
//				break;
//			case 'C' :
//				System.out.println("보통입니다");
//				break;
//			case 'D' :
//				System.out.println("노력하세요");
//				break;
//			default :
//				System.out.println("잘못입력하셨습니다.");
//		}
	
//		for(int i=1;i<=5;i++) {
//			for(int j=1;j<=5;j++)
//			{
//				if(i==j)
//					System.out.print("["+i+","+j+"]");
//				System.out.print("  ");
//			}
//			System.out.println();
//		}
		
		
//		int[] arr= {100,200,300,400,500};
//		int sum=0;
//		
//		for(int i=0;i<arr.length;i++)
//		{
//			System.out.print(arr[i]+"");
//		}
//		System.out.println();
//		for(int temp : arr)
//		{
//			System.out.print(temp);
//			sum+=temp;
//		}
//		System.out.println("\n"+sum);
		
		
//	xooox
//	oxoxo
//	ooxoo
//	oxoxo
//	xooox  출력하기
		
		for(int i=1; i<=5;i++)
		{
			for(int j=1; j<=5;j++)
			{
				
				if(i==j||6-i==j)
				{
					System.out.print("x");
				}
				else
				{
					System.out.print("o");
				}
			}
			System.out.println();
		}
		
	
	
		
			
		
	}

}
