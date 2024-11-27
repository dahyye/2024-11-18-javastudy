/*
 
 	선택문 : 다중조건문을 단순화 시킨 제어문
 	     => 한 개만 수행이 가능
 	     => 게임 / 네트워크
 	     => ------------ 값을 한 개만 선택(선택문), 범위(다중조건문)
 	     => 자바에서 데이터베이스는 처리범위가 워낙 넓기 때문에
 	     	범위지정이 어려운 switch-case는 많이 사용하진 않아
 	    
 	 
 	 1. 형식
 	 
 		switch(정수 or 문자 or 문자열)  // c언어에서는 정수나 문자만 가능
 		
 		1)정수 => 메뉴만들 때
 		switch(no) => no=1,2,3,4,5 등
 		{
 			case(0) : 
 				처리문장
 				break; // 종료 break는 반드시 주는 것은 아니다
 						  같은 내용을 실행 할 때가 있다
 						  
 			case(1) : 
 				처리문장1
 			case(2) : 
 				처리문장2
 			case(3) : 
 				처리문장3
 			default : 
 				처리문장4 // else같은 역할
 				
 			
 			// 학점처리 할 때는 점수가 0~100까지라서 case문 쓰기 어려워
 			 	case문 사용하려면 점수를 10으로 나눠서 등급나누기
 			
 			
 		
 */
public class 자바선택문_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int score = (int)(Math.random()*101);
		int avg=score/10; // 소수점을 int로 받으면 소수점 뒷 자리가 다 사라져 ex. 0.5=0, 1.4=1
		System.out.println("score = "+score);
		System.out.println("avg = "+avg);
		switch(avg)
		{
			case 10 :
			case 9:
				System.out.println(score+"점은 A등급입니다.");
				break;
			case 8:
				System.out.println(score+"점은 B등급입니다.");
				break;
			case 7:
				System.out.println(score+"점은 C등급입니다.");
				break;
			case 6:
				System.out.println(score+"점은 D등급입니다.");
				break;
			default:
				System.out.println(score+"점은 F등급입니다."); //생략가능, 마지막은 break를 안해도 상괎없어
				
		}
	}

}
