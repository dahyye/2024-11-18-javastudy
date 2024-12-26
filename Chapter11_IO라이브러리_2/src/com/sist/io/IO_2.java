package com.sist.io;
import java.io.*;
public class IO_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis =  null;
		FileOutputStream fos = null;
		
		try {
			//파일복사, 파일전송 할 때 사용
			//파일 자체를 제어한다면 Reader / Writer
			fis=new FileInputStream("c:\\javaDev\\movie.txt");
			fos = new FileOutputStream("c:\\java_data\\movie.txt");
			//파일이 이미 존재하면 덮어쓰고, 파일이 없는 경우 자동으로 생성된다
			// append 모드 삭제없이 추가생성 => fos = new FileOutputStream("c:\\java_data\\movie.txt",true);
			int i = 0;
			//읽은 바이트수
			byte[] buffer = new byte[1024]; //TCP(1024) / UDP(512)
			//read(), read(byte[],start,end)
			while((i=fis.read(buffer,0,1024))!=-1)
			{
				fos.write(buffer,0,i);
			}System.out.println("복사완료");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			
			try {
				fis.close();
				fos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
	}

}
