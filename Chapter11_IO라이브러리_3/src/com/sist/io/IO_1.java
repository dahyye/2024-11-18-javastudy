package com.sist.io;

import java.io.ByteArrayOutputStream;
import java.io.FileReader;

/*
 	1. File 정보
 		파일명 : getName()
 		경로명 : getPath()
 		파일생성: createNewFIle()
 		폴더에 있는 파일목록 : listFiles()
 		파일 크기 : length()
 		폴더생성 : mkdir()
 		삭제 : delete()
 				
  	2. 파일 입출력
 	   -------- 이미지 / 동영상 / zip
 	   		FileInputStream / FileOutputStream
 	   		=> 바이트스트림
 	   		
 	   -------- 실제 파일 입출력
 	   		FileReader / FileWriter
 	   		=> 문자스트림
 	   		
 	   		모드 : 
 	   		'w' - create - 새로운 파일 생성
 	   	 	'a' - append - 기존파일 옆 / 밑에 출력, 문자열 결합
 	   	
 	   			new FileReader("파일명") => 'w'
 	   			new FileReader("파일명",true) => 'a'
 	   			
 	   	
 	3. 속도 최적화
 		InputStream / OutputStream
 		Reader		  Writer
 		
 		=>	BufferedInputStream / BufferedOutputStream
 		=> BufferedReader / BufferedWriter 
 		
 	4. 객체단위로 입출력
 		ObjectInputStream / ObjectOutputStream
 		
 	5. 네트워크 입출력
 		송신 : OutputStream => 네트워크 패킷 => byte
 		수신 : BufferedReader => char
 		============================> 브라우저 송수신(TCP)
 		=======================> 오라클(TCP)
 		
 	6. 표준 입출력
 		입력 => System.in.read() => Scanner;
 		출력 => System.out.println()
 */

public class IO_1 {
	public static void main(String[] args) {
		FileReader fr = null;
		try {
			fr = new FileReader("c:\\javaDev\\seoul_location.txt");
			int i=0;
			long start = System.currentTimeMillis();
			while((i=fr.read())!=-1)
			{
				System.out.print((char)i);
			}
			long end=System.currentTimeMillis();
			
			System.out.println("걸린 시간 : "+(end-start)+"초(ms)");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			
			try {
				fr.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
