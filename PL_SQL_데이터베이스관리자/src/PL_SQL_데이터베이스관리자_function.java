/*
 
 	FUNCTION 제작
 	  : 리턴형을 가지고 있는 함수 => 삭제하기전까지 영구 저장
 	  
 	  오라클 / 자바에서도 사용이 가능
 	  select뒤, where 조건값
 	  내장함수 => 사용자정의 함수
 	  장점 : 소스 간결하게 만들 수 있다
 	  
 	  형식) 
 	  	CREATE [OR REPLACE] FUNCTION func_name(매개변수..)
 	  	RETURN 데이터형 --데이터형은 VARCHAR2, NUMBER 등 지정만 (10)(10,2) 등 크기설정은 하지 않는다
 	  	IS 
 	  		변수선언
 	  	BEGIN
 	  		처리
 	  	  RETURN 값 --리턴값은 한 개만 넘어간다
 	  	END;
 	  	/
 	  	
 	  	
 	 FUNCTION 삭제
 	 	DROP FUNCTION stdTotal;
 	  	 
 	  	살무 -> 처음보는 함수
 	  	메핑테이블 -> 조인 => 보안, sql문장을 볼 수 없다(가독성이 낮다)
 	  	내용변경시 문제발생
 	  	고정된 경우 : 총페이지 
	 ========================================예제========================================================
	 	SELECT hakbun,name,kor,eng,math,(kor+eng+math) "total",ROUND((kor+eng+math)/3.0,2) "avg"
		FROM student;
		--함수만들어서 간편하게 사용
		--총점함수
		CREATE OR REPLACE FUNCTION stdTotal(pHakbun student.hakbun%TYPE)
		RETURN NUMBER --정수,실수 모두 리턴가능
		IS
		  total NUMBER;
		BEGIN
		  SELECT (kor+eng+math) INTO total
		  FROM student
		  WHERE hakbun=pHakbun;
		RETURN total;
		END;
		/
		
		
		
		--평균함수
		CREATE OR REPLACE FUNCTION stdAvg(pHakbun student.hakbun%TYPE)
		RETURN NUMBER --정수,실수 모두 리턴가능
		IS
		  savg NUMBER;
		BEGIN
		  SELECT ROUND((kor+eng+math)/3.0,2) INTO savg
		  FROM student
		  WHERE hakbun=pHakbun;
		RETURN savg;
		END;
		/
		
		
		SELECT hakbun,name,kor,eng,math,stdTotal(hakbun),stdAvg(hakbun)
		FROM student;
	
 	  	 
 
 
 */
public class PL_SQL_데이터베이스관리자_function {

}
