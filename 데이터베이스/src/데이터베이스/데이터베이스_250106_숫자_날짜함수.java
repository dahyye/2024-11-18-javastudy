package 데이터베이스;
/*
--숫자함수 / 날짜함수
숫자함수
	MOD(숫자, 숫자) -> MOD(10,3) -> 10%3 -> 1
	CEIL(실수) -> 올림함수 -> 소수점이 1이상이면 올림 => 총페이지 구할 때 사용
	ROUND(실수, 자리수) -> 반올림 -> ROUND(10.567,2) -> 10.57
	TRUNC(실수, 출력자리수) -> 버림 ->  TRUNC(10.567,2)=> 10.56


SELECT MOD(10,3) FROM dual;
--emp에서 사번이 짝수인 사원의 이름과, 사번, 직위 출력

SELECT ename, empno, job
FROM emp
WHERE MOD(empno,2)=0
ORDER BY empno ASC;


--COUNT(*) 총 갯수
--총페이지를 구할 때 사용
SELECT CEIL(COUNT(*)/5) FROM emp; 

--ROUND 반올림 TRUNC 버림
SELECT ROUND(10.5678,2),
	TRUNC(10.5678,2)
FROM DUAL;

날짜함수
	SYSDATE : 시스템의 날짜 / 시간을 읽어온다
	=> +/- 가 가능하다
	MONTHS_BETWEEN(현재,과거) : 기간의 개월수 -> 퇴직금 계산, 1년지나면 자동해제 등에서 사용
	

--오늘날짜출력 -> 게시판, 예약, 회원가입일, 로그인한 날 등에서 사용
SELECT SYSDATE FROM DUAL;
SELECT SYSDATE-1 "어제",SYSDATE "오늘" ,SYSDATE+1 "내일" FROM DUAL;

--입사한날짜부터 지금까지의 년수 구하기
SELECT empno, ename, hiredate, ROUND(ROUND(MONTHS_BETWEEN(SYSDATE,hiredate)/12)) "년수"
FROM emp;
	
--ADD_MONTHS : 개월을 지정 => 지정된 날짜 출력
SELECT SYSDATE, ADD_MONTHS(SYSDATE,6) FROM DUAL;
--7개월후인데 28,30,31을 계산하지 않고 달 수만 변함
SELECT '24/11/18', ADD_MONTHS('24/11/18',7) FROM DUAL;
--LAST_DAY : 마지막날짜 출력
SELECT SYSDATE,LAST_DAY(SYSDATE) FROM DUAL;
SELECT LAST_DAY('25/02/02') FROM DUAL;
SELECT LAST_DAY('20/02/02') FROM DUAL;

--NEXT_DAY : 지정된 날짜 확인 -> 해당 요일이 돌아오는 날짜를 반환
SELECT NEXT_DAY(SYSDATE,'월') FROM DUAL;
*/


