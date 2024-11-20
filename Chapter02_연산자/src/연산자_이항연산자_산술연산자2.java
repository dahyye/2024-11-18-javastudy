
/*
 	1. 출력
 		system.out.print이 3가지는 보통 오류출력시 많이 사용
 							개발자가 확인할 때 사용
 		system.out.print() // 가로출력
 			
 		system.out.printf() // 출력서식을 만들어 출력, c언어출력
 								=> jdk1.8이상에서만 실행가능
 								
 		system.out.println() // 자동줄바꿈 => 에러출력시 사용
 		
 
 
 
 
 
 
 */
public class 연산자_이항연산자_산술연산자2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int kor=90;
		int eng=80;
		int math=80;
		
		System.out.println("국어:"+kor);
		System.out.println("영어:"+eng);
		System.out.println("수학:"+math);
		System.out.println();
	
		System.out.print("국어:"+kor+", 영어:"+eng+", 수학:"+math);
		System.out.println();
		System.out.println();

		System.out.printf("국어:%d, 영어:%d, 수학:%d", kor, eng, math);
				//%d 정수 %f 실수 %s 문자열 %c 문자입력시
		System.out.println();
		
		System.out.printf("%.2f",5/2.0);
				//소수점 자리수 설정가능
		
	}

}
