package com.sist.io;
//파일 출력 => FileOutputStream / FileWriter
//필터 BufferedOuputStrem (byte단위) / BufferedWriter (char단위)
import java.io.*;
public class IO_4 {
	public static void main(String[] args) {
	
		try {
			FileOutputStream fos = new FileOutputStream("c:\\java_data\\student.txt");
			//파일 존재하지 않을 땐 자동 생성
//			fos.write('A');
//			fos.write('B');
//			fos.write('C');
//			fos.write('D');
//			fos.write('E');
//			fos.close();
			String msg = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			fos.write(msg.getBytes());
			//단위가 byte => byte[] => getBytes
			fos.close();
			System.out.println("저장완료");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
