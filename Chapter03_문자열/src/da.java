/*
 ** 규칙
규칙 : 1~9 사이의 중복되지 않은 랜덤한 3자리 숫자 맞추기
com : 135
user : 234 => 1Strike 2Out( 3이 숫자,자리수 모두 맞음)
user : 379 => 1Ball 2Out ( 3이 숫자만 맞음)
user : 678 => 3Out ( 맞음 없음)
user : 135 => 3Strike (모두 맞음, 게임 종료 )

 */
import java.util.*;
public class da {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.println("1~9사이의 중복되지 않는 3자리 숫자를 입력하세요 : ");
		int user = scan.nextInt();
		while(true)
		{
			int com1 = (int)(Math.random()*9)+1;
			int com2 = (int)(Math.random()*9)+1;
			int com3 = (int)(Math.random()*9)+1;
		
			if((com1==com2)||(com1==com3)||(com3==com2))
			{
				
			}
			else 
			{
				System.out.println(com1+""+com2+com3);
				break;
			}
		}
		//System.out.println(com1+""+com2+com3);
			
	}

}
