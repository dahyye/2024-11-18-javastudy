/*
 향상된 for => for-each  : JDK1.5
 			---------- 배열 / collection
 						웹에서 주로 사용
 			VueJS/ReactJS
 			  ㅣ       ㅣ
 			 Vuex    Redix
 			 		  ㅣ
 			 		  React-Query => 개인프로그램
 			 		  =========== nextjs
 			 		  
 
 	프로젝트 
 		1. 자바활용 => 자바를 정리하고 (네트워크, 데이터베이스 활용)
 		2. 웹 데이터베이스 활용
 		3. 웹 Spring 관련 내용 습득, 데이터베이스 고급과정
 		4. 웹 (개인프로젝트) => 신기술
 
 */
import java.io.*;
public class 반복문_6 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		FileReader fr=new FileReader("c:\\javaDev\\movie.txt");  //파일형식이 utf-8로 되어있어야해
	//	String movie=""; //이렇게 사용하면 느려
		StringBuffer sb=new StringBuffer(); // => 저장했다가 한 번에 뿌려 속도가 훨씬 빨라 // 최적화
		int i=0; // 문자읽기
		while((i=fr.read())!=-1) // -1 이 파일의 끝까지 읽어라 라는 뜻 
		{
			sb.append((char)i);
		}
		fr.close();
		System.out.println(sb.toString());
		
		
	}

}
