package 데이터베이스;
/*
 
 1. 데이터베이스는 중복을 최소화
 	---------------------
 		테이블을 나눠서 저장 -> 참조 -> 정규화
 		=> 필요할 때 테이블을 연결해서 데이터를 추출 => JOIN
 		
 		=> 원자값만 저장한다
 		EX. 
 			취미를 저장할 때
 			
 			ID	HOBBY
 			A	등산, 여행, 게임 ==> 이렇게 저장하면 안됨 => 데이터 수정/삭제가 어렵다
 			
 			
 			ID	HOBBY
 			A	등산
 			A	여행
 			A	게임  		==> 이렇게 저장하면 안됨 => 중복이 많아
 		
 		  ==========>
 		  
 			ID와 HOBBY를 따로 저장해서 매핑 테이블로 연결시킨다 => JOIN
 			
 			
 	  정규화 : 여러개의 테이블이 생성
 	         ------------ 한 개로 묶어서 데이터 추출 -> 조인
 	        
 	      emp	dept
 	       |_____|
 	       	  |
 	       	  deptno로 연결

 	       
 	       orders	customer	book
 	         |_________|		  |
 			 |	  |				  |
 			 |__custid____________|
 			 			|
 			 		  bookid
 			 		
 		163page	 		  
 		1. 조인의 종류
 			for(int i=0;i<=10;i++)
 			{
 				for(int j=0;j<=10;j++)
 				{
 					if(emp[i]=dept[i])
 					{
 						데이터추출
 					}
 				}
 			}	
 			
 			JOIN 의 단점은 SELECT만 사용이 가능하다는 점 ( 테이블의 데이터가 통합 )
 				서브쿼리는 코드가 길어진다는 단점이 있다
 			
 			INNER JOIN => 교집합(Intersect)
 					   => 단점은 null값을 처리하지 못한다==> 보안 OUTER JOIN
 				*EQUI_JOIN : 컬럼의 값이 같은 경우 => 등가조인
 							연산자(=)를 표시해야한다
 							컬럼명이 동일하지 않는 경우도 있다
 							같은 테이블을 이용해서 조인을 걸 수 있다 -> SELF JOIN
 				--같은 컬럼명을 가지고 있는 경우 -> 반드시 테이블명.컬럼명 or 별칭명.컬럼명 으로 구분해줘야 한다	
 				--테이블에 별칭을 줄 땐 FROM 테이블명 별칭, 테이블명 별칭 형식으로 사용
				--다른 컬럼명으로 비교가 가능하다 : 컬럼에 저장된 값이 동일한 경우
				--예약, 결제 에서 많이 사용 -> 예약정보의 회원정보와 결재정보의 회원정보			
 							
 					
 					*Oracle JOIN : 오라클에서만 사용
 						SELECT A.col, B.col
 						FROM A,B
 						WHERE A.col=B.col
 						-> 테이블 컬럼명이 다른 경우에는 테이블.컬럼명에서 테이블명을 생략할 수 있다
 						-> 테이블이 길거나 알아보기 어려운 경우엔 별칭을 사용할 수 있다
 						
						SELECT A.col,B.col
 						FROM A a, B b
 						WHERE a.col=b.col
 						
 						--사원의 이름, 직위, 입사일, 부서명, 근무지
						SELECT ename, job, hiredate, dname, loc
						FROM emp, dept
						WHERE emp.deptno=dept.deptno;                             
						
						--테이블명이 긴 경우에는 별칭사용가능
						SELECT ename, job, hiredate, dname, loc
						FROM emp e, dept d
						WHERE e.deptno=d.deptno;
 						
 						
 					*ANSI JOIN(표준조인) : 모든 데이터베이스에서 사용(표준화)
 										실무는 대부분 표준 조인을 사용하고 있다
 						SELECT A.col, B.col
 						FROM A (INNER) JOIN B //INNER 은 생략가능
 						ON A.col=B.col
 						
 						SELECT ename, job, dname, loc
						FROM emp JOIN dept
						ON emp.deptno = dept.deptno;
						
						2차조인일 땐 join on join on 이런식으로 사용해야 한다
						
						SELECT orderid, name, bookname, saleprice 
						FROM orders JOIN customer
						ON orders.custid=customer.custid
						JOIN book
						ON orders.bookid=book.bookid;
						
						//테이블명이 길거나 많을 땐 별칭을 사용하는게 편할 수 있다
						//디비버는 자동으로 별칭이 생성된다(나중에 사용)
						SELECT orderid, name, bookname, saleprice 
						FROM orders o JOIN customer c
						ON o.custid=c.custid
						JOIN book b
						ON o.bookid=b.bookid;
						
 					
 					-------------------컬럼명은 다를 수 있다(저장된 데이터값)
 					NATURAL JOIN : 테이블.컬럼명같은 식별자가 있으면 오류
 									WHERE절이 없어도 같은 컬럼을 자동으로 인식한다
 						SELECT A.col, B.col
 						FROM A NATURAL JOIN B
 					JOIN ~ USING : 테이블.컬럼명같은 식별자가 있으면 오류
 						SELECT A.col, B.col 
 						FROM A JOIN B USING(비교대상의 컬럼명)
 					-------------------컬럼명이 동일해야한다
 					
 					
 					조인조건 + 일반조건이 있는 경우
 					-> emp테이블에서 이름, 입사일, 직위, 급여, 부서명, 근무지
 						+ 10번 부서에 대해서 데이터를 추출
 						
 					SELECT ename, hiredate, job, sal, dname, loc
					FROM emp, dept
					WHERE emp.deptno=dept.deptno AND emp.deptno=10;
					
					-> 직원의 이름, 직위, 부서명, 근무지를 출력하는데 이름에 A가 포함된 사람을 출력	
					SELECT ename, job, dname, loc
					FROM emp, dept
					WHERE emp.deptno=dept.deptno AND ename LIKE '%A%';
 					
 					
 							
 				NON_EQUI_JOIN : 포함된 경우 -> 연산자(=)가 아닌 연산자 사용 => 비등가조인
 								오라클에서만 존재함 
 								조인 조건이 정확히 일치하지 않는 경우에 사용
 								BETWEEN, AND를 사용
 								
 					WHERE sal>=losal AND sal<=hisal
 					WHERE sal BETWEEN losal AND hisal
 					
 					
 					--NON_EQUI-JOIN
					SELECT ename, job, hiredate, sal, grade
					FROM emp, salgrade
					WHERE sal BETWEEN losal AND hisal;
					
					--2단
					SELECT ename, job, hiredate, sal, dname, loc, grade
					FROM emp, dept, salgrade
					WHERE emp.deptno=dept.deptno
					AND sal BETWEEN losal AND hisal
					
					--2단(안시)
					SELECT ename, job, hiredate, sal, dname, loc, grade
					FROM emp JOIN dept
					ON emp.deptno=dept.deptno
					JOIN salgrade
					ON sal BETWEEN losal AND hisal
 					
 					
 					-------------------------------------------
 					--오라클조인
 					SELECT *
					FROM customer c, orders o
					WHERE c.custid=o.custid;
					안시조인
					--SELECT *
					FROM customer c JOIN orders o
					ON c.custid=o.custid;
					--내츄럴조인
					SELECT * 
					FROM customer NATURAL JOIN orders;
					--using조인
					SELECT *
					FROM customer JOIN orders USING(custid);
					---------------------------------------------
 					
 					SELECT name, saleprice
					FROM customer c, orders o
					WHERE c.custid=o.custid;  
					
					--고객별로 주문한 도서의 총판매액을 출력, 고객별로 정렬
					--이름, 총판매액
					SELECT name, SUM(saleprice)
					FROM customer c, orders o
					WHERE c.custid=o.custid
					GROUP BY name;
					
					--고객의 이름name, 주문한 도서이름bookname을 출력
					SELECT name, bookname 
					FROM customer c, orders o, book b
					WHERE c.custid=o.custid;
	
					
					SELECT *
					FROM customer;
					--custid, name, address, phone
					
					SELECT *
					FROM orders;
					--orderid, custid, bookid, saleprice, orderdate
					
					SELECT *
					FROM book;
					--bookid, bookname, publisher, price
					
					
					
					
					--20000원인 도서를 주문한 고객의 이름과 도서이름을 출력
					SELECT name, bookname
					FROM customer c, orders o, book b
					WHERE c.custid=o.custid 
					AND o.bookid=b.bookid 
					AND price=20000;
					
					
					--고객의 이름, 주문한 책 제목을 출력
					--주문한 책이 없는 고객도 출력(null)-> OUTTER JOIN 이용
					-- INNER JOIN + NULL값을 가진 데이터까지 출력
					--관리자페이지에서 주로 출력
					SELECT name, bookname
					FROM customer c, orders o, book b
					WHERE c.custid=o.custid 
					AND o.bookid=b.bookid

 					
 		-------------------------------------------------------------------------------------------------			
 								
 			OUTER JOIN : 교집합 ->  INNER JOIN의 단점을 보완
 								 ---------------- > NULL값 처리 가능
 								 
 				RIGHT OUTER JOIN
 					오라클 JOIN
 						SELECT A.col, B.col
 						FROM A,B
 						WHERE A.col(+)=B.col
 					ANSI JOIN
 						SELECT A.col, B.col
 						FROM A RIGHT OUTER JOIN B
 						ON A.col=B.col
 					
 				LEFT OUTER JOIN
 					오라클 JOIN
 						SELECT A.col, B.col
 						FROM A,B
 						WHERE A.col=B.col(+)
 					
 						SELECT e1.ename "본인", e2.ename "사수명"
						FROM emp e1, emp e2
						WHERE e1.mgr=e2.empno;
						
						SELECT e1.ename "본인", e2.ename "사수명"
						FROM emp e1, emp e2
						WHERE e1.mgr=e2.empno(+);
 						
 					ANSI JOIN
 						SELECT A.col, B.col
 						FROM A LEFT OUTER JOIN B
 						ON A.col=B.col
 						
 						
 						
 					
 				FULL OUTER JOIN -> 사용빈도가 거의 없다
 					ANSI JOIN
 						SELECT A.col, B.col
 						FROM A FULL OUTER JOIN B
 						ON A.col=B.col
 				
 				
 */
/*
 	
 
 
 */
public class 데이터베이스_250107_JOIN_SUBQUERY {

}
