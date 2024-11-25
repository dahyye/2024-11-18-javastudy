/*
 
 무한루프
 컴퓨터가 난수발생 1~100
 맞추기 
 */
import java.util.*;
//반복문에서 가장 많이 사용하는 건 if문
//if문을 사용하면서 조건이 맞으면 종료
public class 반복문_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int com = (int)((Math.random()*100)+1);
		Scanner scan = new Scanner(System.in);
		int counter = 0;
		for(int i=1;;i++)
		{
			counter++;
			System.out.println("1~100까지의 정수를 입력하세요");
			int user = scan.nextInt();
			if(com>user) 
			{
				System.out.println("UP!!!");
				
			}else if(com<user)
			{
				System.out.println("DOWN!!!");
			}else 
			{
				System.out.println("정답!!!");
				System.out.println(counter+"번 만에 맞췄습니다");
				System.exit(0);  //시스템 종료 함수, 무한루프는 반드시 종료 조건을 첨부해야해
				//break; //위 함수랑 같은 역할?
				
				//break는 for문을 종료한다는 뜻
				//System.exit(0)은 프로그램 자체를 종료한다는 뜻
			
			}
			
			
		}
		
		
	}

}
