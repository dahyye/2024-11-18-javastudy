import java.util.*;
public class 메소드응용_변경 {
	//중복없눈 난수(3개의 정수)
	static int[] rand()
	{
		int[] com=new int[3];
		for(int i=0;i<com.length;i++)
		{
			com[i]=(int)(Math.random()*9)+1;
			for(int j=0;j<i;j++)
			{
				if(com[i]==com[j])
				{
					i--;
					break;
				}
			}
		}
		return com;
	}
	
	
	//사용자 입력 => 유효성 검사
	static int[] userIn()
	{
		int[] user=new int[3];
		Scanner scan = new Scanner(System.in);
		while(true)
		{
			System.out.print("3자리 입력 :");
			int input=scan.nextInt();
			
			//오류처리
			if(input<100||input>999)
			{
				System.out.println("세자리 정수만 입력해야 합니다");
				//처음으로 이동
				continue;
				/*
				 for문에서 continue 사용하면 증가식으로 이동
				 while문에서 continue 사용하면 조건문으로 이동
				 */
			}
			//3자리 정수를 잘라서 배열에 저장
			//코딩테스트에서는 화폐매수 구하기로 자주 나와
			user[0]=input/100;
			user[1]=(input%100)/10;
			user[2]=input%10;
			
			//오류처리 ==> 중복된 수가 없어야 된다 , 0을 사용하면 안된다
			if(user[0]==user[1]||user[0]==user[2]||user[2]==user[1])
			{
				System.out.println("중복된 숫자는 사용할 수 없습니다!!");
				//처음부터 다시 시작
				continue;
			}
			if(user[0]==0||user[1]==0||user[2]==0)
			{
				System.out.println("0은 사용할 수 없다");
				continue;
			}
			break;
			
		}
		return user;
	}
	
	//비교
	static int compare(int[] com, int[] user)
	{
		int s=0, b=0;
		for(int i=0;i<3;i++)
		{
			
			for(int j=0;j<3;j++)
			{
				if(com[i]==user[j]) //같은 숫자가 있는지
				{
					
					if(i==j) //같은 자리에 들어가는지
						s++;
					else
						b++;
				}
			}
		}
		hint(s,b,user);
		return s;
	}
	static void hint(int s, int b, int[] user)
	{
		System.out.println("Input Number :"+user[0]+user[1]+user[2]);
		System.out.println("========전광판=======");
		System.out.print("S:");
		for(int i=0; i<s;i++)
		{
			System.out.print("○");
		}
		System.out.println();
		System.out.print("B:");
		for(int i=0; i<b;i++)
		{
			System.out.print("●");
		}
		System.out.println("\n==================");
	}
//	static void hint(int[] com, int[] user)
//	{
//		
//		//System.out.println("Input Number :"+input);
//		System.out.println("========전광판=======");
//		System.out.print("S:");
//		for(int i=0; i<s;i++)
//		{
//			System.out.print("○");
//		}
//		System.out.println();
//		System.out.print("B:");
//		for(int i=0; i<b;i++)
//		{
//			System.out.print("●");
//		}
//		System.out.println("\n==================");
//	}
	//종료여부
	static boolean isEnd(int s)
	{
		boolean bCheck=false;
		if(s==3)
		{
			bCheck=true;
			System.out.println("Game Over!!!");
		}
		return bCheck;
	}
	//전체 조립=> 새로운 게임여부 확인
	static void process()
	{
		Scanner scan = new Scanner(System.in);
		int[] com=rand();
		int[] user=new int[3];
		while(true)
		{
			user=userIn();
			int s=compare(com, user);
			if(isEnd(s))
			{
				System.out.print("새게임을 할까요?(y/n)");
				char c=scan.next().charAt(0);
				if(c=='y'||c=='Y')
				{
					System.out.println("★★★★★ 새 게임을 시작합니다 ★★★★★★");
					process();//재귀호출
				}
					
				else
				{
					System.out.println("Game Over!");
					//break;//break를 사용하면 오류 날 가능성이 있어
					System.exit(0);//0은 정상종료
				}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process();
		
	}

}
