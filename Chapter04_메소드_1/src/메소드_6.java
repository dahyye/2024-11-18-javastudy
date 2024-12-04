/*
 	메소드 호출 => 매개변수
 	1)Call By Value
 		=> 값만 전송
 	2)Call By Reference =>자바에서 주소전송은 배열 / 클래스
 											  ~~~~~~> String은 제외
 											  		String은 일반 데이터형으로 취급
 	 	=> 주소값 전송
 	
 	
 */
// Call By Value => 값만 전송 => 복사본! 원본은 그대로
public class 메소드_6 {
	static void swap(int a,int b)
	{
		System.out.println("swap메소드에 진입....=>2");
		System.out.println("사용자가 요청한 값=>3");
		System.out.println("swap => 변경 전");
		System.out.println("a= "+a);//=>4
		System.out.println("b= "+b);//=>5
		int temp=a;
		a=b;
		b=temp;
		System.out.println("swap => 변경 후");
		System.out.println("a= "+a);//
		System.out.println("b= "+b);//
		System.out.println("swap메소드 요청 완료!=>6");
	}
	//메인은 자동호출, 사용자 정의는 자동호출 안되고 필요시 요청해야함
	//Trace => 디버킹머드 => f6누르면 진행방향으로 한칸씩 이동
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main 시작=>1");
		int a=10;
		int b=20;
		System.out.println("main => 변경 전");
		System.out.println("a= "+a);
		System.out.println("b= "+b);
		swap(a,b);
		System.out.println("main => 변경 후");
		System.out.println("a= "+a);
		System.out.println("b= "+b);
//		System.out.println("main 종료 => 프로그램 종료=>7");
		
		
	}

}
