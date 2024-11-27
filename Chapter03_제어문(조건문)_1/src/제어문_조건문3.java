/*
 
 	중첩조건문사용
 	3개의 점수를 받아서 총점을 구하고 평균, 학점을 구해서 출력
 	=> 97이상a+ 94이상 a0 90 a-
 	
 
 */
import java.util.Scanner;
public class 제어문_조건문3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan= new Scanner(System.in);
		System.out.print("국어점수를 입력해주세요 : ");
		int kor = scan.nextInt();
		System.out.print("영어점수를 입력해주세요 : ");
		int eng = scan.nextInt();
		System.out.print("수학점수를 입력해주세요 : ");
		int math = scan.nextInt();
		//점수입력
		int sum=kor+eng+math;
		//총점
		double avg = sum/3.0;
		//평균
		
		
		 //97이상a+ 94이상 a0 90 a-
		
		char score = 'A', opt = '+'; // 초기값 넣기
		int avg2=(int)avg; // 평균점수의 소수점 없애기
		if(avg2>=90&&avg2<=100){
			
			score='A';
			if(avg2>=90&&avg2<94) {
				opt='-';
			}
			if(avg2>=94&&avg2<97) {
				opt='-';
			}
			if(avg2>=97&&avg2<100) {
				opt='-';
			}
		}
		if(avg2>=80&&avg2<90){
			
			score='B';
			if(avg2>=80&&avg2<84) {
				opt='-';
			}
			if(avg2>=84&&avg2<87) {
				opt='-';
			}
			if(avg2>=87&&avg2<90) {
				opt='-';
			}
		}
		if(avg2>=70&&avg2<80){
	
			score='C';
			if(avg2>=70&&avg2<74) {
				opt='-';
			}
			if(avg2>=74&&avg2<77) {
				opt='-';
			}
			if(avg2>=77&&avg2<80) {
				opt='-';
			}
		}
		
		if(avg2>=60&&avg2<70){
			
			score='d';
			if(avg2>=60&&avg2<64) {
				opt='-';
			}
			if(avg2>=64&&avg2<67) {
				opt='-';
			}
			if(avg2>=67&&avg2<70) {
				opt='-';
			}
		}
		if(avg2<60) {
			score='f';
			opt='0';
		}
		
		
		System.out.println("=======결과값========");
		System.out.println("국어 점수 : "+ kor);
		System.out.println("영어 점수 : "+ eng);
		System.out.println("수학 점수 : "+ math);
		System.out.println("총점수   : "+ sum);
		System.out.printf("평균 점수 : %.2f\n", avg);
		System.out.println("학점     : "+score+" "+opt);
		
	}

}
