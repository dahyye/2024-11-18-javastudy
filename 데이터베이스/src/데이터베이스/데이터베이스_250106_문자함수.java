package 데이터베이스;

//문자함수 오라클 예제
/*
--1. 대문자변환,소문자변환,이니셜(첫글자만 대문자)
SELECT ename,UPPER(ename),LOWER(ename),INITCAP(ename)
FROM emp;

--king사원의 이름, 급여, 직위, 입사일을 출력
--저장된 데이터는 대소문자를 구분해야하는데
--데이터값이 소문자인지 대문자인지 확실히 모를 때

SELECT ename, sal, job, hiredate
FROM emp
WHERE ename=UPPER('king');

SELECT ename, sal, job, hiredate
FROM emp
WHERE LOWER(ename)='king';

--2. LENGTH 문자의 갯수(알파벳/한글 동일) :  byte가 아닌 갯수라서

--주로 사용되는 위치 => 자바/자바스크립트 ->유효성검사에서 사용
--VARCAHR2(20) 
SELECT ename,LENGTH(ename)
FROM emp;


--이름이 5글자인 사원의 목록을 출력
SELECT ename
FROM emp
WHERE LENGTH(ename)=5;

--3. REPLACER함수 사용 : 문자 대체

SELECT REPLACE('Hello java','java','oracla') FROM dual;


--URL 주소가 나오거나 POSTER를 가져올 때(크롤링) & || 를 제거
--&가 있으면 데이터를 입력받아
SELECT 'Oracle&java'
FROM dual;


--SELECT  REPLACE('Oracle&java','&','^') FROM dual;
--SELECT  REPLACE('Oracle&java','&'||'gt;','^') FROM dual;

--4. SUBSTR : 문자열을 자르는 경우
--자바는 0부터, 오라클은 1부터 시작
SELECT SUBSTR('Hello Oracle',7,6) FROM emp;

--emp테이블에서 81년에 입사한 사원의 이름, 입사일을 출력
SELECT ename, hiredate
FROM emp
WHERE SUBSTR(hiredate,1,2)=81;

--12월에 입사한 사원의 이름과 입사일 출력
SELECT ename, hiredate
FROM emp
WHERE SUBSTR(hiredate,4,2)=12;


--입사한 날짜를 출력
--25/01/06
--12345678
--뒤에서 부터 셀 때는 -1부터 시작
--  2  5 / 0  1 / 0  6
-- -8-7-6-5-4-3-2-1
SELECT ename, SUBSTR(hiredate,-2,2)
FROM emp;


--LPAD/RPAD : 지정된 글자수만큼 출력
--LPAD('Hello',10,'*');==> *****Hello
--RPAD('Hello',10,'*');==> Hello*****

CREATE TABLE member(
	id VARCHAR2(20),
	name VARCHAR2(51)
);

INSERT INTO member VALUES('hong','홍길동');
INSERT INTO member VALUES('shim','심청이');
COMMIT;

SELECT RPAD(SUBSTR(id,1,2),LENGTH(id),'*')
FROM member
WHERE name='홍길동';


SELECT ename,RPAD(SUBSTR(ename,1,2),LENGTH(ename),'*') "rpad",
LPAD (SUBSTR(ename,-1,2),LENGTH(ename),'*') "lpad"
FROM emp;

--LTRIM / RTRIM / TRIM : 좌우의 공백이나 지정된 문자열 제거
SELECT LTRIM('AAABBBCCCAAA','A'),
 RTRIM('AAABBBCCCAAA','A'), TRIM('A' FROM 'AAABBBCCCAAA')
FROM DUAL;

--CONCAT : 문자열결합 --> ||
SELECT CONCAT('Hello ','Oracle') 
FROM dual;

SELECT 'Hello '||'Oracle'
FROM dual;


--INSTR : indexof -> 문자의 위치를 찾기
--INSTR(문자열,찾는문자,시작위치,몇번째)
				  ----------> 양수 : indexOf
						 음수 : lastIndexof

 A  B  C  D
 1   2  3  4
-4 -3 -2 -1

(문자열,찾는문자,시작위치,몇번째)에서 몇번째라는건
Hello -> 'l'을 찾는 경우 어떤 'l'을 찾을 지 결정 -> 1 or 2

SELECT ename, INSTR(ename,'A',1,2)
FROM emp;	

--indexOf
SELECT INSTR('Hello Oracle','l',1,3)
FROM dual;
--lastIndexOf
SELECT INSTR('Hello Oracle','l',-1,1)
FROM dual;


SELECT ename
FROM emp
WHERE ename LIKE '__O__';

SELECT ename
FROM emp
WHERE LENGTH(ename)=5 AND INSTR(ename,'O',1,1)=3;


LENGTH(문자열|컬럼명)
SUBSTR(컬럼명,시작위치,갯수)
INSTR(컬럼명,찾는문자,시작위치,몇번째)
RPAD(컬럼명,문자출력갯수,대체문자)


*/




public class 데이터베이스_250106_문자함수 {
	
}
