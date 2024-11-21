/*
 	자바에서 지원하는 제어문
 		=> 프로그램의 흐름을 제어하기 위해
 			필요시에는 건너뛰는 프로그램을 만들 수 있다 (조건문)
 			반복수행을 요청 (반복문)
 			중간에 정지시킬 수 있음 (반복제어문) => ESC
 		=> 자바의 모든 제어문은 바로 밑에 있는 문장 1개만 수행한다
 			여러개 동시에 제어하고 싶을 땐 { } 을 이용
 			
 		1. 조건문 54page
 			중복이 있을 땐 단일조건문, 중복이 없다면 다중조건문을 사용 
 			ex. 3,5,7의 배수 -> 중복이 있어서 다중조건문 사용시 누락발생
 			
 			1)단일조건문 (마우스클릭/버튼클릭/상세보기)
 			
 				    => 조건문에는 부정연산자(!)/비교연산자/논리연산자 만 사용가능 => 갸ㅕㄹ과값이 true/false만
 				if(조건문)
 				{
 					실행문장 // true일 때 실행
 				}
 				
 				단일조건문의 단점 => 여러개 사용시에 모든 if문의 조건을 확인해야 해서 속도가 늦다
 				
 			2)선택조건문 => true / false 나눠서 처리
 			
 			3)다중조건문 (메뉴)
 			
 			
 		2. 선택문
 			switch~case (값을 1개만 선택해서 처리)->게임에서 많이 사용, 키값에 따라 처리
 			
 		3. 반복문
 			while
 			do~while
 			for
 			
 		4. 반복제어문
 			break
 			continue => 특정부분을 제외시킬 때 사용
 		
 	
 */
public class 자바제어문 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int score=67;
		if(score>=60) {
			System.out.println("합격");
			System.out.println("프로그램종료");
		}
		
	}

}
