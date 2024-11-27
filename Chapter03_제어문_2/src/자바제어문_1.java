/*
 	변수는 선언 시 초기화가 필요
 	방법은 여러가지
 	1. 명시적인 초기화 => int a=1;
 	2. 난수입력받기 => int a=(int)(Math.random())
 	3. 사용자로부터 입력받기 => Scanner 사용
 	4. 파일읽기 => 데이터베이스로부터 데이터 가져오기
 	
 	네트워크 => 게임
 	데이터베이스 => 웹 ==> 조별 프로젝트가 이 데이터베이스 활용해서 만들기
 
 */

// 정수 입력받아서 학점 출력


import java.util.*;
public class 자바제어문_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int score = (int)(Math.random()*101); // 0~100
		System.out.println("score = " + score);
		
		
		if(score >=90) // 다중조건문이라 실행하고나면 빠져나가서 조건이 간단해져
			System.out.println(score+"점은 A등급입니다.");
		else if(score >=80) 
			System.out.println(score+"점은 B등급입니다.");
		else if(score >=70) 
			System.out.println(score+"점은 C등급입니다.");
		else if(score >=60) 
			System.out.println(score+"점은 D등급입니다.");
		else
			System.out.println(score+"점은 F등급입니다.");
		
	}

}
