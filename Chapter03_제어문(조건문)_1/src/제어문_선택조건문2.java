
/*
 
 	정수를 랜덤입력받아서 짝수? 홀수?
 */


public class 제어문_선택조건문2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int a=(int)((Math.random()*100)+1);
		int b=(int)((Math.random()*100)+1);
		System.out.println("a="+a+"b"+b);
		
		if(a%2==0) {
			System.out.println(a+"는(은) 짝수입니다");
		}
		else
			System.out.println(a+"는(은) 홀수입니다");
		*/
		/*
		if(a<b) {
			System.out.println(a+"는(은) 작은수");
			System.out.println(b+"는(은) 큰수");
		}else {
			System.out.println(a+"는(은) 큰수");
			System.out.println(b+"는(은) 작은수");
		}
		*/
		/*
		if(a<b) {
			System.out.println(a+"는(은) 작은수");
			System.out.println(b+"는(은) 큰수");
		}else if(a>b) {
			System.out.println(a+"는(은) 큰수");
			System.out.println(b+"는(은) 작은수");
		}else {
			System.out.println(a+"와"+b+"는 같다");
		}*/
		
		int a=5;
		int b=5;
		
		System.out.println("최대값 : "+Math.max(a, b));
		System.out.println("최소값 : "+Math.min(a, b));
		
	}
		
}
