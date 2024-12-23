package com.sist.main;

import lombok.Data;

/*
 	List 순서가 있다 / 중복 출력
 
 	(345page)
 	Set 순서가 없더 / 중복허용x
 		-> List에서 중복을 제거하는 역할
 		=> 장르 / 회원명.... / 장바구니
 		=> 오라클 : DISTINCT (오라클 중복제거 명령어)
 		
 	
 	HashSet / TreeSet
 	(저장용)		(검색용)
 	웹 채팅 =>
 		
 		
 	Set
 	1. 저장되는 순서가 없다
 	   ----------------> 순서가 없어서 출력이 다르게 나올 수 있다
 	   ex. 입력 123 -> 출력 231
 	
 	2. 중복된 데이터는 허용하지 않는다
 	
 	3. HashSet / 
 	   TreeSet 검색속도가 빠르다
 	
 	4. 주요 메소드
 		add, remove, isEmpty, size, iterator(데이터 순차적으로 읽을 때), clear
 	
 	5. List에서 중복된 데이터를 제거
 	
 	6. 일반데이터는 중복을 제거해주지만
 		객체단위가 데이터값이 같은 경우에는 데이터를 제거하지 못해 
 		
 		Sawon s1 = new Sawon(1, "A", "A");
 		Sawon s2 = new Sawon(1, "A", "A");
 			=> 다른값으로 인식해 => 그래서 hashCode() / equals()의 재정의가 필요해
 */

@Data
//hashCode , equals 재정의(오버라이딩)
class Sawon2
{
	private int sabun;
	private String name;
	private String dept;
	
	public Sawon2(int sabun, String name, String dept)
	{
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
		//지역변수 / 매개변수 우선 순위
		//=> this.는 생략이 가능
		//구분자로 주로 사용(멤버변수와 지역변수의 이름이 같을 때)
	}
	
}
public class 컬렉션_6_Set_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sawon2 s1 = new Sawon2(1, "홍길동", "개발부");
		Sawon2 s2 = new Sawon2(1, "홍길동", "개발부");
		
		System.out.println("s1="+s1);
		System.out.println("s2="+s2);
		
		System.out.println("s1="+s1.hashCode());
		System.out.println("s2="+s2.hashCode());

		
		if(s1.equals(s2)) // 주소값비교 => 재정의가 필요해 => @Data 사용
		{
			System.out.println("같은 사원이다");
		}
		else
		{
			System.out.println("다른 사원이다");
		}
	}

}
