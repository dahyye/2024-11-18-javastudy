package com.sist.music;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MusicMain {
	//공통(교집합) , 다른곳(차집합), 합집합
	//지니뮤직에서 데이터 가져오기
	public Set<String> genieMusic()
	{
		Set<String> set=new HashSet();
		try {
			Document doc = Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
			//웹서버에 접근
			Elements title = doc.select("table.list-wrap a.title");
			//System.out.println(title);
			for(int i=0; i<title.size();i++)
			{
				set.add(title.get(i).text());
			}
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		return set;
	}
	//멜론에서 데이터 가져오기
	public Set<String> melonMusic()
	{
		Set<String> set=new HashSet();
		try {
			Document doc = Jsoup.connect("https://www.melon.com/chart/index.htm").get();
			//웹서버에 접근
			Elements title = doc.select("div.wrap_song_info div.rank01 a");
			//System.out.println(title);
			for(int i=0; i<title.size();i++)
			{
				set.add(title.get(i).text());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return set;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MusicMain mm = new MusicMain();
		Set<String> genie = mm.genieMusic();
		for(String music:genie)
		{
			System.out.println(music);
		}
		System.out.println("==================================");
		Set<String> melon=mm.melonMusic(); //순서가 랜덤으로 들어와
		for(String music: melon)
		{
			System.out.println(music);
		}
		System.out.println("============차집합===============");
		
		genie.removeAll(melon); //genie-melon
		for(String music: genie)
		{
			System.out.println(music);
		}
		
		
//		System.out.println("============교집합===============");
//		genie.retainAll(melon); 
//		System.out.println("동일 곡 : "+genie.size());
//		for(String music: genie)
//		{
//			System.out.println(music);
//		}
		
//		System.out.println("============합집합===============");
//		List<String> list = new ArrayList<String>();
//		list.addAll(genie);
//		list.addAll(melon);
//		//중복포함
//		System.out.println("총 몇 곡 : "+list.size());
//		for(String music: list)
//		{
//			System.out.println(music);
//		}
//		
//		Set<String> hap = new HashSet<String>();
//		hap.addAll(list);
//		System.out.println("================================");
//		System.out.println("총 몇 곡(중복제거) : "+hap.size());
//		for(String music: hap)
//		{
//			System.out.println(music);
//		}
	}

}
