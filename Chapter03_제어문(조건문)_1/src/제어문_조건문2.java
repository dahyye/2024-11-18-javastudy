


import java.util.Scanner;
public class 제어문_조건문2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("가위(0) 바위(1) 보(2)를 입력 : ");
		int player = scan.nextInt();
		int com= (int)(Math.random()*3);
		String[] str = {"가위","바위","보"};
		System.out.println("Player: "+str[player]);
		System.out.println("컴퓨터: "+str[com]);
		
		System.out.println("=====결과=====");
		int res=com-player;
		if(res==-1||res==2) {
			System.out.println("플레이어가 이겼습니다");
		}
		if(res==1||res==-2) {
			System.out.println("컴퓨터가 이겼습니다");
		}
		if(res==0) {
			System.out.println("비겼습니다");
		}
	}

}
