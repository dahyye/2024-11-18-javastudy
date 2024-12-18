package com.sist.music;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
/*
 	1. 파일 -> IO
 	2. URL => URL주소
 	3. SQL => 네트워크
 	------------------> CheckException
 						-> 컴파일이 예외처리 확인
 
 */


public class MusicSystem {
	//url={null,탑50,가요,pop.ost,트롯,jazz,classic}
//			 0    1    2   3   4  5    6     7
	private String[] url= {"","https://www.genie.co.kr/chart/top200",
			"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20241217&genrecode=M0100",
			"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20241217&genrecode=M0200",
			"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20241217&genrecode=M0300",
			"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20241217&genrecode=M0107",
			"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20241217&genrecode=M0500",
			"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20241217&genrecode=M0600"};
	public MusicVO[] musicData(int type)
	{
		MusicVO[] music = new MusicVO[50];
		try {
			
//			int k=0;//인덱스번호 만들기
			//사이트의 HTML을 읽어온다
			Document doc=Jsoup.connect(url[type]).get();
			//Document~~ 는 꼭 try안에 들어와있어야해
			//필요한 값 => HTML의 태그 <>  => 이걸 자바에서는 Elements라고 해
			
			// https://try.jsoup.org/
			//table.list-wrap 시작점
			Elements title=doc.select("table.list-wrap td.info a.title");
//			System.out.println(title);
//			<a href="#" class="title ellipsis" title="재생" onclick="fnPlaySong('108434388','1');return false;"> HOME SWEET HOME (Feat. 태양 &amp; 대성)</a>
			Elements singer=doc.select("table.list-wrap td.info a.artist");
			Elements album=doc.select("table.list-wrap td.info a.albumtitle");
			
			for(int i=0;i<50;i++)
			{
				music[i]=new MusicVO();
				music[i].setTitle(title.get(i).text());
				music[i].setSinger(singer.get(i).text());
				music[i].setAlbum(album.get(i).text());
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return music;
	}

}
