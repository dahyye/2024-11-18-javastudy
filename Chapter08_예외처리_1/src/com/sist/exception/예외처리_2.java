package com.sist.exception;

public class 예외처리_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
//		try {
//			for(int i=1;i<=10;i++)
//			{
//				int r = (int)(Math.random()*3); //0,1,2
//				int a=i/r;//오류발생-> catch
//				System.out.println("i="+i+", r="+r+", a="+a);
//			}
//	
//		} catch (Exception e) {
//			// TODO: handle exception
//			
//		}finally {
//			
//		}
		//크롤링시 사용
		for(int i=1;i<=10;i++)
		{
			try {
				int r = (int)(Math.random()*3); //0,1,2
				int a=i/r;//오류발생-> catch
				System.out.println("i="+i+", r="+r+", a="+a);
			} catch (Exception e) {}  //try catch 위치에 따라 결과 달라져 
			
		}
		
		
	}

}
