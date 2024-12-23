package com.sist.movie;
import java.util.*;
public class MovieUserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		MovieSystem ms = new MovieSystem();
		while(true)
		{
			System.out.println("===========Menu============");
			System.out.println("1. 전체 영화 목록");
			System.out.println("2. 상세보기");
			System.out.println("3. 검색(영화명)");
			System.out.println("4. 검색(출연진)");
			System.out.println("5. 검색(장르)");
			System.out.println("6. 프로그램 종료");
			System.out.println("===========================");
			
			int menu =scan.nextInt();
			if(menu==6)
			{
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
			}
			else if(menu==1)
			{
				ArrayList<Movie> list = ms.movieListData();
				for(Movie m: list)
				{
					System.out.println(m.getMno()+"."+m.getTitle());
				}
			}
			else if(menu==2)
			{
				System.out.print("1~1938까지 영화 번호 입력 : ");
				int mno=scan.nextInt();
				Movie m=ms.movieDetailData(mno);
				System.out.println("==="+m.getTitle()+"상세보기===");
				System.out.println("영화명 : "+m.getTitle());
				System.out.println("출연 : "+m.getActor());
				System.out.println("감독 : "+m.getDirector());
				System.out.println("장르 : " + m.getGrade());
				System.out.println("개봉일 : " + m.getDate());
			}
			else if(menu==3)
			{
				System.out.print("검색어를 입력하세요 : ");
				String title = scan.next();
				ArrayList<Movie> list = ms.movieFindTitle(title);
				System.out.println("검색 결과 "+ list.size()+"건");
				for(Movie m:list)
				{
					System.out.println(m.getMno()+"."+m.getTitle());
				}
			}
			else if(menu==4)
			{
				System.out.print("검색어를 입력하세요 : ");
				String actor = scan.next();
				ArrayList<Movie> list = ms.movieFindActor(actor);
				System.out.println("검색 결과 "+ list.size()+"건");
				for(Movie m:list)
				{
					System.out.println(m.getMno()+"."+m.getTitle()+m.getActor());
				}
			}
			else if(menu==5)
			{
				System.out.print("검색어를 입력하세요 : ");
				String genre = scan.next();
				ArrayList<Movie> list = ms.movieFindGenre(genre);
				System.out.println("검색 결과 "+ list.size()+"건");
				for(Movie m:list)
				{
					System.out.println(m.getMno()+"."+m.getTitle()+m.getActor()+m.getGenre());
				}
			}
		}
	}

}
