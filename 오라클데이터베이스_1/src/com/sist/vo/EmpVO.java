package com.sist.vo;
import java.util.*;

import lombok.Data;
/*
 	오라클에 있는 데이터를 모아서 윈도우나 브러우저에 전송할 목적
 	=> 한 명에 대한 데이터를 가지고 있다
 	
 	멤버변수는 컬럼명과 동일하게 만든다
 	데이터형 일치시켜야 한다
 		(오라클)							 (자바)
 		문자형 					===>	 String
 			CHAR
 			VARCHAR2
 			CLOB
 		숫자형
 			NUMBER(4) 정수 		===>     int
 			NUMBER(7,2) 실수		===>	 double
 		날짜형
 		 	DATE				===> 	java.util.Date
 
 
 */
@Data
public class EmpVO {
	private int empno;  // => 유일하게 중복이 없다
	private String ename;
	private String job;
	private int mgr;//사수번호
	private Date hiredatel;
	private int sal;//임금
	private int comm;//성과금
	private int depno;//부서번호

}
