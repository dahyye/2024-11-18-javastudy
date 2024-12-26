package com.sist.io;

import java.io.*;
import java.util.*;
//BufferedInputStream
//BufferedOutputStream
public class IO_3 {

	public static void main(String[] args) {
		try {
			
			FileInputStream fis = new FileInputStream("c:\\javaDev\\mydata.jar");
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			FileOutputStream fos = new FileOutputStream("c:\\java_data\\mydata.jar");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			int i=0;
			byte[] buffer = new byte[1024];
			while((i=bis.read(buffer))!=-1)
			{
				bos.write(buffer,0,i);
			}
			System.out.println("파일복사완료!!");
			fis.close();
			bis.close();
			fos.close();
			bos.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
