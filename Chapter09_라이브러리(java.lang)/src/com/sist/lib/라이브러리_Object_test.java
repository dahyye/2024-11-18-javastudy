package com.sist.lib;

import java.util.Arrays;

class Fruit
{
	String name;
	String color;
	
	
	public Fruit(String name, String color) {
		this.name = name;
		this.color = color;
	}

//
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "과일 이름 : "+this.name + "색상 : "+this.color; 
//	}
//	
	
	
}

public class 라이브러리_Object_test {

	static String s1; //null값
	static String s2=""; //""공백
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "Hello My Name is Hong Gil Dong";
		//charAt()
		System.out.println(str.charAt(6)); //6번재 인덱스 : M
		//equals()
		System.out.println(str.equals("Hello My Name is Hong Gil Dong"));
		System.out.println(str.equals("HelloMyNameisHongGilDong")); //공백있으면 같은 문자열로 인식x
		//indexOf()
		System.out.println(str.indexOf("Hong")); //Hong의 위치 : 17 h의 위치
		System.out.println(str.indexOf("H"));// H의 위치 : 0 //앞부분의 h값의 인덱스를 가져온다
		System.out.println(str.substring(17)); //17번 인덱스부터 끝까지 출력
		System.out.println(str.substring(0, 5)); // 0~4의 인덱스 출력  //뒤는 -1인걸 기억
		System.out.println(str.toLowerCase()); //전체 소문자
		System.out.println(str.toUpperCase()); //전체 대문자
		System.out.println(str.length());//문자열길이
		System.out.println(str.startsWith("Hello")); //Hello로 시작하는지
		System.out.println(str.endsWith("Hello"));
		System.out.println(str.endsWith("Dong")); //dong으로 끝나는지
		System.out.println(str.replace("Hong", "Kim"));
		
//		System.out.println("s1"+s1);
//		System.out.println("s2"+s2);
//		System.out.println(s2.length());
//		System.out.println("".equals(s2));
		
//		String text = "Hello My Name is Hong Gil Dong";
//		
//		System.out.println("0번 인덱스 : "+ text.charAt(0));
//		for(int i=0;i<text.length();i++)
//		{
//			System.out.print(text.charAt(i));
//		}
		
		
//		String name1 = "홍";
//		String name2 = "홍";  //같은 데이터를 가지고 있으면 같은 주소값생성
//		
//		System.out.println(name1);
//		System.out.println(name2);
//		
//		if(name1==name2)
//		{
//			System.out.println("같다");
//		}
//		else
//		{
//			System.out.println("다르다");
//		}
//		
//		if(name1.equals(name2))
//		{
//			System.out.println("같다");
//		}
//		else
//		{
//			System.out.println("다르다");
//		}
//		
//		String name3 =new String("홍");
//		String name4 =new String("홍");//다른 주소값이 배정
//		if(name3==name4)
//		{
//			System.out.println("같다");
//		}
//		else
//		{
//			System.out.println("다르다");
//		}
//		
//		if(name3.equals(name4)) //String에서 equals는 주소값이 아닌 변수를 비교해
//		{
//			System.out.println("같다");
//		}
//		else
//		{
//			System.out.println("다르다");
//		}
//		
//		
//		int score = 90;
//		System.out.println("점수는"+score+"입니다"); //자동형변환
//		
//		String s = score;  오류 socre 은 int
//		
//		String s = String.valueOf(score); //score을 강제형변환
//		
//		
//		Fruit f = new Fruit("사과", "빨강");
//		System.out.println(f); //toString이 생략되어 있어
//		System.out.println(f.toString());
//		
//		//toString 오버라이딩하면 둘의 결과값이 다 바뀐다
//		
//		String[] arr = {"홍", "이", "김", "안"};
//		String[] arr2 = arr.clone();
//		
//		System.out.println(arr);
//		System.out.println(arr2);
//		
//		String[] arr3= new String[arr.length];
//		
//		System.arraycopy(arr, 0, arr3, 0, arr.length);
//		System.out.println(arr3); //새 주소를 생성하고 값을 넣어준다

		
	}

}
