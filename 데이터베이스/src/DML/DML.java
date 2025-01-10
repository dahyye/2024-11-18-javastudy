package DML;
/*
 	데이터를 첨부
 	INSERT 명령 (COMMIT이 필요하다)
 		1. 데이터를 전체 첨부
	 		CREATE TABLE memner
			(
				id VARCHAR2(20),
				name VARCHAR2(30),
				address VARCHAR2(100),
				regdate DATE DEFAULT SYSDATE
			)
 		2. 전체 데이터 추가
 			INSERT INTO member VALUES('hong','홍길동','서울',SYSDATE)
 		3. 원하는 데이터 추가
 			INSERT INTO member(id, name, address VALUES('hong','홍길동','서울');
 		
 ------------------------------------------------------------------------------
 
  	CREATE TABLE member
	(
		id VARCHAR2(20) CONSTRAINT mem_name_nn NOT NULL,
		pwd VARCHAR2(10) CONSTRAINT mem_pwd_nn NOT NULL,	
		name VARCHAR2(50),
		sex CHAR(6),	
		email VARCHAR2(100),	
		birthday DATE CONSTRAINT mem_day_nn NOT NULL,	
		address VARCHAR2(100) CONSTRAINT mem_addr_nn NOT NULL,
		regdate DATE DEFAULT SYSDATE,
		CONSTRAINT mem_id_pk PRIMARY KEY(id),
		CONSTRAINT mem_sex_ck CHECK(sex IN('남자','여자')),
		CONSTRAINT mem_email_uk UNIQUE(email)
	);

	INSERT INTO member VALUES('hong','1234','홍길동','남자','','00/10/10','서울',SYSDATE);
	COMMIT;
	INSERT INTO member VALUES('shim','1234','심청이','여자','shim@co.kr','11/09/10','경기',SYSDATE);
	INSERT INTO member VALUES('park','1234','박문수','남자',' ','08/01/17','부산',SYSDATE);
	COMMIT;
	
	
	
	
	CREATE TABLE board(
		no NUMBER,
		name VARCHAR2(50) CONSTRAINT board_name_nn NOT NULL,
		subject VARCHAR2(2000) CONSTRAINT board_subject_nn NOT NULL,
		content CLOB CONSTRAINT board_content_nn NOT NULL,
		pwd VARCHAR2(10) CONSTRAINT board_pwd_nn NOT NULL,
		regdate DATE DEFAULT SYSDATE,
		hit NUMBER DEFAULT 0,
		CONSTRAINT board_no_pk PRIMARY KEY(no)
	);
	

	INSERT INTO board(no,name,subject, content,pwd)
	VALUES(1,'홍길동','CRUD=DML','DML : 데이터조작언어','1234');
	
	INSERT INTO board(no,name,subject, content,pwd)
	VALUES(2,'홍길동','CRUD=DML','DML : 데이터조작언어','1234');
	
	INSERT INTO board(no,name,subject, content,pwd)
	VALUES(3,'홍길동','CRUD=DML','DML : 데이터조작언어','1234');
	
	INSERT INTO board(no,name,subject, content,pwd)
	VALUES(4,'홍길동','CRUD=DML','DML : 데이터조작언어','1234');

	 
	
	--번호 자동증가, null값 처리
	INSERT INTO board(no,name,subject, content,pwd)
	VALUES((SELECT NVL(MAX(no)+1,1) FROM board),'홍길동','CRUD=DML','DML : 데이터조작언어','1234');
	INSERT INTO board(no,name,subject, content,pwd)
	VALUES((SELECT NVL(MAX(no)+1,1) FROM board),'홍길동','CRUD=DML','DML : 데이터조작언어','1234');
	INSERT INTO board(no,name,subject, content,pwd)
	VALUES((SELECT NVL(MAX(no)+1,1) FROM board),'홍길동','CRUD=DML','DML : 데이터조작언어','1234');
	COMMIT;
 
 	
 	
 */
public class DML {

}
