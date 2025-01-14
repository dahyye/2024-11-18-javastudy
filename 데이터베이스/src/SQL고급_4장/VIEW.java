package SQL고급_4장;
/*
 	
 	뷰(view) : 특정 사용자에게 테이블의 모든 데이터를 보여주는 게 아닌 필요한 데이터만 추출하여 보여줄 수 있다
 		사용자 계정에서 뷰를 생성할 권한이 없다 (system 계정 => 권한 부여)
 		-----------------------------
 			권한을 부여하는 계정 : (system/ sysdba)
 			hr : 사용자 계정
 			1) system으로 연결
 				conn system/happy
 			2) 권한부여
 				grant create view to hr;
 					  -----------
 					  	create function /create procedure..
 			   권한해제
 				revoke create view from hr;
 			3) 다시 사용자 계정으로 복귀
 				conn hr/happy
 				
 		다른 테이블을 참조해서 새롭게 만들어지는 가상테이블
 		=> 장점 : 보안 (뷰에 저장되는 것은 데이터가 저장되는 것이 아니다.SELECT 문장이 저장된다)
 		=> 복잡한 sql문장이 있는 경우에 주로 사용 / 소스가 간결해진다
 		=> 일반 테이블과 동일하게 사용
 			FROM table_name|(SELECT~)|view_name
 		=> 주의점 : INSERT / UPDATE / DELETE => view에 저장되는 것이 아니라 참조하는 테이블에 저장된다
 		=> view는 테이블을 참조하는 것이기 떄문에 반드시 table이 필요하다
 			=> 데이터를 모다서 재사용하는 방법
 		
 		
 		1. 뷰 종류
 			1) 단순뷰 : 한 개의 테이블을 참조 => 테이블을 사용하는 것이 편리
 					  사용빈도는 거의 없다
 			2) 복합뷰 : 두개이상의 테이블을 참조
 						=> 조인 / 서브쿼리
 			3) 인라인뷰 : SELECT => 새로운 가상테이블 처리
 						=> 페이징 기법
 		
 		2. 뷰 옵션 => 보여주는 문장(DML을 적용)
 			1) WITH CHECK OPTION => INSERT / UPDATE / DELETE 가능
 				=> DEFAULT 
 			2) WITH READ ONLY : DML이 불가능 => SELECT만 가능
 			** 뷰에서 DML을 사용하면 table에 영향을 미친다
 			
 				 		
 		3. 뷰 형식
 			생성방법
	 			CREATE VIEW view_name
	 			AS
	 			SELECT *FROM emp; => emp/dept를 조인해서 사용할 수도 있다 => 복합뷰
				
				=> 수정하고 싶을 땐 삭제후 다시 제작해야함
			
			생성과 동시에 수정이 가능하게 만드는 방법
				CREATE OR REPLACE VIEW view_name => 없으면 만들고 있으면 덮어쓴다
				AS
				SELECT ~ 
	 			
	 			=> 삭제 없이 수정이 가능하다
 		
 		4. 사용법 : 자바에서 JDBC시 수로 사용 => SQL문장이 복잡한 경우에 뷰를 이용해서 사용
 		
 		5. 삭제
 			DROP VIEW view_name
 		
 		6. 뷰 확인
 			SELECT * FROM user_views
 			WHERE view_name='대문자'; => 보통 SELECT 문장이 저장되어 있다
 			
 ---------------------------------------------------------------------------------------------	
 		
 	235page(오라클 면접의 단골-VIEW, INDEX, 프로시저와 트리거의 차이, 조인/서브쿼리)
 	view
 	=>뷰는 하나 이상의 테이블을 합하여 만든 가상테이블
 	=> 사용
 		실제 데이터에 물리적인 colum을 추가하면 메모리 용량이 커진다
 	    테이블 수정이나 관리가 어려운 경우 사용한다
 	    자바에서 sql문장 처리가 어려운 경우(소스가 길어지는 경우) => 단순화
 	=> 뷰는 SQL문장이 저장된다
 	=> 장점
 		편리성 : 여러개 테이블의 데이터를 재사용할 수 있다 -> JOIN/SUBQUERY 사용할 필요가 없다
 		보안성 : 실제 데이터가 저장되어 있지 않기 때문에
 		독립성 : 테이블없이 단독으로 사용이 가능하다 => 테이블에 영향을 미칠 수 있다는 부분을 조심해야한다
 		
 	
 	237page
 	view 생성
	 	CREATE [OR REPLACE] VIEW view_name
	 	AS 
	 	 SELECT ~ -> 참조 테이블
	 	 
	 	 
	 	CREATE [OR REPLACE] VIEW view_name(empno,ename,job..) -> 컬럼 지정이 가ㅡㄴㅇ
 	 	AS 
	 	 SELECT ~ -> 참조 테이블
 	
 	240page
 	view 삭제
 		DROP VIEW view_name
 		
 	user_vies:뷰에 저장된 SQL 문장을 볼 수 있다
 	
 	오라클 객체 talbe / view/ sequence / constraints 
 	=> user_object
 	
 	
 	
 	
 		 			
 			 			
 			 			
 			 			
 			 			
 			 			
 			 			
 			 			
 			 			
 			 			
 
 */
public class VIEW {

}
