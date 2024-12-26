package com.sist.io;
import java.io.*;

public class IO_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//폴더생성
		
		File dir = new File("c:\\javaDev");
		//이 폴더안에 어떤 파일/디렉토리를 가지고 있는지 확인
		File[] list = dir.listFiles();
		for(File f : list)
		{
			if(f.isFile())
			{
				System.out.println(f.getName()+" "+f.length()+"bytes");
			}
			else if(f.isDirectory())
			{
				System.out.println(f.getName()+" <DIR>");
			}
		}
		
	}

}
