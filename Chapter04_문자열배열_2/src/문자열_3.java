/*
 
 	문자열
 		비교(로그인, 아이디중복) => equals
 		검색 => contains
 		검색어 출력 => startsWith
 		검색어를 자르는 경우 => substring()
 		검색시 사용자가 실수하는 경우(space누르는 경우)=>trim() 공백제거 
 	
 */
public class 문자열_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id="admin";
		//문자열 자체가 String => 메모리주소
		if(id.equals(" admin".trim())) //공백이 있어서 아이디를 인식 못함
		{
			System.out.println("아이디가존재");
		}
		else
		{
			System.out.println("아이디가 없다");
		}
	}

}
