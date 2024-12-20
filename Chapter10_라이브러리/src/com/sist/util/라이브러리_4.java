package com.sist.util;
import java.text.SimpleDateFormat;
/*
 	날짜 관련
 	-------
 	Date=>기능이 없다
		현재 시스템(현재 컴퓨터)의 날짜와 시간을 읽어 온다
			오라클과 호환이 좋아 
			java.util.Date **
			java.sql.Date(오라클과 호환이 안된다)
 	Calendat -> Date에 해당하는 기능을 추가(Date보다 업그레이드된 클래스)
 		Date를 확장 -> 제어가 간단하다
 		------------------------
 				메소드 기능이 좋다
 	
 	=> 반드시 동행
 		SimpleDateFormat => java.text
 		----------------
 		날짜 출력시에 원하는 형태로 출력
 
 		년도 yyyy or yy	(소문자)
 		월 MM or M		(대문자)  //월과 분이 같은 알파벳을 사용하기 때문에 충돌이 일어날 수 있어서 하나는 대문자
 		일 dd or d 		(소문자)
 		분 mm or m		(소문자)
 		초 ss or s		(소문자)
 
 */
import java.util.*;
public class 라이브러리_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) //시간이 계속 업데이트 
		{
			 Date date = new Date();
			 SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
			 System.out.println(date);
			 System.out.println(sdf.format(date));
			 
		}
	}

}
