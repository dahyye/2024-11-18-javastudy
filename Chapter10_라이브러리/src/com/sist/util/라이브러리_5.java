package com.sist.util;
import java.util.*;
import java.text.*;
public class 라이브러리_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
		//MM => 9월을 09로 만들면 => 정수형변환할 때 오류
		//09 (앞자리에 0이 붙으면 8진법으로 인식 -> 근데 뒷자리가 8,9면 오류
		String today = sdf.format(date);
		
		StringTokenizer st = new StringTokenizer(today,"-");
		//문자열로 따로 받았어
		int year = Integer.parseInt(st.nextToken());
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		
		Calendar cal = Calendar.getInstance(); //싱글턴
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, day);
		
		int week = cal.get(Calendar.DAY_OF_WEEK); //1부터 시작하기 때문에 배열에 0번째인덱스는 ""
		String[] strWeek= {"","일","월","화","수","목","금","토"};
		System.out.println(year+"년도"+month+"월"+day+"일은"+strWeek[week]+"요일 입니다");
		
	}

}
