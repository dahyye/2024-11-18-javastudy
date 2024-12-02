import java.util.*;
public class 배열_문제2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//	4. 양의 정수 10개 입력받아 배열에 저장하고, 배열에 있는 정수 중에서 3의 배수만 출력하는 프로그램을 작성하라
		
//		Scanner scan = new Scanner(System.in);
//		int arr[]=new int[10];
//		for(int i=0;i<arr.length;i++)
//		{
//			System.out.print((i+1)+"번 째정수를 입력하세요: ");
//			arr[i]=scan.nextInt();
//		}
//		for(int a:arr)
//		{
//			System.out.print(a+" ");
//		}
//		System.out.println();
//		System.out.println("3의 배수 :");
//		for(int i=0;i<arr.length;i++)
//		{
//			if(arr[i]%3==0)
//			{
//				System.out.print(arr[i]+" ");
//			}
//		}
		
		
		
		
//	5. 정수를 10개 저장하는 배열을 만들고 1에서 10까지 범위의 정수를 랜덤하게 생성하여 배열에 저장하라. 그리고 배열에 든 숫자들과 평균을 출력하라. 
	
		
//		int arr[]=new int[10];
//		int sum=0;
//		double avg=0.0;
//		for(int i=0;i<arr.length;i++)
//		{
//			arr[i]=(int)(Math.random()*10)+1;
//			sum+=arr[i];
//		}
//		for(int a:arr)
//		{
//			System.out.print(a+" ");
//		}
//		avg=sum/10.0;
//		System.out.println();
//		System.out.printf("평균은 : %.2f",avg);
		
		
//	6. int[] num = { 94, 85, 95, 88, 90 };
//		다음 배열에서 최대값,최소값을 출력하는 프로그램을 작성하시오
		
		
//		int[] num = { 94, 85, 95, 88, 90 };
//		int min=100;
//		int max=0;
//		
//		for(int i=0;i<num.length;i++)
//		{
//			if(num[i]>max)
//				max=num[i];
//			if(num[i]<min)
//				min=num[i];
//			
//		}
//		
//		System.out.println(Arrays.toString(num));
//		System.out.println("최대값 : "+ max);
//		System.out.println("최소값 : "+ min);
		
		
//	7. 정수를 10개 저장하는 배열을 만들고 1에서 10까지 범위의 정수를 랜덤하게 생성하여 배열에 저장하라. 그리고 배열에 든 숫자들과 평균을 출력하라.
//		예) 랜덤한 정수들 : 3 6 3 6 1 3 8 9 6 9 평균은 5.4
//		[Hint] 1에서 10까지 범위의 정수를 랜덤하게 생성할 때는 다음 코드를 이용하라
//		int i  = (int)(Math.random()*10)+1;
	
//		int arr[]=new int[10];
//		int sum=0;
//		double avg=0.0;
//		for(int i=0;i<arr.length;i++)
//		{
//			arr[i]=(int)(Math.random()*10)+1;
//			sum+=arr[i];
//		}
//		for(int a:arr)
//		{
//			System.out.print(a+" ");
//		}
//		avg=sum/3.0;
//		System.out.println();
//		System.out.printf("평균은 : %.2f",avg);
		
		
		
//	8. arr 배열 중에서 인덱스가 1인 곳의 값을 출력해보자.
//		 int[] arr = { 10, 20, 30, 50, 3, 60, -3 };  
//		int[] arr= {10,20,30,50,3,60,-3};
//		
//		System.out.println(arr[1]);
		

//	9. arr 배열 중에서 값이 60인 곳의 인덱스를 출력해보자. 
//		 int[] arr = { 10, 20, 30, 50, 3, 60, -3 };  		
//		int[] arr= {10,20,30,50,3,60,-3};
//		
//		for(int i=0;i<arr.length;i++) {
//			if(arr[i]==60)
//			{
//				System.out.println(arr[i]);
//			}
//			
//		}
		
		
		
//   길이가 10인 배열을 선언하고 1부터 10까지의 값을 반복문을 이용하여 역순으로 배열 인덱스에 넣은 후 그 값을 출력하세요.
		
