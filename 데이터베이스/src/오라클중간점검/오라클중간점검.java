package 오라클중간점검;
/*
 	3장/4장
 	------
 	 3장 : DQL관련
 	 -----------
 	 	SQL : 구조화된 질의 언어 => SELECT(검색) => 형식/사용처/응용/자바에서 처리
 	 												   ------- JDBC=>DBCP=>MyBatis=>JPA 
 		jsp교재안에 MVC구조에 대한 내용이 없다
 		Spring => boot
 		
 	
 	DQL : SEKECT -> 데이터를 검색 => 오라클 저장값을 읽기
 		형식) 
 			SELECT *|column_list
 			FROM table_name|(SELECT ~)|view_name
 			[
 				WHERE 조건절 (컬럼명|함수 연산자 값)
 				GROUP BY 그룹컬럼|함수
 				HAVING 그룹조건(집계함수)
 				ORDER BY 컬럼|함수 ASC|DESC
 			]
 			=> 웹사이트 : 70%
 			목록출력/상세보기/검색...
 			마이페이지 -> 찜목록 / 장바구니 / 예약..
 			
 		주의점 
 		1. 오라클에서 사용시에는 명령문이 종료;을 사용한다
 			=> 자바에서는 ; 사용하면 오류발생
 		2. 크롤링에서 ||, & 가 나오면 replace()를 이용한다
 		3. 자바에서는 문자열을 사용 => 공백사용
 		4. 문자/날짜 => ' '
 		5. 저장된 데이터는 대소문자 구분
 		6. 사용기술
 			문자열 결합 ||
 			중복제가 : 자바에서는 (Set) => 오라클에서는 DISTINCT
 		
 		
 		WHERE 문장
 			연산자
 				산술연산자(+,-,*,/)
 					순수하게 산술만 처리가 가능
 					정수/정수 = 실수
 					'10'+1=11
 					 --------> TO_NUMBER 자동으로 정수형 변경
 					 ROW단위 통계
 					 SELECT 뒤에서 주로 사용
 				비교연산자
 					= 같다, (<>, !=, ^=)rkxwl dksgek
 				논리연산자 
 					AND : 포함 or : 미포함
 					&&(Scanner:입력) ||(문자열결합)
 				오라클에서 지원하는 연산자
 					IN : OR가 여러개인 경우에 사용/다중검색
 					WHERE 컬럼 IN(값,값,값..)
 				 	BETWEEN a AND b : 범위를 따질 때 (a이상 b이하) -> 페이징기법에서 사용
 				 	NOT : 부정
 				 	NULL : null은 값이 없는 상태
 				 			연산처리가 안된다
 				 			is null : null인 경우
 				 			is not null : null이 아닌 경우
 				 	LIKE : 검색
 				 		시작문자검색 '문자%'
 				 		끝문자검색	  '%문자'
 				 		포함문자검색  '%문자%' => 문자갯수를 알면 __를 사용할 수도 있다
 				 		
 			
 		SELECT 문장
 			내장함수
 				ROW단위 => 한 줄씩 처리 -> 단일행함수
 					문자함수
 						SUBSTR(문자열|컬럼,시작위치, 몇개)
 						-> 오라클은 시작 인덱스가 1부터 시작
 						LENGTH(문자열|컬럼) -> 문자 갯수
 						RPAD(문자열|컬럼,출력 글자수, 대체할문자)
 						INSTR(문자열|컬럼,찾는문자,시작,몇번째)
 						
 					숫자함수
 						ROUNT(실수, 소수점) : 반올림
 						CEIL(실수) : 올림
 						TRUNC(실수, 소수점) : 버림
 					날짜함수
 						SYSDATE : 시스템날짜, 시간
 						
 					변환함수
 						TO_CHAR
 							=> 숫자 TO_CHAR(숫자,'999,999')
 							=> YYYY(RRRR)/MM/DD/HH(HH24)/MI/SS
 							
 					기타함수
 						NVL(컬럼,대체값)
 							--------> NULL인 경우 대체값
 						
 					
 				COLUMN 단위 => 한 개의 컬럼 전체에 대한통계
 						   => 집계함수
 						   
 					COUNT() : ROW 갯수
 					MAX() : 자동 증가번호
 					SUM/AVG => 구매현황
 				-------------------------------- 단일 테이블
 				
 				=> 테이블연결 : JOIN
 					INNER JOIN -> 같은 값을 가지고 있거나 값이 포함
 								  단점 : NULL값을 처리할 수 없다
 						같은 값일 경우 : EQUI_JOIN
 							연산자  : =
 						포함된 값일 경우 : NON_EQUI_JOIN
 							연산자 : AND, BETWEEN ~ AND
 							
 						사용 방법
 						=> 오라클조인
 							SELECT A.col, B.col
 							FROM A,B
 							where A.col=B.col
 							*컬럼명이 동일할 때 반드시 식별자를 사용해야한다(테이블명 이용)
 						
 						=> ANSI 조인(표준조인)
 							SELECT A.col, B.col
 							FROM A JOIN B
 							ON A.col=B.col
 						
 					OUTER JOIN => INNER JOIN+NULL값 처리가 가능
 						LEFT OUTER JOIN
 							SELECT A.col, B.col
 							FROM A,B
 							where A.col=B.col(+)
 							
 							SELECT A.col, B.col
 							FROM A LEFT OUTER JOIN B
 							ON A.col=B.col
 						
 						RIGHT OUTER JOIN
 							SELECT A.col, B.col
 							FROM A,B
 							where A.col(+)=B.col
 							
 							SELECT A.col, B.col
 							FROM A RIGHT OUTER JOIN B
 							ON A.col=B.col
 						
 						=> 정규화 : 중복을 최대 제거 => 테이블 분리
 						 			관련 테이블 여러개가 된다
 						 			데이터를 모아서 -> 조인
 						
 				=> SQL문장 연결 : SubQuery
 					MainQuery=(SubQuery)
 								------
 								먼저실행 => 결과값 MainQuery로 전송
 					=> 네트워크 속도를 높인다(SQL문장 여러번 수행하면 속도가 느려진다)
 					
 					종류 
 					1) 단일행 서브쿼리
 						-> 서브쿼리의 결과값 컬럼 1개 결과값 1
 						WHERE절 뒤에 사용
 						-> 연산자(비교연산자, 논리연산자 주로 사용)
 					2) 다중행 서브쿼리
 						-> 서브쿼리의 결과값 컬럼 1개에 결과값 여러개
 						WHERE절 뒤에 사용
 						->IN AND ALL
 							 -------> MAX MIN
 						=> 조건의 값을 가지고 올 때 사용
 							 
 					3) 스칼라 서브쿼리
 						-> 조인대신 사용이 가능하다
 						-> SELECT 뒤에 컬럼 대신 사용
						SELECT 컬럼,(SELECT~)
						장점 : join보다 속도가 빠르다 
						단점 : SQL문장이 길어진다
						-> 소프트웨어 품질
						  | 최적화, 복잡성(가독성)
						 
					4) 인라인뷰
						-> 테이블 대신 사용
						-> 보안이 뛰어나다
						-> 페이징 기법
						   --------
						   rownum : 오라클 지원에서 지원하는 가상컬럼
						   ->row마다 번호를 지정
						   ->Top-N 인기순위, 공지에서 사용
						   -> rownum의 순서변경 => 인라인뷰(FROM에 SELECT)
						  
						SELECT 
						FROM (SELECT~~) 
						      --------- 지정된 컬럼만 사용이 가능


						    
	DML : INSERT, UPDATE, DELETE
	      INSERT INTO table_name VALUES(값,값..)
	      -> 전체 컬럼값설정 -> DEFAULT적용이 안됨
	      -> 순서확인은 DESC table_name
	      INSERT INTO table_name(컬럼,컬럼...) VALUES(값,값..)
		  -> 지정된 컬럼값만 설정 -> DEFAULT적용가능
		  
		  UPDATE table_name SET 컬럼=값, 컬럼=값..
		  [WHERE 조건]
		  
		  DELETE FROM table_name
		  [WHERE 조건]
		  
		  
	DDL : 	  
 		
 */
public class 오라클중간점검 {

}
