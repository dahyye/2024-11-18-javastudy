package com.sist.io;

import java.io.*;
import java.net.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
public class IO_7 {
	
	public static void main(String[] args) {
		String[] strUrl = {"","searchMainDailyBoxOffice.do", //일일박스오피스
				"searchMainRealTicket.do", //실시간순위
				"searchMainDailySeatTicket.do" //좌석점유율순위
				};
		try 
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("======menu=======");
			System.out.println("1. 일일박스오피스");
			System.out.println("2. 실시간점유율 순위");
			System.out.println("3. 좌석점유율 순위");
			System.out.println("=================");
			System.out.print("메뉴를 선택하세요 : ");
			int menu = scan.nextInt();
			String path="https://www.kobis.or.kr/kobis/business/main/";
			//.do => MVC구조 => URL을 내 마음대로 변경이 가능하다
			path=path+strUrl[menu];
			Document doc = Jsoup.connect(path).get();
			System.out.println(doc.toString());
//			URL url = new URL(path);
//			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//			
//			if(conn!=null) //접속이 된 경우
//			{
//				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//				//전송은 1byte => 받을 땐 2byte
//				while(true)
//				{
//					String msg = br.readLine();
//					if(msg==null)
//						break;
//					System.out.println(msg);
//				}
//				
//			}
//			conn.disconnect();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
}
