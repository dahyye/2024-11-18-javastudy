
import java.util.Scanner;
public class 자바제어문_단일조건문test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Scanner scan=new Scanner(System.in);
		System.out.print("정수를 입력해주세요 : ");
		
		int a=scan.nextInt();
		System.out.println(a>=0 ? a+"는(은)양수입니다" : a+"는(은)음수입니다");
		*/
		
		/*
		Scanner scan=new Scanner(System.in);
		System.out.print("정수를 입력해주세요 : ");
		
		int a=scan.nextInt();
		System.out.println(a%3==0 ? a+"는(은)3의배수" : a+"는(은)3의배수가아니다");
		*/
		
		
		/*
		Scanner scan=new Scanner(System.in);
		System.out.print("2자리 정수(10~99)를 입력해주세요 : ");
		
		int a=scan.nextInt();
		int b=a/10;
		int c=a%10;
		
		System.out.println(b==c ? "10의자리와 1의자리가같습니다" : "10의자리와 1의자리가다릅니다");
		*/
		/**/
		Scanner scan=new Scanner(System.in);
		System.out.print("달를 입력해주세요(1~12) : ");
		
		int a=scan.nextInt();
		
		if(a>=3&&a<=5){
			System.out.println(a+"월은 봄입니다");
		}
		if(a>=6&&a<=8) {
			System.out.println(a+"월은 여름입니다");
		}
		if(a>=9&&a<=11) {
			System.out.println(a+"월은 가을입니다");
		}
		if(a==12||a==1||a==2) {
			System.out.println(a+"월은 겨울입니다");
		}
		
		


		
	}

}
