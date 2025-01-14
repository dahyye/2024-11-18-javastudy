package com.sist.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainClass {
	public static void main(String[] args) {
		/*
		 
		 class : 중복이 가능 => 태그명.class명
		 id : 중복이 없다	-=> 태그명#id이름
		 
		 */
		String html="<html>"//html문서 시작
					+"<body>" //브라우저에 출력
					+"<div id=aaa>" //같은 태그 이름일 땐 구분자를 준다 class / id*
					+"<div>Java</div>" //이 데이터 하나를 가져오는 걸 Element라고 하고
					+"<div>Oracle</div>" //한 번에 가져오는 걸 Elements라고 한다
					+"<div>HTML/CSS</div>"
					+"</div>"
					+"<div class=bbb>"
					+"<div>JavaScript</div>"
					+"<div>JSP</div>"
					+"<div>Spring</div>"
					+"</div>"
					+"<img src=http://www.daum.net>" // http://www.daum.net=> 이 값을 속성이라고함
					+"</body>" //화면출력 종료
					+"</html>"; //문서종료
		
		try {
			//Element -> text(), attr() : 속성값
			//html() => HTML 태그까지 읽어오기, data() : 자바스크립트읽기
			//Elements => get() => 태그를 1개씩 읽기
			//태그갯수 확인 -> size()
			Document doc=Jsoup.parse(html);//이 문서를 저장하겠다
			//System.out.println(doc);
			//Elements div=doc.select("div");
			//Elements div=doc.select("div#aaa"); //아이디로 찾기
			//Elements div=doc.select("div.bbb"); //class로 찾기
			Elements div=doc.select("div.bbb div"); //class로 찾기 -> 후손 태그 -> 밑에 있는 태그값을 가져와
			//System.out.println(div);
			//System.out.println("div몇 개 ? "+div.size());
			//Element div1=div.get(0);//태그를 하나씩
			//Element div2=div.get(1);
			//Element div3=div.get(2);
			//Element div4=div.get(3);
			//Element div5=div.get(4);
			for(int i=0;i<div.size();i++)
			{
				System.out.println(div.get(i).text());
			}
			Element img=doc.selectFirst("img");//상세보기할 때
			//img태그안에 있는 속성값을 가지고와라
			System.out.println(img.attr("src"));
			/*
			 	1. 읽어 올 태그 -> 위의 상위 태그를 확인해야한다
			 	
			 
			 */
			
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
}
