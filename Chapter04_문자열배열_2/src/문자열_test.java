import java.lang.reflect.Array;
import java.util.Arrays;

public class 문자열_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 1. (1차배열)1번 학생 100점 2번 학생 90점 3번학생 85점이다. 점수를 score 배열 변수에 저장하 고 1) 아래와 같이 출력하시오.
	1번 학생 : 100점  
	2번 학생 : 90점  
	3번 학생 : 85점  

	2) 학생들의 총점을 출력하시요
 */
//		int[] score= {100,90,85};
//		int sum=0;
//		for(int i=0;i<score.length;i++)
//		{
//			System.out.println((i+1)+"번 학생 : "+score[i]+"점");
//			sum+=score[i];
//		}
//		System.out.println("학생들의 총 점수는 : "+sum);
		
/*
 2. 1월달 사원(1번부터 5번사원)의 실적이 50 45 35 12 70 이다. (실적 0~100) 사번별 실적을 출력하시오.
	ex.	사원(1) 50  

	2) 1월 실적의 총점과 평균을 출력하시오.
	3) 실적이 제일 큰 사원의 사번과 실적, 작은 사원의 사번과 실적을 출력하시오.
		
 */
//		int[] point={50,45,35,12,70};
//		int sum=0;
//		for(int i=0;i<point.length;i++)
//		{
//			System.out.println("사원"+"("+(i+1)+")\t"+point[i]);
//			sum+=point[i];
//		}
//		double avg=sum/(double)point.length;
//		System.out.println("1월 실적의 총점 : "+sum);
//		System.out.printf("1월 실적은 평균 : %.2f",avg);
//		
//		int max=point[0];
//		int min=point[0];
//		int index_min=0;
//		int index_max=0;
//		for(int i=0;i<point.length;i++)
//		{
//			if(point[i]>max)
//			{
//				index_max=i;
//				max=point[i];
//			}
//			if(point[i]<min)
//			{
//				index_min=i;
//				min=point[i];
//			}
//		}
//		System.out.println();
////		System.out.println("index_max="+index_max+","+"index_min="+index_min);
//		System.out.printf("실적이 가장 높은 사원은 사원(%d) %d",(index_max+1),max);
//		System.out.printf("실적이 가장 낮은 사원은 사원(%d) %d",(index_min+1),min);

	
	
//	 3. 크기가 10인 정수형 배열을 생성하고 여기에 0부터 9까지의 값으로 배열을 채우는 프로그램 만들기
		
//		int[] arr=new int[10];
//		for(int i=0;i<arr.length;i++)
//		{
//			arr[i]=i;
//		}
//		System.out.println(Arrays.toString(arr));
		
		
//	5. 1~100사이의 정수를 10개 저장하고  
//	   정수형 변수 evenTotal 에 배열 내의 데이터 짝수 합 계산하여 저장 정수형 변수 oddTotal 에 배열 내의 데이터 홀수 합 계산하여 저장
		
//		int[] arr=new int[10];
//		int evenTotal=0;
//		int oddTotal=0;
//		
//		for(int i=0;i<arr.length;i++)
//		{
//			arr[i]=(int)(Math.random()*100)+1;
//			if(arr[i]%2==0)
//			{
//				evenTotal+=arr[i];
//			}
//			else
//			{
//				oddTotal+=arr[i];
//			}
//		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println("짝수합 : "+evenTotal);
//		System.out.println("홀수합 : "+oddTotal);
		
		
		
/*		6. 0~9사이의 난수를 100개 발생해서 
		   빈도를 구해서 출력하시오 
		   예)
		   0의 개수: 1
		   1의 개수: 1
		   ..
		   9의 개수: 0
		
*/		

//		int[] arr=new int[100];
//		int[] count=new int[10];
//
//		for(int i=0;i<arr.length;i++)
//		{
//			count[i]=0;
//			arr[i]=(int)(Math.random()*10);
//		}
//		for(int i=0;i<arr.length;i++)
//		{
//			switch(arr[i])
//			{
//				case 0 : 
//					count[arr[i]]++; break;
//				case 1 : 
//					count[arr[i]]++; break;
//				case 2 : 
//					count[arr[i]]++; break;
//				case 3 : 
//					count[arr[i]]++; break;
//				case 4 : 
//					count[arr[i]]++; break;
//				case 5 : 
//					count[arr[i]]++; break;
//				case 6 : 
//					count[arr[i]]++; break;
//				case 7 : 
//					count[arr[i]]++; break;
//				case 8 : 
//					count[arr[i]]++; break;
//				case 9 : 
//					count[arr[i]]++; break;
//				default :
//			
//			}
//		
//		}
//		System.out.println(Arrays.toString(arr));
//		for(int i=0;i<count.length;i++)
//		{
//			System.out.printf("%d의 개수: %d\n", i, count[i]);
//		}
//		
		
//		int[] arr2=new int[100];
//		for(int i=0;i<arr2.length;i++)
//		{
//			arr2[i] =(int)(Math.random()*10);
//
//		}
//		System.out.println(Arrays.toString(arr2));
//		int[] result=new int[10];
//		for(int i=0;i<arr2.length;i++)
//		{
//			result[arr2[i]]++;
//		}
//		for(int i=0;i<result.length;i++)
//		{
//			System.out.printf("%d의 개수: %d\n", i, result[i]);
//		}
//		
		
		
		
/*		임의의 문자 5개를 저장하고 정렬해서 출력하시오 
	       A C D H J
	     A C D H J
	     J H D C A
*/
		
		char[] arr=new char[5];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(char)((int)(Math.random()*26)+65);
		}
		System.out.println("=======정렬전=========");
		System.out.println(Arrays.toString(arr));
		//선택정렬
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					char temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println("=======올림정렬후========");
		//버블정렬
		System.out.println(Arrays.toString(arr));
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=0;j<arr.length-1-i;j++)
			{
				if(arr[j]<arr[j+1])
				{
					char temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		System.out.println("=======내림정렬후========");
		System.out.println(Arrays.toString(arr));
		

		
		
		
		
		
	
	}
}
