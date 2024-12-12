import java.util.Arrays;
import java.util.Scanner;

public class LoginApplication {
	private static int usernum = 0;
	private static User user[] = new User[10];
	private static Scanner scan = new Scanner(System.in);
	private static String inputId, inputPwd, inputNickname;
	
	private static void createAccount() 
	{
		System.out.println("사용하실 아이디를 입력하세요 : ");
		inputId=scan.next();
		user[usernum].setId(inputId);
		System.out.println("사용하실 비밀번호를 입력하세요 : ");
		inputPwd=scan.next();
		user[usernum].setPwd(inputPwd);
		System.out.println("사용하실 닉네임을 입력하세요 : ");
		inputNickname=scan.next();
		user[usernum].setNickname(inputNickname);
		
		usernum++;
	}
	
	private static void loginAccount()  //로그인
	{
		System.out.println("아이디를 입력하세요: ");
		inputId=scan.next();
		System.out.println("비밀번호를 입력하세요 ");
		inputPwd=scan.next();
		
		int loginSuccess=0;
		for(int i=0;i<user.length;i++)
		{
			if(inputId.equals(user[i].getId())&&inputPwd.equals(user[i].getPwd()))
			{
				System.out.println("로그인성공");
				System.out.println(user[i].getId()+" "+ user[i].getNickname());
				loginSuccess=1;
				break;
			}
		}
		if(loginSuccess==0)
			System.out.println("로그인실패");
		
	}
	
	
	private static void lookAccount() // 사용자조회
	{
		for(User users:user)
		{
			if(users.getNickname()!=null)
			{
				System.out.println(users.getNickname());
			}
		}
	}
	
	private static void deleteAccount()
	{
		System.out.println("아이디를 입력하세요: ");
		inputId=scan.next();
		System.out.println("비밀번호를 입력하세요 ");
		inputPwd=scan.next();
		int deleteSucess=0;
		
		for(int i=0;i<user.length;i++)
		{
			if(inputId.equals(user[i].getId())&&inputPwd.equals(user[i].getPwd()))
			{
				System.out.println("탈퇴 성공");
				user[i].setId(null);
				user[i].setPwd(null);
				user[i].setNickname(null);//탈퇴했으니 해당배열을 null값으로 지워주기
				//System.out.println(Arrays.toString([i]));
				deleteSucess=1;
			}
			
		}
		if(deleteSucess==0)
		{
			System.out.println("일치하는 정보가 없음");
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<10;i++)
		{
			user[i]=new User();//nullpointerException방지 배열 초기화
		}
		boolean run=true;
		
		do {
			
			System.out.println("원하는 메뉴 입력");
			System.out.println("1.회원가입 2.로그인 3.사용자조회 4.탈퇴 5. 종료");
			System.out.print("선택 > ");
			int select = scan.nextInt();
			
			if(select==1)//회원가입
			{
				if(usernum==10)
				{
					System.out.println("용량 초과 회원가입 실패");
					break;
				}
				else
					createAccount();
			}else if(select==2)
			{
				loginAccount();
			}else if(select==3)
			{
				lookAccount();
			}else if(select==4)
			{
				deleteAccount();
			}else if(select==5)
			{
				run=false;
			}
			
		}while(run);
		System.out.println("프로그램 종료");
	}

}
