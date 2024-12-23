package com.sist.movie;
//영화데이터 관리 => 오라클 제어
import java.util.*;
import java.io.*;
//모든 사용자가 공통으로 사용

public class MovieSystem {
	private static ArrayList<Movie> movieList  = new ArrayList<Movie>();
	
	//초기화
	static
	{
		//생성자 => 초기화 블럭을 이용
		//static은 자동저장
		try {
			//IO => CheckException
			//java.net / java.io / java.sql
			//크롤링 => URL(네트워크)
			//초기화블럭에서는 throws문장을 사용할 수 없다
			//try는 복구가능 throws 복구불가
			FileReader fr = new FileReader("c:\\javaDev\\movie.txt");
			StringBuffer sb = new StringBuffer();
			//StringBuffer 문자열 결합이 쉬워
			int i=0;
			while((i=fr.read())!=-1) // 데이터가 없으면 -1
			{
				sb.append((char)i);
			}
			fr.close();
			//데이터분리
			String data = sb.toString();
			String[] movies = data.split("\n");
			
			for(String movie:movies)
			{
				String[] ss=movie.split("\\|");
				Movie m= new Movie();
				m.setMno(Integer.parseInt(ss[0]));
				m.setTitle(ss[1]);
				m.setGenre(ss[2]);
				m.setPoster(ss[3]);
				m.setActor(ss[4]);
				m.setDate(ss[5]);
				m.setGrade(ss[6]);
				m.setDirector(ss[7]);
				
				
				movieList.add(m); //저장된 데이터를 movieList에 추가하기
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//전체목록 출력
	
	public ArrayList<Movie> movieListData()
	{
		return movieList;
	}
	
	//상세보기
	
	public Movie movieDetailData(int mno)
	{
		Movie m=new Movie();
		for(Movie mm: movieList)
		{
			if(mm.getMno()==mno)
			{
				m=mm;
				break;
			}
		
		}
		return m;
	}
	
	//검색1(제목)
	
	public ArrayList<Movie> movieFindTitle(String title)
	{
		ArrayList<Movie> list = new ArrayList<Movie>();
		//배열크기 확인할 필요가 없이 자동으로 메모리크기가 결정이 된다
		for(Movie m:movieList)
		{
			if(m.getTitle().contains(title))
			{
				list.add(m);
			}
		}
		return list;
	}
	
	//검색2(출연진)
	
	//검색3(장르)==> 오라클에서 검색은 SELECT
	
	public ArrayList<Movie> movieFindActor(String actor)
	{
		ArrayList<Movie> list = new ArrayList<Movie>();
		//배열크기 확인할 필요가 없이 자동으로 메모리크기가 결정이 된다
		for(Movie m:movieList)
		{
			if(m.getActor().contains(actor))
			{
				list.add(m);
			}
		}
		return list;
	}
	
	
	public ArrayList<Movie> movieFindGenre(String genre)
	{
		ArrayList<Movie> list = new ArrayList<Movie>();
		//배열크기 확인할 필요가 없이 자동으로 메모리크기가 결정이 된다
		for(Movie m:movieList)
		{
			if(m.getGenre().contains(genre))
			{
				list.add(m);
			}
		}
		return list;
	}
	
			
}
