package com.sist.manager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sist.vo.*;//같은패키지상에 있으면 import를 안쓰는데 다른패키지이기 때문에 import사용
//import 사용자 정의, 라이브러리 클래스 로드
//import java.lang.*; //생략되어 있지만 자동추가
public class MelonMusicSystem extends GenieMusicSystem{
	//public MusicVO[] musics=new MusicVO[50];
	public String title = "멜론뮤직 Top50"; //상속 오버라이딩
	//인스턴스 초기화 블럭-> 호출(x), 상속(x)
	{
		//예외처리 => 파일, 네트워크, 데이터베이스 관련은 예외처리 필수 
		//URL연결도 웹 네트워크 -> 필수적으로 예외처리 필요
		try {
			
			//정상적으로 수행하는 문장이 들어간다
			Document doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get();
			Elements title= doc.select("div.wrap_song_info div.rank01");
			Elements singer= doc.select("div.wrap_song_info a.span rank02");  //span a 멜론에서 데이터 가져올 때 2번가져오는데 중복제거
			Elements album= doc.select("div.wrap_song_info div.rank03"); //import 넣을 떄 잘 선택해야해
			
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
	//musicAllData()들어와있어 / 상속받았기 때문에
	//musicFindData(String fd)추가
}