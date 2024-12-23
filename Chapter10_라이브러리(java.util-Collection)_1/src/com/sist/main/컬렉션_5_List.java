package com.sist.main;
import java.util.*;
public class 컬렉션_5_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<String> names = new ArrayList<String>();
//		
//		names = new LinkedList<String>();
//		names = new Vector<String>();
		//객체를 하나만 생성해서 이용
		//지금부터는 리턴형을 List로 할 예정
		
		
		//데이터를 모아서 순차적으로 접근-> 크롤링할 때 사용
		List<String> list = new ArrayList<String>(); //생성자에서는 new List를 사용하면 메소드 다 구현해야해 
		list.add("Java");
		list.add("Oracle");
		list.add("HTML/CSS");
		list.add("JavaScript");
		list.add("JSP"); //Jquery / Ajaz
		list.add("Spring");	//VueJS
		list.add("Python"); //Numpy / Pandas / MalplotLib
		list.add("ElasticSearch");
		list.add("AWS");	//Linux
		
		for(String subject : list)
		{
			System.out.println(subject);
		}
		
		System.out.println("=========================");
		//데이터를 모아서 순차적으로 출력
//		Iterator<String> iter = list.iterator();
//		while(iter.hasNext())
//		{
//			System.out.println(iter.next());
//		}
//		System.out.println("두번째hasNext");
//		while(iter.hasNext())
//		{
//			System.out.println(iter.next());
//		}//next()가 종료되면 다시 읽지 못해
					
		
	}

}
