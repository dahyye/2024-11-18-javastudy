/*
 	
 	문자자르기기능(완전중요 암기필수)  => 원본이 변경되는 건 아니야
 	substring : 문자열을 자르기
 		0123456789
 		Hello Java
 		=> 지정된 위치부터 마지막까지 자르는 방법
 			substring(6) => Java
 		=> 지정된 위치부터 지정된 위치까지 특정 부분을 자르는 방법
 			substring(1,4) => ell //endIndex는 1개가 제외
 		trim()  공백을 제거하는 함수
 	---------------------------------------------------> JavaScript에서도 동일하게 사용		
 			
 */


public class 문자열_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String data = "Hello.Hello.Java";
		System.out.println(data.substring(data.lastIndexOf(".")+1)); //확장자 자를 때 쓰는 형식
		
		String data2="ID:admin,PWD:1234";
		System.out.println(data2.substring(data2.indexOf(":")+1,data2.indexOf(",")));
		System.out.println(data2.substring(data2.lastIndexOf(":")+1));
		System.out.println(data);
		String address= "서울 동대문구 회기동 346-14[새주소] 서울 동대문구 경희대로4길 76";
		System.out.println(address.substring(address.indexOf("]")+2));
		System.out.println(address.substring(0,address.lastIndexOf("[")));
		//System.out.println(addr2.trim());  //공백을 제거하는 함수 trim()
		
		String s="Hello Java";
		System.out.println(s.substring(s.indexOf(" ")+1));
		System.out.println(s);
		s=s.substring(s.indexOf(" ")+1);
		System.out.println(s);
	}

}
