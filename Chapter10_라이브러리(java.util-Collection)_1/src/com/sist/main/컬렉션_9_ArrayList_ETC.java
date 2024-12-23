package com.sist.main;
import java.util.*;

public class 컬렉션_9_ArrayList_ETC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = {"홍길동", "박문수","이순신","강감찬","김두한","홍길동","심청이"};
		List<String> list = Arrays.asList(names);
		//배열 ==> List로 변경
		list.c
		for(String n : list)
		{
			System.out.println(n);
		}
		System.out.println();
		System.out.println("====set중복제거====");
		
		Set<String> set = new HashSet<String>();
		set.addAll(list);
		for(String n : set)
		{
			System.out.println(n);
		}
		//set을 사용하면 순서가 다르게 나와
	}

}
