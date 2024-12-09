//3명의 학생 국/영/수 => 총점, 평균, 학점
import java.util.Scanner;

class Student
{
	String name;
	int kor,eng,math;
	int total;
	double avg;
	char score;
}

public class 클래스_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] std=new Student[3];//배열선언
		//초기화
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<std.length;i++)
		{
			std[i]=new Student();//학생 1명에 대한 저장공간 만들기
			//System.out.println(std[i]);
			System.out.print((i+1)+"번째 국어 입력:");
			std[i].kor=scan.nextInt();
			System.out.print((i+1)+"번째 영어 입력:");
			std[i].eng=scan.nextInt();
			System.out.print((i+1)+"번째 수학 입력:");
			std[i].math=scan.nextInt();
			
			std[i].total=std[i].kor+std[i].math+std[i].eng;
			std[i].avg=std[i].total/3.0;
			
			switch(std[i].total/30)
			{
				case 10: case 9:
					std[i].score='A';
					break;
				case 8:
					std[i].score='B';
					break;
				case 7:
					std[i].score='C';
					break;
				case 6:
					std[i].score='D';
					break;
				default : 
					std[i].score='F';
					
			}
			
		}
		for(int i=0;i<std.length;i++)
		{
			System.out.printf("%-5d %-5d %-5d%-7d%-7.2f %-5c\n",std[i].kor,std[i].math,std[i].eng,std[i].total,std[i].avg,std[i].score);
		}
		
	}

}
