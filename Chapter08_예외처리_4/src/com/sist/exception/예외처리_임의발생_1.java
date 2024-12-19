package com.sist.exception;
import java.util.Scanner;
/*
 
 
 */
public class 예외처리_임의발생_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("국어점수 입력: ");
			int kor =scan.nextInt();
			if(kor<0||kor>100)
			{
				//잘못된 입력이다 -> 직접처리
				//catch를 불러올 수 있다
				//테스트(배포시) 사용
				//거의 쓰이지 않아
				throw new IllegalArgumentException("점수는 0이상 100이하만 가능합니다");
				
				//throw => 필요시에 의해 catch를 호출할 수 있다
				//아래는 코딩이 불가능하다
				//catch문으로 이동하기 때문에 밑에 문장을 수행할 수 없다
			}
		} catch (IllegalArgumentException e) {
			
			
		}
	}

}
