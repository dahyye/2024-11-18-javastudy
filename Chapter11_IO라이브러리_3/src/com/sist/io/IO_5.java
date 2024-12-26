package com.sist.io;
//문자단위 저장 => write(String s)

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;
public class IO_5 {

	public static void main(String[] args) {
		try {
			
			FileWriter fw = new FileWriter("c:\\java_data\\student.txt",true);
//			String msg = "Hello Java!! => IO\n";
//			fw.write(msg);
//			fw.close();
			BufferedWriter bw = new BufferedWriter(fw);
			//글자가 많을 때, 크롤릴 할 때
			String msg = "Hello Oracle!!";
			bw.write(msg);
			System.out.println("저장완료");
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
