package com.sist.movie;
//데이터 크롤링
//객체단위로 저장한 파일을 만든다

//ObjectOutputStream
import java.io.*;
import java.util.*;




public class MovieInputData {

	
	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		try {
			
			List<Movie> list = new ArrayList<Movie>();
			FileReader fis = new FileReader("c:\\javaDev\\movie.txt");
			//한글이 들어있어서 InputStream보다는 Reader를 사용하는게 편해
			//InputStream 을 사용하려면 Buffer를 사용해야해
			int i=0;
			StringBuffer sb = new StringBuffer();
			while((i=fis.read())!=-1)
			{
				sb.append((char)i);
			}
			String data = sb.toString();
			String[] mdata = data.split("\n");
			for(String m : mdata)
			{
				String[] mm = m.split("\\|");
				Movie movie = new Movie();
				movie.setMno(Integer.parseInt(mm[0]));
				movie.setTitle(mm[1]);
				movie.setGenre(mm[2]);
				movie.setPorster(mm[3]);
				movie.setActor(mm[4]);
				movie.setRedate(mm[5]);
				movie.setGrade(mm[6]);
				movie.setDirector(mm[7]);
				list.add(movie);
			}
			FileOutputStream fos = new FileOutputStream("c:\\java_data\\movie_data.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			System.out.println("영화 객체 단위 저장 완료");
			
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally { 
			
		}
	}
}
