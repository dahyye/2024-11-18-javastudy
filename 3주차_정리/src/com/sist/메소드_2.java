package com.sist;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*; // 파일,네트워크 전송 : 읽기 / 쓰기
//input output => io

/*
 	
 	
 	
 */

public class 메소드_2 {
	//전역변수
	static String seoulData;//클래스안에 들어오는 변수는 자동초기화 (null)
	//초기화(자동초기화) => 자동로그인/쿠키읽기 에서 많이 사용
	
	static
	{
		try
		{
			FileReader fr=new FileReader("c:\\javaDev\\seoul_location.txt");
			int i=0;
			StringBuffer sb=new StringBuffer();
			while((i=fr.read())!=-1)
			{
				sb.append((char)i);
			}
			seoulData=sb.toString();
			fr.close();
		}catch(Exception ex)
		{
			
		}
	}
	//출력
	static void menu()
	{
		System.out.println("============menu==============");
		System.out.println("1. 명소 목록 ");
		System.out.println("2. 명소 상세보기 ");
		System.out.println("3. 명소 검색(명소명) ");
		System.out.println("4. 명소 검색(지역명) ");
		System.out.println("5. 종료 ");
		System.out.println("==============================");
	}
	
	
	//장소 목록
	static void location(int m)
	{
		String[] datas = seoulData.split("\n");
		//System.out.println(Arrays.toString(datas));
		int i=0;
		int j=0;
		final int ROWSIZE=20;
		int cnt=(m*ROWSIZE)-ROWSIZE;
		for(String s:datas)
		{
			if(j<20&&i>=cnt)
			{
				String[] ld=s.split("\\|");
				System.out.println(ld[0]+"."+ld[1]);
				j++;
			}
			i++;
		}
	}
	
	
	//장소 상세보기
	static void locatDetail(int m)
	{
		String[] datas = seoulData.split("\n");
		for(String s:datas)
		{
			String[] ld=s.split("\\|");
			if(ld[0].equals(String.valueOf(m)))
			{
				System.out.println("명소 명 : "+ld[1]);
				System.out.println("설명 : "+ld[2]);
				System.out.println("주소 : "+ld[3]);
			}
		}
	}
	static String[] find(int type, String findData)
	{
		
		//확인 => 검색된 갯수?
		String[] datas=seoulData.split("\n");
//		int count=0;
//		for(String seoul:datas)
//		{
//			String[] sd=seoul.split("//|");
//			String ss="";
//			if(type==1)
//			{
//				ss=sd[1];
//			}else
//			{
//				ss=sd[3];
//			}
//			
//			if(ss.contains(findData))
//			{
//				count++;
//			}
//					
//		}
		String[] data = new String[273];
		int i=0;
		//String[] datas=seoulData.split("\n");
		for(String seoul:datas)
		{
			String[] sd=seoul.split("\\|");
			String ss="";
			
			if(type==1)
			{
				ss=sd[1];
			}else
			{
				ss=sd[3];
			}
			
			if(ss.contains(findData))
			{
				
				data[i]=sd[1]+"--"+sd[3];
				i++;
			}
					
		}
		
		//String[] data=new String[10];
		return data;
	}
	
	static void process()
	{
		//System.out.println(seoulData);
		Scanner scan = new Scanner(System.in);
		while(true)
		{
			menu();
			System.out.print("메뉴 선택 : ");
			int m=scan.nextInt();
			switch(m)
			{
				case 5:
					System.out.println("프로그램 종료");
					System.exit(0);
				case 1:
					location(m);
					break;
				case 2:
					System.out.println("명소번호 : ");
					int num = scan.nextInt();
					locatDetail(num);
					break;
				
				case 3:case 4:
					System.out.println("명소는 1, 주소는 3 : ");
					int type = scan.nextInt();
					System.out.println("검색어 입력 : ");
					String fd=scan.next();
					String[] ss=find(type,fd);
					for(String s:ss)
					{
						if(s!=null)
							System.out.println(s);
					}
					break;
					
					
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process();
	}

}
