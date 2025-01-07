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
 							연산자(=)
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
 						
 					*ANSI JOIN(표준조인) : 모든 데이터베이스에서 사용(표준화)
 										실무는 대부분 표준 조인을 사용하고 있다
 						SELECT A.col, B.col
 						FROM A JOIN B
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
 						SELECT A.col, B.col
 						FROM A NATURAL JOIN B
 					JOIN ~ USING : 테이블.컬럼명같은 식별자가 있으면 오류
 						SELECT A.col, B.col 
 						FROM A JOIN B USING(공통 컬럼명)
 					-------------------컬럼명이 동일 
 					
 					
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
 								BETWEEN, AND
 								
 			OUTER JOI : 교집합 ->  INNER JOIN의 단점을 보완
 								 ---------------- > NULL값 처리 가능
 								 
 				RIGHT OUTER JOIN
 				LEFT OUTER JOIN
 				FULL OUTER JOIN
 */
/*
 	
 
 
 */
public class 데이터베이스_250107_JOIN_SUBQUERY {

}
