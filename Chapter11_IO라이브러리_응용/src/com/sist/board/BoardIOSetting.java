package com.sist.board;
import java.util.*;
import java.io.*;
public class BoardIOSetting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectOutputStream oos = null;
		try {
			
			List<BoardVO> list = new ArrayList<BoardVO>();
			//파일을 먼저 가져오기
			FileOutputStream fos = new FileOutputStream("c:\\java_data\\board.txt");
			oos= new ObjectOutputStream(fos);
			oos.writeObject(list);
			System.out.println("파일에 저장공간 생성 완료");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			//오라클, 서버, 파일 연결할 경우 finally사용
			try {
				oos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
