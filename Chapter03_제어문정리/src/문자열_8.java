/*

	함수	   : function
 	메소드   : method
	================기능상으로는 동일
	class종속
	c/c++/파이선-> function(함수)
 	java/Kotlin->method
 	
 	대문자 변환 toUpperCase()
 
 	replace(문자열, 문자열)
            old   new 	
 	replace(문자, 문자)
 	
 	
 	|,&,'' -> 오라클에서는 첨부할 수 없다
 	&을 replace해서 다른 문자로
 	오라클에서 &=> Scanner, ||=>문자열 결합, 문자열 =>''
 	
 */

import java.util.*;

public class 문자열_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "Hong gil dong";
		System.out.println(name.toUpperCase()); //대문자
		System.out.println(name.toLowerCase()); //소문자
		Scanner scan = new Scanner(System.in);
		System.out.println("문자를 입력: ");
		
		
		String data="Hello Java";
		System.out.println(data.replace("a", "k"));
		System.out.println(data.replace("Java", "Oracle"));
	
		
		
		
		
		
	}

}
