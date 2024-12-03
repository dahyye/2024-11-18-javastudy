/*
 
	문자열 배열
	String[] 배열명 = {"","","",""};  => 명시적 선언
	String[] 배열명 = new String[10]; =>null
	
	int[] aa;
	aa=null;
 

 */
import java.util.*;
public class 문자열_1 {
//	static int[] arr;//자동으로 초기화 -> null
//	arr=""
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr;  //오류
		
		String[] names= {"","","",""};
		//문자열 => 데이터수정, 추가가 불가능 => 검색에서 주로 사용
		//문자열 => 오라클 명령어 "SELECT
		//전체출력
		//일반 for
		for(int i=0;i<names.length;i++)
		{
			System.out.println(names[i]+" ");
		}
		//for-each
		//라이브러리
		
	}

}
//