//		int arr[]=new int[10];
//		for(int i=0;i<arr.length;i++)
//		{
//			arr[i]=10-i;
//		}
//		for(int a:arr)
//		{
//			System.out.print(a+" ");
//		}

//	사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고 1부터 입력 받은 값까지 배열에 초기화한 후 출력하세요.
		
//		Scanner scan = new Scanner(System.in);
//		System.out.print("양의 정수를 입력 : ");
//		int num=scan.nextInt();
//		int arr[]= new int[num];
//		
//		for(int i=0;i<arr.length;i++)
//		{
//			arr[i]=1+i;
//		}
//		System.out.println(Arrays.toString(arr));
//		
		
		
//	문자열을 입력 받아 문자 하나하나를 배열에 넣고 검색할 문자가 문자열에 몇 개 들어가 있는지 개수와 몇 번째 인덱스에 위치하는지 인덱스를 출력하세요.
		
		
//		Scanner scan = new Scanner(System.in);
//		System.out.print("문자열을 입력 : ");
//		String str=scan.next();
//		char ch[]=new char[str.length()];
//		
//		for(int i=0;i<str.length();i++)
//		{
//			ch[i]=str.charAt(i);
//		}
//		System.out.print("검색할 문자를 입력 : ");
//		char a=scan.next().charAt(0);
//		int count=0;
//		for(int i=0;i<str.length();i++)
//		{
//			if(ch[i]==a)
//			{
//				count++;
//				System.out.print(i+" ");
//			}
//		}
//		System.out.println();
//		System.out.println(count+"개 있습니다");
		
		
//	“월“ ~ “일”까지 초기화된 문자열 배열을 만들고 0부터 6까지 숫자를 입력 받아 입력한 숫자와 같은 인덱스에 있는 요일을 출력하고 범위에 없는 숫자를 입력 시 “잘못 입력하셨습니다“를 출력하세요.
		
//		String[] str= { "월", "화", "수", "목", "금", "토","일"};
//		Scanner scan = new Scanner(System.in);
//
//		while(true)
//		{
//			System.out.print("0~6사이의 숫자를 입력 : ");
//			int num=scan.nextInt();
//			if(num>=0&&num<=6)
//			{
//				System.out.println(str[num]);
//				break;
//			}
//			else
//				System.out.println("잘못 입력하셨습니다.");
//			
//		}
		
		
		
//	사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고 배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화 하세요. 그리고 배열 전체 값을 나열하고 각 인덱스에 저장된 값들의 합을 출력하세요

//		Scanner scan = new Scanner(System.in);
//		System.out.print("배열의 길이 입력 : ");
//		int num=scan.nextInt();
//		int[] arr = new int[num];
//		int sum=0;
//		for(int i=0;i<num;i++)
//		{
//			System.out.print("인덱스"+i+"의 값 입력 : ");
//			arr[i]=scan.nextInt();
//		}
//		for(int a:arr)
//		{
//			System.out.print(a+" ");
//			sum+=a;
//			
//		}
//		System.out.println();
//		System.out.println("인덱스에 저장된 값들의 합 : "+sum);

//	3이상인 홀수 자연수를 입력 받아 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고, 
//	중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하세요. 단, 입력한 정수가 홀수가 아니거나 3 미만일 경우 “다시 입력하세요”를 출력하고 다시 정수를 받도록 하세요.
		
		Scanner scan = new Scanner(System.in);
		
		
		while(true)
		{
			System.out.print("3이상인 홀수 자연수 입력 : ");
			int num=scan.nextInt();
			int[] arr = new int[num];
			if(num%2!=0||num<3)
			{
				for(int i=0;i<=num/2;i++)
				{
					arr[i]=1+i;
					System.out.print(arr[i]+" ");
				}
				for(int i=0;i<num/2;i++)
				{
					arr[i]=num/2-i;  
					System.out.print(arr[i]+" ");
				}
				
				break;
			}
			else
			{
				System.out.println("다시 입력하세요");
			}
			
		}
		//System.out.println(Arrays.toString(arr));
	}
	
}
