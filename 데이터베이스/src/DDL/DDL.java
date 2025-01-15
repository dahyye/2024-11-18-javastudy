package DDL;
/*
 
 	DDL : 테이블생성
	 	 -> COMMIT이 필요가 없다(자동 저장)
	 	 -> DQL/DML => 단위 ROW (가로행을 하나씩 추가/삭제)
	 	 -> DDL => 단위 Column (세로행을 추가/삭제
	 	 -> 단점 : DROP시 복구가 안됨
	 	 CREATE : 생성
	 	 	TALBLE : 데이터 저장 공간 -> 파일
	 	 	VIEW : 가상테이블 -> 보안
	 	 	SEQUENCE : 자동 증가번호
	 	 	INDEX : 검색의 속도 최적화 -> ORDER BY 대체
	 	 	FUNCTION : 함수
	 	 	PROCEDURE : 기능처리
	 	 	TRIGGER : 자동 이벤트 처리
	 	 	
	 	 ALTER : 수정 (데이터유지)
	 	 	ADD : 추가(컬럼, 제약조건)
	 	 	MODIFY : 수정 -> 데이터 크기, 제약조건
	 	 	DROP : 컬럼삭제
	 	 DROP : 삭제 (데이터삭제)
	 	 	table 삭제 => 완전삭제
	 	 TRUNCATE : 데이터만 잘라내기
	 	 	table은 유지하고 데이터만 삭제 -> 크롤링시
	 	 RENAME : 이름 변경
	 	 	table명 변경
	 	 	
	DML : 데이터조작
	 	 => 저장시 COMMIT 필요
         INSERT : 데이터추가
         UPDATE : 데이터수정
         DELETE : 데이터삭제
         
	DCL : VIEW 생성

    TCL : 저장 / 취소
         COMMIT / ROLLBACK
 		 
 --------------------------------------------------------------------------
 
 	table : 데이터를 저장하는 공간
 	-----
	 	 1) 형식 
	 	 2) 데이터형 
	 	 3) 제약조건
	 	 4) 수정
	 	 5) 삭제
	 	 => 오라클안에 테이블 정보 저장 : user_tables => 모든 테이블명은 대문자
	 	 
	 	 => 같은 이름으로 저장이 불가능
	 	 => 알파벳 / 한글 => 운영체제가 변경이 되면 깨진다
	 	 				  -------HOSING
	 	 				  
 	 1. table명(column명)주는 방법 => 식별자
 	 	|class |멤버변수
 	 	1) 문자로 시작한다(알파벳, 한글)
 	 		알파벳 사용시에 대소문자 구부닝 없다(오라클에서는 대문자로 저장된다)
 	 		운영체제에 따라 한글은 문제가 발생할 수 있다
 	 	2) table명이나 column명은 기본 30byte사용이 가능하다
			기본 : 7~15자가 적당(freeBOard, goods, cart)
			table명과 column명은 같아도 상관없다
							   -----------> 권장사항은 아니다
		3) 같은 데이터베이스 안에서 테이블명은 한 개만 사용이 가능
			공통 오라클 -> 211.238.142.124
		4) 키워드는 사용할 수 없다
		5) 숫자는 사용이 가능하다(맨 앞에는 불가능)
		6) 테이블명이나 컬럼명은 공백을 사용 할 수 없다
		7) 특수문자 사용이 가능(_)
			ex. goods_info goods_cart ...
		
		CREATE TABLE table_name( 
			=> 컬럼추가
			=> 벤치마킹 필요
		
		)
		
		
 	 2. 컬럼 설정 : 데이터형
		문자저장
			CHAR(1~2000byte) => 고정바이트(같은 글자수 저장)
			=> y,n 여자/남자
			=>CHAR(100) ==> 'A' => 무조건 100byte가 생성
			VARCHAR2(1~4000byte) => 가변바이트
			=> 'A' => 1byte
			CLOB => 4기가 저장 => 가변형
			 ( 줄거리, 맛집소개.. 등 에서 사용)
			
		숫자저장
			NUMBER =>기본 디폴트 NUMBER(8,2) ->NUMBER(38,128)
			NUMBER(4) => 0~9999
			NUMBER(2,1) => 숫자 두개 사용이 가능
						=> 숫자 두개중에 1자리는 소수점으로 사용가능
						=> 무조건 실수로 저장해야 하는 건 안다
		날짜저장
			DATE
			TIMESTAMP -> 기록경기같은곳에서 사용
		기타저장==> 동영상 / 증명사진
			BLOB -> 4 기가(binary형태로 저장)까지 저장가능
			BFILE -> 기가(파일형태로 저장
			================================> 폴더에 저장
			
		=> 테이블 형식
		CREATE TABLE table_name
		(
			컬럼명 데이터형 [제약조건]
			컬럼명 데이터형 [제약조건]
			컬럼명 데이터형 [제약조건]
			컬럼명 데이터형 [제약조건]
			컬럼명 데이터형 [제약조건]
			[제약조건]
			[제약조건]
		)
		
		(181page)
		제약조건 => 필요한 데이터만 저장이 가능
			
			 id    name   sex
			aaa    hong	  man
			aaa	   shim  women
			
		=> DELETE FROM table_name WHERE id='aaa;'
		=> 원하지 않는 데이터가 수정, 삭제 -> 이상현상
		   -> 무결성 : 제약조건
		      ----> 기본키를 반드시 부여(중복이 없는 값)
		      
		     1. 기본키(Primary key) : 중복없는 데이터 설정
			 2. 반드시 입력값 = NOT NULL
			 3. 중복이 없는 데이터 ㅣ null값을 허용(후보키) : UNIQUE
			 4. 다른 데이블 참조 : FOREIGN KEY
			 5. 지정된 데이터만 설정 ㅣ CHECK
			 6. DEFAULT => 사용자 입력이 없는 경우 자동으로 지정
			 
			 CREATE TABLE mybook(
				bookid NUMBER(2),
				bookname VARCHAR2(40),
				publisher VARCHAR2(40),
				price NUMBER(8),
				PRIMARY KEY(bookid	
			)
			
			 CREATE TABLE mybook(
				bookid NUMBER(2) PRIMARY KEY,
				bookname VARCHAR2(40),
				publisher VARCHAR2(40),
				price NUMBER(8),
			)
			
			 CREATE TABLE mybook(
				bookid NUMBER(2) PRIMARY KEY,
				bookname VARCHAR2(40),
				publisher VARCHAR2(40),
				price NUMBER(8),
				CONSTRANINT mybook_bookid_pk PRIMARY KEY(bookid)
			)
			==> 수정 삭제가 쉬은 방법 ( 이 방법을 권장한다 )
			==> 제약조건은 user_constraints에 저장
						---------------> 중복이 있으면 안된다
				제약조건명을 만들 때 절대 중복이 안되게 만드는 방법
				 : table명_컬럼명_pk
				 PRIMARY KEY => pk
				 FOREIGN KEY => fk
			 	 CHECK		 => ck
			 	 UNIQUE      => uk
			 	 NOT NULL    => nn
			 
			 	컬럼뒤에 설정 => 컬럼 레벨 => 컬럼과 동시에 생성
			 			  => NOT NULL / DEFAULT
			 	컬럼설정 후에 => 테이블 레벨 => 컬럼을 다 생성후에 나중에 제약조건 저장
 						  => PRIMARY / FOREIGN / CHECK / UNIQUE
 ---------------------------------------------------------------------------
 						  
 			저장 데이터 추출 -> 개념적 설계
			------------
				|
			 어떤 데이터(데이터형) -> 논리적 설계
			 	|
			  메모리 크기결정	-> 물리적 설꼐
			  
			  명세표
			  -------------------------------------------------
			  컬럼명  		id		name		sex     regdate
			  -------------------------------------------------
			  키종류			pk		nn			ck
			  -------------------------------------------------
			  참조테이블
			  -------------------------------------------------
			  참조컬러
			  -------------------------------------------------
			  CHECK 여부						 check('남자','여자')
			  -------------------------------------------------
			  데이터형 	 VARCHAR2   VARCHAR2   CHAR		DATE
			  -------------------------------------------------
			  크기  			20			51	 	6
			  -------------------------------------------------
			  ==>email, addr, 추가
			    email VARCHAR2(150)
			    addr VARCHAR2(
			  	
			  	
			  	CREATE TABLE member(
				id VARCHAR2(20),
				name VARCHAR2(51) CONSTRAINT memner_name_nn NOT NULL,
				sex CHAR(2),
				regdate DATE_DEFAULT SYSDATE,
				CONSTRAINT member_id_pk PRIMARY KEY(id),
				CONSTRAINT member_sex_ck CHECK(sex,IN('남자','여자'))

				);
				
				--컬럼 추가 / 수정 ALTER
				ALTER TABLE member ADD email VARCHAR(150);
				ALTER TABLE member ADD addr VARCHAR(10);
				
				ALTER TABKE memberMODIFY addr VARCHAR2(200);
				
				--email은 필요가 없다
				ALTER TABLE member DROP COLUMN email;
				
				--addr의 이름을 address 로 변경
				ALTER TABLE member RENAME COLUMN addr TO address: 
-----------------------------------------------------------------------

	게시물 번호 => 중복없는 데이터
	작성자 => 반드시 입력
	제목 => 반드시 입력
	내용 => 반드시 입력
	비밀번호 => 반드시 입력 (본인여부 확인)
	작성일 => 작성일 등록
	조회수 => 0으로 초기화
	
	CREATE TABLE board(
		no NUMBER,
		name VARCHAR2(51) CONSTRAINT board_name_nn NOT NULL,
		subject VARCHAR2(2000) CONSTRAINT board_subject_nn NOT NULL,
		content CLOB CONSTRAINT content_name_nn NOT NULL,
		pwd VARCHAR2(10) CONSTRAINT board_pwd_nn NOT NULL,
		regdate DATE DEFAULT SYSDATE,
		hit NUMBER DEFAULT 0,
		CONSTRAINT board_no_pk PRIMARY KEY(no)
	);
	
	
	 

-------------------------------------------------------------------------


		/*
		회원가입
		
		아이디=> 중복없는 데이터
		*비밀번호 => 반드시입력 (본인여부 확인)
		*이름 
		성별 => check 키
		*생년월일
		이메일 => 후보키(unique
		*우편번호
		*주소
		상세주소
		*전화번호
		소개
		
		*/
		/*
		
		CREATE TABLE test_member(
			id VARCHAR2(20), 
			pwd VARCHAR2(10) CONSTRAINT tm_pwd_nn NOT NULL,
			name VARCHAR2(51) CONSTRAINT tm_name_nn NOT NULL,
			sex CHAR(6),
			birthday DATE CONSTRAINT tm_day_nn NOT NULL,
			email VARCHAR2(150),
			post VARCHAR2(7) CONSTRAINT tm_post_nn NOT NULL,
			addr VARCHAR2(100) CONSTRAINT tm_addr_nn NOT NULL,
			addr2 VARCHAR2(100),
			phone VARCHAR2(13),
			content CLOB,
			CONSTRAINT tm_id_pk PRIMARY KEY(id),
			CONSTRAINT tm_sex_ck CHECK(sex IN('남자','여자')),
			CONSTRAINT tm_email_uk UNIQUE(email)
		);
		
		이름                           	    널?      	유형
		 ---------------------------------- -------- 	--------------
		 ID                               	NOT NULL 	VARCHAR2(20)
		 PWD                           	    NOT NULL 	VARCHAR2(10)
		 NAME                          	    NOT NULL 	VARCHAR2(51)
		 SEX                                          	CHAR(6)
		 BIRTHDAY                  	    	NOT NULL	DATE
		 EMAIL                                     		VARCHAR2(150)
		 POST                          	    NOT NULL 	VARCHAR2(7)
		 ADDR                         	    NOT NULL 	VARCHAR2(100)
		 ADDR2                                         	VARCHAR2(100)
		 PHONE                                         	VARCHAR2(13)
		 CONTENT                                       	CLOB
		
		
		--수정(추가) =>  회원가입일 추가
		ALTER TABLE test_member ADD regdate DATE DEFAULT SYSDATE;
		--수정(추가) => 홈페이지추가 ( null 허용 )
		ALTER TABLE test_member ADD homepage VARCHAR2(10);
		--수정(변경) => 홈페이지 글자수 수정
		ALTER TABLE test_member MODIFY homepage VARCHAR2(150);
		--수정(삭제) => 홈페이지 삭제
		ALTER TABLE test_member DROP COLUMN homepage;
		--테이블 삭제
		DROP TABLE test_member;
		

		--테이블 복사(기존의 데이터를 재사용)
		CREATE TABLE emp_dept
		AS SELECT empno,ename,job,hiredate,sal,dname,loc
		FROM emp, dept
		WHERE emp.deptno=dept.deptno;
		
		
		--데이터없이 테이블만 생성
		CREATE TABLE emp_dept2
		AS SELECT empno,ename,job,hiredate,sal,dname,loc
		FROM emp, dept
		WHERE 1=2; 
		
		--1=2 false를 만들어준 것 100=200, a=b 아무거나 상관 없음
		


		비절차적 언어
		=오류가 나면 => 다음문장을 수행
		=테이블 : 설계 => 6장/7장 => 정규화
		179~186page
		1. 테이블은 데이터를 저장하는 공간(파일)
		   ----일관성이 있어야 한다
		   관련데이터를 모아서 관리 : 회원, 구매, 장바구니, 게시판, 댓글
		   -> 데이터 추출 => 개념적 설계(벤치마킹)
		   -> 데이터형 => 출력형태 => 논리적 설계 
		   -> 제약조건 / 크기 => 물리적 설계
		   =================================> 데이터 추가(DML)
		  
		2. 테이블형식
		3. 데이터형
		4. 제약조건
		5. 수정
		6. 테이블삭제
		
		
		--직접 생성하는 방법
		CREATE TABLE table_name
		(
			--순서가없다
			컬럼명 데이터형 [제약조건] => 제약조건은 여러개를 사용할 수 있다
			예) address VARCHAR2(100) NOT NULL CHECK UNIQUE
			컬럼명 데이터형 [제약조건],
			컬럼명 데이터형 [제약조건],
			컬럼명 데이터형 [제약조건],
			컬럼명 데이터형 [제약조건],  
			-------------------------------------=> DEFAULT / NOT NULL
			[제약조건],
			[제약조건],
			-------------------------------------- PROMARY KEY
									CHECK 
									UNIQUE -> 중복없는 데이터 
									FOREIGN -> 외래키 (참조키)
		)

		
		 1. 테이블 식별
		 	= 같은 데이터베이스안에서는 테이블명이 유일하다
		 	  -------------(XE), 공통 사용오라클(XE)
		 	  			   ----계정따라 hr_1... hr_4
		 	= 문자로 시작(알파벳, 한글) => 알파벳 권장
		 			   ----
		 			   대소문자 구분이 없다(실제 오라클에 테이블 정보가 저장이 될 때
		 			   					대소문자로 저장) -> 테이블 확인시에는 대문자로 입력
									 	SELECT *
									 	FROM user_contraints
									 	WHERE table_name='BOARD'
									 	
									 	* user_contraints : 제약조건 저장
									 	* user_tables : 테이블 정보
									 	* user_views : 뷰정보가 저장
			= 테이블명 길이(30byte) -> 7~15자리가 적당(의미)
			= 특수문자 : _ 를 많이 사용(헝가리식 표기법(x))
			 						------------ FileNAme, UserData, TableName
			= 키워드는 사용할 수 없다 : SELECT / FROM / JOIN
			= 공백사용은 할 수 없다
			= 숫자는 사용이 가능( 앞에 사용할 수 없다 )
			--------------------------------------
			CREATE TABLE table_name
						 ---------- column명
			데이터형
			-----
				문자 : CHAR(1~2000byte) -> 고정 -> 문자의 길이가 동일할 때 사용 => 성별
					  VARCHAR2(1~4000byte) -> 가변 -> 가장 많이 사용하는 문자형
	 				  CLOB : 4기가바이트 => 소개, 줄거리에서 사용 ( 자바에서는 String )
	 				  
	 			숫자 : NUMBER -> NUMBER(8,2)가 기본 디폴트값
	 				  NUMBER(2,1) -> 소스점 한 자리를 사용할수 있다
	 			
	 			날짜 : DATE -> 날짜/시간
	 	
	 		제약조건
	 		-----
	 			NOT NULL : NULL을 허용하지 않는데
	 						=> 무조건 데이터값이 설정
	 						=> 필수 입력
	 			UNIQUE : 유일값 (중복이 없는 값)
	 					   => NULL값 허용
	 					   => 후보키 (기본키를 찾기위한 키)
	 					   => 전화번호 / 이메일
	 			PRIMARY KEY : 기본키
	 					     => 모든 테이블에서는 기본키를 한개이상 설정해야한다
	 					     				  ----------------- 식별(구분자)가 필요하다
	 					     => UNIQUE+NOT NULL
	 					     => 기본적으로는 숫자, 문자열->ID
	 					     	(게시물번호 / 영화번호 / 맛집번호 / 댓글번호)
	 					     => 자동증가번호사용
	 			FOREGIN KEY : 외래키 (참조키)
	 						=> 다른 테이블 연결
	 						emp.deptno=dept.deptno
	 					     	-----		------
	 					     	외래키		기본키  
	 					     		
	 			CHECK : 지정된 데이터만 사용이 가능
	 					-> 부서명 / 근무지 / 성별 / 장르
	 					=> 콤보박스 / 라디오버튼
	 					
	 			DEFAULT : 미리 기본값 설정 => 입력이 없는 경우 적용(제약조건은 아님)
	 					=> 숫자(0) / 날짜(SYSDATE)
	 			
	 			** 컬럼뒤에 붙이는 경우 -> NOT NULL, DEFAULT
	 			** 컬럼 생성후에 붙이는 경우 -> PK, FK, CK, UK
	 		
	 	======================================================================
	 	
	 	CREATE TABLE myEmp
		AS SELECT empno, ename, job, hiredate, sal
		FROM emp;
		
		--ALTER 
		--deptno 추가, mgr추가
		ALTER TABLE myEmp ADD deptno NUMBER(2) DEFAULT 10 CONSTRAINT my_deptno_nn NOT NULL;
		ALTER TABLE myEmp ADD mgr NUMBER(4);
		
		--MODIFY
		ALTER TABLE myEmp MODIFY ename VARCHAR2(50) CONSTRAINT my_ename_nn NOT NULL;
		
		--DROP 
		ALTER TABLE myEmp DROP COLUMN mgr;
		
		--RENAME -> 테이블 이름 변경
		--RENAME old_table TO new_table
		RENAME myEmp TO youEmp;
		
		--RENAME -> 컬럼 이름 변경
		ALTER TABLE youEmp RENAME COLUMN empno TO sabun;
		
		--TRUNCATE : 데이터만 잘라내기(테이블은 남아있다)
		--복구불가
		TRUNCATE TABLE youEmp;
		
		--테이블삭제
		DROP TABLE youEmp; 			
	 					     				  
 */
public class DDL {

}
