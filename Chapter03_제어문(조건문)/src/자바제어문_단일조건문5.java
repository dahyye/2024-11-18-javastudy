/*
 
 	국어, 영어, 수학 => 입력 총점 평균 학점
 
 */
import java.util.Scanner;
public class 자바제어문_단일조건문5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.print("국어성적을 입력 : ");
		int kor=scan.nextInt();
		
		System.out.print("영어성적을 입력 : ");
		int eng=scan.nextInt();
		
		System.out.print("수학성적을 입력 : ");
		int math=scan.nextInt();
		
		int total=kor+eng+math;
		double avg=total/3.0;
		
		System.out.println("====결과값====");
		System.out.println("국어성적 : "+kor);
		System.out.println("영어성적 : "+eng);
		System.out.println("수힉성적 : "+math);
		System.out.printf("평균 : %.2f\n", avg); //%.2f 소수점2자리표현
		
		
		
		char score='A';
		int temp=(total/3); //[ total/30 ]으로 나눠서 if문 범위를 10,9,8,이렇게 나눌 수도 있어)
		if(avg>=90 && avg <=100) {
		score='A';
			System.out.println("등급은 "+ score);
		}
		if(avg>=80 && avg <90) {
			score='B';
			System.out.println("등급은 "+ score);
		}
		if(avg>=70 && avg <80) {
			score='C';
			System.out.println("등급은 "+ score);
		}
		if(avg>=60 && avg <70) {
			score='D';
			System.out.println("등급은 "+ score);
		}
		if(avg<60) {
			score='F';
			System.out.println("등급은 "+ score);
		}
		
		
		
		
		
		
	}

}
