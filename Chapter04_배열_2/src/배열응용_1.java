/*
 
 	3명의 학생
 	=> 국영수성적입력
 	
 	총점, 평균, 학점, 등수 출력
 	
 
 */
import java.util.*;
public class 배열응용_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] kor = new int[3];  //인덱스번호 일치 = 같은학생
		int[] eng = new int[3];
		int[] math = new int[3];
		int[] total = new int[3];
		double[] avg = new double[3]; 
		char[] score = new char[3];
		int[] rank = new int[3];
		
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<kor.length;i++)
		{
			System.out.print((i+1)+"국어 성적 입력 : ");
			kor[i]=scan.nextInt();
			System.out.print((i+1)+"영어 성적 입력 : ");
			eng[i]=scan.nextInt();
			System.out.print((i+1)+"수학 성적 입력 : ");
			math[i]=scan.nextInt();
			
			total[i] = kor[i]+eng[i]+math[i];
			avg[i]=total[i]/3.0;
		}
		
		for(int i=0;i<kor.length;i++)
		{
			switch((int)(avg[i]/10))
			{
				case 10: case 9:
					score[i]='A';
					break;
				case 8:
					score[i]='B';
					break;
				case 7:
					score[i]='C';
					break;
				case 6:
					score[i]='D';
					break;
				default :
					score[i]='F';
					
			}
		}
		//등수계산
		for(int i=0;i<kor.length;i++)
		{
			rank[i]=1;
			for(int j=0;j<kor.length;j++)
			{
				if(total[i]<total[j])
					rank[i]++;
			}
		}
	
		for(int i=0;i<kor.length;i++)
		{
			System.out.printf("%5d%5d%5d%7d%7.2f%3c%-5d\n",kor[i],eng[i],math[i],total[i],avg[i],score[i],rank[i]);
			//%5d하는 이유는 공백 3개를 만들기 위해서 5d는 5자리를 출력하는 코드
			//%-5d는 앞자리부터 채우기 때문에 뒤에 빈 자리를 만들 수 있어
		}
		
		
	
		
		
		
		
		
		
	}

}
