package com.sist.lib;
import java.util.*;
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

//	static String s1; //null값
//	static String s2=""; //""공백
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String number = "100";
		 
		int i1 = Integer.parseInt(number);
		
		
//		System.out.println("정수의 최대값 : "+Integer.MAX_VALUE);
//		System.out.println("정수의 최소값 : "+Integer.MIN_VALUE);
		
		
//		long start = System.currentTimeMillis();
//		
//		String str = "";
//		for(int i=0;i<1000;i++)
//		{
//			str += i;
//		}
//		
//		long end = System.currentTimeMillis();
//		System.out.println("실행시간 : "+(end-start)/1000);
		
		
		
//		String str1 = "abcd";
//		String str2 = "abcd";
//		System.out.println("str1 = "+System.identityHashCode(str1));
//		System.out.println("str2 = "+System.identityHashCode(str2));
//		
//		//기본객체에 + 연산 후 다시 대입
//		
//		str1 = str1 + "efg";
//		System.out.println("str1 = "+System.identityHashCode(str1)); //새로 생성되었기 때문에 해시코드값이 달라졌다
//		System.out.println(str1);
//		
//		
//		StringBuffer sb1 = new StringBuffer("abcd");
//		System.out.println("문자열 연결 전sb1 = "+System.identityHashCode(sb1));
//		sb1.append("efgf");
//		System.out.println("문자열 연결 후sb1 = "+System.identityHashCode(sb1)); //해쉬코드가 같다
//		System.out.println(sb1.toString());
		
//		String str = "Hello My Name is Hong Gil Dong";
//		//charAt()
//		System.out.println(str.charAt(6)); //6번재 인덱스 : M
//		//equals()
//		System.out.println(str.equals("Hello My Name is Hong Gil Dong"));
//		System.out.println(str.equals("HelloMyNameisHongGilDong")); //공백있으면 같은 문자열로 인식x
//		//indexOf()
//		System.out.println(str.indexOf("Hong")); //Hong의 위치 : 17 h의 위치
//		System.out.println(str.indexOf("H"));// H의 위치 : 0 //앞부분의 h값의 인덱스를 가져온다
//		System.out.println(str.substring(17)); //17번 인덱스부터 끝까지 출력
//		System.out.println(str.substring(0, 5)); // 0~4의 인덱스 출력  //뒤는 -1인걸 기억
//		System.out.println(str.toLowerCase()); //전체 소문자
//		System.out.println(str.toUpperCase()); //전체 대문자
//		System.out.println(str.length());//문자열길이
//		System.out.println(str.startsWith("Hello")); //Hello로 시작하는지
//		System.out.println(str.endsWith("Hello"));
//		System.out.println(str.endsWith("Dong")); //dong으로 끝나는지
//		System.out.println(str.replace("Hong", "Kim")); //Hello My Name is Kim Gil Dong //데이터 변경
//		System.out.println(str.replaceAll("Name", "NickName"));// Hello My NickName is Hong Gil Dong
//		//replace replace 차이?
//		//replace는 해당 문자를 한 번만 찾아서 바꾼다
//		//replace는 해당 문자를 모두 찾아서 바꾼다
//	
//		System.out.println();
//		System.out.println(str.toString());
//		
//		str = "   안녕 하세요,     반갑습니다.      ";
//		System.out.println(str.trim());// 안녕 하세요,     반갑습니다.
//		System.out.println(str.replace(" ", "")); //안녕하세요,반갑습니다.
//		
//		str = String.valueOf(10);
//		System.out.println(str);
//		str = String.valueOf(10.5);
//		System.out.println(str);
//		
//		str = "홍길동, 이순신, 유관순, 안중근";
//		String[] arr = str.split(", ");
//		for(String a:arr)
//		{
//			System.out.println(a);
//		}
//		for (int i=0; i<arr.length; i++) {
//            System.out.println(i+"번 인덱스 값 = "+arr[i]);
//        }
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
