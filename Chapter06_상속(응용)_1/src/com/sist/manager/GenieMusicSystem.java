package com.sist.manager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.*;
import com.sist.vo.*;

public class GenieMusicSystem {
	public MusicVO[] musics=new MusicVO[50];
	public String title = "지니뮤직 Top50";
	//인스턴스 초기화 블럭-> 호출(x), 상속(x)
	{
		//예외처리 => 파일, 네트워크, 데이터베이스 관련은 예외처리 필수 
		//URL연결도 웹 네트워크 -> 필수적으로 예외처리 필요
		try {
			
			//정상적으로 수행하는 문장이 들어간다
			Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
			Elements title= doc.select("table.list-wrap a.title");
			Elements singer= doc.select("table.list-wrap a.artist");
			Elements album= doc.select("table.list-wrap a.albumtitle"); //import 넣을 떄 잘 선택해야해
			
			for(int i=0;i<50;i++)
			{
				System.out.println(title.get(i).text());
				System.out.println(singer.get(i).text());
				System.out.println(album.get(i).text());
				System.out.println("============================"); //데이터 들어오는 지 확인
				musics[i]=new MusicVO();
				musics[i].setNo(i+1);
				musics[i].setTitle(title.get(i).text());
				musics[i].setSinger(singer.get(i).text());
				musics[i].setAlbum(album.get(i).text());  // 데이터 저장
			}
		} catch (Exception ex) {
			//에러발생시 복구를 하거나 건너뛰거나 에러출력을 하는 부분
			}

	}
	//=> 웹/윈도우 => 리턴형으로 데이터 전송
	public MusicVO[] musicAllData()
	{
		return musics;
	}
	
	public MusicVO[] musicFindData(String fd)
	{
		int count=0;
		for(MusicVO vo : musics)
		{
			if(vo.getTitle().contains(fd))
			{
				count++;
			}
		}
		//동적배열 생성을 위한 코드 count갯수만큼 배열생성 => 이런 불편함때문에 나온게 가변 Collection
		MusicVO[] music=new MusicVO[count];
		
		int i=0;
		for(MusicVO vo:musics)
		{
			if(vo.getTitle().contains(fd))
			{
				music[i]=vo;
				i++;
			}
		}
		
		
		return music;
	}
}
