import java.io.*;
import java.util.*;// util에 있는거 다 가져올거야
public class 제어문_다중조건문1 {

	public static void main(String[] args) throws Exception{  //예외처리
		// TODO Auto-generated method stub
		Scanner scan= new Scanner(System.in);
		System.out.print("인덱스 번호를 입력 : ");
	
		int index = scan.nextInt();
		
		if(index==1) {
			Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe http://www.daum.net");
		}
		else if(index==2) {
			Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe http://www.naver.com");
		}
		else if(index==3) {
			Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe http://www.google1.co.kr");
		}
		
		
	}
	
	

}
