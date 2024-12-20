package com.sist.util;

import java.util.Arrays;
import java.util.StringTokenizer;

public class 라이브러리_3 {

	
	public static void main(String[] args) {
		
		String color = "red|yellow|green|pink|magenta|blue|black|cyan";
		StringTokenizer st = new StringTokenizer(color, "|");
		String[] colors = color.split("\\|"); //정규식이라서 \\를 같이 써줘야헤
		//StringTokenize 은 클래스, split은 메소드
		//StringTokenize는 문자열로 문자열 구분. split은 정규표현식으로 구분
		//StringTokenize는 빈 문자열을 토큰으로 인식x, split은 인식
		//StringTokenize는 결과값이 문자열, split은 문자열 배열이 결과값
		//
		System.out.println("컬러 갯수:"+st.countTokens());
		while(st.hasMoreTokens())
		{
			System.out.println(st.nextToken());
		}
		//hasMoreTokens 
		
		String str = "inpa@tistory@com@super@power";
		String[] sp = str.split("@");
		System.out.println(Arrays.toString(sp));
		String[] sp2 = str.split("@",3);//길이가 3인 배열만큼만 잘라
		System.out.println(Arrays.toString(sp2));
		
	}
}
