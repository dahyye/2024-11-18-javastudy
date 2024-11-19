/*
 
 	자바에서 사용하는 표현법
 	
 	1.  
	 	정수	byte / short / int -> 숫자사용 ( 범위만 초과하지 않는다 )
	 		숫자표현
		 		10(10진법) / 012(8진법) / 0x12(16진법)
		 		날짜(2024-09-09)에서 0이 앞에 있으면 8진법으로 인식 -> 오류가 발생
		 		시간에서도 마찬가지로 오류발생 가능성이 있음
		 	long 표현
		 		10l. 10L
 		실수형 
 			10.5 -> double => 데이터형중에 가장 큰 데이터형 
 			10.5F, 10.5f
 		
 		문자형 
 			한글자만 저장 가능
 			'A'   ""(문자열) -> 문자열은 여러개문자 사용가능 "asdfe"
 			
 			
 		논리형
 			true/false
 			
 	2. 데이터 저장방법
 		1. 명시적 초기화
 			int=10;
 		2. 입력을 받아서 초기화
 		3. 난수발생
 	
 	3. 변수 선언
 		선언과 동시에 값을 저장
 		데이터형 변수명 = 값; ( 사용빈도 높음 )
 		
 		선언
 		데이터형 변수명;
 		값을 저장
 		변수명 = 값
 		
 		변수 선언만 하고 사용하면 오류생길 수 있음(초기값을 가지고 있지 않아서)
 		

 
 */


public class 변수_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte byteVal=127;//-128~127
		short shortVal=32767; // 32768~32767
		//System.out.println("32767");
		//System.out.println(byteVal+","+shortVal);
		int intVal=21400000;
		/*
		 	이 메모리를 사용하려면 intVal을 이용한다(데이터값수정가능)
		 */
		long longVal=30000000000L;
		longVal = 100L; // (수정)
		System.out.println(longVal);
		//큰 데이터형에는 작은 값을 저장할 수 있다
		long a=100;
		System.out.println(a);
		int b='A';
		System.out.println(b);
		
		char c=65;  //자동형변환
		
		System.out.println(c);
		// 'A' = 65, 'a' = 97, '0' = 48   =>아스키코드값
		System.out.println((int)'홍');
		
		boolean boo=false; // 크기비교가 아니야 
		System.out.println(boo);
		
		float f=10.5f;
		System.out.println(f);
		double d=10.5;
		System.out.println(f);
		//
		//f=d;-> double을 float에 대입했기 때문에 오류
		//왼쪽에 있는 데이터형이 크거나 같아야 저장이 가능
		//데이터는 선언된 데이터형을 따라 간다
		
		System.out.println((int)10.5);  //  =>10 출력
		System.out.println((double)10);  // => 10.0출력
		System.out.println((float)65);
		//ex. 맛집평점 리뷰 중 4점대인 리뷰를 가지고 오고 싶다-> int값이 4인 걸 찾으면 됨
		System.out.println(10/3); // 정수를 정수로 나누면 닶은 정수
		System.out.println(10/(double)3);  // 소수점을 얻고싶으면 형변환 필요
		
		
	}

}
