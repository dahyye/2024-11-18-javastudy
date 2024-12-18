package com.sist.music;
import java.util.Scanner;
public class MusicUserMain {
//파일을 하나로 제어했다 -> 클릭하면 그 파일의 데이터를 바꿨기때문에
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MusicSystem ms = new MusicSystem();
		Scanner scan =new Scanner(System.in);
		while(true)
		{
			System.out.println("========== 장르별 메뉴 =========");
			System.out.println("1. Top 50");
			System.out.println("2. 가요");
			System.out.println("3. POP");
			System.out.println("4. OST");
			System.out.println("5. 트롯");
			System.out.println("6. JAZZ");
			System.out.println("7. CLASSIC");
			System.out.println("8. 종료");  //무한루프를 사용할 땐 꼭 종료옵션 넣어주기
			System.out.println("==============================");
			System.out.print("메뉴선택 : ");
			int menu = scan.nextInt();
			if(menu==8)
			{
				System.out.println("종료되었습니다");
				break;
			}
				
			MusicVO[] music = ms.musicData(menu);
			
			//화면출력
			int i=1;
			for(MusicVO vo : music)
			{
				System.out.println(i+"."+vo.getTitle());
				i++;
			}
		}

	}

}
