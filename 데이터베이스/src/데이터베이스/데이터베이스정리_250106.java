package 데이터베이스;
/*
 
 	데이터 검색 : SELECT => 웹(50%) -> INSERT / UPDATE / DELETE(20%) -> DDL(테이블설계) 30%
 	
 
 	컬럼명이 길거나 알 수 없는 경우 => 별칭사용
 		컬럼명 "별칭" , 컬럼명 as 별칭
 	중복없는 데이터 : DISTIMCT 컬럼명
 	문자열 결합 => ||
 	
 	=> WHERE 문장 처리 -> 연산자
 		산술연산자 : + - * /
 		 	==> 순수하게 산술만 처리(/=> 정수/정수=실수)
 		 **오라클에서 지원하지 않는 부분 -> row단위 통계(x)
 		  -> CUBE / ROLLUP => GROUP BY를 이용한다
 		 
 		비교연산자 : = , <>(!=, ^=), <, >, <=, >=
 		논리연산자 : AND, OR
 				  IN
 				  BETWEEN ~AND
 		
 		OR가 여러개인 경우 : IN 사용
 		WHERE DEPTNO=10 OR DEPTNO=20 OR DEPTNO=30
 		-> WHERE DEPTNO IN (10,20,30)
 		기간, 범위 : BETWEEN~AND
 		WHERE page>=1 AND page<=10
 		=> WHERE page BETWEEN 1 AND 10
 		NULL연산자 -> NULL은 값이 없는 상태 -> 연산처리가 안된다
 			(IS NULL, IS NOT NULL, NVL() NULL값을 변경해서 사용)
 		
 		부정연산자 : NOT
 		LIKE : 검색할 때
 			% : 문자의 길이를 모를 때
 			_ : 문자1개
 			=> startsWith => 'java%'
 			=> endsWith => '%java'
 			=> contains => '%java%'
 			**오라클에 저장된 데이터는 대소문자를 구분한다
 	
 	---------------------------------------------------------------------
 	상세보기 : =
 		맛집, 영화, 장바구니, 상품 ...
 	검색 : LIKE '%검색어%'
 		맛집-> 지역, 이름, 음식
 	목록 : WHERE page BETWEEN 1 AND 10
 	
 	---------------------------------------------------------------------
 	
 	내장함수
 		단일행함수 : row ( 한 줄씩 처리 )
 			문자 관련 함수
 				LENGTH(문자열|컬럼명) : 문자갯수
 				SUBSTR(문자열|컬럼명, 시작번호, 갯수) : 문자를 자를 때
 					앞에서 부터 자를 땐 1번부터 시작, 뒤에서부터 자를 땐 -1부터 시작
 				INSTR(문자열|컬럼명, 찾는문자, 시작번호, 몇번째) : 특정문자위치찾기
 				PRAD(문자열, 출력갯수, 문자지정) : 아이디찾기 EX. AS****
 				
 			숫자 관련 함수
 				CEIL(실수) : 올림함수 
 				ROUND(실수, 자리수) : 반올림
 					ROUND(10.2345,2) -> 10.23
 				TRUNC(실수, 자리수) : 버림
 					TRUNC(10.4567,2) -> 10.45
 				
 			날짜 관련 함수
 				SYSDATE : 시스템의 날짜, 시간
 				MONTHS_BETWEEN : 기간 사이의 개월을 가지고 온다
 				
 			변환 함수
 				TO_CHAR : 문자열 변환
 					=날짜 (대소분자 상관없음)
 					yyyy/rrrr
 					mm/MM
 					dd/DD
 					HH/HH24
 					MI (분)
 					SS (초)
 					DY (요일)
 					
 					=숫자
 					달러 '$999,999', 원 'L999,999'
 						
 				TO_DATE : 날짜 변환
 					자바에서 문자열을 보내면 => DATE형으로 변경
 			기타함수
 				NVL : null값을 대체해서 사용
 					
 		
 		집계합수 : colum -> 컬럼 1개에 대한 통계
 			AVG : 평균
 			SUM : 합
 			MAX : 최대 -> 자동증가번호 만들 떄 사용
 			MIN : 최소
 			COUNT : ROW의 갯수 -> 저장된 갯수
 			
	==============================================================================
		--가지고 있는 테이블전체 확인
	 	SELECT * 
		FROM tab;
		
		--테이블정보확인
		SELECT * 
		FROM user_tables 
		WHERE table_name='table명';
		//오라클에 저장되는 테이블명,컬럼명은 무조건 대문자로 저장된다
		
		--컬럼확인
		DESC table명;
 	
 		--가상컬럼
 		SELECT ename, sal, rownum
		FROM emp;
		//rownum이라는 컬럼이 생성되고 1부터 차례대로  순서가 정해진다


		SELECT ename, sal, rownum
		FROM emp
		WHERE rownum<=5
		ORDER BY sal DESC; 
		//문장 실행 순서가 where이 더 빠르기 때문에 
		//내림차순 정렬해서 가져올 수 없다
		
		==> 순서를 바꿔줘야함
		SELECT ename, sal, rownum
		FROM (SELECT ename,sal FROM emp ORDER BY sal DESC)
		WHERE rownum<=5
		
		
		

	==============================================================================
 	
 	
 	
 	
 */

public class 데이터베이스정리_250106 {

}
