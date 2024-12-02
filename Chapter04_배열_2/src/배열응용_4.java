/*
 
 	정렬
	
	1. 선택정렬 
		한 개의 데이터를 선택한 후에 기준점으로 변경
		순차적으로 바교
		
		 10 30 50 20 40 
		 -- --
		 30 10
		 --    --
		 50    30
		 --       --
		 50       20
		 --          --
		 50          40
		(고정)
		------------------------ 1ROUND
		50 10 30 20 40
		   -- --
		   30 10
		   --    --
		   30    20
		   --       --
		   40       30
		  (고정)
		-------------------------2ROUND
		50 40 10 30 20 
			  -- --
			  30 10
			  --    --
			  30    20
			 (고정)
		-------------------------3ROUND
		50 40 30 10 20
				 -- --
				 20 10
	    -------------------------4ROUND
	    50 40 30 20 10
		
		 ====================> 이런식으로 차례대로 비교
		 
		 
		 
		
	2. 버블정렬 
	
	3. ASC(올림)
	
	4. DESC(내림)=> 더 많이 사용=> 최신순 정렬을 해야 할 때
	
	
	
	86~96page => 1차원배열
	108 page 알고리즘 => 정렬 알고리즘 
	
 */
import java.util.Arrays;
public class 배열응용_4 {
	static void sort(int[]arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]<arr[j]) //비교했을 때 뒤에 값이 더 크면 위치 바꾸기
				{		//<(내림차순) , >(올림차순)
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 내림차순


		int[] arr= new int[5];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.print("정렬 전 :");
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]<arr[j]) //비교했을 때 뒤에 값이 더 크면 위치 바꾸기
				{		//<(내림차순) , >(올림차순)
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.print("정렬 후 :");
		for(int i:arr)
		{
			System.out.print(i+" ");
		}

		
		
		
	}

}
