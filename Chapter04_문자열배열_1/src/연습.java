
import java.util.*;
public class 연습 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		사용자가 입력한 값이 배열에 있는지 검색하여 있으면 “OOO 치킨 배달 가능“, 없으면 “OOO 치킨은 없는 메뉴입니다“를 출력하세요. 단, 치킨 메뉴가 들어가있는 배열은 본인 스스로 정하세요.
//
//		ex. 치킨 이름을 입력하세요 : 양념
//		양념치킨 배달 가능
//		Scanner scan = new Scanner(System.in);
//		boolean bCheck=true;
//		while(bCheck)
//		{
//			String[] arr = {"양념", "후라이드", "순살"};
//			System.out.print("메뉴를 골라주세요");
//			String name=scan.next();
//			for(String a:arr)
//			{
//				if(a.contains(name))
//				{
//					System.out.println(name+"치킨 배달 가능");
//					bCheck=false;
//					break;
//				}
//				else
//				{
//					System.out.println(name+"치킨은 없는 메뉴입니다");
//					System.out.println("메뉴를 다시 골라주세요");
//					break;
//				}
//			}
//				
//		}
		
		
		
		
//		주민등록번호 성별자리 이후부터 *로 가리고 출력하세요. 단, 원본 배열 값은 변경 없이 배열 복사본으로 변경하세요.
		
//		Scanner scan = new Scanner(System.in);
//		System.out.println("주민등록번호 입력 : ");
//		String num=scan.next();
//
//		char[] ch=new char[num.length()];
//		char[] ch2=new char[num.length()];
//		for(int i=0; i<num.length();i++)
//		{
//			
//			ch[i]=num.charAt(i);
//			if(i>7)
//			{
//				ch2[i]='*';
//			}
//			else
//				ch2[i]=num.charAt(i);
//		}
//		System.out.println(Arrays.toString(ch2));
//		for(char a:ch2)
//		{
//			System.out.print(a);
//		}
//		
//		10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고 1~10 사이의 난수를 발생시켜 배열에 초기화한 후 출력하세요.+최대최소 
		
//		int[] arr=new int[10];
//		int max=0;
//		int min=10;
//		for(int i=0;i<10;i++)
//		{
//			arr[i]=(int)(Math.random()*10)+1;
//		}
//		for(int a:arr)
//		{
//			System.out.print(a+" ");
//		}
//		for(int i=0;i<10;i++)
//		{
//			if(arr[i]>max)
//				max=arr[i];
//			if(arr[i]<min)
//				min=arr[i];
//		}
//		System.out.println();
//		System.out.println("max : "+max);
//		System.out.println("min : "+min);
		
		
//		10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고 1~10 사이의 난수를 발생시켜 배열에 초기화+중복없게
		
//		int[] arr=new int[10];
//		for(int i=0;i<10;i++)
//		{
//			arr[i]=(int)(Math.random()*10)+1;
//			for(int j=0;j<i;j++)
//			{
//				if(arr[i]==arr[j])
//					i--;
//			}
//		}
//		System.out.println(Arrays.toString(arr));
		
		
//		로또 번호 자동 생성기 프로그램을 작성하는데 중복 값 없이 오름차순으로 정렬하여 출력하세요.(6자리 1~45까지)
//		int[] arr=new int[6];
//		for(int i=0;i<arr.length;i++)
//		{
//				arr[i]=(int)(Math.random()*45)+1;
//				for(int j=0;j<i;j++)
//				{
//					if(arr[i]==arr[j])
//						i--;
//				}
//				
//		}
//		for(int i=0;i<arr.length;i++)
//		{
//				for(int j=i;j<arr.length;j++)
//				{
//					if(arr[i]<arr[j])
//					{
//						int temp=arr[i];
//						arr[i]=arr[j];
//						arr[j]=temp;
//					}
//				}
//		}
//		System.out.println(Arrays.toString(arr));
//		
			
	
//		문자열을 입력 받아 문자열에 어떤 문자가 들어갔는지 배열에 저장하고 문자의 개수와 함께 출력하세요.		
		
//		Scanner scan = new Scanner(System.in);
//		System.out.println("문자열 입력 : ");
//		String str = scan.next();
//		char[] arr = new char[str.length()];
//		for(int i=0;i<str.length();i++)
//		{
//			arr[i]=str.charAt(i);
//			System.out.print(arr[i]+" ");
//		}
//		System.out.println("문자의 개수"+ str.length());
//		System.out.println(Arrays.toString(arr));
		
		
		
		
//		사용자가 입력한 배열의 길이만큼의 문자열 배열을 선언 및 할당하고 
//		배열의 인덱스에 넣을 값 역시 사용자가 입력하여 초기화 하세요. 
//		단, 사용자에게 배열에 값을 더 넣을지 물어보고 몇 개를 더 입력할 건지, 
//		늘린 곳에 어떤 데이터를 넣을 것인지 받으세요. 사용자가 더 이상 입력하지 않겠다고 하면 배열 전체 값을 출력하세요.		
		
		
//		Scanner scan = new Scanner(System.in);
//		System.out.print("배열의 길이를 입력하세요 : ");
//		int count=scan.nextInt();
//		String arr[]=new String[count];
//		for(int i=0;i<count;i++)
//		{
//			System.out.print(i+"번째 배열의 내용을 입력하세요 : ");
//			arr[i]=scan.next();	
//		}
//		while(true)
//		{
//			System.out.println("값을 더 넣겠습니까?(y/n) ");
//			char yn=scan.next().charAt(0);
//			if(yn=='y')
//			{
//				System.out.print("추가할 배열의 길이를 입력하세요 : ");
//				int count2=scan.nextInt();
//				arr=Arrays.copyOf(arr, (count+count2));
//				for(int i=count;i<count+count2;i++)
//				{
//					System.out.print(i+"번째 배열의 내용을 입력하세요 : ");
//					arr[i]=scan.next();	
//				}
//			}
//			else
//			{
//				System.out.println(Arrays.toString(arr));
//				break;
//			}
//			
//		}
	
//		100개의 정수를 저장할 수 있는 배열을 선언하고 정수를 차례로 입력받다가 0이 입력되면 0을 제외하고 그때까지 입력된 정수를 가장 나중에 입력된 정수부터 차례대로 출력하는 프로그램 작성		
		
		int arr[]=new int[100];
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
					
			Scanner scan = new Scanner(System.in);
			System.out.print("정수입력 : ");
			int num=scan.nextInt();
			if(num==0)
			{
				count--;
				break;
			}
			arr[i]=num;
			count+=1;
			//System.out.println(count);
			
		}
		//System.out.println(count);
		for(int i=count;i>=0;i--)
		{
			System.out.println(arr[i]);
		}
		
		
		
	}

}
