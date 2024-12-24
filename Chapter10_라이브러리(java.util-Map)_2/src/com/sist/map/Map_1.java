package com.sist.map;
/*
 	Map(인터페이스 349page)
 		두 개를 동시에 저장 (Key, value) => HashMap => 방문한 맛집 / 장바구니 / 아이디저장
 	
	 	HashMap => 비동기 : 동시에 저장 ( 속도가 빠르다 )
	 		=> AJAX / VUE / React 
	 	Hashtable => 동기 : 한개가 완전히 저장후에 다른 데이터를 저장 ( 속도가 느리다 )
	 	
	 	
	 	특징)
	 		두개(key, value)를 동시에 저장 
 			key는 중복이 불가능
 			value는 중복이 가능
 			웹에서는 90%가 Map형식을 사용하고 있다
 			--
 			 사용자가 보내준 데이터 정보
 			 	HttpSevletRequest
 			 	 => request.setAttribute("key",value)
 			 브라우저로 보내는 정보
 			 	HttpServketResponse
 			 	 => reponse.setAttribute("key",value)
 			 브라우저에 저장하는 정보
 			 	Cookie
 			 	 => new Cookie(key, value)
 			 서버에 저장하는 정보
 			 	HttpSession
 			 	 => session.setAttribute("id","Hong")
 
 
 		=> 스프링, MyBatis에서 많이 사용
 		
 		=> 주요메소드
 			
 			clear() : 전체 삭제
 			get() : 데이터 읽기 => get(key)
 			put() : 데이터 지정
 			isEmpty()  : 데이터 존재여부 확인
 			size() : 저장 갯수
 			keySet() : 키값 전체를 가지고 온다
 			values() : 값 전체를 가지고 온다
 */
import java.util.*;


public class Map_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] data= {"사과","수박","배","귤","참외","메론","바나나"};
		Map<String, Integer> cart = new HashMap<String, Integer>();
		
		Scanner scan = new Scanner(System.in);
		while(true)
		{
			System.out.println("======== 과일 목록 =========");
			System.out.println("1. 사과");
			System.out.println("2. 수박");
			System.out.println("3. 배");
			System.out.println("4. 귤");
			System.out.println("5. 참외");
			System.out.println("6. 메론");
			System.out.println("7. 바나나");
			System.out.println("8. 종료");
			System.out.println("==========================");
		
			System.out.println("과일을 선택하세요 : ");
			int f = scan.nextInt();
			
			if(f==8)
			{
				System.out.println("프로그램 종료합니다");
				break;
			}
			cart.put("f_"+f, f); //+f를 하는 이유? 선택할 때 마다 상품이 1개씩 들어와
			//        ------ 중복이 안되게
			if(cart.isEmpty())
			{
				System.out.println("장바구니가 비어있습니다");
			}
			else
			{
				System.out.println("과일 구매 총 "+ cart.size()+"건");
				for(String key : cart.keySet())//keySet() 모든 키 값을 가지고 온다(중복x)
				{
					int value = cart.get(key);
					System.out.println(data[value-1]);
				}
			}
		}
		
	}

}
