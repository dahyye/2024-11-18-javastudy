/*
 switch-case는 다중조건물을 간결하게 표현하는데
 웹에서는 범위조건이 많아서 다중조건이 훨씬 편해
 
 1)	100점 만점으로 성적을 입력 받아 90~100이면 A,80~89이면 B,70~79이면 C, 60~69이면 D, 60점 이하면 F를 출력하라 (switch~case 사용)
 */
//import java.util.*;

//자바에서 사용하는 라이브러리, 사용자 정의 클래스를 불러온느 코드
//							(다른 폴더(패키지)에 있는 경우)

/* 자바의 기본 형식
	package 위치지정 => 한 번만 사용이 가능
	import => 여러번 사용 가능
	public class ClassName{
		멤버변수 => 전역변수
		생성자() => 멤버변수 초기화
		사용자 정의 메소드
		main()
	} => 퍼블릭은 1개만!
	class ClsName1
	{
	}



*/
import java.util.*;
public class number1 {
	//static public으로 적어도 가능
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.print("100점 만점으로 성적 입력 : ");
		int score = scan.nextInt();
		int grade = (int)score/10;
		
		switch(grade)
		{
			case(10) :
			case(9)  :
				System.out.println(score+"의 학점은 A입니다");
				break;
			case(8) :
				System.out.println(score+"의 학점은 B입니다");
				break;  // break가 없으면 값이 85가 들어왔을 때 다음 break까지 실행 //결과값 학점 b,c 모두 나와
			case(7) :
				System.out.println(score+"의 학점은 C입니다");
			    break;
			case(6) :
				System.out.println(score+"의 학점은 D입니다");
				break;
			default :
				System.out.println(score+"의 학점은 F입니다");
		}
		
		
	}

}
