package com.sist.io;

/*
 
 	1. 입출력
 		메모리 입출력 - System.out.println()
 		 		  - System.in.read() => 대신에 Scanner 사용
 					=> int로 읽어오고 반드시 예외처리가 필요
 					
 		파일 입출력 - InputStream(읽기)
 				 - OutputStream(쓰기)
 				 => 특징
 				 	1. 단방향 통신(읽기/쓰기를 동시에 처리할 수 없다)
 				 	2. Stream : 데이터 이동 통로
 				 	3. 1byte 입출력 => 브러우저 / 한글이 아닌 파일 읽을 때
 				 	4. read() : 한글자씩 읽어온다
 				 	   write() : 한글자씩 저장
 				 	   close() : 닫기
 				 - Reader / Writer -> 2byte씩 읽어온다 => 한글 읽기에 적합
 				 
 				 - 바이트스트림 : 1byte 송수진 => 다운로드, 업로드
 				 				FileInputStream / FileOutputStream
 	
 				 - 문자스트림 : 2byte 송수신 => 한글 파일 제어
 				 				FileReader / FileWriter
 				 - 필터스트림 : 데이터를 메모리에 모아서 한 번에 처리 : 속도
 				 			 BufferedInputStream / BufferedOutStream
 				 			 BufferedReader / BufferedWriter
 				 			 
 				 			 ObjectInputStream / ObjectOutputStream
 				 	
 				 	
 		네트워크 입출력 -
 		
 		 
 		 	키보드 ==========> 자바프로그램 ============> 모니터
 		 		~InputStream			~OutputStream
 		 		~Reader					~Writer
 		 	
 		 	~InputStream/~OutputStream
 		 		이미지나 동영상 같은 바이트형태의 데이터 입출력
 		 		업로드 / 다운로드
 		 		
 			~Reader/~Writer		
 				파일에 글쓰기/ 파일을 읽어온다
 			
 			메모리에 모아서 한 번에 처리 => Buffered~
 			
 			=> 객체단위로 저장 
 			 	--------- > 파일 프로그램
 			=> 파일 => 데이터베이스 변경
 			=> 파일에 저장
 			   --------- Open API => 파싱
 			   --------- 크롤링 => 임시저장장소
 			   
 			   
 			   1. 데이터 종류
 			   		정형화된 데이터 : 데이터베이스안에 저장 => 공유
 			   			=> 웹 / 윈도우에 출력할 데이터만
 			   		반정형화된 데이터 : 구분만 된 데이터 
 			   			=> HTML/XML/JSON/CSV
 			   			=> API
 			   		비정형화된 데이터 : 구분이 없는 데이터
 			   			뉴스 / 줄거리 / 댓글
 			   			=> 분석해서 필요한 데이터를 갖고와서
 			   				정형화된 데이터로 만든다 => 빅데이터 => AI
 			   			
 			
 			
 					
 */	

import java.io.*;

public class IO_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileOutputStream fo = null;
		String msg = "FileOutputStream Test";
		byte[] byteArray = msg.getBytes();
		
		try {
			fo = new FileOutputStream("c:\\java_data\\fileoutput.txt");
			fo.write(byteArray);
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			try {
				fo.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
		
//		//FileInputStream fis = null;
//		FileReader fis = null;
//		
//		try 
//		{
//			//파일 읽기
//			//fis = new FileInputStream("C:\\Users\\sist.110\\git\\java-study\\Chapter11_IO라이브러리_2\\src\\com\\sist\\io\\IO_1.java");
//			fis = new FileReader("C:\\Users\\sist.110\\git\\java-study\\Chapter11_IO라이브러리_2\\src\\com\\sist\\io\\IO_1.java");
//
//			int i=0;
//			while((i=fis.read())!=-1)
//			{
//				//System.out.print((char)i); //int로 글씨를 읽어오기 때문에 (char)로 강제형변환 => 한글은 꺠져
//				System.out.print((char)i);
//			}
//		} catch (Exception e) 
//		{
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		finally
//		{
//			try 
//			{
//				fis.close();
//			} 
//			catch (Exception e2)
//			{
//				// TODO: handle exception
//			}
//		}
		
//		FileInputStream fi = null;
//		try {
//			
//			fi = new FileInputStream("c:\\javaDev\\test.txt");
//			
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		int var_read =-1;
//		try {
//			while((var_read=fi.read())!=-1)
//			{
//				System.out.println((char)var_read);
//				//한글은 깨져
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}finally
//		{
//			try {
//				fi.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
		
		
//		int var_byte =-1;
//		System.out.println("문자 입력 >>");
//		do {
//			try {
//				var_byte = System.in.read();
//				
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			if(var_byte==10||var_byte==13)
//				break;
//			else
//			{
//				System.out.println("읽은 값 : "+(char)var_byte);
//			}
//			
//		}while(true);
//		System.out.println("end");
	}

}
