/*
 
 	SQL
 	1. DQL : 데이터를 검색 -> 자바에서 데이터 읽어오기
 		SELECE *|colum_list
 		FROM table_name|view_name|(SELECT ~)
 		[
 			WHERE 조건문 (컬럼명|함수명 연산자값)
 						ename='KING';
 						TO_CHAR(hiredate,'YY')=80
 			GROUP BY 그룹컬럼|함수
 			HAVING 집계함수 연산자 값
 			ORDER BY 컬럼|함수 ASC|DESC
 			--------
 			  보통 수정, 삭제, 추가가 많은 경우 사용
 		]
 		**별칭 / 중복없는 데이터 검색
 		  --- 컬럼명 "별칭", 컬럼명 as 별칭명
 		      테이블명 별칭 -> FROM emp e
 		      함수이용 / 서브쿼리 -> FROM (SELECT ~)
 		      
 		      SELECT empno,ename,NVL(comm,0)
 		      FROM emp
 		      => rs.getInt(1), rs.getString(2), rs.getInt(3) -> jdbc 가능
 		      => mybatis에서는 ->  rs.getInt("empno"), rs.getString("ename"), rs.getInt("NVL(comm,0)")
 		      																--------------------------
 		      															오류발생 -> select에서 별칭을 따로 지정해서 
 																					rs.getInt("별칭")으로 사용해야함
 	2. DML
 		데이터 변경(데이터 조작)
 			INSERT : 데이터 추가 => 회원가입 글쓰기 댓글쓰기
 				INSERT INTO table_name(컬럼...) VALUES(값...)
 									  ------default, null값을 제외
 				INSERT INTO table_name VALUES(값...)			
 					   	=> 모든 컬럼값을 추가해야한다
 				-> 제외시에 PK,NN,FK,CK 
 									  
 			UPDATE : 데이터 수정 => 회원수정 장바구니 예약수정 조회수 증가
 				UPDATE table_name SET
 				컬럼=값, 컬럼=값...
 				[WHERE 조건문]
 				
 				
 			DELETE : 데이터 삭제 => 예약취소 회원탈퇴 장바구니 취소 
 				DELETE FROM table_name
 				[WHERE 조건문]
 				
 		==> 웹 개발자가 주로 사용
 			=> 사용자 요청 -> SQL 문장을 이용해서 데이터를 관리 	
 	3. DDL : 정의언어
 		데이터형
 			CHAR(1~2000byte) -> 같은 글자수를 저장할 때 주로 사용한다
 								(남자/여자) (y/n) 등 고정바이트
 			VARCHAR2(1~4000byte) ->  주로 문자열의 디폴드 => 가변 바이트
 			
 			CLOB -> 4기가 => 가변 바이트
 			------------------------ 자바에서는 String으로 값을 받는다
 			숫자 저장 : NUMBER -> NUMBER(8,2)
 					  평점 : NUMBER(2,1), 점수 NUMBER(3)
 					  => 저장된 데이터
 					  	실수 / 정수
 					  		=> int
 					  	=> double
 			날짜저장 : 날짜 / 시간
 					DATE => java.util.Data
 		제약조건 => 데이터베이스 설계 => 프로그램에서 필요한 데이터만 저장(정형화된 데이터)
 			NOT NULL : 반드시 입력값이 필요하다
 			UNIQUE : NULL값은 허용, 데이터는 중복이 없다
 					-> ID찾기(후보키) -> EMAIL/PHONE
 			NOT NULL+UNIQUE => PRIMARY KEY
 							=> 데이터 무결성
 							=> 원하지 않는 데이터의 수정, 삭제 문제 해결
 						=> 반드시 테이블에는 한 개의 PRIMARY를 사용한다
 			참조키(FOREIGN KEY) : 다른 테이블의 컬럼값을 참조
 						=> 조인
 			CHECK : 지정된 값만 저장
 			DEFAULT : 사용자 입력이 없는 경우에 자동 값 주입
 			
 		
 		형식
 			Table : 데이터 저장장소
 				=> DESC table_name : 컬럼확인
 				=> SELECT * FROM tab : 테이블명 확인
 				=> SELECT * FROM user_tables
 				   FROM table_name='테이블명(대뮨자)' : 테이블에 대한 자세한 정보 확인
 				   
 				=> 테이블 생성
 					CREATE TABLE table_name(
 						컬럼명 데이터형 [제약조건], => 컬럼뒤에는 NOT NULL, DEFAULT
 						컬럼명 데이터형 [제약조건],
 						[제약조건], => PK,FK,CK,UK
 						[제약조건]
 					)
 					제약조건은 반드시 제약조건 이름을 부여해야한다(제약조건 수정,삭제를 하기 위해서)
 					
 					제약조건 쓰는 방식
 						CONSTRAINT 테이블명_컬럼명_pk PRIMARY KEY(컬럼명)
 						CONSTRAINT 테이블명_컬럼명_uk UNIQUE KEY(컬럼명)
 						CONSTRAINT 테이블명_컬럼명_fk FOREIGN KEY(컬럼명)
 						REFERENCES 참조테이블(참조컬럼)
 						CONSTRAINT 테이블명_컬럼명_ck CHECK(컬럼명 IN('',''))
 						------------------------------------------------
 						CONSTRAINT 테이블명_컬럼명_nnn NOT NULL
 						컬럼명 데이터형 DEFAULT 값
 						----------------------- 컬럼명 뒤에 설정
 											
 			View  : 한 개이상의 테이블을 참조해서
 					새로운 가상테이블을 생성
 					=> 참조할 테이블이 존재할때만 가능
 					=> 보안 / SQL문장을 간결하게 만드는 경우
 					=> 기존의 테이블을 재사용
 					
 				CREATE [OR REPLACE] VIEW view_name
 				AS 
 					SELECT~
 					FROM table_name --단일뷰
 					WITH READ ONLY --읽기전용
 					
 				CREATE [OR REPLACE] VIEW view_name
 				AS 
 					SELECT~
 					FROM table_name, table_name2 --복합뷰(조인, 서브쿼리 이용할 때)
 					WITH READ ONLY --읽기전용	
 					
 				==> 뷰에는 SQL(SELCET문장이 저장)
 				==> SELECT text FROM user_views
 				    FROM view_name='대문자'
 				==> 제약조건
 					SELECT * FROM user_constraints
 					FROM table_name='테이블명대문자로'
 					
 				==> SELECT ~~
 					FROM (SELECT ~~ ) --인라인뷰 : 페이지, ROWNUM
 					*가장 많이 등장
 			
 			Sequence : 자동 증가 번호
 				CREATE SEQUENCE seq명
 					START WITH 시작번호 --초기값
 					INCREMENT BY 증가값
 					NOCACHE ==> 기본으로 20개정도 메모리에 저장하고 사용하는데 저장없이 사용하겠다는 설정
 					NOCYCLE ==> 다시 돌아오지 않게 설정 -> 무한대
 			
 			Index : 검색 속도 향상
 				PK / UK => 자동으로 생성
 				사용자 정의
 					CREATE INDEX index명 ON table_name(컬럼)
 						=> table_name(컬럼) => ASC는 생략이 가능
 						=> table_name(컬럼 DESC)
 						=> table_name(컬럼 ASC,DESC)
 				데이터가 많은 경우
 				검색어로 사용하는 컬럼이 있는 경우
 				NULL값이 많은 경우
 				수정 / 삭제 / 추가가 많은 경우 -> rebuild -> 속도가 저하
 				크롤링된 데이터는 인덱스를 이용하면 좋다
 				
 				정렬 
 				힌트 => /*+INDEX_ASC(테이블명,pk)
 					   /*+INDEX_DESC(테이블명,pk)
 					   /*+INDEX(테이블명 인덱스명)
 					  
 			
 			Function
 			
 			Pricedure
 			
 			Trigger
 		
 	
 	4. TCL : 일괄처리할 때 사용
 		정상 저장 : COMMIT
 		비정상저장 : ROLLBACK -> 모든 SQL문장 취소
 	5. DCL
 		GRANT : 권한 부여
	 		GRANT CREATE TABLE TO 계정
	 			  ----------- 
	 			  CREATE VIEW 
	 			  CREATE SEQUENCE
	 			  CREATE FUNCTION
	 			  CREATE PROCEDURE
 		REVOKE : 권한 해제
 			REVOKE CREATE TABLE FROM 계정 
 			
 	
 	** 조인 / 서브쿼리
 
 	
 ------------------------------------------------------------------------------------------------
 
 	자바에서 오라클 연결
 	1. 드라이버 등록 
 		Class.forName("oracle.jdbc.driver.OracleDriver");
 
 	2. 연결
 	 	Connection conn=DriverManager.getConnection(오라클주소 , 계정명, 비밀번호 )
 	 	
 	 		**오라클 주소 : jdbc:oracle:thin:@localhost:1521:XE
 	 		*				  업체명 	드라이버종류   ip 	 port 데이터베이스명
 	3. SQL문장을 전송
 		PreparedStatemenet / CallableStatement : 프로시저호출
 		ps=conn.preparedSttement(sql)
 		
 		결과값
 		ResultSet rs = ps.executeQuery() -> select만 사용
 		ps.executeUpdate() -> 데이터만 변경 (INSERT / UPDATE/ DELETE) 
 		
 	4. 닫기
 		rs.close()
 		ps.close()
 		conn.close()
 	 	
 	 	
 
 */
public class 오라클전체정리 {

}
