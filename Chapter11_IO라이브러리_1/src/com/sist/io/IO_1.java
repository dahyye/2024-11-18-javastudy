package com.sist.io;
/*
 
 	IO : InputStream / OutputStream
 		=> 메모리입출력, 파일입출력, 네트워크입출력
 		
 	**java.io : CheckException => 예외처리가 필요하다
 	**file => 파일업로드 / 다운로드
 			  파일 읽기 / 쓰기
 	
 	-관련 클래스
 		1. File
 		2. FileInputStream / FileOutputStream
 		3. FileReader / FileWriter
 		4. BufferedReader / BufferedWriter
 		5. BufferedInputStream / BufferedOutputStream
 		6. ObjectInputStream / ObjectOutputStream
 		
 		=> InputStream / OutputStream 
 			1Byte 입출력
 			Byte 스트림
 			일반 파일을 읽기 zip, doc
 		=> Reader / Writer
 			2byte 입출력
 			문자 스트림
 			한글이 포함된 파일 읽기
 			
 		(1byte)	  (2byte)
 		브라우저 ===> 자바
 		인코딩		디코딩
 		
 		------------------------------------------------
 		IO 입력과 출력
 		-자바에서 지원하는 IO는 단방향이다
 		=> 입력/출력 프로그램을 따로 만든다
 		   -------------------> 동시에 처리(네트워크) -> 프로그램을 동시에 실행하기 위해 
 		   											쓰레드 사용
 		   											
 		=> InputStream / OutputStream  => 읽기 / 쓰기
 									   => 1byte씩 읽기 / 쓰기
 									   => 업로드 / 다운로드
 		=> Reader / Writer => 읽기 / 쓰기
 						   => 2byte씩 읽기 / 쓰기
 						   => 파일 읽기 / 파일 쓰기
 						   => 문자단위로 저장. 읽기
 		
 		** File 
 		=> 파일 / 디렉토리(폴더)를 동시에 처리
 		=> 생성 방법
 		=> File file = new File("경로명\\파일명");
 				=> 파일정보
 		   File file = new wFile("경로명\\폴더명");
 		   		=> 디렉토리정도
 		
 		=> 주요메소드
 			1. 파일명 : String getName()
 			2. 경로명 : String getParent()
 			3. 파일명+경로명 : String getPath()
 			4. 파일크기 : long length()
 			5. 숨김파일 : isHidden() :  boolean
 			6. 읽기/쓰기 : canRead() : boolean
 						 canWrite() : boolean
 			7. lastModified() : long => 최종수정날짜
 				=> Date를 이용해서 변환 => 날짜로 변경이 가능
 			8. 폴더안에 있는 모든 파일 / 폴더
 				=> String[] listFiles
 			9. 파일/디렉토리 확인 : isFile / isDirectory : boolean
 			
 		=>File 제어
 			1. 폴더생성 : mkdir()
 			2. 파일 생성 : createNewFile
 			3. 파일 삭제 : delete()
 			4. 파일 존재여부 : exists()
 		
 
 */
import java.io.*;
import java.util.*;
import java.text.*;

public class IO_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//파일 생성은 CheckException이 아니다
		File file = new File("c:\\javaDev\\movie.txt");
		System.out.println("파일명 : "+file.getName());
		System.out.println("경로명 : "+file.getParent());
		System.out.println("경로+파일명 : "+file.getPath());
		System.out.println("파일 크기 : "+file.length()+" bytes");
		//파일크기는 byte단위인데 kb로 표현하고 싶으면 file.length()/1024
		System.out.println("읽기 전용 : "+ file.canRead());
		System.out.println("쓰기 전용 : "+ file.canWrite());
		System.out.println("숨김 파일 : "+file.isHidden());
		System.out.println("파일여부 : "+file.isFile());
		//탐색기 => 다운로드 / 업로드
		System.out.println("최종 수정일 : "+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
				.format(new Date(file.lastModified())));
		
	}

}
