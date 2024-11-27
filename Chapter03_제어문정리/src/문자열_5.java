/*
 	
 	문자의 위치 찾기
 	indexOf(문자)  // 문자열 처음부터 지정된 문자를 찾는다
// 	lastindexOf(문자)  //문자열 뒤에서부터 지정된 문자를찾는다
 	==> 찾는 문자가 없는 경우에는 -1;
 	->확장자?
 	
 
*/

public class 문자열_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data="Hello Java";
		
		//https://www.daum.net/index.html  여기서 (index.html)를 찾고싶을 때 마지막 /를 찾아야해
		//웹에서 등장 : url => 마지막 파일명을 찾아서 처리
		int a=data.indexOf("a");
		int b=data.lastIndexOf("a");
		int c=data.indexOf("c");
		
		System.out.println("a"+a);
		System.out.println("b"+b);
		System.out.println("C"+c);  //출력은 데이터값이 아니라 자리위치
	}

}
