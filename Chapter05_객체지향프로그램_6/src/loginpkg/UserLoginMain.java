package loginpkg;
import java.util.*;

public class UserLoginMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id = "";
		String pwd = "";
		String role = "";
		boolean rs = false;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("User Login Sdrvice");
		System.out.println("Admin or User? (a/u) : ");
		role=scan.next();
		System.out.println("아이디를 입력히세요 : ");
		id=scan.next();
		System.out.println("비밀번호를 입력하세요 : ");
		pwd=scan.next();
		
		if(role.equals("a")||role.equals("u"))
		{
			UserLogin login = new UserLogin(role);
			rs = login.isLogin(id, pwd, role);
			System.out.println("Login1 : "+rs);
			
		}else
		{
			System.out.println("Login Fain-step1");
		}
		
		System.out.close();
	}

}
