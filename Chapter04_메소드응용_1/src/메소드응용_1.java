/*
 
 	숫자 야구게임 => 절차적언어(main)
 			  => 메소드형식 변환
 			  => 객체지향 프로그램으로 변환
 			  
 	
 	1. 중복없는 3개의 정수를 추출(1~9번사이의 숫자)
 	2. 사용자 입력
 	3. 난수와 입력값 비교
 	4. 힌트를 하나씩 주고
 		=> 문자열 1S - 2B 형식으로 출력
 			S: ○
 			B: ○○
 			
 	5. 맞추면 종료
 
 
 
 */
import java.util.Arrays;
import java.util.*;
public class 메소드응용_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//중복없는 난수 발생 (1~9사이의 3개의 정수)
		int[] com = new int[3];
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
		//System.out.println(Arrays.toString(com));
		
		Scanner scan = new Scanner(System.in);
		int[] user = new int[3];
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
			
			System.out.println("Input Number :"+input);
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
			//System.out.println("Input Number : "+input+",Result ;"+s+"S-"+b+"B");
			//System.out.printf("Input Number : %d,Result : %dS-%dB",input,s,b);
			
			if(s==3)
			{
				System.out.println("Game Over!!!");
				break;
			}
		}
	}

}
