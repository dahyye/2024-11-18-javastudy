package SQL고급_4장;
/*
	 **면접에서 거의 100%나오는 질문
	 인덱스 (데이터를 빨리 찾기 위한 용도 -> 일종의 주소록 )
	 1. 검색 속도 향상
	 2. 인덱스를 저장하기 위해 메모리가 많이 소요된다(단점)
	 3. 생성 -> 사용자 정의, UNIQUE / PRIMARY KEY는 자동 생성이 된다
	 4. 인덱스 생성 시기
	 	1) 구별되는 값을 가지고 있는 경우(PRIMARY KEY)
	 	2) WHERE절에서 자주 사용되는 컬럼(검색)
	 	   -----------------------------> TITLE, NAME
	 	3) JOIN에서 주로 사용되는 컬럼
	 	4) NULL값을 포함하고 있는 컬럼이 많은 경우
	 	5) 성능 저하(사용하지 않는다)
	 		-> INSERT/UPDATE/DELETE가 많은 테이블
	 		회원가입/게시판/댓글/리뷰
	 		-> 다시 인덱스 번호를 조정해야 하기 때문에 속도가 많이 느려져서 잘 사용하지 않는다
	 			----------------> 
	 	AAAStO 		AAH		 AAAAFb		 AAG		
	 	오브젝트번호 상대파일번호   블록번호		 데이터번호
	  	테이블(유일값) 데이터별유일값
	  	**같은 데이블에 있으면 나머지는 비슷한데 마지막 데이터번호만 다르다
	  	
	 
	 	B트리방식
	  	예) 1~7 -> empno
	  			가운데 있는 숫자 -> 류트
	  			
	  			4				중간숫자
	  		  ------		
	  		 |      |			중간숫보다 작은것과 큰 것으로 나누기
	  		1~3    5~7
	  	  	 2		6
	  	    ---	   ---
	  	    | |    | |
	  	    1 3	   5 7  
	  	    
	  
	  => rowid는 검색을 위한 구분자 -> 오라클에서 만드는 가상컬럼
	     rownum / rowid
	  	
	  	
	 인덱스의 장단점
	 	장점 : 검색속도가 빠르다
	 	      시스템 부하를 줄여서 전체 성능 향상
	 	단점 : 메모리(인덱스를 추가하는 메모리 공간)가 필요하다
	 			-> 한 테이블안에 4~5개 정도가 적당하다
	 				-> 검색어를 중심으로 제작 => title / name
	 		  테이블 변경시에는 인덱스를 최신화를 시켜줘야한다(INSERT/UPDATE/DELETE)
	 		  	-> ALTER INDEX index명 REBUILD
	 		  인덱스 번호를 계속 추가하면 속도가 저하된다
	 		  
	 		  
 	SELECT * FROM genie_music
	WHERE title='APT.';
	--데이터검색
	
	CREATE INDEX idx_title
	ON genie_music(title);
	--인덱스 생성
	--인덱스 생성 후 다시 위 문장을 조회하면 속도가 빨라짐
	
	1. 인덱스 생성
		1) PK / UK -> 자동생성
		2) 직접 생성 -> 검색어로 많이 사용
			CREATE INDEX index명 ON 테이블명(검색이 많은 컬럼명)
						-> user_indexs
						-> idx_테이블명_컬럼명
						
			=> ON 테이블명(컬럼명)==>ASC
			=> ON 테이블명(컬럼명, DESC)==> DESC
			=> ON 테이블명(컬럼명, 컬럼명 DESC) ==> DESC
		3) 데이터변경시 리빌드(인덱스 갱신)
			ALTER INDEX index명 REBUILD
		
	2. 인덱스 삭제
		DROP INDEX index명
	
	3. ORDER BY 대체
		INDEX_ASC(테이블명 PK)
		INDEX_DESC(테이블명 PK)
		INDEX(테이블명 인덱스명)
		       
		       주석때문에 분리 실제 사용할 땐 붙여서 사용
		       ----
		SELECT / *+ INDEX_ASC(genie_music_gm_mno_pk) * / 컬럼명
		FROM genie_music

	
		
		CREATE INDEX idx_emp_ename ON emp(ename DESC);
		
		SELECT / *+ INDEX(emp idx_emp_ename) * / empno,ename,hiredate
		FROM emp
		WHERE ename>='A';
		--조건이 붙어야 정렬이 된다
		--이름별로 저장
	
		SELECT --+ INDEX(emp idx_emp_sal) 
		empno,ename,sal
		FROM emp
		WHERE sal>0;
	
	4. 인덱스 사용
		테이블에 ROW가 많은 경우 (100000이상인 경우) => 레시피
		WHERE문장에서 검색이 많은 컬럼이 있는 경우
		-> 영화명/맛집명/레시피명
		검색결과가 전체 데이터의 2~5%정도인 경우
		JOIN에서 자주 사용되는 컬럼
		NULL값을 포함하는 검색어가 있는 경우
	

	
  	
  	
 */
public class INDEX {

}
