

/*
 
	연산자
	1. 단항연산자
		증감연산자 (++,--)
		부정연산자 (!)
		형변환연산자 ( (int)5.5 )
		부호연산자 (+, -) -10, +10
 		반전연산자 (~) 양수<=>음수
 		
 	2. 이항연산자
 		산술연산자 (+,-,*,/,%)
 			a+b. a-b, 5%2=1
 		비교연산자 (==, !=, <,>,<=,>=) 왼쪽기준으로
 		논리연산자 (&& 직렬연산자, || 병렬연산자, )
 		대입연산자 ( = )
 		복합대임연산자 ( +=, -= 등)
 		
 	3. 삼항연산자
 		(조건)?값1:값2
 		true 값1, false 값2
 		
 		
 	41page
 		증감연산자
 		a=10
	 	후치(대입 후 증가)
	 	a++ = a+1 = 11 
	 	a-- = a-1 = 12
	 	전치(증가 후 대입)
	 	++a, --b
	 	
	 	ex. 
	 	int a=10;
	 	int b=a++ => 결과값 a=11, b=10
	 	
	 	int a=10;
	 	int b=++a; => 결과값 a=11, b=11
 		
		char a='A';
		System.out.println(a++);
		System.out.println(a);
 		결과값 = A B
 
 		int a=10;
		int b=a++ + a++ + a++ ;
			  10    11    12   33
		int b=++a + ++a + a++
		      11    12    12   35	  
			  10 12 13 13
			  
			  
	   a+=1 =>  a+1,    a+=5(5번 증가시켜라) => a+5
 
 */
public class 변수_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	int a=10;
	int b=a++ + a++ + a++ ;
	System.out.println(a);
	System.out.println(b);

		
		
	}
}
