/*
 

 

 */
import java.util.*;
public class 문자열_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);  //new 새로운 메모리 공간을 만들어라
		String[] ids= {"admin","hong","park","kim","shim"};
		String[] pwds= {"1234","1234","1234","1234","1234"};
		String[] names= {"이순신","홍길동","박문수","김두한","심청이"};
		//로그인처리
		System.out.print("아이디를 입력하세요: ");
		String id=scan.next();
		
		System.out.print("비밀번호를 입력하세요: ");
		String pwd=scan.next();
		int count=0;
		// 아이디체크
		int index=0;
		for(int i=0;i<ids.length;i++)
		{
			if(ids[i].equals(id))
			{
				count++;
				index=i; //아이디가 몇번째에 있는지 확인하기 위해서
				break;
			}
		}
		
		if(count==0)
		{
			System.out.println("아이디가 존재하지 않습니다");
		}
		else
		{   //비밀번호 체크
			if(pwds[index].equals(pwd))
			{
				//로그인처리
				System.out.println(names[index]+"님 로그인되었습니다");
			}
			else
			{	//비밀번호가 틀린 경우 처리
				System.out.println("비밀번호가 틀립니다.");
			}
		}
		
		
	}

}
