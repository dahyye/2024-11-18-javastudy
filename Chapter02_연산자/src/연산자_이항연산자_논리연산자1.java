
/*
 	논리연산자
 	1. && - 직렬연산자
 		(조건) && (조건) => 결과값은 true false
 		ex. 로그인할 때 아이디가 같고 비밀번호도 같으면=>로그인
 		범위, 기간안에 있는 경우
		a>=1 && a<=100
		=> 예약일, 체크인
			
  	2.|| - 병렬연산자
 		(조건) || (조건) => 결과값은 true false
 		범위밖에 있는 경우
 		a<1 || a>100
 		=> 유효성검사
 		ex. 총점, 평균 구하는 코딩을 짤 때 범위를 지정해줘야 해
 			0~100이 아니면 다시입력
 			어느 숫자를 입력할 지 모르니까
 			
 	int x=10;
 	int y=9;
 	
 	x<=y && x==++y  => false
 
 	x=10, y=9 => 앞 연산조건이 맞지 않았을 때 뒷 부분 연산처리가 안되기 때문에
 				=> 효율적인 연산이라고 함
 	
 	x<=y || x==++y  => true
 
 	x=10, y=10
 	
 	x>=y || x==++y  => true
 	
 	x=10, y=9 => 앞 연산조건이 맞았을 때 뒷 부분 연산처리가 안되기 때문에
 				=> 효율적인 연산이라고 함
 	
 	
 */
public class 연산자_이항연산자_논리연산자1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x=10;
		int y=9;
		
		boolean bCheck1 = x<y&&x==++y;
		System.out.println(bCheck1);
		System.out.println(x);
		System.out.println(y);
		/*
		boolean bCheck2 = x<y||x==++y;
		System.out.println(bCheck2);
		System.out.println(x);
		System.out.println(y);
		*/
		boolean bCheck3 = x>y||x==++y;
		System.out.println(bCheck3);
		System.out.println(x);
		System.out.println(y);
		
		
	}

}
