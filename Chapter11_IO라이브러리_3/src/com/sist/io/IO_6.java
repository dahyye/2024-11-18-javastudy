package com.sist.io;
import java.io.*;
//FileInputStream을 Reader 형식으로 변경
//seoul_nature
public class IO_6 {
	public static void main(String[] args) {
		
		try {
			FileInputStream fis = new FileInputStream("c:\\javaDev\\seoul_nature.txt"); //파일읽기
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			// InputStreamReader inputstream을 Reader로 바꿔라 
			//웹을 읽는 경우 사용
			
//			int i = 0;
//			while((i=fis.read())!=-1)
//			{
//				System.out.print((char)i);
//			}
			
			while(true)
			{
				String msg = br.readLine();
				if(msg==null)
					break;
				System.out.println(msg);
			} //1줄씩 읽는게 훨씬 빨라
			
			fis.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
