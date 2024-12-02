/*
 5명의 학생의 국어점수를 받아서 등수를 출력하는 프로그램 작성
10개의 임의의 정수를 받아서 최대값,최소값(난수)  구하는 프로그램 작성
100 개의 난수(0~9)를 발생하여 빈도수를 구하는 프로그램을 작성하시오
10개의 난수를 발생하여 배열에 저장한 후에 인덱스가 1인 곳의 값을 출력하시오.
위 문제 배열 중에서 최대값의 인덱스를 출력하시오. 
10개의 난수를 배열 안의 모든 값을 더하고, 총합과 평균을 출력하시오.
10개의 난수를 배열에 저장 후에 배열의 인덱스가 3인 곳은 출력하지 말고, 나머지만 출력하시오
5개의 난수를 배열에 저장한 후에 인덱스번호 두개를 받아서 값을 교환하는 프로그램을 작성하시오
char 배열을 생성하여, 알파벳 A~Z까지 대입 후, 출력하시오
위문제를 역순으로 출력하시오
정수 10개를 입력받아 배열에 저장하고, 배열에 있는 정수 중에서 3의 배수만 출력하시오
10개의 정수를 입력받아서 짝수의 최대값,홀수의 최대값을 출력하는 프로그램을 작성하시오
 3명의 학생에 대한 국어,영어,수학 점수를 입력받아서 저장후에 총점,평균,등수를 구하고 국어점수 총점,영어점수 총점,수학점수의 총점을 구해서 출력하는 프로그램을 작성하시오
 
 
 
 */
import java.util.*;
public class 배열_문제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1. 5명의 학생의 국어점수를 받아서 등수를 출력하는 프로그램 작성
		
		
//		Scanner scan = new Scanner(System.in);
//		int kor[] = new int[5];
//		int rank[] = new int[5];
//		for(int i=0;i<kor.length;i++)
//		{
//			System.out.print((i+1)+"번째 학생의 국어점수 입력 : ");
//			kor[i]=scan.nextInt(); 
//		}
//		
//		System.out.println(Arrays.toString(kor));
//		for(int i=0;i<kor.length;i++)
//		{
//			rank[i]=1;
//			for(int j=0;j<kor.length;j++)
//			{
//				if(kor[i]<kor[j])
//				{
//					rank[i]++;
//				}
//			}
//		}
//		
//		System.out.println(Arrays.toString(rank));
		
		
		
		
		
//		2. 10개의 임의의 정수를 받아서 최대값,최소값(난수)  구하는 프로그램 작성		
//		int arr[] = new int[10];
//		
//		for(int i=0;i<arr.length;i++)
//		{
//			arr[i]=(int)(Math.random()*100)+1;
//		}
//		
//		int max=0;
//		int min=100;
//		
//		for(int i=0;i<arr.length;i++)
//		{
//			if(arr[i]>max)
//			{
//				max=arr[i];
//		
//			}
//			if(arr[i]<min)
//			{
//				min=arr[i];
//				
//			}
//		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println("최대값은 "+max);
//		System.out.println("최소값은 "+min);
		
		
		
//		3. 100 개의 난수(0~9)를 발생하여 빈도수를 구하는 프로그램을 작성하시오
//		int num=0;
//		int[] arr = new int[10];
//		for(int i=0;i<100;i++)
//		{
//			num=(int)(Math.random()*10);
//			System.out.print(num+" ");
//			arr[num]++;
//			
//		}
//		System.out.println();
//		System.out.println(Arrays.toString(arr));
	

		
//		4. 10개의 난수를 발생하여 배열에 저장한 후에 인덱스가 1인 곳의 값을 출력하시오.
//		5. 위 문제 배열 중에서 최대값의 인덱스를 출력하시오
		
//		int arr[] = new int[10];
//		int max=0;
//		for(int i=0;i<arr.length;i++)
//		{
//			arr[i]=(int)(Math.random()*100)+1;
//			System.out.print(arr[i]+" ");
//			if(arr[i]>max)
//			{
//				max=arr[i];
//			}
//		}
//		System.out.println();
//		System.out.println("인덱스가 1인 곳의 값: "+arr[1]);
//		System.out.println("최대값: "+max);
//		
		
		
		
//		6. 10개의 난수를 배열 안의 모든 값을 더하고, 총합과 평균을 출력하시오.		
		
//		int arr[] = new int[10];
//		int sum=0;
//		for(int i=0;i<arr.length;i++)
//		{
//			arr[i]=(int)(Math.random()*100)+1;
//			sum+=arr[i];
//		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println("총합은 : "+sum);
//		System.out.printf("평균은 : %.2f",(double)(sum/10.0));
		
		
//		7. 10개의 난수를 배열에 저장 후에 배열의 인덱스가 3인 곳은 출력하지 말고, 나머지만 출력하시오
		
