package com.sist.io;
import java.io.*;
//필터스트림 => 읽기성능을 최적화
/*
 	파일의 단점 : 구분자가 없다
 	
 	
 
 */
public class IO_2 {
	public static void main(String[] args) {
		
		try {
			
			FileReader fr = new FileReader("c:\\javaDev\\seoul_location.txt");
			BufferedReader br = new BufferedReader(fr);
			long start = System.currentTimeMillis();
			while(true)
			{
				String msg=br.readLine();//한 줄씩 읽어오기
				if(msg==null)
					break;
				System.out.println(msg);
				
			}
			
			long end = System.currentTimeMillis();
			fr.close();
			br.close();
			System.out.println("걸린 시간 : "+(end-start)+"초(ms)");
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
	}
}
