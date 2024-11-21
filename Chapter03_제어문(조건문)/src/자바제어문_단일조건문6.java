
public class 자바제어문_단일조건문6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int score=(int)(Math.random()*101);
		System.out.println(score);
		System.out.println(score>=60? "합격" : "불합격");
		//삼항연산자=> 소스줄일 때 (if~else일때
		/*
		if(score>=60) {
			System.out.println("합격");
		}
		if(score<60) {
			System.out.println("불합격");
		}
		*/
		int a = 5;
		int b = 5;
		
		System.out.println("a와 b가 같은가요?" + (boolean)(a==b));

	}

}
