package com.sist.music;

import lombok.Data;

/*
 	캡슐화 => 데이터보호
 	VO -> 데이터를 모아서 전송할 목적의 클래스
 	 
 */
@Data
public class MusicVO {
	private String title;
	private String singer;
	private String album;
	//변수를 감췄지만 사용자가 연결해서 사용할 수 있게 getter/setter필요
	//->소스가 너무 길어져서 롬복을 라이브러리에 추가했어 @Data
	
}
