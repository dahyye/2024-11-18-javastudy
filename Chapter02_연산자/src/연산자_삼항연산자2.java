//사용자로부터 값을 받아서 => 합격여부 (60점이상 합격)

import java.util.Scanner;
public class 연산자_삼항연산자2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
	//   클래스   객체명  저장할메모리 생성자
		System.out.println("0~100점 사이의 점수 입력 : ");
		
		int score = scan.nextInt();
		System.out.println(score>=60 ? "합격" : "불합격");
		
	}

}
