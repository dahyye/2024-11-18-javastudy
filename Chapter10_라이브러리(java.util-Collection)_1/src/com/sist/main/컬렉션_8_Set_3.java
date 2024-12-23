package com.sist.main;
//제네릭은 Collection 전체에서 사용이 가능해
//List / Set / Map
/*
 	List<String> => ArrayList
 	Set<String> => HashSet / TreeSet 
 		add, addAll(다른컬렉션의 데이터 가져올 때), clear, isEmpty, size, iterator
 		
 	Map<String,String> => HashMap / Hashtable
 						  -------   ---------
 						  비동기			동기
 						  속도빠름			안전성좋아 => 데들락
 						  						*데들락 : Java의 교착 상태는 두개 이상의 스레드가 
 						  								서로를 기다리면서 영원히 차단되는 상태를 의미
 
 */
import java.util.*;



public class 컬렉션_8_Set_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Integer> set = new TreeSet<Integer>();
		Random r = new Random();
		for(int i=0;i<10;i++)
		{
			set.add(r.nextInt(101));//0~100까지의 난수
		}
		//출력
		for(int score : set)
		{
			System.out.print(score+" ");
		} 
		//출력값이 10개가 아닐수도 있어 -> 중복이 있는 경우에는 제거하기 때문에
		System.out.println();
		System.out.println("=======60점 이하========");
		System.out.println(set.headSet(60));  //지정범위 제외 (60점 제외)
		System.out.println("=======60점 이하========");
		System.out.println(set.tailSet(60)); //지정범위 포함 (60점 포함)
	}

}
