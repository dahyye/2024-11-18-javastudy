package com.sist.io;
import java.io.*;
//폴더생성-> 파일저장 
//폴더,파일 존재여부 확인
//삭제

public class IO_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//File dir = new File("c:\\java_data\\");
		File file = new File("c:\\java_data\\sawon.txt");;
		if(!file.exists())
		{
			try 
			{
				file.createNewFile(); //파일 생성
				System.out.println("폴더 생성 완료");
			} 
			catch (Exception e)
			{
				// TODO: handle exception
			}
		}
		
//		if(!dir.exists())//폴더가 존재하지 않을 경우에 실행
//		{
//			dir.mkdir();//폴더 생성
//			System.out.println("폴더 새로 생성");
//		}
//		else
//		{
//			System.out.println("이미 존재하는 폴더입니다");
//		}
		System.out.println("프로그램 종료!!!!");
	}

}
