package 데이터베이스;

/*
 
 데이터베이스 시스템
 -------- 관련된 데이터를 모아서 관리 =>XE데이터베이스명
 		  ----------공유(모든 사람이 접근이 가능
 		  
 		  
 		 개발자
 		   |
 		 오라클
 		   |
 		 운영체제
 		   |
 		 하드디스크 : 데이터저장
 		 => 데이터베이스 : 저장 / 수정 / 삭제 / 추가 / 읽기 => CRUD
 		    예약하기 : 정보저장 / 수장 / 식제 / 예약보여주기
 		 => web의 핵심 : 자바 / 오라클 => HTML출력
 		 			   ---------- 수료
 		 			   
 		프로그램 언어 사용
 		브라우저 =========오라클(ㅌ)
 		------화면 UI
 		
 		
 		브라우저 ========== 자바 ======== 오라클
 						 ----
 						 오라클 연결 . 브라우저 데이터 전송
 		SQL문장은 로직이 없다(제어문이 없다 -> 함수, 연산자)
 		------ 형식 -> 컬럼/테이블
 		------ SQL문장 / HTML / CSS => 암기만 하면 된다
 						---------- 사용자 정의가 없다 
 		
 		SQL => 구조화된 질의 언어 -> 검색과 관련
 								----
 								루씬(구글) => ElasticSearch
 		
 		SQL의 종류
 		
 		DQL : 데이터 검색 = SELECT
 		DML : 데이터 조작언어
 			INSERT : 데이터 추가( 회원가입, 글쓰기, 댓글올리기.. )
 			UPDATE : 데이터 수정( 회원수정, 댓글 수정, 예약 수정.. )
 			DELETE : 데이터 삭제( 회원탈퇴, 예약취소, 결제 취소.. )
 			MERGE  : 데이터 통합( 분기별 통계, 부서별 통계.. )
 		DDL : 데이터 정의언어	
 			CREATE : 생성 -> 저장소(테이블), 가상테이블(View)
 							자동증가번호(SEQUENCE)
 							속도의 최적화(INDEX)
 							중복제거 -> 함수(FUNCTION)
 							기능을 수행 -> 프로시저(PROCEDURE)
 							자동화처리 -> 트리거(TRIGGER)
 			ALTER : 수정
 					ADD -> 컬럼추가. 제약조건
 					MODIFY -> 수정
 					DROP -> 컬럼제거
 			DROP : 삭제	
 			TRUNCATE : 데이터만 잘라내기
 			RENAME : 테이블명 변경	
 		DCL : 데이터제어언어	
 			-> 개발자가 사용하지 않는다 -> 주로 DBA 가 접근
 			GRANT : 권한 부여
 			REVOKE : 권한 해제
 			=> hr(현재 사용하는 계정 : 사용자계정)-> view, 시노님, 함수, 트리거 생성이 불가능
 		TCL : 트랜잭션->일괄처리
 			  정상저장은 반드시 commit을 날려야한다
 			  오류발생 => 취소 : ROLLBACK
 			
 		SQL 데이터형
 											Mybatis
 				문자열:CHAR VARCHAR2			========>text
 							--------오라클에서만 사용
 				숫자(정수/실수):NUMBER			========>int/double
 				날짜:DATE						========>DateTime
 			
 			
 		SQL 문징의 주의점
 		 1. 문장의 순서, 문법 잘 지키기
 		 2. SQL문장이 종료되면 ;을 사용 -> 자바에서는 자동으로 ;가 생성되기 때문에 사용하면 안된다
 		 3. 문자열 / 날짜 => ' '을 사용한다
 		 4. SQL문장의 기본은 대소문자를 구분하지 않는다
 		 	-> 저장된 데이터는 대소문자를 구분
 		 	-> 실제 오라클에 저장이 될 때 테이블명, 컬럼명은 대문자로 저장
 		 	-> 테이블 : 한글을 사용할 수 있다(리눅스 => 한글이 깨짐)
 		5. 파일 -> 구분을 직접 만들어서 처리 -> \n  |
 			데이터베이스 구분 -> 컬럼
 		6. 처리단위 -> ROW -> RECORD
 		7. 가급적이면 키워드는 대문자로 사용
 		
 		**SELECT : 데이터 검색
 		  1) 컬럼 대신 사용 ==> 스칼라 서브쿼리
 		  	SELECT no(SELECT~)
 		  2) 조건 ===> 서브쿼리
 		  	WHERE depno=(SELECT~~)
 		  3) 테이블 대신 사용이 가능 ==> 인라인뷰
 		  	SELECT
 		  	FROM(SELECT~)
 		**SELECT 형식
 		  SELECT *|column_list
 		  			 출력에 필요한 데이터만 선택할 때 사용
 		  FROM table_name
 		  [
 		  	WHERE 조건문(연산자사용)
 		  	GROUP BY 그룹컬럼 -> 그룹별로 나눠서 따로 처리
 		  	HAVING 조건 -> GROUP BY가 있는 경우에만 사용이 가능
 		  	ORDER BY 컬럼 -> 정렬할 때 사용(ASC,DESC)
 		
 		  ]
 		  
 		*컬럼명이 길거나 알아보기 어려운 경우 별칭사용
 		 - 컬럼명 ""    컬럼명 as ""
 		*필요시에는 문자열결합(||사용)
 		*문자열/날짜 => ' '
 		*오라클안에서 문장이 종료 ; 사용
 		
 ----------------------------------------------------------------------------------------
 	
 	156page
 	정렬
 	명령어 : ORDER BY => SQL문장 마지막에 추가
 					=> ASC / DESC 
 					=> ASC는 생략가능
 					
 			--컬럼별로 올림차순정리하기 1=ename, 2=sal
			//자바에서는 0으로 시작하지만 오라클은 1부터 시작
			SELECT ename, sal
			FROM emp
			ORDER BY 2;
 	
 			
 			--2중정렬 처음조건으로 정렬하고 같은 값이 있을 때 뒷 조건으로 한 번더 정렬하기
			SELECT ename, sal
			FROM emp
			ORDER BY 2 DESC, 1 ASC;
			//주로 답변형 게시판 대댓글에서 사용
			 
 ----------------------------------------------------------------------------------------
 	
 	SELECT : 데이터검색(오라클에서 데이터를 찾아주는 역할)
 	------
 	
 	1. 형식 / 순서
 		SELECT * |column_list
 		FROM table명
 		[
 			WHERE 조건문
 			GROUP BY 그룹컬럼
 			HAVING 그룹조건
 			ORDER BY 컬럼 (ASC|DESC)
 		]
 	2. 조건 검색
 		WHERE -> 연산자 사용법
 			산술연산자 : + - * /
 			비교연산자 : =, <>, <, >, <=, >=
 			논리연산자 : AND OR
 			IN / BETWEEN / NOT / NULL(IS NULL, IS NOT NULL) / LIKE 
 	3. 내장함수 : 오라클에서 지원하는 함수(라이브러리)
 				리턴값을 가지고 있다
 				사용위치 -> SELECT, WHERE, GROUP BY, ORDER BY뒤에 사용
 				사용자 정의 함수도 존재
 				CREATE FUNCTION GKATN
 		단일행함수 : ROW 단위 처리, 한줄씩 처리
 			문자 함수 String
 				LENGTH(), LENGTHB():바이트 수
 				EX. LENGTH('ABC') -> 3
 					LENGTH('홍길동') -> 3
 					LENGTHB('ABC') -> 3BYTE
 					LENGTHB('홍길동') -> 9BYTE
	 				-> 비밀번호글자수 확인할 때 사용
 					
 					CHAR(1~2000byte)
 					VARCHAR2(1~4000byte)
 					CLOB(1~4GB) //줄거리, 회사소개
 					
 				UPPER() : 대문자 변환할 때 사용 -> String에서 처리후에 전송하는게 편할 수 있다
 					UPPER('abc') => ABC
 				LOWER() : 소문자 변환할 때 사용
 					LOWER('ABC') => abc
 				INITCAP() : 이니셜 변환 -> 첫자만 대문자
 					INITCAP('abc')-> Abc
 				LPAD
 					LPAD(문자열,문자갯수,출력문자)
 					LPAD('admin',10,'*')
 						=> *****adimin
 				RPAD
 					RPAD('admin',10,'*')
 						=> adimin***** => id찾기
 										  비밀번호는 이메일전송으로 해야해(보안)
 												  ------- javaMail
				LTRIM / RTRIM / TRIM : 좌우의 문자 제거, 공백 제거
					LTRIM(문자열,'제거할문자')
					LTRIM('aaaHongaaa','a') => Hongaaa
					RTRIM('aaaHongaaa','a') => aaaHong
					TRIM('a' FROM 'aaaHongaaa') => Hong
					
				SUBSTR : 문자열을 자를 때 사용(자바의 subString()과 같은 역할)
					SUBSTR(문자열,시작번호,갯수)
					SUBSTR('abcdefg',1,3) 1에서부터 3글자 -> abc
				
 		 	숫자 함수 Math
 		 	날짜 함수 Calender
 		 	변환 함수 Format
 		 	기타 함수 NULL처리, 다중 조건문, 선택문
 		 	
 		 	
 		집합행함수
 			
 	4. 여러개 테이블을 연결
 		조인
 		서브쿼리(부속질의)
 		
	5. 그룹별 처리 => GROUP BY
	6. 정렬 => ORDER BY
			 
 			
 
 */
public class 데이터베이스_250103 {

}
