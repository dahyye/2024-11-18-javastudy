package com.sist.main;
import java.util.*;
public class 컬렉션_7_Set_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet set = new HashSet();//일반클래스이용
		// Set set = new HashSet(); //인터페이스이용
		//1. 저장 => add()
		// => 콤보박스 -> 여러가지 중 선택 ( 중복x ) => 부서명 / 장르 / 검색 / 근무지 ..
		System.out.println("=====추가=====");
		set.add("red");
		set.add("blue");
		set.add("green");
		set.add("yellow");
		set.add("pink");
		set.add("red");
		set.add("blue");
		set.add("green");
		set.add("yellow");
		set.add("pink");
		set.add("red");
		set.add("blue");
		set.add("green");
		set.add("yellow");
		set.add("pink");
		set.add("red");
		set.add("blue");
		set.add("green");
		set.add("yellow");
		set.add("pink");
		set.add("red");
		set.add("blue");
		set.add("green");
		set.add("yellow");
		set.add("red");
		set.add("blue");
		set.add("pink");
		set.add("red");
		set.add("blue");
		set.add("green");
		set.add("red");
		set.add("blue");
		set.add("red");
		set.add("blue");
		set.add("pink");
		set.add("red");
		set.add("blue");
		set.add("green");
		set.add("yellow");
		set.add("pink");
		set.add("yellow");
		set.add("pink");
		set.add("pink");
		set.add("red");
		set.add("blue");
		set.add("green");
		set.add("yellow");
		set.add("pink");
		set.add("red");
		set.add("blue");
		//실제 저장은 5개만 저장된
		System.out.println("====람다식====");
		set.forEach(name->System.out.println(name));
		
		
		System.out.println("====Iterator====");
		Iterator<String> iter = set.iterator();
		while (iter.hasNext())
		{
			System.out.println(iter.next());
		}
		System.out.println("=====================");
		System.out.println("저장 갯수 : "+set.size());
		for(Object a : set) //for(int i ...) 사용 못하는 이유 : 순서가 없어서
		{	//String으로 받고 싶을 땐 선언할 때 제네릭스로 String 설정을 해주면 됨
			System.out.println(a);  // 출력값이 입력순서랑 달라
		}
		
		System.out.println("=====삭제=====");
		set.remove("yellow");
		System.out.println("저장 갯수 : "+set.size());
		for(Object a : set)
		{	
			System.out.println(a);
		}
		
		System.out.println("====전체삭제====");
		set.clear();
		System.out.println("저장 갯수 : "+set.size());
		for(Object a : set)
		{	
			System.out.println(a);
		}
		
		if(set.isEmpty())
		{
			System.out.println("장바구니가 비워져있습니다");
		}
		else
		{
			System.out.println("장바구니에 담겨 있는 데이터가 있습니다");
		}
		
		
		
	}

}
