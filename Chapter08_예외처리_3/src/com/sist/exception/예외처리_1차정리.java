package com.sist.exception;
/*
 	
	 try가 for문 안에 있으면 특정 데이터만 스킵하고 가져올 수 있다
	 try가 for문 밖에 있으면 특정 데이터에 오류가 있을 때 그 뒤를 읽지 않아
 
 
 	**오라클은 commit을 해야 저장이 된다
 		
 	try
 	{
 		1. 오라클 연결
 		2. AutoCommit : 해제
 		.
 		.				==> 중간에 오류생기면 => catch절로 넘어가서 commit을 실행할 수 없어
 		. 
 		
 		7.commit;
 	}catch(Exception e)
 	{
 		try
 		{
 			rollback;
 		}catch(Exception)
 		{
 		}
 	}
 	finally
 	{
 		try
 		{
 		}
 		catch(Exception e)
 		{
 		}
 	}
 	
 	이렇게 catch와 finally에도 try~catch가 들어갈 수 있어 ==> 트랜젝션(일괄처리)***
 	 												정상이면 다 수행, 오류있으면 다시 롤백
 
 */
public class 예외처리_1차정리 {
	
	public void display() throws Exception
	{
		System.out.println(10/0);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		예외처리_1차정리 a = new 예외처리_1차정리();
		try {
		a.display();
		}
		catch (Exception e) {
			// TODO: handle exception
		}System.out.println("종료");
	}

}
