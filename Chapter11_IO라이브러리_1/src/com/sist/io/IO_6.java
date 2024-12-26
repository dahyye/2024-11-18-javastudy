package com.sist.io;
import java.io.*;
/*
 
 	1. 파일 읽기
 		new File("경로명\\파일명");
 	
 	2. 폴더 읽기
 		new File("경로명\\폴더명");
 		
 		//웹에서 계속 나온다 => 이미지올리기, 업로드, 다운로드
 							----------------------> 자료실
 	3. 주요메소드
 		getName() : 파일명
 		getPath() : 경로명 ~ 파일명
 		length() : 파일크기
 		listFiles() : 폴더의 파일 목록
 		mkdir() : 폴더 생성
 		createNewFile() : 파일 생성
 		delete() : 삭제
 		exists() : 존재여부 확인
 	
 */
public class IO_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir = new File("c:\\java_data");
//		dir.delete();
//		System.out.println("삭제완료");
//		//폴더 안에 파일이 있을 경우 삭제불가
//		//파일을 먼저 삭제 후 폴더 삭제해야함
		File[] files = dir.listFiles();
		for(File f:files)
		{
			f.delete();
			System.out.println("파일 삭제 완료");
			//폴더 안에 있는 파일 삭제
		}
		dir.delete();//폴더 삭제
		System.out.println("폴더삭제완료");
	}

}
