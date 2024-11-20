/*
 
 	형변환연산자 int -> long,  char -> int 
 	
 	데이터가 숫자 / 문자(정수인식)인 경우 형변환 가능
 	boolean은 제외
 	
 	데이터형 크기
 	byte < short =char < int < long < float < double
 	
 	DownCasting 데이터 작게 만들 때
 	-> 강제 
 	
 	UpCasting 데이터를 크게 만들 때
 	-> 자동
 	
 	byte b= 10;
 	int i=b; 
 	=> byte에서 int로 형변환
 	
 	int a=10;
 	double b=a;
 	=> double로 형변환, 출력하면 10.0
 
 	연산처리할 때 주의점 
 	int이하 데이터형(byte, short, char)의 연산결과는 int
 	byte+byte = int
 	
 	***필요시 강제로 변환할 수 있다 => 형변환 연산자
 		10.5+20.3=> 내가 원하는 닶은 30
 		이럴 때 int(10.5)+int(20.3)     
 		
 	10/3 = 3 정수/정수 = 정수 => 내가원하는 건 소수점까지
 	=> 10/(double)3 으로 형변환하면 소수점까지 출력가능
 	=> 3.3333333333333335 끝이 5로끝나기 때문에 결과값이 달라질 수 있어서 조심
 	그래서 가급적이면 같은 크기의 데이터타입을 사용하는게 좋아
 	
 */



public class 연산자_단항연산자3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=10;
	 	double b=a;
	 	System.out.println(b);
	 	
	 	char c='A';
	 	int d=c;
	 	System.out.println(d);
	 	
	 	byte b1=10;
	 	byte b2=27;
	 	int b3=b1+b2;
	 	System.out.println(b3);
	 	
	 	System.out.println(10/3);
	 	System.out.println(10/(double)3);
	 	
	 	int aa=123456;
	 	float dd=123456.78f;
	 	int res=(int)((dd-aa)*100);
	 	System.out.println(res);
	 	
	}

}
