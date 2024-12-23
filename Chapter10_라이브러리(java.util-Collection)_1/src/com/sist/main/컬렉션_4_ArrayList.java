package com.sist.main;
import java.util.*;

/*
 	ArrayList 데이터베잉스, 크롤링
 	Vector 네트워크, 채팅
 	LinkedList 게시판
 
 
 */
public class 컬렉션_4_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		for(int i:list)
		{
			System.out.print(i+" ");
		}
		
		System.out.println("\n");
		Vector<Integer> vec = new Vector<Integer>();  //Vector -> 동기화?
		vec.add(1);
		vec.add(2);
		vec.add(3);
		vec.add(4);
		vec.add(5);
		for(int i : vec)
		{
			System.out.print(i+" ");
		}
		
		System.out.println("\n");
		
		LinkedList<Integer> ink = new LinkedList<Integer>();
		ink.add(1);
		ink.add(2);
		ink.add(3);
		ink.add(4);
		ink.add(5);
		for(int i:ink)
		{
			System.out.print(i+" ");
		}
		System.out.println("\n");
		
		// add / addall / remove / set / get / size / isEmpty
		
	}

}
