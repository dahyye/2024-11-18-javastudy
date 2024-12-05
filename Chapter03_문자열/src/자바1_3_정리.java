/*
 
 	변수
 	1. 지역변수
 	2. 멤버변수
 	3. 공유변수
 	
 	메모리 저장 
 	--------------------------------
 	MethodArea : Method / static (공유변수)
 	--------------------------------
 	Stack : 메모리 자체에서 관리 => 지역변수
 			{}이 종료가 된 경우 사라진다
 	--------------------------------
 	Heap : 실제 데이터 공간 : 클래스 / 배열
 			자동으로 해제되지 않는다 => 개발자가 처리
 			new / delete : => 가비지컬렉션
 							  자동 메모리 회수
 							  
 	--------------------------------		
 
 	
 
 */


import java.util.*;
public class 자바1_3_정리 {
	static int userInput(String s)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println(s+" 입력 : ");
		return scan.nextInt();
		
	}
      //멤버변수-자동초기화
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 //지역변수-변수선언시 초기화필수
//		for(int i=0; i<=100;i++)
//		{
//			A a= new A();  // new A()값은 주소
//			System.out.println("a="+a);
//		}
		
		Scanner scan = new Scanner(System.in);
		int year=userInput("년도");
		int month=userInput("월도");
		int day=userInput("일도");
		System.out.printf("%d-%d-%d",year,month,day);
		
		
	}

}
