/*
 알파벳을 입력받아서 대문자/소문자/알파벳이 아니냐 구분
 대문자라면 => if(대문자)
 소문자라면 => if(소문자)
 알파벳이 아니라면 => if(대소문자 아닌 조건)
 
 */

import java.util.Scanner;
//라이브러리
public class 자바제어문_단일조건문3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		
		System.out.print("알파벳을 입력해주세요: ");
		char ch = scan.next().charAt(0);  // charAt(0)는 첫글짜만 달라고 하는코드
		if(ch>='a'&&ch<='z') {
			System.out.println(ch+"는 소문자입니다");
		}
		if(ch>='A'&&ch<='Z') {
			System.out.println(ch+"는 대문자입니다");	
		}
		if(!((ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z'))) {
			System.out.println(ch+"는 알파벳이아닙니다");	
		}
				
	}

}
