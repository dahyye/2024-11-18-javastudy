/*
 
 	점수를 입력받아서
 	학점출력 A~D, F
 	score>=90 && score<=100
 	score>=80 && score<90
 	score>=70 && score<80
 	score>=60 && score<70
 	score<60
 
 	조건을 걸 때 
 	알파벳 => 대문자 조건 65~90
 			c>='A' && c<='Z'
 			소문자 조건 97~122
 			c>='a' && c<='z'
 			
 	알파벳인지 조건? 대문자 소문자 범위가 전혀 달라서 or로 묶어줘야함
 			c>='A' && c<='Z' ||  c>='a' && c<='z'
 			
 
 */
import java.util.Scanner;
public class 연산자_삼항연산자3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		
		  Scanner scan=new Scanner(System.in); //system.in 키보드로부터 입력값을 받는다
		  System.out.println("점수를 입력 : ");
		  
		  int score = scan.nextInt(); System.out.println(score<=0 || score>100 ?
		  "비정상입력" : "정상입력"); //정수받을 땐 nextInt, 실수 nextDouble;
		  System.out.println("=====결과값====="); System.out.print(score>=90 &&
		  score<=100? "A학점" : ""); System.out.print(score>=80 && score<90? "B학점" : "");
		  System.out.print(score>=70 && score<80? "C학점" : "");
		  System.out.print(score>=60 && score<70? "D학점" : "");
		  System.out.print(score<60 && score>=0? "F학점" : "");
		 
		 
		
		System.out.println((int)'a');
		System.out.println((int)'z');
		System.out.println((int)'A');
		System.out.println((int)'Z');
		
	}

}
