/*
 
 	파일추가하는 방법
 	자바프로젝트파일을 생성 후 오른쪽클릭-> build path -> configure build path -> classpath 선택 후 add external JARs -> mydata.jar파일 추가
 																											(javaDev폴더에 있는)

	 변수=> 데이터를 모아서 관리 => 배열/클래스
	 연산자 응용=> 제어문
	 제어문 응용=> 배열
	 배열 응용=> 메소드
	 메소드=> 클래스
	 클래스=> 라이브러리
 
 	1. 문자열
	 	=> 웹, 윈도우 프로그램은 대부분 문자열로 만들어 진다
	 	=> 가장 많이 사용되는 데이터
	 	=> 문자 여러개를 모아서 저장
	 	  ---------
	 	   char[]=>String
 	   
 	2. String : 일반 데이터형 / 클래스형
 		일반 데이터형
 			String 변수명="";
 		클래스형
 			String 변수명=new String("저장데이터","UTF-8");
 			~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~=> 한글사용할 때 사용
 	3. String 의 디폴트는 null값(주소가 없는 상태)
 		=> 모든 클래스의 디폴트는 null => (NullPointerExeption)에러 발생 할 수 있어(주소값이 없다?)
 		
 	4. String 기능(메소드)
 		**String, Math, Scanner, System 은 final class => 변경을 할 수 없다(표준화)	
 		**java.lang.* => import생략할 수 있다 
	 	=> 변환
	 		toUpperCase() : 대문자변환
		 		결과값 : String
		 		매개변수 : x
		 		메소드명 : toUpperCase
		 		기능
		 		=> String toUpperCase() =>원형
		 		=> String name=toUpperCase()
		 		
	 		toLowerCase() : 소문자변환
	 			String toLowerCase()
	 	**	valueof() : 모든 데이터형을 문자열로 변환
	 			String valueof(int)
	 			String valueof(char)
	 			String valueof(double)  => 이렇게 여러가지 데이터형을 사용하는 걸 오버로딩
	 	
	 	**	replace() : 문자, 문자열 변환
	 			String replace(char c1, char c2) => c1을 c2로 변경해라
	 			String replace(String old, String new)
	 			-> 리턴형
	 		replaceAll() : 패턴을 이용한 문자열 변환
	 					   ---------> regex(정규식)
	 			String replaceAll(String regex, String change)
	 					   		  -------------
	 					   		  	정규식
	 					   
	 	=> 문자열 분해
	 	**	substring() : 문자를 자르는 경우
	 			String substring(int begin)
	 			String substring(int begin, int end)
	 										--------
	 										   end-1까지 (내가 지정한 곳 한칸 전까지 자른다)
	 	**	split() : 단어별로 나눠서 배열에 저장
	 	*		String[] split(String regex)
	 	
	 	 => 비교
	 	 **	equals() : 같은 경우에 true(==)
	 	 		boolean equals(String s)
	 		startsWith() : 시작하는 문자열이 같은 경우
	 			boolean startsWith(String s)
	 		endsWith() : 끝나는 문자열이 같은 경우
	 			boolean endsWith(String s)
	 		contains() : 포함한 문자열 찾을 때
	 			boolean contains(String s)
	 			
	 			==> 이 4가지는 boolean이라서 주로 if문에서 사용한다
	 			
	 			
	 	
	 	=> 위치찾기
	 	**	indexOf() : 처음부터 찾기
	 			int indexOf(Char s)
	 	**	lastIndexOf() : 마지막부터 찾기
	 			int lastIndexOf(char s)
	 	=> 문자열 결합
	 		concat() : 문자열 결합
	 			String concat(String s) 
	 		  +      : 문자열 결합
	 		  	==> concat보다는 +를 더 많이 사용해
	 		  
	 	=> 기타
	 	**	trim : 좌우의 공백 제거
	 			String trim()
	 		charAt() : 문자의 위치를 찾아서 문자 읽기
	 			charAt(int index)
	 		toCharArray() : String을 char[]로 변경
	 			char[] toCharArray()
	
	
	
		로그인을 할 때 -> 아이디 비밀번호를 받아야해
		boolean login(String id, String pwd)
		파일 검색할 때 -> 검색어를 받아야해
 		
 */
import java.util.Scanner;
public class 문자열배열_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//배열선언과 동시에 초기화
		String[] names={"홍길동", "심청이", "박문수","이순신","강감찬"};
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = scan.next();
		// 공백이 있는 경우는 scan.nextLine()
		for(String n:names)
		{
			if(n.contains(name))  // equals는 꼭 대소문자를 구분해야해
								// equalsIgnoreCase()는 대소문자 구분 안해
			{
				System.out.print(n+" ");
			}
			
		}
		
		
	}

}
