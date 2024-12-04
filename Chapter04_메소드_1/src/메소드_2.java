//사칙연산자 ==> 4개의 메소드
//회원가입-회원탈퇴
import java.util.*;
public class 메소드_2 {
	// 리턴형O 매개변수O
	static int plus(int a, int b)
	{
		int c = a+b;
		return c;
	}
	static int minus(int a, int b)
	{
		int c = a-b;
		return c;
	}
	static int gop(int a, int b)
	{
		int c = a*b;
		return c;
	}
	static String div(int a, int b)
	{
		//0으로 나눴을 때의 오류처리를 해야하기 때문에
		//double이 아닌 String으로 처리
		String result="";
		if(b==0)
		{
			result="0으로 나눌 수 없습니다";
		}
		else
		{
			result=String.valueOf(a/(double)b); //valueOf() string으로 변환시켜주는 함수
		}
		return result;  //리턴형의 선언된 데이터형과 일치
	}
	//조립 => 다른 클래스에서 사용이 가능
	//계산기 조립
	static void process()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("첫번째 정수 입력 : ");
		int num1=scan.nextInt();
		
		System.out.print("두번째 정수 입력 : ");
		int num2=scan.nextInt();
		
		System.out.print("연산자를 입력(+,-,*,/) : ");
		String op = scan.next();
		
		//switch or 다중조건문 사용
		if(op.equals("+"))
		{
			System.out.println(num1+"+"+num2+"="+plus(num1,num2));
		}else if(op.equals("-"))
		{
			
			System.out.println(num1+"-"+num2+"="+minus(num1,num2));
		}else if(op.equals("*"))
		{
			System.out.println(num1+"*"+num2+"="+gop(num1,num2));
		}else if(op.equals("/"))
		{
			System.out.println(num1+"/"+num2+"="+div(num1,num2));
		}else
		{
			System.out.println("사용할 수 없는 연산자입니다");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process();
		
		
		
	}

}
