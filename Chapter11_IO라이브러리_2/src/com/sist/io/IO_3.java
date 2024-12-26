package com.sist.io;

import java.io.FileWriter;

public class IO_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FileWriter:파일에 입력
		FileWriter fw = null; //2바이트 단위 : 한글 가능
		try {
			fw = new FileWriter("c:\\java_data\\sawon.txt",true); //append모드 -> 이어서 저장할 수 있게
			//
			//파일이 없는 경우에 자동으로 파일 생성
			fw.write("1|홍길동|개발부|서울|3000\r\n");
			fw.write("2|심청이|총무부|경기|3000\r\n");
			fw.write("3|박문수|영업부|부산|4000\r\n");
			
			System.out.println("등록 완료");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {

				fw.close();	
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
	}

}
