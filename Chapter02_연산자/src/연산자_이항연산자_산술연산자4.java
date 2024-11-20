/*
 	입력방식 2가지
 		키보드 입력
 			BufferedReader => java.io
 				=> 예외처리를 해야해서 사용하기 어려워
 				
 			Scanner => java.util
 			
 			사용하기 위해 맨 위에
 			import java.util.Scanner; 입력하고 시작해야 사용할 수 있다
 			// 다른 폴더에 있는 경우에 클래스를 읽어오기 위한 코드
 
 
 */

import java.util.Scanner;
public class 연산자_이항연산자_산술연산자4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//클래스를 메모리에 저장-> new
		
		//Scanner scan=new Scanner(System.in);
		//System.in => keyboard입력값을 받는다
		//연산자_이항연산자_산술연산자4 a=new 연산자_이항연산자_산술연산자4
		Scanner scan=new Scanner(System.in);
		
		
		System.out.print("국어 입력: ");
		int kor=scan.nextInt();//입력한 정수값 읽기	
		
		System.out.print("영어 입력: ");
		int eng=scan.nextInt();//입력한 정수값 읽기
		
		System.out.print("수학 입력: ");
		int math=scan.nextInt();//입력한 정수값 읽기
		
		System.out.println(kor);
		System.out.println(eng);
		System.out.println(math);
		
	}

}
