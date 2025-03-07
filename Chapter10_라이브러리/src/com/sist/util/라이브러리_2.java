package com.sist.util;

import java.util.StringTokenizer;

/*
 	StringTokenizer 
 	
 	1. 자른 데이터를 읽기 -> nextToken()
 	2. 총 자른 갯수 : counterTokens()
 	3. 자른 데이터가 있는 동안 : hasMoreTokens() // 몇개인지 모를 때 
 		-> 영화출연진 -> ,
	4. 일반 데이터형 => 사용빈도가 많다
	5. 네트워크 입출력
 
 */

//StringTokenizer 
public class 라이브러리_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// => 크롤링
		String data ="박 : 현빈 ,  박정민 ,  조우진 ,  전여빈 ,  박훈 ,  유재명 ,  릴리 프랭키 ,  이동욱";
		StringTokenizer st = new StringTokenizer(data,",");//(데이터, 구분자)
		//new StringTokenizer(data) => " " 공백으로 자른다
		System.out.println("출연 총 인원 : "+ st.countTokens());
		
		while(st.hasMoreTokens()) //자른 갯수만큼
		{
			System.out.println(st.nextToken().trim());
		}
		
		String make = "그릭요거트 4 큰 술, 땅콩버터 1 큰 술을 고르게 섞어 줍니다.^https://recipe1.ezmember.co.kr/cache/recipe/2024/12/05/c608f60aeb98bbd3116a764c0dde400e1_m.jpg";
		System.out.println("레시피제작법 : "+st.nextToken());
		System.out.println("레시피이미지 : "+st.nextToken());
		/*
		 
		 1. 클라이언트에서 서버로 데이터 전송
		 	100|admin|1234
		 	로그인해줘 | 아이디 | 패스워드
		 	switch(protocol)
		 	{
		 		case 100 :
		 			로그인한다
		 		   .
		 		   .
		 		   .
		 		 
		 	}
		 
		 */
		
	}

}
