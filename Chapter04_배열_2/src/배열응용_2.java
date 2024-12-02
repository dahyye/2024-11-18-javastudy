/*
  달력
  1. 사용자 정의
  	=>달력 : 1일자의 요일 확인이 가장 중요!!!
  		1년도 1월 1일 => 월요일
  		1) 1/1/1 ~ 2023~12/31 => 총 날수 계산
  		2) 2023/11/30 => 총 날수 계산
  		3) -------------------------------+1
  		4)  1)+2)+3) / 7  => 요일을 구한다
  		
  			0=일요일 6=토요일
  			
  		==> 예약시스템/일정관리를 하려면 지금처럼 달력시스템을 만들어야해
  
  2. 라이브러리 Calendatr
 */
import java.util.*;
public class 배열응용_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scan=new Scanner(System.in);
//		System.out.print("년도 입력 : ");
//		int year = scan.nextInt();
//		
//		System.out.print("월 입력 : ");
//		int month = scan.nextInt();
//		
//		System.out.print("일 입력 : ");
//		int day = scan.nextInt();
//		
//		
//		//전년도까지의 날 수
//		int total=(year-1)*365
//					+(year-1)/4
//					-(year-1)/100
//					+(year-1)/400;  //윤년처리
//		
//		//전달까지의 날 수
//		int[] lastday= {31,25,31,30,31,30,31,31,30,31,30,31};  //월별 날 수
//		if(year%4==0 && year%100!=0 || year%400==0)
//			lastday[1]=29;
//		else
//			lastday[1]=28;
//		
//		for(int i=0;i<month-1;i++)
//		{
//			total+=lastday[i];
//		}
//		
//		//입력날
//		total+=day;
//		//요일구하기
//		char[] strWeek= {'일', '월', '화', '수', '목', '금', '토'};
//		int week = total%7;
//		
//		System.out.println(year+"년도"+month+"월"+day+"일은 "+strWeek[week]+"요일입니다");
//		
		
		
		
		
//각 달의 1일자 계산		
		Scanner scan=new Scanner(System.in);
		System.out.print("년도 입력 : ");
		int year = scan.nextInt();
		
		System.out.print("월 입력 : ");
		int month = scan.nextInt();
		
		
		
		//전년도까지의 날 수
		int total=(year-1)*365
					+(year-1)/4
					-(year-1)/100
					+(year-1)/400;  //윤년처리
		
		//전달까지의 날 수
		int[] lastday= {31,25,31,30,31,30,31,31,30,31,30,31};  //월별 날 수
		if(year%4==0 && year%100!=0 || year%400==0)
			lastday[1]=29;
		else
			lastday[1]=28;
		
		for(int i=0;i<month-1;i++)
		{
			total+=lastday[i];
		}
		
		//입력날
		total++;  // -> 각 달의 1일자 계산
		//요일구하기
		char[] strWeek= {'일', '월', '화', '수', '목', '금', '토'};
		int week = total%7;
		
		System.out.println(year+"년도"+month+"월"+strWeek[week]+"요일입니다");
		System.out.println();
		for(char c:strWeek)
		{
			System.out.print(c+"\t");  //\t일정간격 띄우기
		}
		
		System.out.println();
		for(int i=1;i<lastday[month-1];i++)
		{
			if(i==1)//for문 시작
			{
				for(int j=0;j<week;j++)
				{
					System.out.print("\t");
				}
			}
			System.out.printf("%2d\t",i);  //출력
			week++;  //요일변경
			if(week>6)  //일요일이라면
			{
				week=0; 
				System.out.println();  //다음줄에 출력
			}
		}
	
		
	}

}
