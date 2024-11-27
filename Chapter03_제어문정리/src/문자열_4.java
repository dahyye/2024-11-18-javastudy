/*
 	문자열 분리 / 자르기 / 변경 / 찾기
 	=charAt(int index)
 	Hello Java
 	0123456789
 	
 	charAt(6) -> J     , charAt(8) -> a
 	
 	
 */
//사용자의 입력값을 받아서 a가 몇개인지 확인 

//사용자의 문자열 입력을 받아서 좌우 대칭인지 여부 확인
import java.util.*;

public class 문자열_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String data="Hello Java";
//		System.out.println("첫번째 문자 : "+data.charAt(0));
//		System.out.println("마지막 문자 : "+data.charAt(data.length()-1)); //lengh는 길이라서 hello java기준으로 값이 10, 위치는 0부터시작이니까 -1
		
//		Scanner scan = new Scanner(System.in);
//		System.out.print("입력해주세요: ");
//		String data = scan.nextLine();
//		int count=0;
//		for(int i=0;i<data.length();i++)
//		{
//			char ch=data.charAt(i);
//			if(ch=='a'||ch=='A')
//				count++;
//		}
//		System.out.println(count);
		
		
		Scanner scan = new Scanner(System.in);
	
		String data="";
		while(true)
		{
			System.out.print("입력해주세요: ");
			data = scan.nextLine();
			if(data.length()%2==0)
				break;
			else
				System.out.println("문자갯수가 짝수여야해");
		}
		boolean bCheck =true;
		int j=data.length()-1;
		for(int i=0 ; i<data.length()/2;i++)
		{
			char ch1=data.charAt(i);
			char ch2=data.charAt(j);
			System.out.println(data.length()/2);
			System.out.println(i+","+j);
			System.out.println("start :"+ch1+", end :"+ch2);
			if(ch1!=ch2)
			{
				bCheck=false;
				break;
			}
			else
				j--;
		}
		System.out.println("=========결과값=========");
		
		System.out.println(bCheck);
		
		if(bCheck) 
		{
			System.out.println("좌우대칭");
		}
		else
			System.out.println("비대칭");
		
	}

}
