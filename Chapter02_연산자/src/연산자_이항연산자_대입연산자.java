/*
 	대입연산자
 		( = ) => 뒤에서부터 처리
 		int a=10 => 10을 a에 넣는다!
 		
 		복합대입연산자 => 누적이나 합 구할 때 사용
 			+= -= /= %= |= ^= &= <<= >>=
 			            ~~~~~~~~~~~~~~~~
 			             	자바에서는 사용x, 회로에서 사용
 			+=, -= 여러개 증가, 감소
 			
 			int a = 10;
 			//5증가하려고 할 때
 			 
 			a++;
 			a++;
 			a++;
 			a++;
 			a++;
 			
 			a+=5 => a+5
 			
 			a++ ++a a+=1 a+1 => 다 1씩증가
 			
 			a+=1은 원하는 값만큼 더하기 쉬워
 			
 			// 여러번 증가할 땐 복합대입연산자가 쉽고
 			   한 번 증가할 땐 증감연산자가 좋아
 			 	
 
 
 
 */
public class 연산자_이항연산자_대입연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 10;
		
		a++;
		a++;
		a++;
		a++;
		a++;
		
		System.out.println("a="+a);
		
		int b=10;
		
		b+=5;
		
		System.out.println("b="+b);
		
	}

}
