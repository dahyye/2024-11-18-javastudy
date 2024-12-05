/*
 1. 대소문자가 있는 문자열을 입력받아서 대문자는 소문자로 소문자는 대문자로 변경
 2. 문자열을 입력받아서 역순으로 출력하는 프로그램 작성
 
 */
import java.util.*;
public class 문자열_5 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("문자열을 입력 : ");
		
		String msg = scan.next();
		//String change = "";
		for(int i=0;i<msg.charAt(i);i++)
		{
			String change = "";
			char c=msg.charAt(i);
			if(c>='A'&&c<='Z')
			{
				change+=(char)(c+32);
				
			}
			else if(c>='a'&&c<='z')
			{
				change+=(char)(c-32);
				
			}
			System.out.print(change);
		}
		System.out.println();
//		
//		Scanner scan = new Scanner(System.in);
//		System.out.print("문자열을 입력 : ");
//		
//		String user = scan.next();
//		for(int a=user.length()-1;a>=0;a--)
//		{
//			System.out.print(user.charAt(a));
//		}
//		System.out.println();
//		
		
		
	}

}
