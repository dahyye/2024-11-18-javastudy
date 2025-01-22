/*
 
 --5장 PL/SQL ( 데이터베이스 관리자 )
	
	데이터베이스 : CRUD -> SELECT / INSERT / UPDATE / DELETE
	 => 자바 / 오라클 => 흐름 파악( 모방 - >약간 수정 )
	-------------------------------------------------------------
	 => 1 Part : 공통으로 들어가는 댓글 ( 맛집 + 여행 ) 
							   ---------------- 캠핑장예약 + 레시피
								영화+OST -> 캡처본
	PL/SQL => 270page
	--------- 장점 : 보안, 재사용(함수)
		    단점 : 웹개발자가 이해하기 어렵다(가독성이 떨어진다)
			=> SQL -> SELECT name, pwd, email
			=> getData() => SQL문장이 보이지 않는다
			=> 메뉴얼 -> 오버라이딩(소스를 알고 있다)
	
	=> Procedural Language: 함수를 만드는 언어
	=> 비절차적 언어 : 함수이해 => 결과값
	     ---------------- FUNCTION -> 내장함수/사용자정의함수 : 리턴형
				=> SELECT에서만 사용이 가능 / WHERE 문장
				 PROCEDURE => 기능을 만든다 / 리턴형이 없다
	 			=> SELECT / INSERT / UPDATE / DELETE가 가능
				 TRIGGER => 연쇄반응
						    자동화 처리 ( 자바에서는 호출이 안된다)
						    데이터베이스는 변경
						    좋아요 클릭시 자동으로 맛집에 좋아요 증가
	=> PL/SQL 문법
	 1. 변수선언
	  DECLARE 
	  	변수가 선언 -> C언어 형식
	  BEGIN{ 
	  	SQL 문장 제어
	  	예외처리가 가능 => 메소드영역 {}는 사용하지 않는다
	  END;}
	  
	 2. 기능수행
	 	변수 : 변경할 수 있는 한 개의 데이터를 저장하는 공간
	 	---
	 	  1) 스칼라변수
	 	  	no NYMBER
	 	  	name VARCHAR2
	 	  	today DATE
	 	  2) %TYPE : 실제 테이블 컬럼의 데이터형을 사용
	 	  	empno emp.empno%TYPE
	 	  	      --- ---------
	 	  	      테이블명.컬럼의 데이터형을 읽어와라
	 	  3) %ROWTYPE : 실제 테이블의 전체 컬럼 데이터를 모아서 가지고 온다
	 	  	emp emp%ROWTYPE
	 	  		-----------> empno, ename, job.... => VO
	 	  4) RECORD : 사용자 정의 데이터형(테이블 여러개 연동)
	 	  	TYPE 변수명 IS RECORD(
	 	  		empno NUMBER
	 	  		empname VARCHAR2(10),
	 	  		dname VARCHAR2(10),
	 	  		loc VARCHAR2(10),
	 	  	)
	 	  	---------------------------> ROW 한개만 제어
	 	  5) CURSOR : ROW여러개를 모아서 처리가 가능 -> LIST
 			 ------FOR문
 
 ----------------------------------------------------------------------------------
 
 	1. 출력 
 		SET SERVEROUTPUT ON -> import 
 		DBMS_OUTPUT.PUT_LINE(출력데이터) -> System.out.println()
 		
 		
 		SET SERVEROUTPUT ON;
		DECLARE 
		---변수설정-> 초기화(:=) 
		 name VARCHAR2(50):='홍길동';
		BEGIN
		--SQL => 데이터읽기, 출력
		DBMS_OUTPUT.PUT_LINE('이름:'||name);
		END;
 		/

		DECLARE 
		  pEmpno NUMBER(4);
		  pEname VARCHAR2(20); -- 오라클 일반변수:스칼라변수
		  pJob VARCHAR2(20);
		  pHiredate DATE;
		  pSal NUMBER(7,2);
		BEGIN
		  SELECT empno, ename,job,hiredate,sal INTO pEmpno, pEname, pJob, pHiredate, pSal
		  FROM emp
		  WHERE empno=7788;
		  
		  DBMS_OUTPUT.PUT_LINE('사번:'||pEmpno);
		  DBMS_OUTPUT.PUT_LINE('이름:'||pEname);
		  DBMS_OUTPUT.PUT_LINE('직위:'||pJob);
		  DBMS_OUTPUT.PUT_LINE('입사일:'||pHiredate);
		  DBMS_OUTPUT.PUT_LINE('급여:'||pSal);
		
		END;
		/
		-- 테이블에서 데이터타입을 매번 확인하긴 어려워 -> %TYPE사용
		-- 가장 많이 사용되는 데이터형
		DECLARE 
		  pEmpno emp.empno%TYPE;
		  pEname emp.ename%TYPE;
		  pJob emp.job%TYPE;
		  pHiredate emp.hiredate%TYPE;
		  pSal emp.sal%TYPE;
		  
		BEGIN
		  SELECT empno, ename,job,hiredate,sal INTO pEmpno, pEname, pJob, pHiredate, pSal
		  FROM emp
		  WHERE empno=7788;
		  
		  DBMS_OUTPUT.PUT_LINE('사번:'||pEmpno);
		  DBMS_OUTPUT.PUT_LINE('이름:'||pEname);
		  DBMS_OUTPUT.PUT_LINE('직위:'||pJob);
		  DBMS_OUTPUT.PUT_LINE('입사일:'||pHiredate);
		  DBMS_OUTPUT.PUT_LINE('급여:'||pSal);
		 
		END;
		/

		  
		--모든 컬럼의 데이터형을 한 번에 처리 ( 모든 컬럼의 데이터형 읽기 ) : %ROWTYPE
		--테이블명%ROWTYPE -> 한 개의 테이블만 연동
		
		DECLARE 
		  pEmp emp%ROWTYPE;
		
		BEGIN
		  SELECT * INTO pEmp
		  FROM emp
		  WHERE empno=7788;
		  DBMS_OUTPUT.PUT_LINE('--------결과값--------');
		  DBMS_OUTPUT.PUT_LINE('사번:'||pEmp.empno);
		  DBMS_OUTPUT.PUT_LINE('이름:'||pEmp.ename);
		  DBMS_OUTPUT.PUT_LINE('직위:'||pEmp.job);
		  DBMS_OUTPUT.PUT_LINE('사수:'||pEmp.mgr);
		  DBMS_OUTPUT.PUT_LINE('입사일:'||pEmp.hiredate);
		  DBMS_OUTPUT.PUT_LINE('급여:'||pEmp.sal);
		  DBMS_OUTPUT.PUT_LINE('성과금:'||pEmp.comm);
		  DBMS_OUTPUT.PUT_LINE('부서:'||pEmp.deptno);
		  END;
		/
		  
	
		  
	--Front-End(HTML/CSS)에는 사용자정의가 없다
	--JavaScript : java와유사
	
	//회사추천 : 사이버다임, 클라우드웍스, 닥터웍스 
	
	조인/서브쿼리 -> 테이블 여러개 사용 -> 스칼라변수, %TYPE
	%ROWPTYE -> 한 개의 테이블만 연결 (x)-> 사용자 정의 데이터형 RECORD
	함수,프로지서,트리거 -> 스칼라변수, %TYPE, CURSOR
	PL -> 문법 -> 함수/프로시저/트리거 => jsp프로젝트
	
	
	
	사용자 정의 데이터형 RECORD
	조인 : 여러개 테이블을 연결해서 필요한 데이터 추출
	      ---------- 원자값, 중복제거, 매핑테이블
	      							------> 사용자 == 예약 == 영화
	      										 == 구매 == 상품
	      										     |
	      										     매핑테이블 : 관련없는 두 테이블을 연결시켜준다
	     
 	INNER JOIN : 교집합
 	  EQUI_JOIN ==> 같은 값을 가지고 있는 경우(=)
 	  	WHERE emp.deptno=dept.deptno
 	  NON_EQUI_JOIN ==> 포함된 값을 가지고 온다 (AND, BETWEEN)
 	  	WHERE sal BETWEEN losal AND hisal
 	  	
 	  *** 테이블과 테이블 연경
 	      ----   ----
 	       |_______|
 	         같은 컬럼명일 경우에는 구분
 	          => 테이블명.컬럼명 
 	          => FROM emp e, dept d -> 별칭을 만들명
 	          => 별칭명.컬럼명
 	  
 	  => 단점 : null 값이 있는 경우 처리를 못한다
 	  	 --------------------------------- 보완 : Outer JOIN
 	  => 관리자 페이지에서 주로 사용
 	  	 OUTER JOIN : INNER JOIN+null
 	  	   =LEFT OUTER JOIN
 	  	   	(oracle)
 	  	   	WHERE emp.deptno=dept.deptno(+)
 	  	    (ansi)
 	  	    FROM emp LETF OUTER JOIN dept
 	  	    ON emp.deptno=dept.deptno
 	  	    
 	  	   =RIGHT OUTER JOIN
 	  	    (oracle)
 		    WHERE emp.deptno(+)=dept.deptno
 		    (ansi)
 		    FROM emp RIGHT OUTER JOIN dept
 	  	    ON emp.deptno=dept.deptno
 		


		
		--데이터형을 만들어서 처리
		DECLARE 
		  TYPE empDept IS RECORD(
		    pEmpno emp.empno%TYPE,
		    pEname emp.ename%TYPE,
		    pJob emp.job%TYPE,
		    pDay emp.hiredate%TYPE,
		    pSal emp.sal%TYPE,
		    pDname dept.dname%TYPE,
		    pLoc dept.loc%TYPE,
		    pGrade salgrade.grade%TYPE,
		    pRank NUMBER
		);
		
		--RECORD변수 선언
		ed empDept;
		
		BEGIN
		  SELECT empno, ename, job, hiredate, sal, dname, loc, grade, RANK() OVER(ORDER BY sal DESC)
		   	     INTO ed
		  FROM emp,dept,salgrade
		  WHERE emp.deptno=dept.deptno AND sal BETWEEN losal AND hisal AND empno=&sabun;
		 --(&)는 스캐너역할
		 --RANK() OVER(ORDER BY sal DESC) 는 집계합수(여러명 출력시)
		 
		
		  DBMS_OUTPUT.PUT_LINE('--------결과값--------');
		  DBMS_OUTPUT.PUT_LINE('사번:'||ed.pEmpno);
		  DBMS_OUTPUT.PUT_LINE('이름:'||ed.pEname);
		  DBMS_OUTPUT.PUT_LINE('직위:'||ed.pJob);
		  DBMS_OUTPUT.PUT_LINE('입사일:'||ed.pDay);
		  DBMS_OUTPUT.PUT_LINE('급여:'||ed.pSal);
		  DBMS_OUTPUT.PUT_LINE('부서명:'||ed.pDname);
		  DBMS_OUTPUT.PUT_LINE('근무지:'||ed.pLoc); 
		  DBMS_OUTPUT.PUT_LINE('급여등급:'||ed.pGrade);
		
		END;
		/

 		
 		스칼라변수
 		%TYPE
 		------ 한명에 대한 정보 -> 일반변수
 		CURSOR => 멀티(여러개를 동시에 받는다) => List
 		
 		형식) 
 			DECLARE
 			  변수설정
 			BEGIN
 			  SELECT를 이용해서 변수값 저장 => INTO
 			  변수출력
 			END;
 			/
 		
 		
 		--변수설정
 			연산자
 			 = 산술연산자(+,-,*,/) => +는 순수하게 산술만 처리(문자열결합불가능)
 			 						0으로 나눌 수 없다
 			 						정수/정수=실수
 			 = 비교연산자(=, !=(<>,^=),< , >, <=, >=) => 조건문에서 사용
 			 = 논리연산자(AND, OR)
 			 = IN (OR가 여러개인 경우 사용)
 			 = BETWEEN ~ AND (기간, 범위)
 			 = LIKE => %(문자열의 길이를 모를 때), _ ( 글자수당_한개)
 			 = NULL : 값이 없는 상태 ( 연산처리가 안된다) -> IS NULL, IS NOT NULL
 			 = NOT 부정연산자 => NOT IN, NOT LIKE, NOT BETWEEN 
 			
 			제어문 -> 흐름은 자바와 동일 / 형식만 다르다
 			 조건문
 			  =단일조건문
 			  	형식)
 			  		IF 조건문 THEN => 조건이 true일때만 수행
 			  			처리문장
 			  		END IF;
 			  		=> if(조건문)
 			  		   {
 			  		   }
 			  		IF (조건문) THEN => 조건이 true일때만 수행
 			  			처리문장
 			  		END IF;
 			  		-> 조건문을 괄호안에 넣어도 상관없음
 			  		
						DECLARE
						 pEmpno emp.empno%TYPE;
						 pEname emp.ename%TYPE;
						 pJob emp.job%TYPE;
						 pDeptno emp.deptno%TYPE;
						 pDname dept.dname%TYPE;
						
						BEGIN
						  SELECT empno,ename,job,deptno
						  	INTO pEmpno,pEname,pJob,pDeptno
						  FROM emp
						  WHERE empno=7900;
						
						  IF (pDeptno=10) THEN
							pDname:='개발부';
						  END IF;
						
						  IF (pDeptno=20) THEN
							pDname:='영업부';
						  END IF;
						
						  IF (pDeptno=30) THEN
							pDname:='기획부';
						  END IF;
						
						--하나씩 따로 처리하기 때문에 속도가 느리다는 단점이 있다
						  
						  DBMS_OUTPUT.PUT_LINE('--------결과값---------');
						  DBMS_OUTPUT.PUT_LINE('사번:'||pEmpno);
						  DBMS_OUTPUT.PUT_LINE('이름:'||pEname);
						  DBMS_OUTPUT.PUT_LINE('직위:'||pJob);
						  DBMS_OUTPUT.PUT_LINE('부서:'||pDname);
						  
						END;
						/
 			  =선택조건문 : true / false를 나눠서 작업
 			  	형식)
 			  	 	IF 조건문 THEN
 			  	 		처리문장
 			  	 	ELSE
 			  	 		처리문장
 			  	 	END IF;
 			  	 	
 			  	 	
 			  	 	
 			  	 	DECLARE 
					  pNo NUMBER:=&no;
					  pResult VARCHAR2(20);
					
					BEGIN
					  --오라클에는 %라는 기호가 없어서 MOD를 사용해야해
					  IF MOD(pNO,2)=0 THEN
						DBMS_OUTPUT.PUT_LINE(pNo||'는(은) 짝수입니다.');
					  ELSE
						DBMS_OUTPUT.PUT_LINE(pNo||'는(은) 홀수입니다.');
					  END IF;
					
					END;
					/
					 
					내장함수 사용가능
					  문자(substr, instr, rpad)
					  숫자(ceil, round)
					  날짜(sysdate, month_between)
					  변환(to_char) -> 날짜변환시 MM(월), MI(분), DY(요일)
					  기타함수(NVL) -> NULL값을 대체
					
					   regexp_like()
						-> 정규식
						-> 한글자
						-> 여러글자 : *(0이상), +(1이상)
						-> | => 선택
						-> [가-힣] : 한글 전체
							^[가-힣] : 한글로 시작
							[가-힣]$ : 한글로 끝
							[^가-힣] : 한글이 아닌 
						-> [A-Za-z] : 알파벳 전체
							
						-> [0-9] : 숫자전체
					
					
					 
					 DECLARE 
					 pEname emp.ename%TYPE;
					 pComm emp.comm%TYPE;
					 pSal emp.sal%TYPE;
					 pTotal NUMBER; 
					
					
					
					BEGIN
					 SELECT ename, comm,sal,sal+NVL(comm,0) 
					 INTO pEname,pComm,pSal,pTotal
					 FROM emp
					 WHERE empno=&empno;
					
					 IF pComm>0 THEN
						DBMS_OUTPUT.PUT_LINE(pEname||'님의 급여는 '||pSal||'이고 성과급은 '||pComm||'이며 총 급여는'
											||pTotal||'입니다');
					 ELSE 
						DBMS_OUTPUT.PUT_LINE(pEname||'님의 급여는 '||pSal||'이고 성과급은 없고 총 급여는'
											||pTotal||'입니다');
					 END IF;
					
					END;
					/

 			  	 	
 			  
 			  
 			  =다중조건문 : 조건문이 여러개중에 한 개만 수행
 			  	형식) 
 			  		IF 조건문 THEN
 			  			처리문장
 			  			조건 : true => 처리문장을 수행 => 종료
 			  			조건 : false => 밑에 있는 조건문으로 이동
 			  		ELSIF 조건문 THEN
 			  			처리문장
 			  		ELSIF 조건문 THEN
 			  			처리문장
 			  		ELSIF 조건문 THEN
 			  			처리문장
 			  		ELSE
 			  			처리문장 -> 없으면 생략가능
 			  		END IF;
 			 반복문
 			  =BASIC 반복문 -> do~while
 			  =WHILE
 			  =FOR
 			 
 		
 
 */
public class PL_SQL_데이터베이스관리자1 {

}
