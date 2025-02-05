/*
	트리거
	1. 자동화처리(이벤트) -> 어떤 테이블에 대한 이벤트에 반응해서 자동으로 실행되는 코드
	2. 입고 테이블 -> INSERT / UPDATE/ DELETE => 재고 테이블 자동화
	    출고 테이블 -> INSERT / UPDATE/ DELETE => 재고 테이블 자동화
	 								    -----------------------
											오라클 자체 처리
									---------- 자바에서는 호출이 안된다
									프로그램 분석/가동성 -> 낮아진
	\3. SELECT 문장을 사용이 불가능 -> INSERT / UPDATE /DELETE 할 때만 사용이 가능하다
	
	4. NEW , : OLD
		|	   --- 기존의 값을 읽는 경우
	  -----
	  INSERT / UPDATE -> 새로운 데이터를 읽는데 사용
	  INSERT INTO 입고(a,b,c) VALUES(값1,값2,값3..)
	   	   		 				----------------- 다른 테이블에 값을 추가
	  :NEW.a :NEW.b :NEW.c => 재고에 INSERT
	  
	5. DBA가 주로 사용 -> 메뉴얼
	6. 형식) CREATE[OR REPLACE] TRIGGER tri_name
			BEFORE|AFTER(INSERT/UPDATE/DELETE)		
				   -----
				   먼저 INSERT -> 자동화처리
			=> 입고에서 INSERT가 되면 재고를 자동화처리	   
			FOR EACH ROW -- 전체 ROW에 대한 처리
			DELARE 
				변수 선언
			BEGIN
				자동화 처리 -> 재고
			END;
			/
	7. 삭제
		DROP TRIGGER tri_name
		
	8. 수정
		ALTER TRIGGER tri_name => OR REPLACE로 수정하는 경우가 많아서 ALTER은 많이 사용하지 않아
		
	9. 프로젝트에서 트리거를 사용하는 부분
		=> 맛집 : 좋아요 / 찜하기 / 댓글올렸을 때 COUNT 증가
	
	10. 프로시저 : 모든 테이블의 댓글을 한 번에 처리 -> 반복제거
		----- 페이징기법에서 많이 사용
	
	
	================ 예제 ============================================================================
	CREATE TABLE 상품(
		품번 NUMBER,
		상품명 VARCHAR2(30),
		단가 NUMBER
	);
	
	CREATE TABLE 입고(
		품번 NUMBER,
		수량 NUMBER,
		금액 NUMBER
	);
	
	CREATE TABLE 재고(
		품번 NUMBER,
		수량 NUMBER,
		금액 NUMBER
	);
	
	INSERT INTO 상품 VALUES(100,'새우깡',1500);
	INSERT INTO 상품 VALUES(200,'감자깡',1000);
	INSERT INTO 상품 VALUES(300,'맛동산',1200);
	INSERT INTO 상품 VALUES(400,'짱구',1200);
	INSERT INTO 상품 VALUES(500,'고구마깡',2000);

	
	COMMIT;
	
	SELECT * FROM 상품;


	입고 -> 재고 자동화처리
		1. 상품 존재여부 확인
			존재한다면 수량만 증가(UPDATE)
			존재하지 않는다면 상품 추가(INSERT)
	
	출고 -> 재고 자동화처리
		1. 상품이 남아 있는지 확인
			남아있다면 수량만 변경(UPDATE)
			남아있지 않다면 상품 삭제(DELETE)

			
			
			
	--트리거는 COMMIT을 사용하면 오류난다(자동처리됨)
	--AFTER -> 입고처리 완료 후 재고처리를 한다는 뜻
	CREATE OR REPLACE TRIGGER input_trigger
	AFTER INSERT ON 입고
	FOR EACH ROW
	DECLARE 
	 --변수선언
	  vcnt NUMBER:=0; --초기화
	  
	BEGIN 
	  SELECT COUNT(*) INTO vcnt --COUNT값을 vcnt에 넣어라 라는 뜻
	  FROM 재고
	  WHERE 품번=:NEW.품번; --INSERT에서 보낸 품번
	  --재고에 등록된 상품인지 여부 확인
	  IF vcnt=0 THEN --등록이 안 된 상품(INSERT)
	    --INSERT INTO 입고 (100,10,1500)
	    INSERT INTO 재고 VALUES(:NEW.품번, :NEW.수량, :NEW.수량*:NEW.금액);
	  ELSE --이미 등록된 상품(수량만변경->UPDATE)
	    UPDATE 재고 SET
	    수량=수량+:NEW.수량,  --:NEW.수량은 입고에서 들어오는 값
	    금액=금액+(:NEW.수량*:NEW.금액)
	    WHERE 품번=:NEW.품번;
	  END IF;
	END;
	/


	INSERT INTO 입고 VALUES(100,5,1500);
	COMMIT;
	SELECT * FROM 입고; 
	SELECT * FROM 재고;
	
	
	
		
		
	--출고
	CREATE OR REPLACE TRIGGER output_trigger
	AFTER INSERT ON 출고
	FOR EACH ROW
	DECLARE
	  vcnt NUMBER:=0;
	BEGIN
	  SELECT COUNT(*) INTO vcnt
	  FROM 재고
	  WHERE 품번=:NEW.품번;
	  
	  IF :NEW.수량=vcnt THEN
	    DELETE FROM 재고
	    WHERE 품번 = :NEW.품번;
	  ELSE
	    UPDATE 재고 SET
	    수량 = 수량-:NEW.수량,
	    금액=금액-(:NEW.수량*:NEW.금액)
	    WHERE 품번 = :NEW.품번; 
	END IF; 
	END;
	/
	
	INSERT INTO 출고 VALUES(200,5,1000);
	COMMIT;
	SELECT * FROM 출고; 
	SELECT * FROM 재고;
	
	INSERT INTO 출고 VALUES(200,3,1000);
	COMMIT;
	SELECT * FROM 출고; 
	SELECT * FROM 재고;
	
	
	
	===============================================================================================
	
		

*/
public class PL_SQL_데이터베이스관리자_트리거 {

}
