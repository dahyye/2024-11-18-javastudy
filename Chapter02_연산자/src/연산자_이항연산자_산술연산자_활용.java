/*
 	국어, 영어, 수학점수 입력받아서
 	평균, 총점 출력하기
 	
 	변수 => 무조건 초기화해서 사용
 	1. 임의로 설정하기 int =100;
 	2. 사용자로부터 입력값을 받아서 처리 scanner
 	3. 컴퓨터가 임의로 설정 => 난수 (랜덤)
 
 */
import java.util.Scanner;
public class 연산자_이항연산자_산술연산자_활용 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner 클래스를 메모리에 저장
		// 입력값을 받아서 변수에 저장
		Scanner scan=new Scanner(System.in);
		System.out.println("국어 영어 수학점수 입력(90 90 90): ");
		//사용자 입력을 받는다
		int kor=scan.nextInt();
		int eng=scan.nextInt();
		int math=scan.nextInt();
	
		//처리 => 결과값출력
		System.out.println("=======결과값=======");
		System.out.println("국어 점수 : "+kor);
		System.out.println("영어 점수 : "+eng);
		System.out.println("수학 점수 : "+math);
		//+ 연산자 => 문자열 결합
		
		System.out.println("총점 : " + (kor+eng+math));
		// 연산자의 우선 순위 변경 ()를 활용
		
		System.out.printf("평균 : %.2f", (kor+eng+math)/3.0);
		//.2f로 소수점 두자리만 표현
		
		
	}

}
