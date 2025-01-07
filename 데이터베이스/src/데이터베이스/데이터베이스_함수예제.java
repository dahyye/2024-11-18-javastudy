package 데이터베이스;
/*
 1. emp테이블에서 이름, 직업, 월급을 출력하는데
 	직업, 월급을 오름차순으로 정렬
 	
 	SELECT ename, job, sal
	FROM emp
	ORDER BY job ASC, sal ASC;
--------------------------------------------------------------------
	//ORDER BY -> 2차for문 -> 속도가 느리다
	 						-----------> 보안 (인덱스)
	 고급 과정
	 1. view : 가상 테이블(보안, SQL문장 간결)
	 2. index : 속도가 빠르다(검색, 정렬)
	 3. SEQUENCE : 자동 증가번호
	 4. PL/SQL : 함수, 프로시저, 트리거
	 ==> 이걸 하기 위해서는 테이블설계, 변경, 삭제를 할 줄 알아야해
	 					-------> 설계방법/제약조건/키종류/ERD사용법
	 						|
	 					  데이터수집 : DML(INSERT/UPDATE/DELETE)
	 					  
	 오라클의 데이터형 
	 문자형 : CHAR / VARCHAR2 / CLOB
	 숫자형 : NUMBER(38자리까지 사용가능) 예. NUMBER(8,2) 8자리를 사용하는데 2자리는 실수가능
	 날짜형 : DATE / TIMESTAMP
	  				
 -------------------------------------------------------------------										
 2. 직업이 SALESMAN인 사원들의 이름과 연봉을 출력하는데 
 	연봉이 높은 사원부터 출력하고 아래과 같이 결과를 출력하시오.
	"ALLEN 의 연봉은 36000 입니다."

	SELECT ename||'의 연봉은 '||(sal*12)||' 입니다'
	FROM emp
	ORDER BY (sal*12) DESC; 
 
 -------------------------------------------------------------------
 	오라클에서 지원하는 함수
 		단일행 함수 : ROW -> 한 줄씩 처리
 			문자함수
 				length(문자열|컬럼명) -> 문자의 갯수(한글포함)
 				SUBSTR(문자열|컬럼명,시작번호,자르는갯수)
 				INSTR(문자열|컬럼명,찾는문자,시작번호,몇번째)
 				RPAD(문자열,길이,대체문자)
 				
 			숫자함수
 				CEIL -> 올림 -> 소수점이 1이상이면 -> 올린다
 					CEIL(4.1)-> 5
 				ROUND -> 반올림 -> 소수점이 5이상이면 -> 올린다
 					평균구할 때 사용
 					ROUND(200.4567,2) -> 200.46
 				TRUNC -> 버림 -> 소수점은 상관없다
 					TRUNC(10.23453,2) -> 10.23 -> 퇴직금, 날짜를 가져올 때 사용 
 			날짜함수
 				SYSDATE : 시스템 날짜 / 시간 -> 많이 사용
 				MONTHS_BETWEEN(현재, 과거) : 기간의 개월수 가지고 온다
 				ADD_MONTHS : 날짜+개월 -> 지정된 날짜 출력
 				
 			변환함수
 				TO_CHAR : 문자열 변환
 					날짜변환 
 						YYYY/RRRR
 						MM
 						DD/HH
 						MI
 						SS
 						DY
 					숫자변환
 						'$999,999' 'L999,999'
 						
 				TO_DATE : 날짜형으로 변환 -> 예약/체크인
 			
 			기타함수
 			 	NVL() -> NULL값을 대체
 			 
 		집계함수(집합함수) : Column단위 -> 통계
 				SUM
 				AVG
 				MIN
 				MAX
 
 
 3. 이름은 대문자로 직업은 소문자로, 이름의 첫글자를 대문자 나머지는 소문자로 출력하시오.

 	SELECT UPPER(ename), LOWER(job),INITCAP(ename)
	FROM emp;
	
	//UPPER -> 데이터각 대소문자 구분

 4. 이름이 scott인 사원의 이름과 월급을 출력하는데 where절에 scott의 소문자로 검색해서 출력하시오.

	SELECT ename, sal
	FROM emp
	WHERE ename=UPPER('scott');
 
 5. 이름을 출력하는데 이름앞부터3자리만 출력하시오(순서는 입사번호순)
 
 	 SELECT ename, SUBSTR(ename,1,3) "SUBSTR"
	FROM emp
	ORDER BY empno ASC;

 6. 이름의 첫번째 철자만 출력하는데 소문자로 출력되게 하시오

	SELECT LOWER(SUBSTR(ename,1,1)) "SUBSTR"
	FROM emp;

 7. UPPER, LOWER, SUBSTR, ||를 사용해서 이름을 출력해라
 	
 	SELECT UPPER(SUBSTR(ename,1,1))||LOWER(SUBSTR(ename,2,LENGTH(ename)-1)
	FROM emp
	ORDER BY empno ASC;

 8. 이름에 M자를 포함하고있는 사원들의 이름과 월급을 출력하시오.

	SELECT ename, sal
	FROM emp
	WHERE ename LIKE '%M%';
	
 	----권장
	SELECT ename, sal
	FROM emp
	WHERE REGEXP_LIKE(ENAME,'M');   '^M'->'M%'  'M$'->'%M' 
									 시작			 끝
	-----------------------------------------------> 크롤링할 때 사용
 
 9. 이름에 EN 또는 IN을 포함하고 있는 사원들의 이름과 입사일을 출력하는데 최근에 입사한 순서로 출력하시오
	
	SELECT ename. hiredate
	FROM emp
	WHERE ename LIKE '%IN%' OR ename LIKE '%EN%'
	ORDER BY hiredate DESC;
	
	--정규식
	SELECT ename. hiredate
	FROM emp
	WHERE REGEXP_LIKE (ename, 'IN|EN')
	ORDER BY hiredate DESC;
	
 
 10. 직업이 SALESMAN인 사원들의 사원 이름과 직업과 월급을 출력하는데 월급이 높은 사원부터 출력하시오
 
 
	SELECT ename, job, sal
	FROM emp
	WHERE job='SALESMAN'
	ORDER BY sal DESC;

 
 11. 이름의 첫글자가 A로 시작하는 사원들의 이름과 월급과 직업을 출력하시오. 
 
	SELECT ename, job
	FROM emp
	WHERE SUBSTR(ename,1,1)='A'
	
	--정규식
	SELECT ename, job
	FROM emp
	WHERE REGEXP_LIKE(ename,'^A');
 
 12. 월급이 1000에서 3000 사이인 사원들의 이름과 월급과 입사일을 출력하는데, 입사일을 먼저 입사한 사원부터 출력되게 하시오.

	SELECT ename, sal, hiredate
	FROM emp
	WHERE sal BETWEEN 1000 AND 3000
	ORDER BY hiredate ASC;

 
 13. 1981년도에 입사한 사원들의 이름과 입사일을 출력하시오
 
	SELECT ename, hiredate
	FROM emp
	WHERE hiredate LIKE '81%'
	
	SELECT ename, hiredate
	FROM emp
	WHERE hiredate BETWEEN '81/01/01' AND '81/12/31'
	
	SELECT ename, hiredate
	FROM emp
	WHERE SUBSTR(hiredate,1,2)=81
	
	SELECT ename, hiredate
	FROM emp
	WHERE TO_CHAR(hiredate,'yy')=81
 
 14. 이름에 M자를 포함하고 있는 사원들의 이름을 출력하시오. 
 
	SELECT ename
	FROM emp
	WHERE ename LIKE '%M%';

 
 15. instr 함수를 이용해서 이름에 A자를 포함하고 있는 사원들의 이름을 출력하시오. 
 
	SELECT ename
	FROM emp
	WHERE (INSTR(ename,'A',1))!=0;

 16.아래의 데이터를 EMP 테이블에 입력하고, 이름이 JACK인 사원의 이름과 월급을 출력하시오.
	
	insert into emp(empno, ename, sal) values(1238, 'JACK', 4000);
	COMMIT;
	SELECT ename, sal
	FROM emp
	WHERE ename='JACK'; 

 
 17. 이름과 월급을 출력하는데 월급을 전체 10자리로 출력하고 나머지 자리는 *로 출력하시오! 
 
	SELECT ename, RPAD(sal,10,'*')
	FROM emp;

 
 18. 이름과 월급을 출력하는데 월급을 전체 10자리로 출력하고 나머지 자리는 공백으로 출력하시오. 
 
	SELECT ename, RPAD(sal,10,' ') // ''은 NULL값이기 때문에 한 칸 꼭 띄우기
	FROM emp;

 
 19. length 함수를 이용해서 이름과 이름의 철자의 갯수를 출력하시오. 
 
	SELECT ename, LENGTH(ename)
	FROM emp;

 
 20. 이름, 입사한 날짜부터 오늘까지 총 몇일 근무했는지 소수점 뒤에는 잘라서 출력하시오.
 
	SELECT ename, ROUND(SYSDATE-hiredate) "근무일수"
	FROM emp;

 
 21. 이름, 입사한 날짜부터 오늘까지 총 몇달 근무했는지 소수점 뒤에는 잘라서 출력하시오.

	SELECT ename, ROUND((SYSDATE-hiredate)/30)
	FROM emp;

	날짜+날짜 = 날짜
	날짜-숫자 = 날짜
	날짜-날짜 = 숫자
 
 22. 오늘부터 100달 뒤의 날짜를 출력하시오.
 
	SELECT ADD_MONTHS(SYSDATE,100)
	FROM DUAL;
	
 23. 오늘부터 앞으로 돌아올 월요일의 날짜를 출력하시오. 

	SELECT NEXT_DAY(SYSDATE, '월')
	FROM DUAL;
	
 24. 오늘부터 100달뒤 돌아올 금요일의 날짜를 출력하시오. 

	SELECT NEXT_DAY(ADD_MONTHS(SYSDATE,100), '금')
	FROM DUAL;


 25. 이번달 말일의 날짜를 출력하시오. 

 	SELECT LAST_DAY(SYSDATE)
	FROM DUAL;

 26. 오늘부터 요번달 말일까지 총 몇일남았는지 출력하시오! 

	SELECT LAST_DAY(SYSDATE)-SYSDATE
	FROM DUAL;
 
 27. 오늘이 무슨 요일인지 출력하시오 
 	//'DY'는 화 'DAY'는 화요일
	SELECT TO_CHAR(SYSDATE,'DY')
	FROM dual
 
 28. 이름, 입사한 요일을 출력하시오. 
 	SELECT ename, TO_CHAR(hiredate,'DY')
 	FROM dual
 
 29. 오늘부터 200달 뒤에 돌아오는 날짜의 요일을 출력 
 
	SELECT TO_CHAR(ADD_MONTHS(SYSDATE,200),'DY')
	FROM DUAL; 

 
 30. 이름과 입사한 년도를 출력하시오.
 
	SELECT ename, TO_CHAR(hiredate,'YYYY')
	FROM emp

 
 31. 1981년도에 입사한 사원들의 이름과 입사일을 출력하시오.
 
	SELECT ename, TO_CHAR(hiredate,'YYYY/MM/DD DY')
	FROM emp
	WHERE hiredate LIKE '81%';

 32. 목요일에 입사한 사원들의 이름과 입사일, 입사한 요일을 출력하시오.
 
	SELECT ename, TO_CHAR(hiredate,'YYYY/MM/DD DY')
	FROM emp


 33. 81년 12월 11일에 입사한 사원의 이름과 입사일을 출력하시오.
 
	SELECT ename, hiredate
	FROM emp
	WHERE hiredate='81/12/11'

 
 34. 이름과 월급을 출력하는데 월급에 천단위를 부여하시오! (예: 3000 -> 3,000)
 
	SELECT ename, TO_CHAR(sal,'9,999')
	FROM emp;

 
 35. 이름과 월급 * 5400을 출력하는데, 천단위와백만단위를 출력하시오. 
 
	SELECT empno, ename, TO_CHAR(sal*5400, 'L99,999,999') FROM emp;
 
 36. 이름과 커미션을 출력하는데 커미션이 null인 사원들은 0으로 출력하시오.
 
	SELECT ename, NVL(comm,0)
	FROM emp;

 
 
 
 
 
 */
public class 데이터베이스_함수예제 {

}
