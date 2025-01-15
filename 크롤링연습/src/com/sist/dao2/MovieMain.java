package com.sist.dao2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;
import com.sist.dao2.MovieDAO;

/*
M_NO        NOT NULL NUMBER        
M_TITLE     NOT NULL VARCHAR2(100) 
M_ENG_TITLE NOT NULL VARCHAR2(100) 
M_POST      NOT NULL VARCHAR2(100) 
NATION      NOT NULL VARCHAR2(40)  
GENRE       NOT NULL VARCHAR2(20)  
RUNTIME     NOT NULL VARCHAR2(20)   //상영시간
REG_DATE             DATE           //개봉일
TOTAL_AUDI           NUMBER         //누적관객
DIR         NOT NULL VARCHAR2(20)   
ACT                  VARCHAR2(100) 
RATING               NUMBER(2,1)   //관객평점
STORY       NOT NULL CLOB  
 */
public class MovieMain {
	public static void main(String[] args) {
//		try {
//			
//			MovieDAO dao = MovieDAO.newInstance();
//			Document doc=Jsoup.connect("http://www.cgv.co.kr/movies/?lt=1&ft=0").get();
//			Elements link = doc.select("div.box-image a");
//			for(int j=0;j<link.size();j++)
//			{
//				
//				try {
//					String url="http://www.cgv.co.kr"+link.get(j).attr("href");
//					Document doc2=Jsoup.connect(url).get();
//					
//					Element m_title=doc2.selectFirst("div.box-contents div.title strong");
//					//System.out.println(m_title.text());
//					
//					Element m_post=doc2.selectFirst("div.box-image img");
//					//System.out.println(m_post.attr("src"));
//					
//					Elements on=doc2.select("div.box-contents div.spec dd.on");
//					Element nation=null;
//					for(int k=0;k<on.size();k++)
//					{
//						String s=on.get(k).text();
//						if(k==1)
//						{
//							for(int q=0;q<3;q++)
//							{
//								String s2=s.substring(1,s.length());
//								//System.out.println(s2);
//							}
//						}
//						//System.out.println(s);
//					}
//					
//					
//					//movie.setRaiting(cine21Rating);
//					
					Element nation=doc2.selectFirst("div.box-contents div.spec dd.on");
				    System.out.println(nation.text());
					
					
					
					Elements tableLR=doc2.select("div.tabInfo ul.tableLR dt");
					Element parking=null;
					//System.out.println(tableLR.toString());
					for(int k=0;k<tableLR.size();k++)
					{
						String s=tableLR.get(k).text();
						if(s.equals("주차"))
						{
							parking=doc2.select("div.tabInfo ul.tableLR dd").get(k);
							System.out.println(parking.text());
							
						}
					}
					
					String cine21RatingStr = null;
					cine21RatingStr = doc.select(".mov_rating li").first().text().replace("씨네21", "").trim();
					double cine21Rating = Double.parseDouble(cine21RatingStr);
					System.out.println(cine21RatingStr
							);
					
					
					
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		String url= "http://www.cine21.com/movie/info/?movie_id=61175";
		//String url= "http://www.cine21.com/movie/info/?movie_id=61951";
		MovieDAO dao=MovieDAO.newInstance();
		try {
			
			Document doc=Jsoup.connect(url).get();
			Elements title=doc.select("div.box-contents div.title");
			Elements eng_title=doc.select("div.mov_info p.tit_eng");
			Elements post=doc.select("div.mov_poster img");
			
			Elements sub=doc.select("div.mov_info p.sub_info");
			Elements rating=doc.select("ul.mov_rating");
			Elements story=doc.select("div.story");
			
			//System.out.println(rating);
		
		
			System.out.println(sub);
			//System.out.println(post.get(0).attr("src"));
			//System.out.println(sub.get(0).text()); //2022 한국 15세이상관람가
			//System.out.println(sub.get(1).text()); //드라마 상영시간 : 113분
			//S/ystem.out.println(sub.get(2).text()); //개봉일 : 2024-12-24 누적관객 : 4,248,478명 //누적없는경우있음
			//System.out.println(sub.get(3).text()); //감독 : 우민호
			//System.out.println(sub.get(4).text()); //출연 : 현빈(안중근) 박정민(우덕순) more  //출연이 없는 경우 있음
			//SUBINFO의 수가 다른 경우가 있다(나야문희)
			//System.out.println(rating.get(0).text()); // 씨네217.29 네티즌9.20 //NULL인 영화들이 있다
			//System.out.println(story.get(0).text());
		} 
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	*/
		
	}
}
