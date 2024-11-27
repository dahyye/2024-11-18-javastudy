/*
 
 	자바에서 지원하는 제어문
 		조건문 : 요청에 맞는 문장만 실행 => 건너뛰는 경우도 있다
 			  => 오류 방지 (if문으로 처리가 어려운 과정 : 예외처리 )
 			단일 조건문 
 				if(조건문){  // 조건문은 true, false
 						   // 연산자 -> 부정연산자, 비교연산자, 논리연산만 사용가능
 					조건문이 true일 경우에만 처리하는 문장
 				
 				}
 				false ->건너뛴다
 				=> 독립적으로 실행 => if문을 여러개 사용하면 속도가 저하
 				
 				=> 아이디 중복체크, 검색, 상세보기, 예약내용
 			선택 조건문
 				나눠서 처리
 				if(조건문)
 				{
 					조건이 true
 				}
 				if(조건문)
 				{
 					조건이 false
 				}
 				ex. 로그인할 때 로그인이 되면 main화면으로 이동 => if
 							로그인이 안되면 (back, 회권가입) 으로 이동  => else
 			
 			다중 조건문
 			
 		선택문 /// 많이쓰지않아  =>게임, 네트워크에서 사용
 		반복문
 			while : 무조건 1번이상 수행 => 데이터베이스 / 파일 에서 많이 사용
 			do~while : 반복횟수가 없는 경우
 			for => 반복횟수가 정해져있다.  코딩테스트 / 정보처리실기가 편해져
 		반복제어문
 			break 반복을 종료
 			continue 특정부분을 제외하고 다시 반복 시작
 		
 	
 		1. 중첩 조건문
 			컴퓨터와 사용자의 가위 바위 보 게임
 
 */
import java.util.Scanner;
public class 제어문_조건문1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.print("가위(0) 바위(1) 보(2)를 입력 : ");
		
		int player = scan.nextInt();
		System.out.println();
		int com= (int)(Math.random()*3);
		System.out.print("player : " );
		if(player==0) {
			System.out.println("가위");
		}
		if(player==1) {
			System.out.println("바위");
		}
		if(player==2) {
			System.out.println("보");
		}
		
		System.out.print("com    : " );
		if(com==0) {
			System.out.println("가위");
		}
		if(com==1) {
			System.out.println("바위");
		}
		if(com==2) {
			System.out.println("보");
		}
		
		
		System.out.println("=====결과=====");
		
		/*
		
		if(com==0&&player==0)
			System.out.println("비겼다");
		if(com==0&&player==1)
			System.out.println("비겼다");
		if(com==0&&player==2)
			System.out.println("비겼다");
		
		*/
		
		if(player==0) {
			
			if(com==0) {
				System.out.println("비겼습니다");
			}
			if(com==1) {
				System.out.println("플레이어가 졌습니다");
			}
			if(com==2) {
				System.out.println("플레이어가 이겼습니다");
			}
		}
		
		if(player==1) {
			if(com==0) {
				System.out.println("플레이어가 이겼습니다");
			}
			if(com==1) {
				System.out.println("비겼습니다");
			}
			if(com==2) {
				System.out.println("플레이어가 졌습니다");
			}
		}
		
		
		
		if(player==2) {
			if(com==0) {
				System.out.println("플레이어가 졌습니다");
			}
			if(com==1) {
				System.out.println("플레이어가 이겼습니다");
			}
			if(com==2) {
				System.out.println("비겼습니다");
			}
		}
		
		
		
		
		
	}

}
