//3명의 학생 점수(국어, 영어, 수학) 점수를 입력받아 평균 총점 학점받기


import java.util.*;
public class 반복문_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int i=1;
		int sum=0;
		while(i<=3)
		{
			
			System.out.println(i+"번째 국어 점수 입력 : ");
			int kor = scan.nextInt();
			
			System.out.println(i+"번째 영어 점수 입력 : ");
			int eng = scan.nextInt();
			
			System.out.println(i+"번째 수학 점수 입력 : ");
			int math = scan.nextInt();
			
			int total=kor+eng+math;
			double avg=total/3.0;
			
			char score = 'A';
			switch(total/30)
			{
				case 10 : 
				case 9:
					score='A';
					break;
				case 8:
					score='B';
					break;
				case 7:
					score='C';
					break;
				case 6:
					score='D';
					break;
				default :
					score='F';
			}
			
			
			System.out.println("국어 점수 : "+ kor);
			System.out.println("영어 점수 : "+ eng);
			System.out.println("수학 점수 : "+ math);
			System.out.println("총 점수 : "+ total);
			System.out.printf("평균 점수 %.2f : ",avg);
			System.out.println("학점 : "+ score);
			
			i++;
			}
			
			
			
	}
		
	

}
