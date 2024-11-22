/*
 
 1장 : 자바 특징 / 자바 설치 / 주의점
 2장 : 변수 / 연산자
 3장 : 제어문 
 4장 : 배열
 5장 : 객체지향 프로그램 
 6장 : 상속
 7장 : 추상클래스 / 인터페이스
 8장 : 예외처리
 9장 : 라이브러리 ( java.util, java,lang(생략가능해서 생략하고 있어,
  				java.io, java.net, java.sql)
  		
 1. 자바
 2. 오라클
 3. HTML/CSS/JavaScript
 4. JSP=>Jquery/Ajax
 5. Spring Framework->VueJS, MyBatis
 6. Python => Numpy, Pandas, MatplotLib, Django
 7. ElasticSerach
 8. SpringBoot / MySQL / JPA / React(React-Query,Redux / NextJS / TypeScript
 9. Option : MSA / DevOps
10. Option : 알고리즘 개발
 
 */


import java.util.*;
public class 정리_1주차 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		char a='자';
		char b='바';
		char c='의';
		char d='정';
		char e='석';
	
		
		System.out.println(a+""+b+c+d+e);
		System.out.println(a+""+b+""+c+""+d+""+e); // 무슨차이
	*/
		/*
		System.out.println("구구단");
		for(int i=1;i<10;i++) 
		{
			System.out.printf("****%d단****\n",i);
			for(int j=1;j<10;j++) 
			{
				System.out.printf("   %dx%d=%d\n",i,j,i*j);
				
			}
			
				
		}
		
		
		*/
		/*
		//주사위 2개 합이 12가 되면 탈출하는 게임
		int i=0;
		while(true) {
			
			
				
				
				int a=(int)(Math.random()*6)+1;
				int b=(int)(Math.random()*6)+1;
				i=i+1;
				System.out.printf("a=%d, b=%d\n",a,b);
				if(a+b==12) {
					System.out.println("두개의 합이 12가 되었습니다");
					System.out.printf("%d번만에 탈출\n",i);
					break;
				}
		}
		*/
		/*
		사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 문자열에 그 문자가 몇 개 있는지 개수를 출력하세요.
		
		
		 문제와 모든 것이 동일하고, “더 하시겠습니까?”라고 추가로 물어보도록 하세요.
		이 때, N이나 n이 나오면 프로그램을 끝내고 Y나 y면 계속 진행하도록 하되
		 Y, y, N, n이 아닌 다른 문자를 입력했을 경우 “잘못된 대답입니다. 다시 입력해주세요.”를 출력하고 더 하겠냐는 물음을 반복하세요.
		*/
	/*
		while(true)
		{
			
			System.out.print("문자열을 입력하세요 : ");
			Scanner scan = new Scanner(System.in);
			String str = scan.next();
			
			System.out.print("검색하려는 문자를 입력하세요 : ");
			Scanner scan2 = new Scanner(System.in);
			char str2 = scan2.next().charAt(0);
		
			int result=0;
			for(int i=0;i<str.length();i++)
			{
				if(str2==str.charAt(i)) {
					result=result+1;	
				}
				else continue;
			}
			System.out.println("총 "+result+"개 있습니다");
			
			Scanner yesORno = new Scanner(System.in);
			System.out.print("더 하시겠습니까?");
			char yesno = yesORno.next().charAt(0);
			if(yesno=='y'||yesno=='Y') {
				
				continue;
				
			} else if (yesno=='n'||yesno=='N')
			{
				System.out.println("종료되었습니다");
				break;
			} else 
			{
				System.out.println("잘못된 대답입니다. 다시입력해주세요");
				continue;
			}
			
		}
		
		
		
		
		
		*/
		
		//1부터 100 사이의 정수 중 임의의 난수가 정해지고 사용자는 정해진 난수를 맞추는데 몇 번 만에 맞췄는지 출력하세요.

		
		int a=(int)(Math.random()*100)+1;
		//System.out.print("1~100 사이의 임의의 난수를 맞춰보세요");
		System.out.println(a);
		//System.out.print("랜덤수"+a+","+"선택수"+b);
		int result=0;
		while(true) {
			
		
			System.out.print("1~100 사이의 임의의 난수를 맞춰보세요");
			Scanner scan=new Scanner(System.in);
			int b=scan.nextInt();
			
			if(b>=0&&b<=100) 
				{
					result+=1;
					if(a<b)
					{
						System.out.println("DOWN!");
						System.out.println("");
						//break;
					}else if(a>b)
					{
						System.out.println("UP!");
						System.out.println("");
						//break;
					}else
					{
						System.out.println("정답입니다!");
						System.out.println(result+"번 만에 맞췄습니다");
						break;
					}
				}else
				{
					System.out.println("범위안의 숫자만 입력하세요!");
					//break;
				}
			
		
		
		}
	}
}
