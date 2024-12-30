package com.sist.board;
import java.io.Serializable;
import java.util.*;

import lombok.Data;
/*
 	파일 => ArrayList => 제어
 
 */
//캡슐화 / 오버라이딩 => 포함
@Data
public class BoardVO implements Serializable {
	
	private int no;
	private String name;
	private String subject;
	private String content;
	private String pwd; //본인 여부 확인용
	private Date regdate; //작성일
	private int hit; //조회수
	
	
	
	
}
