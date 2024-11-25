//한 개의 정수를 입력 받아 1부터 입력 받은 정수까지의 합을 출력하라

import java.util.*;
public class number6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("한 개의 정수를 입력하세요 : ");
		int a = scan.nextInt();
		int sum = 0;
		for (int i=1;i<=a;i++)
		{
			sum=sum+i;
		}
		System.out.println("입력 받은 정수까지의 합은 : "+sum);
		
	}

}
