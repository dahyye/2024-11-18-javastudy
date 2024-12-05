import java.util.Scanner;

public class 메소드응용_변경2 {

//	static void input()
//	{
//		Scanner scan = new Scanner(System.in);
//		System.out.print("년도 입력: ");
//		int year = scan.nextInt();
//		System.out.print("월 입력: ");
//		int month = scan.nextInt();
//		//System.out.println(year+""+month);
//		week(year, month);
//	}
	static int input(String msg )
	{
		Scanner scan = new Scanner(System.in);
		System.out.print(msg+"입력: ");
		int a = scan.nextInt();
		return a;
	}
	
	static int getWeek(int year, int month)
	{
		int total=(year-1)*365
				+(year-1)/4
				-(year-1)/100
				+(year-1)/400;
		
		int[] lastday= {31,28,31,30,31,30,31,31,30,31,30,31};
		if(year%4==0&&year%100!=0||year%400==0)
		{	
			lastday[1]=29;
		}	
		else 
			lastday[1]=28;
		
		for(int i=0;i<month-1;i++)
		{
			total+=lastday[i];
		}
		
		total++;//요청한 달 1일자의 요일을 확인할 예정이라서
				
		int week=total%7; //0=> 일요일 6=>토요일
		return week;
	}
	
	static void print(int year, int month, int week)
	{
		String[] strWeek= {"일","월","화","수","목","금","토"};
		
		int[] lastday= {31,28,31,30,31,30,31,31,30,31,30,31};
		System.out.println(year+"년도"+month+"월");
		
		for(int i=0;i<strWeek.length;i++)
		{
			if(i==0)
				System.err.print(strWeek[i]+"\t");
			else
				System.out.print(strWeek[i]+"\t");
		}
	
//		for(String w:strWeek)
//		{
//			System.out.print(w+"\t");
//		}
		
		System.out.println();
		for(int i=1;i<=lastday[month-1];i++)
		{
			if(i==1)
			{
				//해당 요일까지 공백을 주기
				for(int j=0;j<week;j++)
				{
					System.out.print("\t");
				}
			}
			System.out.printf("%2d\t",i);
			
			week++;
			if(week>6)
			{
				week=0;
				System.out.println();//한 주씩 표현
			}
		}
	}
	
	static void process()
	{
		int year = input("년도");
		int month = input("월");
		int week=getWeek(year, month);
		print(year, month, week);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process();
	
	}

}
