package 데이터베이스;
/*
SELECT COUNT(*) "인원", SUM(sal) "급여합", ROUND(AVG(sal)) "평균급여", MAX(sal) "최대급여", MIN(sal) "최소급여"
FROM emp
WHERE deptno=10;
SELECT COUNT(*) "인원", SUM(sal) "급여합", ROUND(AVG(sal)) "평균급여", MAX(sal) "최대급여", MIN(sal) "최소급여"
FROM emp
WHERE deptno=20;
SELECT COUNT(*) "인원", SUM(sal) "급여합", ROUND(AVG(sal)) "평균급여", MAX(sal) "최대급여", MIN(sal) "최소급여"
FROM emp
WHERE deptno=30;

//이 코드를 GROUP BY를 이용해서 만들면 한 번에 출력을 할 수 있다
 
SELECT deptno,COUNT(*) "인원", SUM(sal) "급여합", ROUND(AVG(sal)) "평균급여", MAX(sal) "최대급여", MIN(sal) "최소급여"
FROM emp
GROUP BY deptno;


	GROUP BY
		GROUP : 그룹별 통계
			   -> SELECT 소속
			   -> 단일행 함수는 사용이 불가능
			   -> 집계함수를 주로 이용한다
			   -> 같은 속성(컬럼)값까리 그룹을 만들어서 통계
		
		 [
		 	WHERE => 단일행 함수 (O), 집계함수 (X) 
		 	GROUP BY => 컬럼에 같은 값이 있다단일행 함수 (X), 집계함수 (O)
		 	HAVING => 집계합수 (O)
		 	ORDER BY => 함수 / 컬럼
		 ]
		 
	159page
		
		COUNT : ROW의 갯수 => 로그인처리, 아이디중복, 검색결곽갯수, 장바구니가 비었는지..
		MAX : 자동 번호 증
		MIN : 
		SUM : 통계
		AVG : 평균
		RANK / DENSE_RANK : 순위
		
	=> 관리자페이지 -> 회원분리할 때 많이 사용하는 형태
	=> 실행 순서
		  SELECT   --- 5
		  FROM     --- 1
		  WHERE    --- 2
		  GROUP BY --- 3
		  HAVING   --- 4
		  ORDER BY --- 6
		  
		
	--직위별로 사원수, 평균급여, 급여의 총합을 출력
	SELECT job, count(*), AVG(sal),SUM(sal)
	FROM emp
	GROUP BY job;
	 
	--함수 이용방법 => 입사년도별 통계 -> 인원수, 평균, 총합
	SELECT TO_CHAR(hiredate,'yyyy'), count(*), AVG(sal), SUM(sal)
	FROM emp
	GROUP BY TO_CHAR(hiredate,'yyyy');
	
	--입사 요일별 통계
	SELECT TO_CHAR(hiredate,'DAY'), SUM(sal), AVG(sal), MAX(sal), MIN(sal), COUNT(*)
	FROM emp
	GROUP BY TO_CHAR(hiredate,'DAY');
 
 
	 --책에 나오는 테이블 
	ORDERS(구매현황)
	 ORDERID                                   NOT NULL NUMBER(2)
	 CUSTID                                             NUMBER(2)
	 BOOKID                                             NUMBER(2)
	 SALEPRICE                                          NUMBER(8)
	 ORDERDATE                                          DATE
	
	BOOK(책정보)
	BOOKID                                    NOT NULL NUMBER(2)
	 BOOKNAME                                           VARCHAR2(40)
	 PUBLISHER                                          VARCHAR2(40)
	 PRICE                                              NUMBER(8)
	
	CUSTOMER(고객정보)
	 CUSTID                                    NOT NULL NUMBER(2)
	 NAME                                               VARCHAR2(40)
	 ADDRESS                                            VARCHAR2(50)
	 PHONE                                              VARCHAR2(20)
	 
	 
   	고객       	 책
	-----		---
	  |____________|
	 	 |
	     매핑테이블 -> 3정규화 -> 구매
	 

	 --고객이 주문한 도서의 총 판매액
	
	SELECT TO_CHAR(SUM(saleprice),'L999,999,999') as 총매출
	FROM orders;
	
	--2번고객이 주문한 도서의 총 판매액
	SELECT TO_CHAR(SUM(saleprice),'L999,999,999') as 총매출
	FROM orders
	WHERE custid=2;
	
	--총 판매액, 평균, 최소, 최대, 구매인원
	SELECT TO_CHAR(SUM(saleprice),'L999,999,999') as 총판매액, ROUND(AVG(saleprice)) as 평균
		,MIN(saleprice) as 최소, MAX(saleprice) as 최대, count(*) as 구매인원
	FROM orders;
	
	--고객별
	SELECT custid, TO_CHAR(SUM(saleprice),'L999,999,999') as 총판매액, ROUND(AVG(saleprice)) as 평균
		,MIN(saleprice) as 최소, MAX(saleprice) as 최대, count(*) as 구매인원
	FROM orders
	GROUP BY custid
	ORDER BY custid;
	
	
	---------------------------------------------------------------------------------------
	
	HAVING을 이용하는 경우에는 반드시 GROUP BY를 사용해야 한다
	-> HAVING단독으로는 사용할 수 없다
	WHERE문장에서는 집합함수를 이용할 수 없다
				 -----------------> 서브쿼리
	GROUP BY -> 그룹별 -> 집계(관리자모드)
	--------------------------------
	조인 : 테이블 연결 -> 필요한 데이터 추출
	서브쿼리 : SQL 문장연결 -> 한개문장으로 통합
	------
		많이 사용되는 이유 1. 조인보다 빠르다
					  2. 자바에서 전송 -> 최대한 작은양의 SQL문장을 전송
					  
					  
	--서브쿼리사용예제

	SELECT ROUND(AVG(sal))
	FROM emp;
	--2073
	
	SELECT ename, sal
	FROM emp
	WHERE sal>2073
	
	--두개의 문장을 하나로 묶어서 전송
	SELECT ename, sal
	FROM emp
	WHERE sal>(SELECT ROUND(AVG(sal)) FROM emp);




	--HAVING 사용 => GROUP BY에서만 사용이 가능
	--부서별로 전체 급여보다 많이 받는 부서만 출력
	SELECT deptno, count(*), SUM(sal), ROUND(AVG(sal))
	FROM emp
	GROUP BY deptno
	HAVING AVG(sal)>2073
	ORDER BY deptno ASC;
	
	--부서별로 인원이 3명이상인 부서의 총합, 인원, 평균을 구해라.
	SELECT deptno, COUNT(*), SUM(sal), ROUND(AVG(sal),2)
	FROM emp
	GROUP BY deptno
	HAVING COUNT(*)>=3;
	
	--가격이 8000이상이고 2권 이상을 구매한 고객을 출력하시오
	SELECT custid, COUNT(*)
	FROM orders
	WHERE saleprice >= 8000
	GROUP BY custid
	HAVING COUNT(*)>=2;

 
 
 */
public class 데이터베이스_250107_GROUPBY {

}
