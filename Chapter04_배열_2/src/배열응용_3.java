import java.util.*;  //*은 2개이상 사용한다 => Scanner / Calendar
public class 배열응용_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		System.out.print("년도 입력 : ");
		int year = scan.nextInt();
		
		System.out.print("월 입력 : ");
		int month = scan.nextInt();
		
		System.out.print("일 입력 : ");
		int day = scan.nextInt();
		
		Calendar cal = Calendar.getInstance(); //객체생성
		//Calendar -> 추상클래스 => new 사용못함
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONDAY, month-1); //0부터 시작하기 때문에 0~11! 12월이면 11
		cal.set(Calendar.DATE, day);
		
		char[] strWeek={' ','일', '월', '화', '수', '목', '금', '토'};
		//week가 1번부터 시작해 공백을 하나 주거나, -1을 해주거나 둘 중 하나로 처리
		//요일구하기
		int week=cal.get(Calendar.DAY_OF_WEEK); //요일을 가져올 때 사용
		System.out.println(year+"년도"+month+"월"+day+"일은"+strWeek[week]+"요일입니다");
		
		//입력한 달의 마지막 날
		int lastday=cal.getActualMaximum(Calendar.DATE);
		System.out.println("마지막 날: "+lastday);

		// 나중에 가면 65%가 라이브러리 35%가 코딩
		// 라이브러리 비중이 높아
		
		
	}

}
