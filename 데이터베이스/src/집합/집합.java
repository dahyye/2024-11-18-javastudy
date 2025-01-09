package 집합;
/*
	 --테이블생성------------------------------------------------
	CREATE TABLE A(
	no NUMBER);
	
	CREATE TABLE B(
	no NUMBER);
	
	INSERT INTO A VALUES(1);
	INSERT INTO A VALUES(2);
	INSERT INTO A VALUES(3);
	INSERT INTO A VALUES(4);
	INSERT INTO A VALUES(5);
	
	INSERT INTO B VALUES(4);
	INSERT INTO B VALUES(5);
	INSERT INTO B VALUES(6);
	INSERT INTO B VALUES(7);
	INSERT INTO B VALUES(8);
	
	COMMIT;
	-----------------------------------------------------------
	
	
	--UNION => 합집합 => 중복된 데이터는 제거하고 저장 
	--					(1,2,3,4,5,6,7,8)
	SELECT no
	FROM A
	UNION 
	SELECT no
	FROM B;
	
	--UNION ALL => 합집합 => 중복된 데이터 포함해서 저장 
	--					(1,2,3,4,5,4,5,6,7,8)
	SELECT no
	FROM A
	UNION ALL 
	SELECT no
	FROM B;
	
	--INTERSECT => 교집합 => 같은 값을 가지고 온다
	--					(4,5)
	==> 레시피데이터를 가지고 올 때 목록은 230000 를 가져올 수 있는데 레시피는 120000만 가져올 수 있어
							그래서 목록과 레시피를 교집합으로 묶어서 데이터가 온전한 것만 가져올 수 있어
	SELECT no
	FROM A
	INTERSECT 
	SELECT no
	FROM B;
	
	--MINUS : 없는 데이터를 출력
	
	--A-B = A MINUS B = 1,2,3   ==> INTERECT + MINUS ==> LEFT OUTER JOIN
	--B-A = B MINUS A =  6,7,8  ==> INTERECT + MINUS ==> RIGHT OUTER JOIN
	
	SELECT no
	FROM A
	MINUS 
	SELECT no
	FROM B;
	
	SELECT no
	FROM B
	MINUS 
	SELECT no
	FROM A; 
	 
	
	--책을 구매하지 않은 사람 = 전체 - 책 구매한사람
	SELECT name
	FROM customer
	MINUS
	SELECT name
	FROM customer
	WHERE custid IN(SELECT custid FROM orders);	 
	
	--MINUS를 사용하지 않고 구할 수 있는 방법도 있다
	SELECT name
	FROM customer
	WHERE custid NOT IN(SELECT custid FROM orders);
	 
 	
 	
 
 */
public class 집합 {

}
