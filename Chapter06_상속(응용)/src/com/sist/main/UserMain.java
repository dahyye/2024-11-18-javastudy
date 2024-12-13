package com.sist.main;
import java.util.*;
import com.sist.seoul.*;
import com.sist.vo.*;

public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Seoul seoul = null;
		//동일한 클래스가 많은 경우 주로 상위클래스를 이용한다
		//이제 상위클래스 => 인터페이스 사용하는 방식으로 바뀔거야
		//클래스를 모아서 처리 => 인터페이스 => 스프링
		Scanner scan = new Scanner(System.in);
		System.out.println("명소(1) 자연(2) : ");
		int type = scan.nextInt();
		if(type==1)
		{
			seoul=new SeoulLocation();
		}else if(type==2)
		{
			seoul = new SeoulNature();
		}else
		{
			System.out.println("번호를 잘못 선택함");
		}
		
		while(true)
		{
			System.out.println("==========MENU==========");
			System.out.println("1. 전체 목록");
			System.out.println("2. 상세 보기");
			System.out.println("3. 검색(명칭,주소)");
			System.out.println("4. 종료");
			System.out.println("========================");
			System.out.print("메뉴 선택 : ");
			int menu = scan.nextInt();
			if(menu==4)
			{
				System.out.println("프로그램 종료");
				break;
			}else if(menu==1)
			{
				SeoulVO[] datas = seoul.seoulAllData(type);
				for(SeoulVO vo:datas)
				{
					System.out.println(vo.getNo()+"."+vo.getName());
				}
			}else if(menu==2)
			{
				
			}else if(menu==3)
			{
				
			}else if(menu==1)
			{
				
			}
		}
		
	}

}
