import java.util.Scanner;
public class 가위바위보 {
	static void mode(int num)
	{
		if(num==2)
		{
			userIn1();
		}
		else
		{
			userIn2();
		}
	}
	static void userIn1()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("가위(1), 바위(2), 보(3) 입력 : ");
		int user = scan.nextInt();
		int com = comIn();
		game1(user, com);
		//return user;
	}
	static void userIn2()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("가위, 바위, 보 입력 : ");
		String user_kor = scan.next();
		int user =change(user_kor);
		int com=comIn();
		game1(user,com);
		//return user;
	}
	static int change(String user)
	{
		int change=0;
		if(user.equals("가위"))
		{
			change=0;
		}
		else if(user.equals("가위"))
		{
			change=1;
		}else
		{
			change=2;
		}
		return change;
	}
	static int comIn()
	{
		int com = (int)(Math.random()*3)+1;
		return com;
	}
	
	static void game1(int user, int com)
	{
		if(user - com == -1 || user - com == 2)
		{
			System.out.println("사용자 : "+user+" ,  컴퓨터 : "+com);
			System.out.println("사용자가 졌습니다");
		}else if(user - com == -2 || user - com == 1)
		{
			System.out.println("사용자 : "+user+" ,  컴퓨터 : "+com);
			System.out.println("사용자가 이겼습니다");
		}else
		{
			System.out.println("사용자 : "+user+" ,  컴퓨터 : "+com);
			System.out.println("비겼습니다.");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("게임을 선택 (1)한글 (2)숫자\t");
		int num= scan.nextInt();
		mode(num); 
	}
}
		
		