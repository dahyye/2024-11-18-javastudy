import java.io.*;
public class 반복문_4 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub 
		
		
		FileReader fr=new FileReader("C:\\javaDev\\javaStudy\\Chapter03_제어문_반복문_2\\src\\반복문_3.java"); //""안에 경로를 넣으면 자동으로 \\ 두개로 변경됨 
		int i=0; // 한글자씩 읽어오는데 문제는 정수형으로 읽어온다
		
		// 얼마나 반복해야 하는지 모르는 경우 while문을 사용한다
		while((i=fr.read())!=-1)
		{
			System.out.print((char)i); //정수형으로 읽어오기 때문에 강제형변환 필요
		}
		
	}

}
