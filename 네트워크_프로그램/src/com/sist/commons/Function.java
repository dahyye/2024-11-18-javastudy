package com.sist.commons;
//서버와 클라이언트가 공통으로 사용하는 기능
//내부 프로토콜 : 서버 / 클라이언트의 약속
/*
 	예를들어서 
 	100 => 로그인
 	200 => 방만들기
 	
 	1. 서버로 요청 -> 응답을 받아서 윈도우 출력
 	   --------
 	    요청처리	   	결과값을 출력
 
 */
//모바일 / 빅테이터는 네트워크에 중심
//우리는 웹수업이기 때문에 데이터
public class Function {

	public static final int LOGIN=100;//먼저 로그인한 사람 처리
	public static final int MYLOG=110;//로그인하는사람
	public static final int WAITCHAT=200;
	public static final int END=900;//남아있는사람
	public static final int MYEND=910;//나가는사람
	//나가는 사람과 남아있는 사람 따로 처리해야한다
	//모든 처리는 서버에서 명령을 내린다	

}
