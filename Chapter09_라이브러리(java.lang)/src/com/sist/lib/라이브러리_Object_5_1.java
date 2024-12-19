package com.sist.lib;
import java.util.*;
class Movie
{
	private int mno;
	private String title;
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public Movie(int mno, String title) {
	
		this.mno = mno;
		this.title = title;
	}
	
	
}
public class 라이브러리_Object_5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ArrayList<Movie> list = new ArrayList<Movie>();  //<> 어떤 데이터형으로 받을 것인지
//		list.add(new Movie(1, "홍길동전"));
//		list.add(new Movie(2, "홍길동전"));
//		
//		Movie m1 = list.get(0);
		
		Movie m1 = new Movie(1, "홍길동전");
		System.out.println(m1.getClass()); //데이터형
		
		String s1 = new String("");
		System.out.println(s1.getClass()); //getClass() 클래스 타입 확인할 때 사용
		//class java.lang.String		

		
		
		
	
	}

}
