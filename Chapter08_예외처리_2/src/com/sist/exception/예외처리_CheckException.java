package com.sist.exception;

import java.util.Arrays;

public class 예외처리_CheckException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			int[] lotto = new int[6];
			for(int i=0;i<lotto.length;i++)
			{
				lotto[i]=(int)(Math.random()*45+1);
				for(int j=0;j<i;j++)
				{
					if(lotto[i]==lotto[j])
					{
						i--;
						break;
					}
				}
			}
			//정렬
			Arrays.sort(lotto);
			for(int i:lotto)
			{
				Thread.sleep(1000); //() 1/1000단위 => 1초 
				//예외처리를 반드시 해야하는 클래스
				//이 부분만 예외처리를 해도 상관없다
				System.out.print(i+" ");
				
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			
			e.printStackTrace();
		} finally {
			System.out.println("프로그램 종료");
		}
		
	}

}
