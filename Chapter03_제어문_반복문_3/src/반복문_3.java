
import java.util.*;
public class 반복문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//가위바위보 게임을 10번 한다=> 승패출력
			//가위바위보를 제외한 다른 번호를 입력하면 게임수에서 제외
		int win=0, same=0, lose=0;
		Scanner scan=new Scanner(System.in); // 클래스는 반복문 밖에서 사용한다
		int i=1;
		while(i<=10)
		{
			System.out.println("===="+i+"번 째 게임====");
			
			System.out.print("가위(0)바위(1)보(2)입력 : ");
			
			int com=(int)(Math.random()*3);
			int user=scan.nextInt();
			
			if(user<0||user>2)
			{
				System.out.println("잘못된 입력입니다!!");
				continue; // 처음부터 다시 시작하게 만든다 -> 단 for문이면 중가식으로 이동
			//  break;   // 종료
			}
			
			
			System.out.println("사용자 : ");
			if(user==0)
				System.out.println("가위");
			if(user==1)
				System.out.println("바위");
			if(user==2)
				System.out.println("보");
			
			System.out.println("컴퓨터 : ");
			if(com==0)
				System.out.println("가위");
			if(com==1)
				System.out.println("바위");
			if(com==2)
				System.out.println("보");
			
			int result = com-user;
			
			if(result==-1||result==2)
			{
				System.out.println("user 승");
				win++;
			}
			else if( result==1||result==-2)
			{
				System.out.println("user 패");
				lose++;
				
			}
			else if(result==0)
			{
				System.out.println("무승부");
				same++;
			}
			System.out.println("게임을 종료할까요?(y/n) : ");
			char c=scan.next().charAt(0);
			if(c=='y')
			{
				System.out.println("게임을 종료한다");
				break;
			}
			i++;
			
				
//				
//				if(user>com)
//				{
//					System.out.println("user 승");
//					win++;
//				}else if(user<com)
//				{
//					System.out.println("user 패");
//					lose++;
//				}else
//				{
//					System.out.println("무승부");
//					same++;
//				}
//				
//			}
//			i++;
//		}
		
		}
		System.out.println("승 : "+win);
		System.out.println("패 : "+lose);
		System.out.println("무승부 : "+same);
		
	}

}
