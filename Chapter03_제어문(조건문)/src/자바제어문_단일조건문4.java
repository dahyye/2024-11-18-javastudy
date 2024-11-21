/*
 	윤년구하기
 	-------
 	윤년에 대한 조건
 	1. 4년마다 한 번씩
 	2. 100년마다 한 번씩은 제외
 	3. 400년마다 한 번씩 윤년
 	
 	
 */
import java.util.Scanner;
public class 자바제어문_단일조건문4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	Scanner scan = new Scanner(System.in);
	System.out.print("년도를 입력 : ");
	int a = scan.nextInt();
		if(a%4==0&& a%100==0||(a%400==0)) {
				
				System.out.println(a+"는 윤년입니다");
		
		}
		if(!(a%4==0&& a%100==0||(a%400==0))){
			System.out.println(a+"는 윤년이아니다");
		}
		
		
				
	}
			
}
