/*
 
 https://mvnrepository.com/   => 자바 라이브러리 가져오는 사이트
 Jsoup Java HTML Parser » 1.18.1 다운
 buildpath -> configure -> libraries -> classpath에 다운받은 파일추가하면
 -> 클래스 안에 Referenced Libraries 파일이 생성됨
 
  contains : 포함된 문자열 => web데이터읽기 => 크롤링
  Jsoup => 크롤링 라이브러리
  
  
  지니뮤직에서 오른쪽마우스 눌러서 소스, 200차트 url가져와서 connect소스에 첨부해
  Document, Elements 치고 스페이스 누르면 import 자동 생성할 수 있다
 */

import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class 문자열_2 {

	public static void main(String[] args) throws Exception { //예외처리
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.print("검색어 입력하세요 : ");
		String fd=scan.next();
		
		
		
		int k=1;
		for(int i=1; i<=4;i++)
		{
			Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20241127&hh=10&rtm=Y&pg="+i).get();  //1~4페이지를 가져올거야
			Elements title=doc.select("table.list-wrap a.title");
			for(int j=0;j<title.size();j++)
			{
				//if(title.get(j).text().contains(fd)) // fd값이 포함 된 데이터만 가져온다   오라클 %검색어%
				//if(title.get(j).text().startsWith(fd)) //fd값으로 시작되는 데이터를 가져온다  오라클 검색어%
				if(title.get(j).text().endsWith(fd))   //fd값으로 끝나는 데이터를 가져온다    오라클 %검색어
				{
					System.out.println((k)+"."+title.get(j).text()); //변수 k자리에 j를 넣으면 50곡씩 나눠서 출력
					//Thread.sleep(2000); // 지연시간추가(2초)
					k++;
				}
				 
			}
		}
		
		
	}

}
