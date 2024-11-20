/*
 * 
 	임의로 변수 초기화 => 난수  // 게임만들 때 자주 사용
 	Math.ramdom() -> double 형식의 숫자
 					0.0~0.99범위의 숫자가 들어온다
 	
 	Math.ramdom()*100 ->0~99.0
 	(int)Math.ramdom()*100+1  -> 1~100
 	
 	
 	
 */
public class 연산자_이항연산자_산술연산자3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		for(int i=0;i<=10;i++) {
			int a=(int)(Math.random()*100);
			
			System.out.println(a);
			
		}
		
		

	}

}
