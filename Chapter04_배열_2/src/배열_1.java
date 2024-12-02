/*
 	
 	** 웹에서 사용하는 배열은 96page까지의 내용만 공부해도 충분
 	
 	데어터 저장 =========> 데이터 가공 ========> 결과값 출력
 						---------		   ----------
 						연산자/제어문		  브라우저, 핸드폰, 윈도우
 	변수 => 묶어서 한 개의 이름으로 제어
 	
 	관련된 데이터를 묶어서 사용
 		-배열 (관련된 데이터를 여러개 모아서 한 개의 이름으로 제어)=> 같은 종류의 변수가 3개 이상이면 사용하기 좋음
 			여러개의 변수를 한 번에 처리할 수 있다는 장점이 있다->연속적인 메모리 구조를 가지고 있어서
 			-> 메모리 크기가 동일해야 한다(같은 데이터형만 모아서 관리할 수 있음)
 			배열의 단점은 한 번 선언하면 추가/삭제가 어렵다
 						->같은주소를 이용해서 다시 생성(얕은 복사)
 						->배열을 새로 생성해야함(clone)
 											
 			
 			이런 단점을 보안하여 나온게 가변형 (컬랙션)
 			
 			1. 배열 생성
 				데이터형[] 배열명; => 이 형식을 권장해
 				데이터형 배열명[];
 			
 			2. 배열의 초기화(값을 지정)
 				=> 지역변수 ( 메소드안에 선언하는 변수) => main에서 사용
 				=> 멤버변수 ( 클래스안에서 사용, 자동 초기화) 
 				
 				
 				선언과 동시에 초기화(명시적 초기화)
 				int[] arr={1, 2, 3, 4, 5}; => 데이터를 알고 있을 때 => 데이터 검색
 				
 				int[] arr=new int[5]; => 기본데이터로 초기화 => 기본 데이터값 저장(가장 많이 사용)
 								~~~~ 정수 5개를 모아서 관리 new를 사용했기 때문에 0으로 자동 초기화
 								정수
 									byte=0
 									int=0
 									long=0L
 								실수
 									float=0.0F
 									double=0.0
 								논리
 									boolean=false
 								문자
 									char='1\u0000' => ''
 								문자열
 									String=null => 저장된 주소가 없는 상태 
 													모든 클래스는 디폴트값이 null
 					
 				배열은 선언시에 저장갯수 확인 필수!
 				int[] arr={1, 2, 3, 4, 5}; => 저장공간 5개
 				int[] arr=new int[5] => 저장공간 5개
 				
 				선언후에 초기화
 				int[] arr;
 				arr=new int[]{1,2,3,4,5}; => 메소드에서 이용
 				
 				
 			3. 출력
	 			1) for문
	 			
	 				int[] arr={1,2,3,4,5};
	 				for(int i=0;i<arr.length;i++)
	 				{
	 					System.out.println(arr[i]);
	 				}
	 				
	 			2) 향상된 for문
	 			
	 				for(int i:arr)
	 				for(int i=0;i<arr.length;i++)
	 				{
	 					System.out.println(i);
	 				}
	 			3) 라이브러리 이용
	 			
	 				System.out.println(Arrays.toString(arr)) 
 			
 			4.	메모리에 저장되는 과정(메모리 주소를 참조해서 데이터 관리 => 참조변수)
 				Stack(데이터가 있는 메모리주소)
 				Heap(실제 데이터가 저장된 메모리)
 				
 				int[] arr= new int[5];
 				
 				
 				1)
 				---------arr--------
 				 null=>주소가 배정이안됨
 				 -------------------
 				
 				2)
 				-------------------------------
 				  0  |  0  |  0  |  0  |  0  |
 				-------------------------------
 				0X100=>가상
 				arr[0] , arr[1], arr[2], arr[3], arr[4]
 				
 				3)
 				---------arr--------
 				 		0X100
 				-------------------
 				
 				4)
 				-------------------------------
 				  0  |  0  |  0  |  0  |  0  |
 				-------------------------------
 				0X100=>가상
 				arr[0] => 0X100의 첫번 째 값
 				arr[1] => 0X100의 두번 째 값
 				 .
 				 .
 				 .
 				=> 첫 번째부터 자동으로 index/첨자를 붙여서 사용
 				=> 인덱스를 이용하는 프로그램 => 항상 순차적이다 => 반복문에서 사용하기 편리하다 
 		
 		데이터 묶기 
 			연속적인 메모리 구조 => 데이터 크기가 동일해야 한다
 			한번 선언하면 변경이 어려워 => 고정적 메모리 구조
 				-> 보완 -> 라이브러리 지원(Collection) => 갯수지정이 없다
 									~~~~~~~~~~~~> 책 10장내용
 	관련된 명령문을 묶어서 사용
 		-메소드
 	------------------------------> 자바의 기본형식
 	클래스 + 메소드를 묶어서 사용 => 객체지향 프로그램(5장)
 	
 	
 	
 	
 	
 	
 	킄래스의 구성요소
 	class ClassName
 	{
 		--------------
 		변수 => 멤버변수
 			   공유변수
 			   =>일반변수/배열/클래스(변수)
 			   =>변수를 보호(데이터보호)
 			   	~~~~~~~~~~~~~~~~~~~캡슐화/은닉화
 		-------------
 		-메소드 => 기능 / 재사용
 		=>유지보수 관련(수정, 추가) => 오버라이딩/오버로딩
 		----------------
 		생성자=> 메모리에 클래스 저장 => 생략이 가능
 	
 	
 	
 	
 	
 	
 	
 */
import java.util.*;
public class 배열_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//정수, 문자, 문자열
		//1. 정수 10개저장 후 평균구하기
		
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[10];
		
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = (int)(Math.random()*100)+1;
		}
		
		System.out.println(Arrays.toString(arr));
		double avg=0.0;  // c언어와 다른 점 
						//c언어는 시작과 동시에 사용하는 모든 변수를 선언해야하지만
						//자바는 필요시마다 어떤 위치든 상관없이 변수 선언이 가능하다
		int sum=0;
		for(int i:arr)
		{
			sum+=i;
		}
		
		String result=String.format("%.2f", sum/10.0);
		System.out.println(result);
		
	}	
	

}
