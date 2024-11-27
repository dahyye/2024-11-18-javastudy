/*
 
 	문자열 정보
 	=> length() :  문자의 객수 => 비밀번호 8자이상 
 	
 
 */
//사용자가 입력한 문자의 갯수 확인 => 공백포함
import java.util.*;
public class 문자열_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in); //Scanner가 공백을 인식을 못해
		System.out.print("문자열을 입력하세요 : ");
		String str = scan.next();  //next()는 엔터를누르거나 공백이 있는 공간까지 입력 scan.nextLine();으로 바꾸면 공백까지 다 인식
	
		System.out.println("=====================");
		System.out.println("문자는"+str.length()+"개 입니다");
		
	}

}
