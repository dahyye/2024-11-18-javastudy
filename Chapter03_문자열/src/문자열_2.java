//format() =>  출력형식 => system.out.printf() 랑 거의 비슷해

import java.text.SimpleDateFormat;
import java.util.Date;

public class 문자열_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
		double avg=0.0;
		/*
		 int = 0
		 char = '/0'
		 double = 0.0
		 long = 0L
		 float = 0.0F
		 String = null (메소드 주소가 없는 상태)
		 		  ---- NullPointerException
		 		  ---- 모든 클래스가 메모리 할당이 안된 상태		 
		 */
		for(int i=1;i<10;i++)
		{
			int num=(int)(Math.random()*10)+1;
			System.out.println(num+" ");
			sum+=num;
		}
		avg=sum/9.0;
		String msg=String.format("평균 : %.2f", avg);
//		%d 정수 %s 문자열 %c 문자 %f 실수
//		날짜 변환, 학점, MessageFormat
		System.out.println(msg);  //ex. 6.44
		System.out.println("평균 : "+avg);  //ex. 6.444444444444445
		System.out.println(new Date());  //Thu Nov 28 12:16:34 GMT+09:00 2024
		System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));  //2024-11-28 12:16:34
	}

}
