package com.sist.vo;
/*
 
 CREATE TABLE replyBoard(
 no NUMBER ,
 name VARCHAR2(51) CONSTRAINT rb_name_nn NOT NULL,
 subject VARCHAR2(2000) CONSTRAINT rb_subject_nn NOT NULL,
 content CLOB CONSTRAINT rb_content_nn NOT NULL,
 pwd VARCHAR2(10) CONSTRAINT rb_pwd_nn NOT NULL,
 regdate DATE DEFAULT SYSDATE,
 hit NUMBER DEFAULT 0,
 groud_id NUMBER,
 groud_step NUMBER DEFAULT 0,
 groud_tab NUMBER DEFAULT 0,
 root NUMBER DEFAULT 0,
 depth NUMBER DEFAULT 0,
CONSTRAINT rb_no_pk PRIMARY KEY(no)
);



----------------------------------------
group_id : 답변별로 묶어주는 역할
group_step : 답변안에서 출력 순서
group_tab : 답변 / 답변에 답변 
-----------------------------------------> 답변 출력용
root : 답변 대상
depth : 답변의 갯수
-----------------------------------------> 삭제용
		
								no	group_id   group_step   group_tab     root    depth
AAAAA     		   -> 글			->	1    	    1			0		0		0	2
  => BBBB		   -> 답변			->	2	    1			1		1		1	1
    => CCCC	   -> 답변의 답변		->	3	    1    		2		2		2	0
  => DDDD	   -> 답변의답변		->	4	    1			3		1		1	0	
QQQQQ		    -> 또 다른 글		->	5	    2			0		0		0	1
  => FFFF		   -> 답변			->	6	    2			1		1		5	0


->AAAA에 대한 새로운 답변 GGGG가 달린다면

								no	group_id   group_step   group_tab     root    depth
AAAAA     		   -> 글			->	1    	    1			0		0		0	2
  => GGGG					->     7	    1			1		1		1	0
  => BBBB		   -> 답변			->	2	    1			1		1		1	1
    => CCCC	   -> 답변의 답변		->	3	    1    		2		2		2	0
  => DDDD	   -> 답변의답변		->	4	    1			3		1		1	0	
QQQQQ		    -> 또 다른 글		->	5	    2			0		0		0	1
  => FFFF		   -> 답변			->	6	    2			1		1		5	0

*/
/*
CREATE SEQUENCE rb_no_seq
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;
*/
/*
--같은 번호가 들어갈 수 있어서 시퀀스는 사용불가
INSERT INTO replyBoard(no,name,subject,content,pwd,group_id) VALUES(rb_no_seq.nextval,'홍길동','답변형게시판(DML)','답변형게시판(DML)-> INSERT/UPDATE/DELETE','1234',(SELECT NVL(MAX(group_id)+1,1) FROM replyBoard));

COMMIT;
*/



/*
INSERT INTO replyBoard(no,name,subject,content,pwd,group_id, group_step,group_tab
) VALUES(rb_no_seq.nextval,'심청이','답변형게시판을 사용','답변올립니다','1234',10,2,2);
COMMIT;


*/
/*
INSERT INTO replyBoard(no,name,subject,content,pwd,group_id) VALUES(rb_no_seq.nextval,'홍길동','답변형게시판(DML)','답변형게시판(DML)-> INSERT/UPDATE/DELETE','1234',(SELECT NVL(MAX(group_id)+1,1) FROM replyBoard));


COMMIT;

*/
 
 /*
 NO         NOT NULL NUMBER         
NAME       NOT NULL VARCHAR2(51)   
SUBJECT    NOT NULL VARCHAR2(2000) 
CONTENT    NOT NULL CLOB           
PWD        NOT NULL VARCHAR2(10)   
REGDATE             DATE           
HIT                 NUMBER         
GROUD_ID            NUMBER         
GROUD_STEP          NUMBER         
GROUD_TAB           NUMBER         
ROOT                NUMBER         
DEPTH               NUMBER     
 
 */
import java.util.*;

import lombok.Data;
@Data
public class ReplyBoardVO {
	private int no,hit, group_id, group_step,group_tab,root,depth;
	private String name, subject,content,pwd,dbday;
	private Date regdate;
	//TO_CHAR을 이용해서 날짜 형식 변경 -> 상세보기 : 날짜+시간
	
	
}