/*
 

1. TO_CHAR : 날짜, 숫자를 문자열로 변환 -> 댓글에서 많이 사용
   ------------SimpleDateFormat / DecimalFormat
	날짜변환
			(소문자도 가능)
		년도 : YYYY / YY  		RRRR도 가능 
		월 : MM / M 
		일 : DD / D	 
		시간 : HH / HH24
		분 : MI
		초 : SS
		요일 : dy
	숫자변환
		1,000 -> 자바(###,###) -> 999,999
		$999,999 (달러)
		L999,999 (원)

2. TO_NUMBER : 문자열을 숫자 변환
   ---------------Integer.parseInt(), Double.parseDouble()
3. TO_DATE : 문자열을 데이터형으로 변환
   ---------- new Date(문자열)	

--25/01/06 2025/01/06 12:35:44 월
SELECT SYSDATE, TO_CHAR(SYSDATE,'YYYY/MM/DD HH24:MI:SS DY')
FROM DUAL;

--emp에서 사원의 입사일과 요일 출력
SELECT ename, hiredate, TO_CHAR(hiredate,'RRRR/MM/DD DY')
FROM emp;

SELECT ename, TO_CHAR(hiredate, 'YYYY"년도" MM"월" DD"일"') FROM emp;

SELECT empno, ename, TO_CHAR(sal, '$999,999') FROM emp;
SELECT empno, ename, TO_CHAR(sal, 'L999,999') FROM emp;

SELECT '100'+'200' FROM DUAL;
--이렇게 사용하면 속도가 느려짐
SELECT TO_NUMBER('100')+TO_NUMBER('200') FROM DUAL;
--큰 프로그램에서는 이렇게 사용하는게 속도가 훨씬 빠르다
--보통Integer.parseInt("100")으로 자바에서 처리하는 방식이 많이 사용됨

--자바에서는 문자열 / 오라클에서는 날짜형
--문자열->날짜형으로 변환
SELECT TO_DATE(SYSDATE,'YYYY-MM-DD')-5, TO_DATE(SYSDATE,'YYYY-MM-DD')+5
FROM DUAL;

SELECT TO_DATE('25/01/05','YYYY-MM-DD'), TO_DATE('25/01/10','YYYY-MM-DD') 
FROM DUAL;

================================================================================

	교재정리
	209page 내장함수(리턴형이 있는 메소드)
		
		단일행 
		=> 문자 :	 LENGTH / SUBSTR / INSTR / RPAD  -> String 
		=> 숫자 : CEIL / ROUND / TRUNC -> Math 
		=> 날짜 : SYSDATE / MONTHS_BETWEEN -> DATE, Calendar
		=> 변환 : TO_CHAR / TO_DATE -> SimpleDateFormat / DecimalFormat
		=> 기타 : NVL -> 자바에서는 null값을 제어할 수 없기 떄문에 매우 중요한 함수
		
		-----------------------------------------------
		0. table/column
			-> 구분자(멤버변수)
		=> 데이터 저장공간(파일)
		
		1. SELECT 형식/순서
		2. WHERE -> 조건문(연산자)
		3. 필요시에 컬럼 처리 -> 내장함수
		4. GROPU BY / ORDER BY / JOIN / SUBQUERY
		-----------------------------------------------
		DDL : 테이블 제작방법 -> 제약, 조건, 정규화
		DML : 데이터첨뷰
		TCL : 정상수행, 취소
		DCL : 권한
		
	
===================================================================================
	159page
	집계함수
		Column 단위
		SUM : 합
		AVG : 평균
		MIN : 최소
		MAX : 최대
		COUNT : 저장갯수
			COUNT(*) -> NULL값을 포함
			COUNT(column) -> NULL값을 제외
			-> 로그인처리, 아이디 중복체크, 검색건수, 장바구니 여부 에서 많이 사용
			
		=> 단일행 함수와 동반하지 못한다 (같이 사용 불가)
			=> GROUP BY를 사용하면 사용 가능
		=> 컬럼명과 동반하지 못한다
		=> 집계함수만 사용이 가능
		SELECT ename, SUM(sal),AVG(sal) ==> 사용불가
		SELECT TO_CHAR(hiredate,'YYYY-MM-DD'), SUM(),MAX() ... -> 사용불가
		
		GROUP BY 없으면 사용불가
		
		RANK : 순위결정
		RANK(), DENSE_RANK() => 집합함수는 아니다 => 컬럼,단일행함수와 사용이 가능
			RANK() => 1,2,2,4
			DENSE_RANK => 1,2,2,3
			
--사원의 급여 총액, 사원의 급여 평균, 사원수 ,가장 많은 급여, 가장 적은 급여 출력
SELECT SUM(sal), ROUND(AVG(sal)), COUNT(*), MAX(sal), MIN(sal)
FROM emp;


--RANK => 인기순, 찜이 많은순, 좋아요 순, 예매율, 방문수 등등..
SELECT ename, sal, RANK() OVER(ORDER BY sal DESC) rank
FROM emp;

SELECT ename, sal, DENSE_RANK() OVER(ORDER BY sal DESC) rank
FROM emp;
			
=========================================================================

**응용**

DROP TABLE member;
CREATE TABLE member(
	id VARCHAR2(20),
	pwd VARCHAR2(10),
	name VARCHAR2(51),
	sex VARCHAR2(6),
	address VARCHAR2(100)
);
INSERT INTO member VALUES('hong','1234','홍길동','남자','서울');
INSERT INTO member VALUES('shim','1234','심청이','여자','서울');
COMMIT;
		
		
 
 */

public class 데이터베이스_250106_숫자_날짜함수 {

}
