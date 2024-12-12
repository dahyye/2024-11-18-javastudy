package com.sist.main;

import java.util.ArrayList;

/*
 	194page
 	
 	상속 : 이미 만들어진 클래스를 재사용
 		=> 변경해서 사용, 상속이 안되는 클래스(final clss ex. String System, Scanner...)
 	포함 : 재사용
 		=> 있는 그대로 사용
 		
 	예)
 		묻고 답하기
 			글쓰기 상세보기 목록출력 수정 삭제 검색 답하기
 		답변 
 			글쓰기 상세보기 목록출력 수정 삭제 검색 답변하기
 		자유게시판
 			글쓰기 상세보기 목록출력 수정 삭제 검색
 		자료실
 			글쓰기 상세보기 목록출력 수정 삭제 검색 다운로드 업로드
 			
 			↓↓↓↓
 		게시판
 			글쓰기 상세보기 목록출력 수정 삭제 검색
 		묻고 답하기 extends 게시판
 			답하기
 		답변  extends 게시판
 			답변하기
 		자유게시판 extends 게시판
 			
 		자료실 extends 게시판
 			다운로드 업로드
 			
 			
 	** 코딩에서 어떤 클래스로 저장할 것인가가 중요
 	*
 			
 */
public class 재사용_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		list.add("홍길동");
//		String name=list.get(0);//오류
//		String name=(String)list.get(0);
		
	}

}
