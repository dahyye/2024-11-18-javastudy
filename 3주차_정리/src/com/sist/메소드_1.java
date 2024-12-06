package com.sist;
/*
 
 	메소드 형식
 	static 리턴형 메소드형(매개변수...) => 선언ㅇ부
 	{
 		구현부 => 메모리에 저장
 	}
 	
 	
 	
 */
import java.util.*;

import com.sun.jdi.Value;

import java.io.*; //파일읽어오기
public class 메소드_1 {
	
	static String movieData=""; //전역변수
	//실행시에 자동 인식
	static
	{
		try
		{
			FileReader fr=new FileReader("c:\\javaDev\\movie.txt");
			int i=0; //단점 => char가 아닌 int를 읽어와
			StringBuffer sb=new StringBuffer();
			while((i=fr.read())!=-1)
			{
				sb.append((char)i);
			}
			movieData=sb.toString();
			fr.close();
			//정상수행문장
		}catch(Exception ex) 
		{
			//오류발생
				
		}//예외처리
		// try-catch 오류시 복구
		//예외회피는 컴파일러에 예외라고 알려주는 역할 
		// 프로그램을 유지
	
	}
	
	//화면에 출력만 할 때
	static void menu()
	{
		System.out.println("===== Menu =====");
		System.out.println("1. 영화 목록");
		System.out.println("2. 영화 상세");
		System.out.println("3. 영화 검색(영화명)");
		System.out.println("4. 영화 검색(출연진)");
		System.out.println("5. 종료 ");
		System.out.println("================");
	}
	
	//영화목록
	static void movieList(int page)
	{
		String[] movie=movieData.split("\n");
		int i=0;//for문
		int j=0;//20개씩 나눠주기 위한
		final int ROWSIZE=20;//시점
		int pagecnt=(page*ROWSIZE)-ROWSIZE;
		// 1page=0 2page=20 3page=40
		for(String s:movie)
		{
			if(j<20 && i>=pagecnt)
			{
				//System.out.println(s);
				String[] md=s.split("\\|");
				System.out.println(md[0]+"."+md[1]);
				j++;
			}
			i++;
			
		}
	}
	
	//영화 상세
	static void movieDetail(int movieNo)
	{
		String[] movie=movieData.split("\n");
		for(String s:movie)
		{
			String[] info=s.split("\\|");
			if(info[0].equals(String.valueOf(movieNo)))
			{
				//System.out.println(s);
				System.out.println("영화명 : "+info[1]);
				System.out.println("장르 : "+info[2]);
				System.out.println("출연 : "+info[4]);
				System.out.println("개봉 : "+info[5]);
				System.out.println("연령 : "+info[6]);
				System.out.println("감동 : "+info[7]);
				break;
			}
			
		}
	}
	
	//영화명 검색
	static void titleFind(String movieName)
	{
		String[] movie=movieData.split("\n");
		for(String s:movie)
		{
			String[] info=s.split("\\|");
			if(info[1].contains(movieName))
			{
				//System.out.println(s);
				System.out.println(info[1]+"("+info[4]+")");
			}
			
		}
	}
	
	
	//배우명검색
	static void actorFind(String actorName)
	{
		String[] movie=movieData.split("\n");
		for(String s:movie)
		{
			String[] info=s.split("\\|");
			if(info[4].contains(actorName))
			{
				//System.out.println(s);
				System.out.println(info[1]+"("+info[4]+")");
			}
			
		}
	}
	
	//조립
	static void process()
	{
		//System.out.println(movieData);
		Scanner scan = new Scanner(System.in);
		while(true)
		{
			menu();
			System.out.print("menu를 선택 : ");
			int m=scan.nextInt();
			if(m==5)
			{
				System.out.println("프로그램 종료");
				break;
			}
			else if(m==1)
			{
				System.out.print("페이지를 입력 : ");
				int page=scan.nextInt();
				movieList(page);
			}else if(m==2)
			{
				System.out.print("영화 번호 입력 : ");
				int movieNo=scan.nextInt();
				movieDetail(movieNo);
			}else if(m==3)
			{
				System.out.print("영화명 입력 : ");
				String movieName=scan.next();
				titleFind(movieName);
			}else if(m==4)
			{
				System.out.print("출연진 입력 : ");
				String actName=scan.next();
			    actorFind(actName);
			}
			
		
		}
			
			
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		process();  //가급적이면 메인에서는 소스코딩을 사용하지 않는다
		
	}

}
