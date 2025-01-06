package 데이터베이스;
/*

기타함수 NVL, DECODE, CASE

NVL : null값을 다른 값으로 대체
	NVL(컬럼명, 대체값)
	       -------
		컬럼이 null인 경우에만 대체
		*컬럼의 데이터형과 대체하는값이 동일

	NVL(100,'no comm') => 오류 => 데이터형이 다르다
	=> NVL(TO_CHAR(100),'NO COMM')
		=> 연산처리 : null값이 있는 경우에는 연산처리 결과 -> null(출력이 안된다)
			*null : 값이 없는 상태

	오라클 데이터형
	문자형
	  CHAR(1~2000byte) -> 고정바이트
	  CHAR(10) -> 'A' -> 10byte
	  => 글자수가 동일한 경우 : 남자/여자, y/n
	  
	  VARCHAR2(1~4000byte) -> 가변바이트
	  VARCHAR2(100) -> 'A' -> 1byte
	  CLOB -> 4기가(줄거리, 자소서..) -> 가변
	-----------------------------------------------------String 매칭
	숫자형
	  NUMBER -> NUMBER(8) -> int
			-> NUMBER(7,2) -> 숫자 7개 사용, 2자리는 소수점가능 -> int, double
				=> 소수점을 꼭 써야하는 건 아님
	날짜형
	  DATE
	  TIMESTAMP : 기록경주 -> DATE를 확장
 	--------------------------------------------------------java.util.Date
	기타형 : 이미지 / 사진 / 동영상 
	  BFILE : 파일형태
	  BLOB : 바이너리형태 
	  	=> 증명사진, 주민등록번호
	--------------------------------------------------------java.io.InpunStream
	  ==> DESC table명으로 테이블의 데이터형 확인 가능


SELECT ename, sal, comm,sal+comm
FROM emp;

--null값이 있으면 0으로 바꿔라
SELECT ename, sal, comm,sal+NVL(comm,0)
FROM emp;

--수치가 부적합합니다 => 데이터형이 안맞는다
SELECT ename, sal, NVL(comm,'NO COMM')
FROM emp;

SELECT ename, sal, NVL(TO_CHAR(comm),'NO COMM')
FROM emp;

CREATE TABLE test( no NUMBER PRIMARY KEY, name VARCHAR2(100)
);
	
INSERT INTO test VALUES((SELECT NVL(MAX(no)+1,1) FROM test),'홍길동');
--null인 경우에는 -> 브라우저에서 null출력 => 우편번호

==> 통계(관리자페이지, 마이페이지)
DECODE : 다중 조건문(=switch~case)
	DECODE(deptno,10,'영업부',
				20,'개발부',
				30,'기획부',
				40,'자재부')
	DECODE(star, 1, '★',
			2, '★★',
			3, '★★★')

SELECT ename, job, deptno,DECODE(deptno,10,'영업부',
				20,'기획부',
				30,'총무부'),dname
FROM emp;


--case다중조건문
SELECT ename, job, deptno, CASE WHEN deptno=10 THEN '개발부'
						WHEN deptno=20 THEN '영업부'
						WHEN deptno=30 THEN '기획부'
						END "dname"
FROM emp;


*/
 

public class 데이터베이스_250106_기타함수 {

}
