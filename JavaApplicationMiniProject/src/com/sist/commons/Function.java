package com.sist.commons;
//서버와 클라이언트의 약속 -> 내부프로토콜(정수/문자열 자유)
//서버와 클라이언트 동시에 사용 -> 공통모듈
//=>  이미지 => 확대/축소프로그램을 만들고 들어갈 예정 :CSS

public class Function {
	//클라이언트 요청사항
	//먼저 로그인된 사람
	public static final int LOGIN=100; 
	//로그인하는 사람
	public static final int MYLOG=110; 
	//채팅
	public static final int WAITCHAT=200;
	//쪽지보내기
	public static final int SENDMESSAGE=300;
	// 개인정보보기
	public static final int INFO=400; 
	//나가기
	public static final int EXIT=900;
	public static final int MYEXIT=910;
	

}
