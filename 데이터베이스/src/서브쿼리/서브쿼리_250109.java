package 서브쿼리;
/*
 
 	서브쿼리의 종류
 		
	
 		-> WHERE문장 뒤에 사용
 		단일행 서브쿼리(서브쿼리의 결과값이 한개)
 		다중행 서브쿼리(결과값이 여러개) -> 연산자(IN, ANY, SOME, ALL)이용
 				>ALL(10, 20, 30) -> 최대 30 
 				<ALL(10, 20, 30) -> 최소 10
 				>ANY(10, 20, 30) -> 최소 10 
 				<ANY(10, 20, 30) -> 최대 30
 		
 		=> SELECT ~ 
		   FROM table명
		   WHERE 컬럼명 연산자(SELECT~~~)
 
 		--------------------------------> 컬럼은 한 개만 이용
 										컬럼을 여러개 사용 -> 다중컬럼 서브쿼리
 		-> 컬럼을 대신 사용 : 스칼라 서브쿼리 => 조인을 대신할 수 있다
 		   => SELECT 컬럼명, (SELECT~~~)
 		   	  FROM table명
 		   	  WHERE ~~~~
 		   	  
 		-> 인라인뷰 : 테이블 대신 사용 => 페이지 나눌 때 사용
 			  SELECT ~~~
 			  FROM (SELECT~~)
 			  
 	서브쿼리의 실행 순서
 	1. 서브쿼리가 먼저 실행 => 결과값을 Main Query로 전송
 	   Main Query=(Subquery)
 	   
 	   SELECT ~
 	   FROM table명 
 	   WHERE 컬럼명 = (SELECT~)
 	   -----------   -------
 	   MainQuery	  SubQuery
 	       2			  1
 	       
 	2. JOIN ===> 테이블 한개이상에서 필요한 데이터추출하는 방식
 	   SubQuery ===> SQL문장 한개이상을 연결 출력
 	   ---->SQL문장을 최대한 줄일 수 있게 만든다
 	   
 	   SQL문장을 두번이상 사용
 	   => 자바-> 오라클-> 결과값 -> 자바-> 오라클-> 결과값
 	   => 자바에서는 한 번만 수행이 가능
 	   => 프로시저 : 여러개의 SQL문장을 한 번에 수행(ERP) -> 속도를 최적화
 	   => SQL + SQL -> SQL 문장이 길어진다
 	   
 	3. SQL문장을 통합하는 방법
 			   ----------
 			   = 사원중에 전체 급여의 평균보다 적게 받는 사원의 이름, 급여, 직위, 입사일
 			   1) 급여의 평균을 구한다
 			   		SELECT ROUND(AVG(sal)) FROM emp;
 			   2) WHERE문장 뒤에 평균을 대입 후 처리
 			   		SELECT ename, sal, job, hiredate
 			   		FROM emp
 			   		WHERE sal<(SELECT ROUND(AVG(sal)) FROM emp);
 			   	    ---------------------------------------------> 단일행 서브쿼리
 			   	    
 -------------------------------------------------------------------------------------------
 	1. 단일행 서브쿼리
 		EX. 
 		KING과 같은 부서에서 근무하는 사원의 이름, 부서번호, 입사일 출력
  		--------------------	---------------------------
  				1							2
  			SELECT deptno FROM emp WHERE ename='KING';
  			
  			SELECT ename, deptno, hiredate
  			FROM emp
  			WHERE deptno=10; 
  			--------------------------> 문장 합치기
  			SELECT ename, deptno, hiredate
  			FROM emp
  			WHERE deptno=(SELECT deptno FROM emp WHERE ename='KING'); 
  		
  		10번 부서에서 급여가 가장 많은 사원의 이름, 급여 출력
  		-----------------------	 ----------------
  		SELECT MAX(sal)
  		FROM emp
  		WHERE deptno=10;
  		
  		SELECT ename, sal
  		FROM emp
  		WHERE sal=(SELECT MAX(sal) FROM emp WHERE deptno=10);
  	
  			
  		getConnecttion();
  		String sql="SELECT MAX(sal) FROM emp WHERE deptno=10";
  		ps=conn.preparedStatement(sql);
  		ResultSet rs=ps.executeQuery();
  		rs.next();
  		int sal=rs.getInt(1);
  		ps.close();
  		rs.close();
  		String sql="SELECT ename, deptno, hiredate
  			FROM emp
  			WHERE deptno="sal;
  		ps=conn.preparedStatement(sql);
  		ResultSet rs=ps.executeQuery();	
  		While(rs.next)
  		{
  		
  		}
  		rs.close();
  		----------------------------------------------------------
  		--가장 비싼 도서의 이름
  		SELECT bookname, publisher
  		FROM book
  		WHERE price=(SELECT MAX(price) FROM book); 
  		
  		--근무지가 DALLAS인 사원의 이름, 직위, 부서번호, 월급을 출력
  		SELECT ename, job, deptno, hiredate
		FROM emp
		WHERE deptno=(SELECT deptno FROM dept WHERE loc='DALLAS');

		--SCOTT가 근무하는 부서에서 같이 근무하는 사원의 이름, 부서번호, 부서명, 근무지, 입사일을 출력
		SELECT ename, e.deptno, dname, loc, hiredate
		FROM emp e, dept d
		WHERE e.deptno=d.deptno AND e.deptno=(SELECT deptno FROM emp WHERE ename='SCOTT');

 	2. 다중행 서브쿼리
 		=> 서브쿼리의 값이 여러개
 		--모든 부서번호를 받아서 10,20,30 -> 해당되는 사원의 이름, 부서번호를 출력
 		SELECT DISTINCT deptno
		FROM emp;
		SELECT ename, deptno FROM emp WhERE deptno IN(10,20,30);
		
		SELECT ename, deptno FROM emp WhERE deptno IN(SELECT DISTINCT deptno
		FROM emp);
		
		IN() => 전체를 대입
		ANY() => 
				deptno > ANY(10,20,30) -> 한 개만 선택 -> 최소값
		 		deptno > 10
 			    deptno < ANY(10,20,30) -> 한 개만 선택 -> 최대값
		 		deptno < 30
		 		
		ALL() => 
				deptno > ALL(10,20,30) -> 한 개만 선택 -> 최소값
		 		deptno > 30
 			    deptno < ALL(10,20,30) -> 한 개만 선택 -> 최대값
		 		deptno < 10
		 		
	-------------------------------------------------------------------------------------	 		
	
	SELECT col1, (SELECT ...) - 스칼라 서브쿼리(Scalar Sub Query): 하나의 컬럼처럼 사용 (표현 용도)
 								=> 조인대신 사용가능
 								=> 한개값만 출력되어야한다
 								
 				--모든 사원의 이름, 직위, 부서명, 근무지 출력
 				SELECT ename, job, dname, loc
				FROM emp, dept
				WHERE emp.deptno=dept.deptno;
				
				SELECT ename, job, (SELECT dname FROM dept WHERE deptno=emp.deptno) dname,
				                (SELECT loc FROM dept WHERE deptno=emp.deptno) loc
				FROM emp;
 		
 			
 				--모든 책아이디, 이름, 책이름, 가격, 주문날짜를 출력해라
 				SELECT orderid,name, bookname,saleprice, orderdate
				FROM orders o, customer c,book b
				WHERE o.custid=c.custid 
				AND o.bookid=b.bookid;
				
				
				SELECT orderid,
				    (SELECT name FROM customer WHERE custid=orders.custid) name, 
				    (SELECT bookname FROM book WHERE bookid=orders.bookid) bookname,
				    saleprice, orderdate
				FROM orders;


	FROM (SELECT ...)         - 인라인 뷰(Inline View): 하나의 테이블처럼 사용 (테이블 대체 용도)
								=> 페이지 나눌 때 사용
								=> 보안이 뛰어나다
								1 단순뷰 2. 복합뷰 3. 인라인뷰
								실제 데이터를 가지고 있지 않는다
				ELECT empno, ename, sal, rownum
				FROM emp 
				ORDER BY sal DESC;				
				데이터의 순위를 정해서 출력하고 싶을 때 
				=> 오더바이가 가장 마지막에 실행되기 때문에 오류발생
				==> rownum을 주로 이용
				 	-----오라클에서 지원하는 가상 컬럼 =>
				 	 	 row가 저장될 대 자동으로 번호 생성(고정)
				 	 	 							-------- 변경이 가능
				 	 	 							-------- 인라인뷰
				 	 ----- Top-N
				 	 ----- 인기순위 / 최근 뉴스
				서브쿼리
				 	WHERE 뒤에(단일행, 다중행) -> 조건값으로 이용
				 	FROM 뒤에 (table대신 사용) ==> 인라인뷰
				 	SELECT 뒤에 -> 스칼라서브쿼리
				 	-> 무조건 SELECT문장으로 만들어진다
				 
				SELECT empno, ename, sal, rownum
				FROM (SELECT empno, ename, sal FROM emp ORDER BY sal DESC);
				
				
				SELECT empno, ename, job, hiredate, sal, rownum
				FROM (SELECT empno,ename,job,hiredate,sal FROM emp) 
				WHERE rownum BETWEEN 1 AND 5;
				//6~10번을 출력하고 싶은데 rownum은 1부터 시작이라서 오류가 발생
								
				SELECT empno, ename, job, hiredate, sal, num
				FROM (SELECT empno,ename,job,hiredate,sal,rownum as num 
					  FROM (SELECT empno,ename,job,hiredate,sal FROM emp)) 
				WHERE num BETWEEN 6 AND 10;				
				
				
				--SMITH보다 급여를 많이 받는 사원의 이름/급여를 출력
				SELECT sal
				FROM emp
				WHERE ename='SMITH'
				
				SELECT ename, sal
				FROM emp
				WHERE sal>(SELECT sal
				FROM emp
				WHERE ename='SMITH'
				);
				
				--10번 부서의 사원들이 가지고 있는 직위를 가진 사원의 이름 / 직위
				SELECT job
				FROM emp
				WHERE deptno=10;
				
				SELECT ename, job
				FROM emp
				WHERE jon IN(SELECT job FROM emp WHERE deptno=10);
				 

				
				
	WHERE col = (SELECT ...)  - 일반 서브쿼리: 하나의 변수(상수)처럼 사용 (서브쿼리의 결과에 따라 달라지는 조건절)
								
									 		
									 	
		 		
		 		
	
		 		
		 		
		 		
 */
public class 서브쿼리_250109 {

}
