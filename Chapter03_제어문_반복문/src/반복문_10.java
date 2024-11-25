/*
 10개의 알파벳을 추출
	사용자가 입력 하나 => 내가 선택한게 몇 번째인지
	//위치값 찾는 건 크롤링에서 많이 나와
	a-z = 97-122
	A-Z = 65-90
A~Z사이 입력받기 -> 몇번째위치?
	
	*/
import java.util.*;
public class 반복문_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.println("알파벳을 입력(대문자) : ");
		char user = scan.next().charAt(0);
		//스캐너 단점은 char을 가져오는 건 없어=> 그래서 문자열을 가져와서 첫번째 문자만 추출
		System.out.println("user="+user);
		
		int index=1;
		for(char ch='A';ch<='Z';ch++)
		{
			if(ch==user)
				break;
			index++;
		}
		
		System.out.println(user+"는"+index+"번째에 위치하고 있다");//알파벳이 숫자가 정해져있으니까
	}

}
