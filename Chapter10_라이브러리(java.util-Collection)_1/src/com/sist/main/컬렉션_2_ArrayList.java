package com.sist.main;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
@EqualsAndHashCode 
//같은 값 들어오면 자동으로 재정의
//equals / HashCode => 재정의
//@Data
//@Data를 사용하면 @Getter+@Setter+@EqualsAndHashCode 가 동시에 사용된다고 생각하면됨
@Getter
@Setter
class Sawon
{
	private int sabun;
	private String name;
	private String dept;

	public Sawon(int sabun, String name, String dept) {
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
	}

	
}

public class 컬렉션_2_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sawon s1 = new Sawon(1, "홍길동", "개발부");
		Sawon s2 = new Sawon(1, "홍길동", "개발부");
		
		if(s1.equals(s2)) //객체비교 
		{
			System.out.println("같은 사원이다");
		}
		else
		{
			System.out.println("다른 사원이다");
		}
		
		
	}

}
