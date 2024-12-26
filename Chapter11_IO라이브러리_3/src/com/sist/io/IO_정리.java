package com.sist.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 	IO => java.io => CheckException => 예외처리반드시필요
 	
 	 특징
 	 	1. 단방향통신
 	 		input / output 
 	 		=> 동시(읽기/쓰기)에 처리하기 위해서 쓰레드 사용
 	 									 ---- 프로그램안에서 다른 프로그램 여러개를 동시에 수행(시분할)
 	 	2. 데이터가 이동하는 통로 : Sream
 	 	3. Queue 방식(FIFO) 
 	 	4. 
 	 
 	 종류 
 	 	바이트 송수신 = 바이트스트림
 	 		=> 1byte => 동영상, 이미지 가져올 때 => 웹(업로드/다운로드/데이터읽기), 네트워크에서 주로 사용
 	 	문자 송수신 = 문자스트림
 			=> 2byte => 한글을 포함한 한글 제어
 			~Reader  / ~Writer
 		필터스트림 => 속도를 최적화
 			BufferedInputStream / BufferedOutputStream
 			BufferedReader / BufferedWriter
 	 	
 	 사용되는 곳
 	 
 	
 					입력스트림						출력스트림
 		사용자 ===================자바프로그램=====================화면
 	  (키보드,마우스)				응용프로그램					(모니터)
 	  
 	  메모리에서 입출력 : BufferedReader => readLine()
 	  파일에서 입출력
 	  	바이트 스트림 : read() , write(), closer()
 	  				read(byte[], int off, int len) => 한 번에 여러개의 글자 읽기 => return은 읽은 글자수
 					write(byte[]) => String을 byte[]로 변환할 땐 => getBytes() 
 	  네트워크 입출력
 	  ============== 스트림을 이용한다
 	  스트림 => 안전성
 	   | 메모리에 저장된 데이터를 읽어 온다 => 절대 잊어버리지 않는다
 	   | 소켓프로그램 => 신뢰성이 좋다
 	   		 | 이메일(smtp) 파일업로드(FTP), TELNET
 	   		 
 	   		 
 	   		 
 	  표준 입출력
 	  =System.in / System.out
 	  
 	 파일모드
 	 	r => 읽기 전용
 	 	w => 쓰기 전용 => create모드 (덮어쓴다)
 	 	a => new FileWriter("파일명",true) => 데이터 추가
 	 	
 	 5. 객체 단위 저장
 	 	-----------
 	 	ObjectInputStream / ObjectOutputSteam
 	 		==> 읽기 / 쓰기 / 수정 / 삭제 / 검색
 	 		제어는 ArrayList => 저장은 ArrayList를 통으로 저장
 	 		직렬화, 역직렬화 (이 부분이 조금 어려워)
 	 		
 	 6. XML : String에서 클래스 등록할 때 사용 
 	 	CSV : 데이터베이스에서 백업용으로 사용 
 	 	JSON : 자바와 자바스크립트를 연동할 때 사용
 	 	
 	 7. 독립적인 클래스 (.propertoes) => Map과 유사
 	 	----------
 	 	File : 파일 정보 / 디렉토리(폴더) 정보
 	 	생성
 	 	 new File("경로명\\폴더명");
 	 	 new File("경로명\\파일명");
 	 	주요기능 
 	 	 getName() : 파일명
 	 	 getPath : 경로
 	 	 isFile : 파일여부
 	 	 length : 파일크기 -> long
 	 	 ------------------------
 	 	 listFilese() : File[] => 폴더안에 있는 모든 정보
 	 	 mkdir() : 폴더만들기
 	 	 createNewFile() : 파일만들기
 	 	 delete() : 삭제
 	 	 exists() : 존재여부
 	 	 
 	 
 */

//키보드로 입력을 받아서 처리
import java.io.*;
public class IO_정리 {
	public static void main(String[] args) {

//		try {
//
//			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//			//가장 단순한 입력기
//			System.out.print("문자열 입력: ");
//			String msg=in.readLine();//엔터일 때 메모리에 저장
//			System.out.println(msg);
//			//도스(명령프롬프트)출력 => 브라우저or윈도우(입력창) / 
			
//			System.out.println("입력: ");
//			int data = System.in.read();//한 글자만 받는다
//			System.out.println((char)data);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
			
			
		
	}
}
