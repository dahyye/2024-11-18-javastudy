package com.sist.exception;

import java.io.FileReader;
import java.io.IOException;

//try ~ catch ~ finally
/*
 	finally는 생략가능
 	-> 보통 파일닫기, 오라클 연결 해제, 서버연결해제 이런곳에서 많이 사용
 	
 	
 */
public class 예외처리_finally사용법 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		FileReader fr = null;
//		//모든 클래스의 초기값은 null;
//		//메모리 주소를 가지고 있지 않은 상태
//		
//		try 
//		{
//			fr = new FileReader("c:\\javaDev\\seoul_nature.txt");
//			//만약에 밖으로 빼면 오류 
//			//CheckException이라서 꼭 예외처리를 해야해서
//			int i=0; //한글자씩 읽어온다
//					//단점은 정수형으로 받아온다는 것
//			while((i=fr.read())!=-1)
//			{
//				//-1 => EOF
//				System.out.print((char)i); //문자로 변환해서 출력하기
//			}
//			
//		}catch (IOException e) { //상위클래스 Exception , Throwable
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				//무조건 파일 닫기
//				fr.close();
//			}catch(IOException e) {}
//			
//			//이 메소드도 예외처리가 필요
//			
//		}
		//자동 -> 리소스
		
	}

}