//		int arr[] = new int[10];
//		for(int i=0;i<arr.length;i++)
//		{
//			arr[i]=(int)(Math.random()*100)+1;
//		}
//		for(int i=0;i<arr.length;i++)
//		{
//			
//			if(i==3)
//			{
//				System.out.print("     ");
//			}
//			System.out.print(arr[i]+" ");
//			
//		}
		
//		8. 5개의 난수를 배열에 저장한 후에 인덱스번호 두개를 받아서 값을 교환하는 프로그램을 작성하시오		
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.print("인덱스 번호 a 선택 : ");
//		int a = scan.nextInt();
//		System.out.print("인덱스 번호 b 선택 : ");
//		int b = scan.nextInt();
//		
//		int arr[] = new int[5];
//		for(int i=0;i<arr.length;i++)
//		{
//			arr[i]=(int)(Math.random()*100)+1;
//		}
//		System.out.println("변경 전 : "+Arrays.toString(arr));
//		int change=0;
//		change=arr[a];
//		arr[a]=arr[b];
//		arr[b]=change;
//		
//		
//		System.out.println("변경 후 : "+Arrays.toString(arr));
		
		
		
//		9. char 배열을 생성하여, 알파벳 A~Z까지 대입 후, 출력하시오
//		10. 위문제를 역순으로 출력하시오
//		char arr[] = new char[26];
//		char c='A';
//		for(int i=0;i<arr.length;i++)
//		{
//			arr[i]=c++;
//		}
//
//		for(char a:arr)
//		{
//			System.out.print(a+" ");
//		}
//		System.out.println();
//		System.out.print("역순");
//		char cc='Z';
//		for(int i=0;i<arr.length;i++)
//		{
//			arr[i]=cc--;;
//		}
//		for(char a:arr)
//		{
//			System.out.print(a+" ");
//		}
		
		
//		11. 정수 10개를 입력받아 배열에 저장하고, 배열에 있는 정수 중에서 3의 배수만 출력하시오
		
//		int arr[] = new int[10];
//		
//		for(int i=0;i<arr.length;i++)
//		{
//			arr[i]=(int)(Math.random()*100)+1;
//		}
//		System.out.print("랜덤 값 : ");
//		for(int i :arr)
//		{
//			System.out.print(i+" ");
//		}
//		System.out.println();
//		System.out.print("그 중3의 배수 : ");
//		for(int i=0;i<arr.length;i++)
//		{
//			if(arr[i]%3==0)
//			{
//				System.out.print(arr[i]+" ");
//			}
//			
//		}
		
		
//     12. 10개의 정수를 입력받아서 짝수의 최대값,홀수의 최대값을 출력하는 프로그램을 작성하시오		
		
//		Scanner scan = new Scanner(System.in);
//		int arr[] = new int[10];
//		int max_홀 = 0;
//		int max_짝 = 0;
//		for(int i=0;i<arr.length;i++)
//		{
//			System.out.print((i+1)+"번째 정수 입력 : ");
//			arr[i]=scan.nextInt(); 
//			if(arr[i]%2==0)
//			{
//				if(arr[i]>max_짝)
//					max_짝=arr[i];		
//			}
//			else
//			{
//				if(arr[i]>max_홀)
//					max_홀=arr[i];
//			}
//				
//		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println("짝수의최대값 : "+max_짝);
//		System.out.println("홀수의최대값 : "+max_홀);
		

		
//		13. 3명의 학생에 대한 국어,영어,수학 점수를 입력받아서 저장후에 총점,평균,등수를 구하고 국어점수 총점,영어점수 총점,수학점수의 총점을 구해서 출력하는 프로그램을 작성하시오
		Scanner scan = new Scanner(System.in);
		
		int kor[] = new int[3];
		int eng[] = new int[3];
		int math[] = new int[3];
		int total[] = new int[3];
		int kor_total = 0;
		int eng_total = 0;
		int math_total = 0;
		double avg[] = new double[3];
		for(int i=0;i<kor.length;i++)
		{
			System.out.print((i+1)+"국어 성적 입력 : ");
			kor[i]=scan.nextInt();
			System.out.print((i+1)+"영어 성적 입력 : ");
			eng[i]=scan.nextInt();
			System.out.print((i+1)+"수학 성적 입력 : ");
			math[i]=scan.nextInt();
			
			total[i]=kor[i]+eng[i]+math[i];
			avg[i]=total[i]/3.0;
			kor_total += kor[i]; 
			eng_total +=eng[i];
			math_total +=math[i];
		}

		
		System.out.println("총점 : "+ Arrays.toString(total));
		System.out.println("평균 : "+ Arrays.toString(avg));
		
		int score[] = new int[3];
		for(int i=0;i<kor.length;i++)
		{
			score[i]=1;
			for(int j=0;j<kor.length;j++)
			{
				if(total[i]<total[j])
				{
					score[i]++;
				}
				
			}
		}
		System.out.println("등수 : "+ Arrays.toString(score));
		
		
	}

}
