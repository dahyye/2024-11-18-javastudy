package com.sist.dao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GenieMusicMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] url= {
				"https://www.genie.co.kr/chart/top200",
				"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20250113&genrecode=M0100",
				"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20250113&genrecode=M0200",
				"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20250113&genrecode=M0300",
				"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20250113&genrecode=M0107",
				"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20250113&genrecode=M0500",
				"https://www.genie.co.kr/chart/genre?ditc=D&ymd=20250113&genrecode=M0600"				
		};
		//한 번만 생성하면 되기 떄문에 for문 밖에서 생성
		MusicDAO dao=MusicDAO.newInstance();
		
		for(int i=0;i<url.length;i++)
		{
			try {
				
				Document doc=Jsoup.connect(url[i]).get();
				Elements title=doc.select("table.list-wrap a.title");
				Elements singer=doc.select("table.list-wrap a.artist");
				Elements album=doc.select("table.list-wrap a.albumtitle");
				Elements poster=doc.select("table.list-wrap a.cover img");
				Elements etc=doc.select("table.list-wrap span.rank");
				System.out.println(url[i]);
				for(int j=0;j<title.size();j++)
				{
					try {
						System.out.println(title.get(j).text());
						System.out.println(singer.get(j).text());
						System.out.println(album.get(j).text());
						System.out.println(poster.get(j).attr("src"));
						//System.out.println(etc.get(j).text());
						String s=etc.get(j).text();
						String state="";
						String id="";
						if(s.equals("유지"))
						{
							state="유지";
							id="0";
						}
						else
						{
							//1상승 -> 원하는 부분만 추출하기 위해 필요없는 부분은 공백으로 만들어버림
							state=s.replaceAll("[^가-힣]", "");
							id=s.replaceAll("[^0-9]", "");
						}
						System.out.println(state);
						System.out.println(id);
						System.out.println("======================");
						
						MusicVO vo = new MusicVO();
						vo.setCno(i+1);
						vo.setTitle(title.get(j).text());
						vo.setSinger(singer.get(j).text());
						vo.setAlbum(album.get(j).text());
						vo.setPoster(poster.get(j).attr("src"));
						vo.setState(state);
						vo.setIdcrement(Integer.parseInt(id));
						vo.setKey("");//추가예정
						dao.genieMusicInsert(vo);
						
					} catch (Exception e) {
						// TODO: handle exception
						//데이터를 못 읽을 때 완전 종료가 아닌 그 자료를 버리고 나머지를 계속 받기위해서 catch 사용
						e.printStackTrace();
					}
				}
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		System.out.println("데이터저장완료!!");
	}

}
