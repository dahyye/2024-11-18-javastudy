/*
 
 	클래스 제작 => 인스턴스와 정적변수 구분
 	
 	클래스 - 사용자 정의 데이터형 : 데이터를 모아서 관리, 전송 목적
 		 	~VO(value object) 값만 저장 => Spring
 		    ~DTO(data transfor object => 데이터를 모아서 전송 
 		     						=> 윈도우, 브라우저, 서버에 전송
 		 - 액션 클래스 : 변수+기능(메소드) => 기능
 		  	=> 메소드 중심
 		  	=> ~DAO : 데이터 베이스 연결과 처리, 오라클이나 MySQL연결할 때 사용 
 			=> ~Manager ( 크롤링 / Map => OpenApi )
 			   ~Service : BI
 			   			: DAO+Model
 			   ~Model : 브라우저 연동
 			=> 요즘 보안처리(시큐어코딩)가 안되면 벌금을 내기도해
 			
 			=> 변수는 크게 나누면 2종류
 				- 데이터값을 따로 저장 => 인스턴스 변수
 				- 한 개의 메모리를 공유 => 정적변수, 공유변수
 					static이 있으면 공유변수, 없으면 저장
 			
 	카드놀이(카드 52장)
 		클래스 한 개 설정해서 52개의 카드정보를 저장
 		class Card //클래스영역에서는 NULL값으로 자동 초기화
 		{
 			char number;  //카드숫자 int로 하면 'A', 'J', 'K', 'Q' 를 처리할 수 없기때문에
 			String type; //모양
 			static int width;  //저장공간을 한 개만 사용(공유)
 			static int height; //저장공간을 한 개만 사용(공유)
 		}
 		
 		// width, height 는 컴파일시 자동으로 MethodArea에 저장된다
 		// 나머지는 Card c1 = new Card()로 공간을 생성해줘야해
 
 
 
 	1. 설계(데이터모아서관리)
 		class Student
 		{
 			int hakbun;
 			String name;
 			String subject;
 			int year;
 		}
 		
 	2. 메모리저장(설계된 데이터저장)
 		Student s1 = new Student;
 	
 	3. 활용(초기화, 변경, 읽기)
 		s1.hanbun=10;...
 	
 	4. 객체소멸	
 		s1=null ==>GC대상
 		=>System.gc()
 		-----------
 		멀티미디어, 화상채팅
 		
 			
 			
 			
 			
 */
class Card//6바이트메모리 ( static은 공유기때문에 )
{
	char number;  //카드숫자 int로 하면 'A', 'J', 'K', 'Q' 를 처리할 수 없기때문에
	String type; //모양
	//Card c1 = new Card()로 공간을 생성해줘야해
	static int width; 
	static int height;
	// width, height 는 컴파일시 자동으로 MethodArea에 저장된다
}

public class 클래스_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card c1 = new Card(); //객체(사용자정의 클래스의 변수, 여러개를 동시에 제어할 수 있다는 장점을 가지고 있다)=인스턴스
		//객체 => 정적인 상태(데이터) => 명사형 => 변수
		//객체 => 동적인 상태(기능) => 동사형 => 메소드
		
		
		//객체 => 변수+메소드
		//객체 => 현실세계에 있는 모든 사물
		c1.number='A';
		c1.type="♡";
		c1.width=150;
		c1.height=180;
		//c1은 Stack영역, c1에 대한 정보는 Heap영역에 저장
		//System.out.println(c1);
		//c1객체의 메모리주소 출력 Card@4aa8f0b4
		System.out.println("c1안에 저장된 데이터 number : "+c1.number);
		System.out.println("c1안에 저장된 데이터 type : "+c1.type);
		System.out.println("c1안에 저장된 데이터 width : "+c1.width);
		System.out.println("c1안에 저장된 데이터 height : "+c1.height);
		
		Card c2 = new Card();
		c2.number='2';//인스턴스(데이터가 저장된 상태) => 객체
		c2.type="♣";
		c1.width=200;
		c1.height=250;
		
		System.out.println("c2안에 저장된 데이터 number : "+c2.number);
		System.out.println("c2안에 저장된 데이터 type : "+c2.type);
		System.out.println("c2안에 저장된 데이터 width : "+c2.width);
		System.out.println("c2안에 저장된 데이터 height : "+c2.height);

		System.out.println("c1안에 저장된 데이터 width : "+c1.width);
		System.out.println("c1안에 저장된 데이터 height : "+c1.height);
		
		//c1의 값도 200,250으로 출력
		//static => 객체명.변수명
		//--------->클래스명.변수명
		Card.width=200;
		Card.height=100;
		
		System.out.println("c1안에 저장된 데이터 width : "+c1.width);
		System.out.println("c1안에 저장된 데이터 height : "+c1.height);
		System.out.println("c2안에 저장된 데이터 width : "+c2.width);
		System.out.println("c2안에 저장된 데이터 height : "+c2.height);

		
	}

}
