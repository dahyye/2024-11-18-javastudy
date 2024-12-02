/*
 
 	버블정렬
 	=> 인접한 데이터끼리 비교
 	DESC(내림차순정렬)
 	20 30 40 50 10
 	-- --
 	30 20 
 	   -- --
 	   40 20 
 	   	  -- --
 	   	  50 20
 	   	     -- --
 	   	     20 10
 	   	       (고정)
	-----------------------------1ROUND
	30 40 50 20 10
	-- -- 
	40 30 
	   -- --
	   50 30
	      -- -- 
	      30 20
	        (고정)
	-----------------------------2ROUND
	40 50 30 20 10      
	-- --
	50 40
	   -- --
	   40 30
	     (고정)
    -------------------------------3ROUND
	50 40 30 20 10
	-- -- 
	50 40 30 20 10
	  (고정)
	 -----------------------------4ROUND	

	

 */

import java.util.Arrays;

public class 배열_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]=new int[5];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(int)(Math.random()*100)+1;
		}
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		System.out.println("\n정렬 후 : ");
		
		
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=0;j<arr.length-1-i;j++) //-i를 하는 이유는 마지막 숫자는 고정하기 때문, 루프를 덜 돌리기 위한 방법
 			{
				if(arr[j]<arr[j+1])
				{
					
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					
				}
			}
			System.out.println((i+1)+"라운드 :"+Arrays.toString(arr));
		}
		System.out.println();
		System.out.println("최종 결과값");
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		
	}

}
